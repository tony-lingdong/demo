package com.hld.mapper;

import com.hld.entities.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from tb_order where user_id = #{user_id}")
    List<Order> getAllOrder(int user_id);
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into tb_order(status,user_id,name,phone,total_price,address_id) " +
            "values(#{status},#{user_id},#{name},#{phone},#{total_price},#{address_id})")
    void InsertOrder(Order order);
}
