package com.cn.ecig.demo.finance.service;

import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.finance.entity.Finance;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguang
 * @since 2021-07-13
 */
public interface IFinanceService extends IService<Finance> {
//获取企业财务信息
    List<Finance> getFinanceInfoByCode(String code);
}
