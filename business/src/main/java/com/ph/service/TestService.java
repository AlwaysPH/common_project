package com.ph.service;

import com.ph.common.Results;
import com.ph.model.Order;

public interface TestService {

    /**
     * 获取订单信息
     * @param id
     * @return
     */
    Results<Order>  getOrder(String id);
}
