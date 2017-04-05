package com.chinalife.sz.cc.order.service.impl;

import com.chinalife.sz.cc.domain.OrderFormRequest;
import com.chinalife.sz.cc.model.order.OrderInfoDTO;
import com.chinalife.sz.cc.order.mapper.OrderInfoMapper;
import com.chinalife.sz.cc.order.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tianwei on 2016/12/16.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Override
    public OrderInfoDTO findOrderById() {
        Integer i=new Integer("1");
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO = orderInfoMapper.findOrderById(i);
        return orderInfoDTO;

    }

    @Override
    public List<OrderInfoDTO> findOrders(OrderFormRequest orderForm) {
        String proposalNo=orderForm.getProposalNo();
        String appliName=orderForm.getAppliName();
        String licenseNo=orderForm.getLicenseNo();
        String frameNo=orderForm.getFrameNo();
        String handlerName=orderForm.getHandlerName();
        String inputStartDate = orderForm.getInputStartDate();
        String inputEndDate = orderForm.getInputEndDate();
        List<OrderInfoDTO> orders = orderInfoMapper.findOrders(proposalNo, appliName, licenseNo, frameNo, inputStartDate,inputEndDate, handlerName);
        return orders;
    }

    @Override
    public void saveOrderInfo(OrderInfoDTO orderInfoDTO) {
        orderInfoMapper.saveOrderInfo(orderInfoDTO);
    }
}
