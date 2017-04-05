package com.chinalife.sz.carcalculate.service.impl;

import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.cc.domain.OrderFormRequest;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.chinalife.sz.cc.model.order.OrderInfoDTO;
import com.chinalife.sz.cc.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tianwei on 2016/12/19.
 */
public class OrderQueryService implements WebService {
    @Autowired
    private OrderInfoService orderInfoService;
    @Override
    public <T> boolean checkData(T object) {
        return false;
    }

    @Override
    public <T> T dealData(Object domain, T response) {
//        OrderInfoDTO orderInfo = orderInfoService.findOrderById();
//        response= (T) orderInfo;
        if(domain instanceof OrderFormRequest){
            OrderFormRequest orderForm=(OrderFormRequest) domain;
            List<OrderInfoDTO> orders = orderInfoService.findOrders(orderForm);
            if(response instanceof List)
           for(OrderInfoDTO orderInfo:orders){
               List responseList=(List)response;
               responseList.add(orderInfo);
           }
            return response;
        }

        return null;
    }

    @Override
    public void asynWtireLog(LogDTO logDTO) {

    }
}
