package com.seasontemple.top.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 手机实体类
 * @create: 2019/07/15 13:28:35
 */
@Alias("jd_phone")
public class Phone {

    private Long id;
    private Long spu;
    private Long sku;
    private String title;
    private Double price;
    private String pic;
    private String url;
    private Date created;
    private Date updated;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", spu=" + spu +
                ", sku=" + sku +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpu() {
        return spu;
    }

    public void setSpu(Long spu) {
        this.spu = spu;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
