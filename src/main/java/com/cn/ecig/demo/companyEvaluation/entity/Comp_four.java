/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Comp_four
 * Author:   liyou
 * Date:     2021/7/27 11:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/27
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/27
 * @since 1.0.0
 */
package com.cn.ecig.demo.companyEvaluation.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class Comp_four  implements Serializable {
    @TableId("code")
    private String code;
    @TableField("name")
    private String name;
    @TableField("shortName")
    private String shortName;
    @TableField("score")
    private String score;
    public Comp_four(){
    }

    public Comp_four(String code, String name, String shortName, String score) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
