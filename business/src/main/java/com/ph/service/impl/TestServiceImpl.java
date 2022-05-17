package com.ph.service.impl;

import com.ph.common.Results;
import com.ph.mapper.OrderMapper;
import com.ph.model.Order;
import com.ph.service.TestService;
import com.ph.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Results<Order>  getOrder(String id) {
        redisUtils.set("id", id);
        Order order = orderMapper.getOrder(id);
        return Results.succeed(order);
    }
}
