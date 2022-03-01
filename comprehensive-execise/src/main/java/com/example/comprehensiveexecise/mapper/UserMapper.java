package com.example.comprehensiveexecise.mapper;

import com.example.comprehensiveexecise.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
    * 根据用户名和密码查询用户对象
    * */
    @Select("SELECT * FROM tb_user WHERE username = #{username} AND password = #{password}")
    User findUser(@Param("username") String username, @Param("password") String password);

    /*
     * 根据用户名和密码查询用户对象
     * */
    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    User findUserByName(@Param("username") String username);

    /*
     * 新增用户
     * */
    @Select("INSERT INTO tb_user(username,password) VALUES(#{username},#{password})")
    User addUser(@Param("username") String username, @Param("password") String password);

}
