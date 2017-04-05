package com.chinalife.sz.cc.order.mapper;


import com.chinalife.sz.cc.model.order.OrderInfoDTO;
import com.prs.framework.core.biz.mapper.RepositoryMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tianwei on 2016/12/16.
 */
@RepositoryMapper
public interface OrderInfoMapper {
    public OrderInfoDTO findOrderById(Integer id);
    public List<OrderInfoDTO> findOrders(@Param("proposalNo")String proposalNo,@Param("appliName") String appliName,
                                          @Param("licenseNo")String licenseNo, @Param("frameNo")String frameNo, @Param("inputStartDate")String inputStartDate,
                                         @Param("inputEndDate")String inputEndDate,  @Param("handlerName")String handlerName);
    public void saveOrderInfo(OrderInfoDTO orderInfo);
}
