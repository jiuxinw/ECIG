package com.cn.ecig.demo.industry.controller;


import com.cn.ecig.demo.config.Result;
import com.cn.ecig.demo.industry.entity.Industry;
import com.cn.ecig.demo.industry.service.IIndustryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguang
 * @since 2021-07-17
 */
@Controller
@RequestMapping("/info")
@CrossOrigin
@Api(value = "获取企业财务信息",tags = "获取企业具体信息模块")
public class IndustryController {

    @Autowired
    private IIndustryService iIndustryService;

    @ApiOperation("获取获取时间-行业信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from",value = "起始年份",required = true,dataType = "String"),
            @ApiImplicitParam(name = "to",value = "截至年份",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取获取时间-行业信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/yearIndustryRegion",method = RequestMethod.POST)
    public Result getFyearIndustryRegionByTwo(String from,String to){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取时间-行业信息失败");
        try {
            result.setData(iIndustryService.getByFromAndTo(from, to));
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取时间-行业信息成功");
            if(iIndustryService.getByFromAndTo(from, to).size()==0){
                result.setCode(0);
                result.setMsg("获取时间-行业信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取热搜企业种类")
    @ApiImplicitParams({

    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "请求成功"),
            @ApiResponse(code = 0, message = "获取热搜企业种类失败")
    })
    @ResponseBody
    @RequestMapping(value = "/industry",method = RequestMethod.POST)
    public Result getIndustry(){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取热搜企业种类失败");
        String[] strings={"农、林、牧、渔业","采矿业","制造业","电力、热力、燃气及水生产和供应业","建筑业","交通运输、仓储和邮政业","信息传输、软件和信息技术服务业","批发和零售业","住宿和餐饮业","金融业","房地产业","租赁和商务服务业","科学研究和技术服务业","水利、环境和公共设施管理业","居民服务、修理和其他服务业","教育","卫生和社会工作","文化、体育和娱乐业"};
        try {
            result.setData(strings);
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取热搜企业种类成功");
            if(strings==null
            ){
                result.setCode(0);
                result.setMsg("获取热搜企业种类失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }

    @ApiOperation("获取行业信息")
    @ApiImplicitParams({

    })
    @ApiResponses({
            @ApiResponse(code = 1, message = "获取行业信息成功"),
            @ApiResponse(code = 0, message = "获取行业信息失败")
    })
    @ResponseBody
    @RequestMapping(value = "/industryInfo",method = RequestMethod.POST)
    public Result getIndustryInfo(){
        Result result=new Result();
        result.setSuccess("-1");
        result.setData(null);
        result.setCode(0);
        result.setMsg("获取行业信息失败");
        Map<String,Object> map=new HashMap<>();
//        String[] strings={"农、林、牧、渔业","采矿业","制造业","电力、热力、燃气及水生产和供应业","建筑业","交通运输、仓储和邮政业","信息传输、软件和信息技术服务业","批发和零售业","住宿和餐饮业","金融业","房地产业","租赁和商务服务业","科学研究和技术服务业","水利、环境和公共设施管理业","居民服务、修理和其他服务业","教育","卫生和社会工作","文化、体育和娱乐业"};
     try {
         Industry in_1=iIndustryService.getInfoByIndustry("金融业");
         Industry in_2=iIndustryService.getInfoByIndustry("信息传输、软件和信息技术服务业");
         Industry in_3=iIndustryService.getInfoByIndustry("教育");
         Industry in_4=iIndustryService.getInfoByIndustry("农、林、牧、渔业");
         Industry in_5=iIndustryService.getInfoByIndustry("制造业");
         Industry in_6=iIndustryService.getInfoByIndustry("房地产业");
         Industry[]in_i={in_1,in_2,in_3,in_4,in_5,in_6};
         String[] strings={"economy","IT","education","agriculture","manufacturing","estate"};
         for (int i = 0; i < 6; i++) {
             map.put(strings[i],industyto(in_i[i]));
         }
            result.setData(map);
            result.setSuccess("200");
            result.setCode(1);
            result.setMsg("获取行业信息成功");
            if(strings==null
            ){
                result.setCode(0);
                result.setMsg("获取行业信息失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
    public static String[] industyto(Industry industry){
        String[] strings={industry.getNum(),industry.getAveProfit(),industry.getBadNum(),industry.getGoodnum(),convert(industry.getAveIncome(),industry.getNum())};
        return strings;
    }
    public static String convert(String s1,String s2){
        BigDecimal num1 = new BigDecimal(s1);
        BigDecimal num2 = new BigDecimal(s2);
        BigDecimal result = num1.multiply(num2);
        return  result.toString();
    }
}
