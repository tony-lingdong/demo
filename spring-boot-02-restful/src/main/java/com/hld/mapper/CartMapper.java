package com.hld.mapper;

import com.hld.entities.Cart;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select * from tb_cart where user_id = #{id}")
    List<Cart> getAllCart(int user_id);
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into tb_cart(user_id,flower_id,flower_name,flower_number,flower_price,flower_pic) " +
            "values(#{user_id},#{flower_id},#{flower_name},#{flower_number},#{flower_price},#{flower_pic})")
    void insertCart(Cart cart);
    @Select("select * from tb_cart where user_id = #{user_id} and flower_id=#{flower_id}")
    Cart existOrNot(int user_id,int flower_id);
    @Update("update tb_cart set flower_number = #{flower_number} where id=#{id}")
    void updateCart(Cart cart);
    @Delete("delete from tb_cart where user_id =#{id}")
    void delete(int id);
}
