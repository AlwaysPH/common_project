package com.ph.controller;

import com.ph.common.Results;
import com.ph.model.Order;
import com.ph.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "测试接口", tags = "测试接口")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "获取订单信息", notes = "获取订单信息接口")
    @ApiImplicitParam(name = "id", value = "订单id", dataType = "String", required = true)
    @GetMapping("/getOrder/{id}")
    public Results<Order> getOrder(@PathVariable String id){
        return testService.getOrder(id);
    }
}
