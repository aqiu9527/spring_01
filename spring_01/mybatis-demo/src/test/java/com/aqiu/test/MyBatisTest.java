package com.aqiu.test;

import com.aqiu.mapper.BrandMapper;
import com.aqiu.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aqiu
 * @create 2022-11-02 14:29
 */
public class MyBatisTest {

    /**
     * 查询所有
     * @throws IOException
     */
    @Test
    public void testSelectAll() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brandList = brandMapper.selectAll();

        System.out.println(brandList);

        sqlSession.close();

    }

    /**
     * 根据id查询详细信息
     * @throws IOException
     */
    @Test
    public void testSelectById() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(1);

        System.out.println(brand);

        sqlSession.close();

    }


    /**
     * 多条件动态查询
     * @throws IOException
     */
    @Test
    public void selectByCondition() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
 
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brandList = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brandList = brandMapper.selectByCondition(brand);
        List<Brand> brandList = brandMapper.selectByCondition(map);

        System.out.println(brandList);

        sqlSession.close();

    }


    /**
     * 单条件动态查询
     * @throws IOException
     */
    @Test
    public void selectByConditionSingle() throws IOException {

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brandList = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brandList = brandMapper.selectByCondition(brand);
        List<Brand> brandList = brandMapper.selectByConditionSingle(brand);

        System.out.println(brandList);

        sqlSession.close();

    }


    /**
     * 新增
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        Brand brand = new Brand();
        brand.setBrandName("aqiu");
        brand.setCompanyName("aqiu");
        brand.setOrdered(100);
        brand.setDescription("Aqiu");
        brand.setStatus(1);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        /*
            提交事务
         */
        //sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 新增：返回主键id
     * @throws IOException
     */
    @Test
    public void testAdd2() throws IOException {
        Brand brand = new Brand();
        brand.setBrandName("aqiu");
        brand.setCompanyName("aqiu");
        brand.setOrdered(100);
        brand.setDescription("Aqiu");
        brand.setStatus(1);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        Integer id = brand.getId();
        System.out.println(id);

        /*
            提交事务
         */
        //sqlSession.commit();
        sqlSession.close();

    }


    /**
     * 动态修改
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        Brand brand = new Brand();
        brand.setId(6);
        brand.setBrandName("aaa");
//        brand.setCompanyName("a");
//        brand.setOrdered(100);
//        brand.setDescription("A");
//        brand.setStatus(1);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Integer count =  brandMapper.update(brand);
        System.out.println(count);

        /*
            提交事务
         */
        //sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 删除单个
     * @throws IOException
     */
    @Test
    public void deleteById() throws IOException {
        Integer id = 6;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        sqlSession.close();

    }

    /**
     * 批量删除
     * @throws IOException
     */
    @Test
    public void deleteByIds() throws IOException {
        int[] ids = {2,3};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //手动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //自动提交,无需sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        sqlSession.close();

    }
}
