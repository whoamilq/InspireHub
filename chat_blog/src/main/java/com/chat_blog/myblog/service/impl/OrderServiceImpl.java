package com.chat_blog.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chat_blog.myblog.mapper.OrderMapper;
import com.chat_blog.myblog.pojo.Order;
import com.chat_blog.myblog.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author ChatViewer
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


}
