package com.seasontemple.top.service.impl;

import com.seasontemple.top.dao.PhoneDao;
import com.seasontemple.top.model.Phone;
import com.seasontemple.top.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 手机商品业务层实现类
 * @create: 2019/07/17 21:25:31
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    @Override
    public List<Phone> findAll() {
        List<Phone> ps = phoneDao.findAllTest();
        return ps;
    }

}
