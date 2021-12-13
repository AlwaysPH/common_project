package com.ph.service;

import com.ph.common.Results;
import com.ph.model.Order;

public interface TestService {
    Results<Order>  getOrder(String id);
}
