package com.cn.ecig.demo.year2.service;

import com.cn.ecig.demo.year2.entity.YearIndustryRegion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-28
 */
public interface IYearIndustryRegionService extends IService<YearIndustryRegion> {
    List<YearIndustryRegion> getByYearAndIndu(String from, String to, String Industry);
}
