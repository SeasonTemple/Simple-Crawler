package com.seasontemple.top.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author Season Temple
 * @program: Crawler
 * @description: 封装的HttpClient工具类
 * @create: 2019/07/14 22:09:48
 */
@Component
public class HttpUtils {

    //声明HttpClient连接池管理器
    private PoolingHttpClientConnectionManager cm;
    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();
        //设置最大连接总数
        this.cm.setMaxTotal(100);
        //设置每台主机的最大连接数
        this.cm.setDefaultMaxPerRoute(10);
        System.out.println("HttpUtils构造方法");
    }

    /**
     * 根据请求地址下载页面数据
     * @param url
     * @return 页面数据
     */
    public String doGetHtml(String url) {
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        //创建HttpGet请求对象
        HttpGet httpGet = new HttpGet(url);
        // 传输的类型
        // 浏览器表示
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
        // 传输的类型
        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
        //设置请求信息
        httpGet.setConfig(this.getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获得响应
            response = httpClient.execute(httpGet);
            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否为空，若不为空则可以使用EntityUtils
                if (response.getEntity() != null) {
                    System.out.println("获取响应内容成功！");
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }
            }
        } catch (IOException e) {
            System.out.println("response获取响应失败！");
        } finally {
          //关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.out.println("response关闭失败！");
                }
            }
        }
        //返回空串
        return "";
    }

    /**
     * 下载图片
     * @param url
     * @return 图片名称
     */
    public String doGetImage(String url) {
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        //创建HttpGet请求对象
        HttpGet httpGet = new HttpGet(url);
        //设置请求信息
        // 浏览器表示
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
        // 传输的类型
        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

        httpGet.setConfig(this.getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获得响应
            response = httpClient.execute(httpGet);
            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否为空，若不为空则可以使用EntityUtils
                if (response.getEntity() != null) {
                    //下载图片
                    //获取图片后缀
                    System.out.println("图片下载开始：");
                    String suffixName = url.substring(url.lastIndexOf("."));
                    //创建图片，重命名图片
                    String picName = UUID.randomUUID().toString() + suffixName;
                    //下载图片
                    OutputStream os = new FileOutputStream(new File("D:\\IDEA Projects\\DataCrawler\\log\\img\\"+ picName));
                    response.getEntity().writeTo(os);
                    System.out.println("图片下载成功！");
                    //返回图片
                    return picName;
                }
            }
        } catch (IOException e) {
            System.out.println("response获取响应失败！");
        } finally {
            //关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.out.println("response关闭失败！");
                }
            }
        }
        //如果下载失败，返回空串
        return "";
    }

    //设置请求的信息
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)     //创建连接的最长时间
                .setConnectionRequestTimeout(500)   //获取连接最长时间
                .setSocketTimeout(10000)    //数据传输的最长时间
                .build();
        return config;
    }
}
