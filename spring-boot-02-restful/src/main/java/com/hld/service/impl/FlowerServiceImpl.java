package com.hld.service.impl;

import com.github.pagehelper.PageHelper;
import com.hld.entities.Flower;
import com.hld.entities.PageBean;
import com.hld.mapper.FlowerMapper;
import com.hld.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.service.impl
 * @version: 1.0
 */
@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    FlowerMapper flowerMapper;
    @Override
    public int countNum() {
        return flowerMapper.countNum();
    }
    @Override
    public List<Flower> getAllFlowers() {
        return flowerMapper.getAllFlowers();
    }

    @Override
    public Flower getFlowerById(int id) {
        return flowerMapper.getFlowerById(id);
    }

    @Override
    public List<Flower> getFlowerByClass_Id(int id) {
        return flowerMapper.getFlowerByClass_Id(id);
    }

    @Override
    public List<Flower> getFlowerByPrice(BigDecimal low, BigDecimal high) {
        return flowerMapper.getFlowerByPrice(low,high);
    }
}
