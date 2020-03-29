package com.hld.mapper;

import com.hld.entities.OrderItems;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    @Select("select * from tb_order_items where order_id=#{order_id}")
    List<OrderItems> getAllOrderItems(int order_id);
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into tb_order_items(order_id,flower_id,name,price,number,total_price,pic) " +
            "values(#{order_id},#{flower_id},#{name},#{price},#{number},#{total_price},#{pic})")
    void InsertOrderItems(OrderItems orderItems);
}
