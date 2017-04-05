package com.chinalife.sz.cc.combos.action.impl;

import com.alibaba.fastjson.JSON;
import com.chinalife.sz.cc.combos.action.CombosSchemaAction;
import com.chinalife.sz.cc.combos.service.CombosSchemaService;
import com.chinalife.sz.cc.domain.CombosForm;
import com.chinalife.sz.cc.domain.ItemKindForm;
import com.chinalife.sz.cc.model.combos.CombosSchemaDTO;
import com.chinalife.sz.cc.model.common.ServiceRequestID;
import com.prs.framework.core.biz.action.support.annotation.ActionHandler;
import com.prs.framework.core.biz.action.support.annotation.HandleRquest;
import com.prs.framework.core.common.model.ServiceRequest;
import com.prs.framework.core.common.model.ServiceResponse;
import com.prs.framework.core.exception.BusinessServiceException;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tianwei on 2016/12/26.
 */
@ActionHandler
public class CombosSchemaActionImpl implements CombosSchemaAction {

@Resource
    private CombosSchemaService combosSchemaService;

    @Override
    @HandleRquest(ServiceRequestID.SAVE_COMBOS)
    public ServiceResponse saveCombosSchema(ServiceRequest serviceRequest) throws BusinessServiceException {
        ServiceResponse serviceResponse = new ServiceResponse();
        Map<String, Object> model = serviceRequest.getParameters();
        Object combosForm = serviceRequest.getParameter("combosForm");
        if(combosForm instanceof CombosForm){
            CombosForm combos=(CombosForm) combosForm;
            CombosSchemaDTO dto = new CombosSchemaDTO();
            dto.setCombosName(combos.getCombosName());
            dto.setInputDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            dto.setHandlerName(combos.getHandlerName());
            dto.setHandlerCode(combos.getHandlerCode());
            ItemKindForm[] itemKindList = combos.getItemKindList();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<itemKindList.length;i++){
                if(i<itemKindList.length-1){
                    sb.append(itemKindList[i].getKindName()+",");
                }
                else {
                    sb.append(itemKindList[i].getKindName());
                }
            }
            dto.setCombosInfo(sb.toString());
            String itemKindListJson = JSON.toJSONString(itemKindList);
            dto.setItemKindList(itemKindListJson);
            combosSchemaService.saveCombosSchema(dto);
            model.put("response","success");
            serviceResponse.setModel(model);
            return serviceResponse;

        }
        return null;
    }

    @Override
    @HandleRquest(ServiceRequestID.FIND_COMBOS)
    public ServiceResponse findCombosSchemas(ServiceRequest serviceRequest) throws BusinessServiceException {
        Map<String, Object> model = serviceRequest.getParameters();
        Object userCode = model.get("userCode");
        List<CombosSchemaDTO> combosSchemas = combosSchemaService.findCombosSchemas(userCode.toString());
        model.put("combosSchemas",combosSchemas);
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setModel(model);
        return serviceResponse;
    }

    @Override
    @HandleRquest(ServiceRequestID.UPDATE_COMBOS)
    public ServiceResponse updateCombosSchema(ServiceRequest serviceRequest) throws BusinessServiceException {
        Map<String, Object> model = serviceRequest.getParameters();
        Object combosSchemaDTO = model.get("combosSchemaDTO");
        ServiceResponse serviceResponse= new ServiceResponse();
        if(combosSchemaDTO instanceof  CombosSchemaDTO){
            CombosSchemaDTO dto=(CombosSchemaDTO)combosSchemaDTO;
            String itemKindString = dto.getItemKindList();
            List<ItemKindForm> itemKindForms = JSON.parseArray(itemKindString, ItemKindForm.class);

            StringBuffer sb=new StringBuffer();
            for(int i=0;i<itemKindForms.size();i++){
                if(i<itemKindForms.size()-1){
                    sb.append(itemKindForms.get(i).getKindName()+",");
                }
                else {
                    sb.append(itemKindForms.get(i).getKindName());
                }
            }
            dto.setCombosInfo(sb.toString());
            combosSchemaService.updateCombosSchema(dto);
            model.put("response","success");
            serviceResponse.setModel(model);
            return serviceResponse;
        }
        return null;
    }

    @Override
    @HandleRquest(ServiceRequestID.DELETE_COMBOS)
    public ServiceResponse deleteCombosSchema(ServiceRequest serviceRequest) throws BusinessServiceException {
        ServiceResponse serviceResponse= new ServiceResponse();
        Map<String, Object> model = serviceRequest.getParameters();
        Long id = (Long)model.get("id");
        String handlerCode = (String)model.get("handlerCode");
        combosSchemaService.deleteCombosSchema(id,handlerCode);
        model.put("response","success");
        serviceResponse.setModel(model);
        return serviceResponse;
    }


}
