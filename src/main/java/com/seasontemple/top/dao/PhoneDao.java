package com.seasontemple.top.dao;

import com.seasontemple.top.model.Phone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: Mapper接口类
 * @create: 2019/07/15 13:32:30
 */
@Repository
public interface PhoneDao {

    @Select("select * from jd_phone where sku = #{sku}")
    List<Phone> findBySku(long sku);

    @Insert("insert into jd_phone(spu,sku,title,price,pic,url,created,updated) values(#{spu},#{sku},#{title},#{price},#{pic},#{url},#{created},#{updated})")
    int save(Phone phone);

    @Select("select * from jd_phone")
    List<Phone> findAllTest();
}
