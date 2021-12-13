package com.ph.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "订单对象")
public class Order implements Serializable {
    private static final long serialVersionUID = 3718123765560897678L;

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "公司名称")
    private String name;

    @ApiModelProperty(value = "boss名")
    private String bissName;

}
