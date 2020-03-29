package com.hld.mapper;

import com.hld.entities.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into tb_address(user_id,name,phone,address,is_default) " +
            "values(#{user_id},#{name},#{phone},#{address},#{is_default})")
    void InsertAddress(Address address);
    @Select("select * from tb_address where user_id = #{user_id}")
    List<Address> getAllAddress(int user_id);
    @Select("select * from tb_address where id = #{id}")
    Address getAllAddressById(int id);
}
