package com.example.comprehensiveexecise.service;

import com.example.comprehensiveexecise.entity.User;
import com.example.comprehensiveexecise.mapper.UserMapper;
import com.example.comprehensiveexecise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 用户服务类
 * */
public class UserService {
    /**
     * 1.获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public User login(String username,String password){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4. 调用方法
        User user = mapper.findUser(username,password);
        // 5. 释放容器
        sqlSession.close();
        return  user;
    }
}
