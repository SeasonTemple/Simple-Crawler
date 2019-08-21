package com.seasontemple.top.dao;

import com.seasontemple.top.model.GoodInfo;
import com.seasontemple.top.model.Phone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: goodDao
 * @create: 2019/07/23 14:56:40
 */
public interface GoodInfoDao {

    @Insert("insert into goodinfo(spu,sku_id,name,message,price,image,stock,brand_id,status) values(#{spu},#{sku_id},#{name},#{message},#{price},#{image},#{stock},#{brand_id},#{status})")
    int save(GoodInfo goodInfo);

    @Select("select * from goodinfo")
    List<Phone> findAllTest();
}
