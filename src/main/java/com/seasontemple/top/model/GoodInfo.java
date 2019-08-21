package com.seasontemple.top.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 商品实体类
 * @create: 2019/07/23 14:36:00
 */
@Alias("goodinfo")
public class GoodInfo {

    private Long id;
    private Long spu;
    private Long sku_id;
    private String name;
    private Double price;
    private String image;
    private String stock;
    private String message;
    private Long brand_id;
    private String status;

    @Override
    public String toString() {
        return "GoodInfo{" +
                "id=" + id +
                ", spu=" + spu +
                ", sku_id=" + sku_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", stock='" + stock + '\'' +
                ", message='" + message + '\'' +
                ", brand_id=" + brand_id +
                ", status='" + status + '\'' +
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

    public Long getSku_id() {
        return sku_id;
    }

    public void setSku_id(Long sku_id) {
        this.sku_id = sku_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
