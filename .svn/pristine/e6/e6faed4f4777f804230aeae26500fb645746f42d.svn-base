package com.chinalife.sz.carcalculate.service.impl;

import com.alibaba.fastjson.JSON;
import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.carcalculate.utils.ConfigUtils;
import com.chinalife.sz.carcalculate.utils.LogUtils;
import com.chinalife.sz.carcalculate.webservice.PremiumCaculateServiceV3XStub;
import com.chinalife.sz.cc.domain.PremiumCalculateResponse;
import com.chinalife.sz.cc.log.service.LogService;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.prs.framework.core.exception.BusinessException;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tianwei on 2016/7/31.
 * 保费计算
 */
public class PremiumCalculateService implements WebService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private LogService logService;
    private PremiumCaculateServiceV3XStub stub;

    @Override
    public <T> boolean checkData(T object) {
        if (object instanceof PremiumCaculateServiceV3XStub.PremiumCaculateRequest) {
            PremiumCaculateServiceV3XStub.PremiumCaculateRequest request = (PremiumCaculateServiceV3XStub.PremiumCaculateRequest) object;
            PremiumCaculateServiceV3XStub.Main mainEhm = request.getMain();
            PremiumCaculateServiceV3XStub.CombosData[] combosList = request.getCombosList();
            // 是否关联,1-关联单、2-单商业、3-单交强
            if (combosList.length == 2) {
                mainEhm.setRelationFlag("1");
                mainEhm.setBZRealationFlag("1");
            } else {
                mainEhm.setRelationFlag("2");
                mainEhm.setBZRealationFlag("0");
            }

            ConfigUtils.setMainInfo(mainEhm, "premiumCalculateService.main");
            //计算年龄
            PremiumCaculateServiceV3XStub.InsuredData[] insuredList = request.getInsuredList();
            for (int i = 0; i < insuredList.length; i++) {
                if (insuredList[i].getIdentifyNumber().length() == 18) {
                    int age = ConfigUtils.getAge(insuredList[i].getIdentifyNumber());
                    insuredList[i].setAge(age);
                }

            }
            request.setInsuredList(insuredList);
            //   车辆信息
            PremiumCaculateServiceV3XStub.CarInfo carInfoEhm = request.getCarInfo();
            ConfigUtils.setMainInfo(carInfoEhm, "premiumCalculateService.carInfo");
             // 行业平台车辆种类
            carInfoEhm.setVehicleStyle(carInfoEhm.getCarType());
            //设置0排量客车的排量
            double exhaustScale = ("A0".equals(carInfoEhm.getCarKindCode()) && Double.parseDouble("0.0") == carInfoEhm.getExhaustScale()) ? 0.01 : carInfoEhm.getExhaustScale();
            carInfoEhm.setExhaustScale(exhaustScale);
            request.setCarInfo(carInfoEhm);


//	   设置商业险信息
            PremiumCaculateServiceV3XStub.CombosData combosDataEhm = combosList[0];
            ConfigUtils.setMainInfo(combosDataEhm, "premiumCalculateService.combos");

            PremiumCaculateServiceV3XStub.ItemKindData[] itemKindList = combosDataEhm.getItemKindList();
            for (int i = 0; i < itemKindList.length; i++) {
                itemKindList[i].setStartDate(request.getMain().getStartDate());
                itemKindList[i].setEndDate(request.getMain().getEndDate());
            }


            if (combosList.length == 2) {
//		   //	   设置交强险信息
                PremiumCaculateServiceV3XStub.CombosData combosDataEhmJQ = combosList[1];
                PremiumCaculateServiceV3XStub.ItemKindData[] itemKindDataEhmJQ = combosDataEhmJQ.getItemKindList();
                itemKindDataEhmJQ[0].setStartDate(mainEhm.getBzStartDate());
                itemKindDataEhmJQ[0].setEndDate(mainEhm.getBzEndDate());
                itemKindDataEhmJQ[0].setKindName("机动车交通事故责任强制险");
//		   设置关联信息
                PremiumCaculateServiceV3XStub.BzRelationMain bzRelationMain = new PremiumCaculateServiceV3XStub.BzRelationMain();
                bzRelationMain.setStartDate_bz(mainEhm.getBzStartDate());
                bzRelationMain.setEndDate_bz(mainEhm.getBzEndDate());
                bzRelationMain.setIsEffectFlag("N");
                bzRelationMain.setCarShipTaxFlag("1");
                bzRelationMain.setPremium_bz("0");
                request.setBZRelationMain(bzRelationMain);
            }
            ConfigUtils.setRequest(stub, request, "noEhm");



            return true;
        }
        return false;
    }

    @Override
    public <T> T dealData(Object domain, T response) {
        PremiumCaculateServiceV3XStub.PremiumCaculateRequest request = new PremiumCaculateServiceV3XStub.PremiumCaculateRequest();

        String domainJson = JSON.toJSONString(domain);

        request = JSON.parseObject(domainJson, request.getClass());
        try {
            stub = new PremiumCaculateServiceV3XStub();
        } catch (AxisFault e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //request = ConfigUtils.simpleBeanConvert(domain, request.getClass());
        if (checkData(request)) {
//			System.out.println(JSON.toJSONString(request));
            logger.info(request.getCarInfo().getLicenseNo() + "(request):" + ConfigUtils.formatJson(request));
            LogDTO logDTO = new LogDTO();
            logDTO.setCrtUsr(request.getMain().getOperatorCode());
            logDTO.setServiceNme("保费计算");
            logDTO.setCarOwner(request.getCarInfo().getCarOwner());
            logDTO.setEngineNo(request.getCarInfo().getEngineNo());
            logDTO.setFrameNo(request.getCarInfo().getFrameNo());
            logDTO.setLicenseNo(request.getCarInfo().getLicenseNo());
            PremiumCaculateServiceV3XStub.PremiumCaculate query = new PremiumCaculateServiceV3XStub.PremiumCaculate();
            query.setRequest(request);

            PremiumCaculateServiceV3XStub.PremiumCaculateResponse premiumCaculateResponse = null;
            try {
                logDTO.setReqTm(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                String reqXml = LogUtils.writeObject2String(request);
                logDTO.setReqXml(reqXml);
                premiumCaculateResponse = stub.premiumCaculate(query).get_return();
                logger.info(request.getCarInfo().getLicenseNo() + "(response):" + ConfigUtils.formatJson(premiumCaculateResponse));
                logDTO.setRespTm(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if (premiumCaculateResponse != null) {
                    String respXml = LogUtils.writeObject2String(premiumCaculateResponse);
                    logDTO.setRespXml(respXml);
                }
                if (premiumCaculateResponse.getResultCode().equals("1")) {
                    PremiumCaculateServiceV3XStub.CombosData[] combosList = premiumCaculateResponse.getCombosList();
                    PremiumCaculateServiceV3XStub.ItemKindData[] itemKindList = combosList[0].getItemKindList();
                    List<PremiumCaculateServiceV3XStub.ItemKindData> totalItemKindList = getTotalItemKindList(itemKindList);
                    PremiumCaculateServiceV3XStub.ItemKindData[] totalItemKindData = totalItemKindList.toArray(new PremiumCaculateServiceV3XStub.ItemKindData[totalItemKindList.size()]);

                    combosList[0].setItemKindList(totalItemKindData);
                    response = (T) ConfigUtils.simpleBeanConvert(premiumCaculateResponse, response.getClass());
//                    logger.info(request.getCarInfo().getLicenseNo() + "(response):" + ConfigUtils.formatJson(response));
                    logDTO.setLogType("success");
                    asynWtireLog(logDTO);
                    return response;
                } else {
                    if (response instanceof PremiumCalculateResponse) {
                        PremiumCalculateResponse pResponse = (PremiumCalculateResponse) response;
                        pResponse.setErrorMessage(premiumCaculateResponse.getResultCodeDesc());
                        logDTO.setLogType("fail");
                        logDTO.setErrMsg(premiumCaculateResponse.getResultCodeDesc());
                        asynWtireLog(logDTO);
                        return response;
                    }
                }


            } catch (RemoteException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
                return null;
            }


        }
        return null;
    }

    @Override
    public void asynWtireLog(final LogDTO logDTO) {
        LogUtils.executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    logService.addLog(logDTO);
                } catch (BusinessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<PremiumCaculateServiceV3XStub.ItemKindData> getTotalItemKindList(PremiumCaculateServiceV3XStub.ItemKindData[] itemKindList) {
        List<PremiumCaculateServiceV3XStub.ItemKindData> itemKindDatas = new ArrayList<PremiumCaculateServiceV3XStub.ItemKindData>();
        for (int i = 0; i < itemKindList.length; i++) {
            if (itemKindList[i].getDeductableFlag().equals("1") && (!itemKindList[i].getKindCode().substring(0, 1).equals("3"))) {
                String deductablekindCode = ConfigUtils.getValue(itemKindList[i].getKindCode());
                double benchMarkPremium = itemKindList[i].getBenchMarkPremium();
                double premium = itemKindList[i].getPremium();
                for (int j = 0; j < itemKindList.length; j++) {
                    if (itemKindList[j].getKindCode().equals(deductablekindCode)) {
                        BigDecimal newBenchMarkPremiumBigDecimal = new BigDecimal(Double.toString(benchMarkPremium)).add(new BigDecimal(Double.toString(itemKindList[j].getBenchMarkPremium())));
                        benchMarkPremium = newBenchMarkPremiumBigDecimal.doubleValue();
                        BigDecimal newPremiumBigDecimal = new BigDecimal(Double.toString(premium)).add(new BigDecimal(Double.toString(itemKindList[j].getPremium())));

                        premium = newPremiumBigDecimal.doubleValue();
                    }
                }
                itemKindList[i].setBenchMarkPremium(benchMarkPremium);
                itemKindList[i].setPremium(premium);
                itemKindDatas.add(itemKindList[i]);
            } else {
//			}
                itemKindDatas.add(itemKindList[i]);
            }
        }
        return itemKindDatas;
    }

    public PremiumCaculateServiceV3XStub getStub() {
        return stub;
    }

    public void setStub(PremiumCaculateServiceV3XStub stub) {
        this.stub = stub;
    }
}
