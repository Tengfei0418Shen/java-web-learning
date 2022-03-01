package com.example.comprehensiveexecise.mapper;

import com.example.comprehensiveexecise.entity.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BrandMapper {
    /*
     * 查询所有品牌数据
     * */
    @Select("SELECT * FROM tb_brand")
    Brand[] getBrands();

    /*
     * 查询某品牌数据
     * */
    @Select("SELECT * FROM tb_brand WHERE id=#{id}")
    Brand getBrandById(@Param("id") Integer id);


    /*
     * 新增品牌数据
     * */
    @Select("INSERT INTO tb_brand(brandname,businessname,order1,detailinfo,status) VALUES(#{brandname},#{businessname},#{order1},#{detailinfo},#{status})")
    Brand addBrand(@Param("brandname") String brandname
            ,@Param("businessname") String businessname
            ,@Param("order1") Integer order1
            ,@Param("detailinfo") String detailinfo
            ,@Param("status") boolean status
    );

    /*
     * 更改品牌数据
     * */
    @Select("UPDATE tb_brand SET brandname = #{brandname},businessname=#{businessname},order1=#{order1},detailinfo=#{detailinfo},status=#{status} WHERE id=#{id} ")
    Brand updBrand(@Param("id") Integer id
            ,@Param("brandname") String brandname
            ,@Param("businessname") String businessname
            ,@Param("order1") Integer order1
            ,@Param("detailinfo") String detailinfo
            ,@Param("status") boolean status
    );

    /*
     * 删除品牌数据
     * */
    @Select("DELETE FROM tb_brand WHERE id=#{id}")
    Brand delBrand(@Param("id") Integer id
    );
}
