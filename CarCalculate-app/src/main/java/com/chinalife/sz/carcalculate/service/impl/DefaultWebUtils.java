package com.chinalife.sz.carcalculate.service.impl;

import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.cc.service.WebUtils;
import com.chinalife.sz.carcalculate.utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tianwei on 2016/8/16.
 */
public class DefaultWebUtils implements WebUtils {
    @Autowired
    private List<WebService> webServiceList;
    @Override
    public <T> T submit(Object o, String id, T response) {
        WebService service = getService(id);
        if(service!=null){
            response = service.dealData(o, response);
            return  response;
        }
        return null;
    }
    private   WebService getService(String id){
        for(int i=0;i<webServiceList.size();i++){

//            System.out.println(ConfigUtils.getValue(id));
            if(webServiceList.get(i).getClass().getName().equals(ConfigUtils.getValue(id))){
                return webServiceList.get(i);
            }

        }
        //return null;

        return null;
    }

    public List<WebService> getWebServiceList() {
        return webServiceList;
    }

    public void setWebServiceList(List<WebService> webServiceList) {
        this.webServiceList = webServiceList;
    }
}
