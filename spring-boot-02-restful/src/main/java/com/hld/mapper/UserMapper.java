package com.hld.mapper;

import com.hld.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_user where id=#{id}")
    User getUserById(int id);
    @Select("select * from tb_user")
    List<User> getAllUsers();
    @Update("update tb_user set username=#{username},password=#{password},sex=#{sex},city=#{city},email=#{email}," +
            "realname=#{realname},phone=#{phone},nickname=#{nickname} where id=#{id}")
    void updateUser(User user);
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into tb_user(username,password,sex,phone,nickname) values (#{username},#{password},#{sex},#{phone},#{nickname})")
    void insertUser(User user);
    @Delete("delete from tb_user where id=#{id}")
    void deleteUser(int id);
    @Select("select *from tb_user where username=#{username} and password=#{password}")
    User getUserByNameAndPw(String username,String password);
    @Select("select *from tb_user where username=#{username}")
    User getUserByName(String username);
}
