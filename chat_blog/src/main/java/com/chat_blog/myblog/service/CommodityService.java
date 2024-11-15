package com.chat_blog.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chat_blog.myblog.pojo.Commodity;

/**
 * @author ChatViewer
 */
public interface CommodityService extends IService<Commodity> {

    /**
     * 秒杀免费限量商品
     * @param commodityId 商品id
     * @return 秒杀结果
     * @throws InterruptedException sleep可能丢出的异常
     */
    String seckill(Long commodityId) throws InterruptedException;
}
