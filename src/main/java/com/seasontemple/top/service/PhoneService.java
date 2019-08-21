package com.seasontemple.top.service;

import com.seasontemple.top.model.Phone;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 手机商品业务层接口
 * @create: 2019/07/17 21:24:07
 */
public interface PhoneService {

    public List<Phone> findAll();
}
