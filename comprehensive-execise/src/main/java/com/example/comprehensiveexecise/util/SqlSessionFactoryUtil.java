package com.example.comprehensiveexecise.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        // 在构造方法之前执行,自动执行,只执行一次
        String resource = "mybatis-config.xml";
        try{
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
