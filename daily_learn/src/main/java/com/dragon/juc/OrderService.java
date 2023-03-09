package com.dragon.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 模拟订单服务，包括远程rpc调用会这本地数据库调用等
 */
public class OrderService {
    private Random random = new Random();
    //订单明细
    public List<Integer> getOrderDetail(Integer orderId){
        random.nextInt(100);
        return new ArrayList<>();
    }
    //优惠劵
    public Integer getOrderSale(Integer orderId){
        random.nextInt(100);
        return 5;
    }
    //会员等级
    public Integer getUserLevel(Integer orderId){
        random.nextInt(100);
        return 2;
    }

    //会员等级权利服务1
    //会员等级服务权利2
    //会员等级服务权利3
    public Integer getUserL1(Integer userLevel){
        random.nextInt(100);
        return 1;
    }
    public Integer getUserL2(Integer userLevel){
        random.nextInt(100);
        return 2;
    }
    public Integer getUserL3(Integer userLevel){
        random.nextInt(100);
        return 3;
    }

    //商品价格计算
    public Integer dealOrderM(Integer orderId, Integer sale){
        random.nextInt(100);
        return orderId*sale;
    }
    //剩余优惠计算
    public Integer dealSale(Integer userL){
        random.nextInt(100);
        return userL*userL;
    }
    //总结果计算
    public Integer getUserL3(Integer orderM, Integer sale){
        random.nextInt(100);
        return orderM-sale;
    }
}
