package com.hld.service;

import com.hld.entities.Flower;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.service
 * @version: 1.0
 */
public interface FlowerService {
    List<Flower> getAllFlowers();
    Flower getFlowerById(int id);
    List<Flower> getFlowerByClass_Id(int id);
    List<Flower> getFlowerByPrice(BigDecimal low, BigDecimal high);
    int countNum();
}
