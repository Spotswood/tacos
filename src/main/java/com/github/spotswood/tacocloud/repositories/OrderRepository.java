package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.Order;

public interface OrderRepository {

    Order save(Order order);
}