package com.example.comprehensiveexecise.service;

import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.entity.User;
import com.example.comprehensiveexecise.mapper.BrandMapper;
import com.example.comprehensiveexecise.mapper.UserMapper;
import com.example.comprehensiveexecise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BrandService {
    /**
     * 1.获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    public Brand[] getAllBrands(){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand[] brands = mapper.getBrands();
        // 5. 释放容器
        sqlSession.close();
        return  brands;
    }

    public Brand getBrandById(Integer id){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand brand = mapper.getBrandById(id);
        // 5. 释放容器
        sqlSession.close();
        return  brand;
    }

    public boolean addBrand(String brandname, String businessname,Integer order1,String detailinfo,boolean status){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand brand = mapper.addBrand(brandname,businessname,order1,detailinfo,status);
        // 5. 释放容器
        sqlSession.close();
        return  brand==null;
    }

    public boolean delBrand(Integer id){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand brands = mapper.delBrand(id);
        // 5. 释放容器
        sqlSession.close();
        return  brands==null;
    }

    public boolean updBrand(Integer id,String brandname, String businessname,Integer order1,String detailinfo,boolean status){
        // 2.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 3.BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 调用方法
        Brand brands = mapper.updBrand(id,brandname,businessname,order1,detailinfo,status);
        // 5. 释放容器
        sqlSession.close();
        return  brands==null;
    }
}
