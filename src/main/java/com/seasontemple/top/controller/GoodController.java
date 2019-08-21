package com.seasontemple.top.controller;

import com.seasontemple.top.dao.GoodInfoDao;
import com.seasontemple.top.model.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: GoodController
 * @create: 2019/07/23 15:03:45
 */
@Controller
public class GoodController {

    @Autowired
    private GoodInfoDao goodInfoDao;

    public void save(GoodInfo goodInfo) {
        int rows = goodInfoDao.save(goodInfo);
        if (rows > 0) {
            System.out.println("数据保存成功！");
        } else {
            System.out.println("数据保存失败！");
        }
    }

}
