package com.hld.mapper;


import com.hld.entities.Flower;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther:HLD
 * @Date:2019/4/3
 * @Description:com.hld.mapper
 * @version: 1.0
 */
@Mapper
public interface FlowerMapper {
    @Select("SELECT count(*) from tb_flower")
    int countNum();
    @Select("select * from tb_flower")
    List<Flower> getAllFlowers();
    @Select("select * from tb_flower where id = #{id}")
    Flower getFlowerById(int id);
    @Select("select * from tb_flower where class_id=#{id}")
    List<Flower> getFlowerByClass_Id(int id);
    @Select("select * from tb_flower where price>#{low} and price<#{high}")
    List<Flower> getFlowerByPrice(BigDecimal low,BigDecimal high);
}
