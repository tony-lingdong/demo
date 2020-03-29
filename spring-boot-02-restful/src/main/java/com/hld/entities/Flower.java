package com.hld.entities;

import java.math.BigDecimal;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.entities
 * @version: 1.0
 */
public class Flower {
    private int id;
    private String name;
    private String details;
    private String pic;
    private BigDecimal price;
    private int class_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", class_id=" + class_id +
                '}';
    }
}
