package com.aqiu.mapper;

import com.aqiu.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Aqiu
 * @create 2022-11-02 14:38
 */
public interface BrandMapper {

    /**
     * 查询所有
     * @return List<Brand>
     */
    List<Brand> selectAll();

    /**
     * 根据id查询详细信息
     * @param id
     * @return
     */
    Brand selectById(int id);


    /**
     * 多条件查询
     *      参数接收
     *          1.散装参数：@Param("参数占位符名称")
     *          2.对象的属性名称需要和参数占位符名称一致
     *          3.
     * @param status
     * @param companyName
     * @param brandName
     * @param Brand
     * @param map
     * @return
     */
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);

//    List<Brand> selectByCondition(Brand brand);

      List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
      List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 新增
     * @param brand
     */
    void add(Brand brand);


    /**
     * 修改
     * @param brand
     */
    int update(Brand brand);

    /**
     * 删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

}
