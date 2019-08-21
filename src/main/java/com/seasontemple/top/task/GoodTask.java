package com.seasontemple.top.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seasontemple.top.controller.GoodController;
import com.seasontemple.top.controller.PhoneController;
import com.seasontemple.top.model.GoodInfo;
import com.seasontemple.top.model.Phone;
import com.seasontemple.top.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 定时任务，商品信息抓取
 * @create: 2019/07/23 15:06:30
 */
@Component("goodTask")
public class GoodTask {
    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private GoodController goodController;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，间隔多少时间进行下一次任务
    public void phoneTask() throws Exception{
        //声明需要解析的初始地址
//        String url2 = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&cid2=653&cid3=655&s=60&click=0&page=";
        String url = "https://search.jd.com/Search?keyword=%E4%B8%8B%E8%A3%85&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E4%B8%8B%E8%A3%85&s=54&click=0&page=";
        //按分页对商品搜索结果进行遍历，由于京东是奇数分页，因此i从1开始，每次+2
        for (int i = 5; i < 11; i = i+2) {
            System.out.println("第"+ i+"页抓取开始！");
            String html = httpUtils.doGetHtml(url + i);
            //解析页面，获取商品数据并存储
            this.parse(html);
        }
        System.out.println("商品数据抓取完成！");
    }

    ///通过Jsoup解析页面，获取商品数据并存储至数据库
    private void parse(String html) throws IOException {
        System.out.println("开始解析数据：");

        //解析html获取Document
        Document doc = Jsoup.parse(html);
        //获取spu信息
        Elements spuEles = doc.select("div#J_goodsList > ul > li");
        for (Element spuEle : spuEles) {
            //获取spu
            Long spu = Long.parseLong(spuEle.attr("data-spu"));
            System.out.println("当前商品的spu值为：" + spu);
            //获取sku
            Elements skuEles = spuEle.select("li.ps-item");
            for (Element skuEle : skuEles) {
                Long sku = Long.parseLong(skuEle.select("[data-sku]").attr("data-sku"));
                System.out.println("当前商品的sku值为：" + spu);
                //根据sku查询商品
                GoodInfo goodInfo = new GoodInfo();
                goodInfo.setSku_id(sku);
                /*List<Phone> ps = phoneController.findBySku(phone.getSku());
                //如果商品存在，则不用保存，直接跳过本次循环
                if (ps.size() > 0) {
                    continue;
                }*/
                //设置商品的spu
                goodInfo.setSpu(spu);
                //获取商品详情的url
                String url = "https://item.jd.com/" + sku + ".html";
//                goodInfo.setUrl(url);
                //获取商品的图片
                String picUrl = "https:" + skuEle.select("img[data-sku]").first().attr("data-lazy-img");
                picUrl = picUrl.replace("/n9/", "/n1/");
                String picName = httpUtils.doGetImage(picUrl);
                goodInfo.setImage(picName);
                //获取商品的价格
                String priceJson = httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
                goodInfo.setPrice(price);
                //获取商品的标题
                String info = httpUtils.doGetHtml(url);
                String title = Jsoup.parse(info).select("div.sku-name").text();
                goodInfo.setName(title);


                System.out.println(goodInfo.toString());

                goodController.save(goodInfo);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodTask goodTask = (GoodTask) appCon.getBean("goodTask");
        goodTask.phoneTask();
    }
}