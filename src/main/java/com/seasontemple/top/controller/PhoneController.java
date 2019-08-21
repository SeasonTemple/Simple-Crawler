package com.seasontemple.top.controller;

import com.seasontemple.top.dao.PhoneDao;
import com.seasontemple.top.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 手机数据存储控制器
 * @create: 2019/07/15 13:31:03
 */
@Controller("phoneController")
public class PhoneController {

    @Autowired
    private PhoneDao phoneDao;

    /**
     * 保存商品
     * @param phone
     */
    public void save(Phone phone) {
        int rows = phoneDao.save(phone);
        if (rows > 0) {
            System.out.println("数据保存成功！");
        } else {
            System.out.println("数据保存失败！");
        }
    }

    /**
     * @param sku
     * @return
     */
    public List<Phone> findBySku(long sku) {
        List<Phone> ps = null;
        while(phoneDao.findBySku(sku)!= null) {
            ps = phoneDao.findBySku(sku);
        }
        return ps;
    }

    public List<Phone> findAllTest() {
        List<Phone> ps = phoneDao.findAllTest();
        return ps;
    }

}
