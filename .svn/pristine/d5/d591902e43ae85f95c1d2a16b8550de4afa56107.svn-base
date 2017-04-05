package com.chinalife.sz.carcalculate.service.impl;

import com.chinalife.sz.carcalculate.service.WebService;
import com.chinalife.sz.carcalculate.utils.ConfigUtils;
import com.chinalife.sz.cc.domain.*;
import com.chinalife.sz.cc.model.log.LogDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;

/**
 * 生成pdf
 * Created by tianwei on 2016/8/23.
 */

public class GeneratePDFService implements WebService {
    @Override
    public <T> boolean checkData(T object) {

        return false;
    }

    @Override
    public <T> T dealData(Object domain, T response) {
        if (domain instanceof PdfInfoRequest) {
            PdfInfoRequest pdfInfo;
            Document document;
            ByteArrayOutputStream bos;
            try {
                pdfInfo = (PdfInfoRequest) domain;
                document = new Document(PageSize.A4, 50, 50, 50, 50);
//                document = new Document(, 50, 50, 50, 50);
                bos = new ByteArrayOutputStream();
                String demandNo = pdfInfo.getMain().getDemandNo();

                PdfWriter writer = PdfWriter.getInstance(document, bos);
                document.open();

                PdfContentByte content = writer.getDirectContent();
//                Image image = new Image(ImageDataFactory.create(IMG));
                URL imageUrl = getClass().getClassLoader().getResource("jpg/logo.png");
                Image logo = Image.getInstance(imageUrl);
                logo.setAlignment(Image.ALIGN_CENTER);
                logo.scaleAbsoluteHeight(10);
                logo.scaleAbsoluteWidth(10);
//                logo.scalePercent(38);
                logo.scalePercent(42);
                logo.setAbsolutePosition(50, 766);
                content.addImage(logo);

                BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//                使用宋体来展示
//                BaseFont bfChinese = BaseFont.createFont("font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                Font FontChinese = new Font(bfChinese, 10, Font.NORMAL);
                Font titleFontChinese = new Font(bfChinese, 14, Font.NORMAL);
                Table table = new Table(4);
                int widths[] = {25, 25, 25, 25};
                table.setWidths(widths);
                table.setWidth(100);
                table.setPadding(2);



//      car
                CarInfoRequest carInfo = pdfInfo.getCarInfo();
                if("7".equals(carInfo.getCarOwnerNature())){
                    Cell cell = new Cell(new Phrase("机动车辆保险报价单(个人)", titleFontChinese));
                    cell.setUseBorderPadding(true);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(4);
                    cell.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell);
                }
               else {
                    Cell cell = new Cell(new Phrase("机动车辆保险报价单(法人)", titleFontChinese));
                    cell.setUseBorderPadding(true);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(4);
                    cell.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell);
                }

                document.add(table);

                Table carTable = new Table(4);

                carTable.setWidths(widths);
                carTable.setWidth(100);
                carTable.setPadding(2);
                ItemKindDataRequest[] syxItemKindList = pdfInfo.getCombosList()[0].getItemKindList();

                Cell licenseNo = new Cell(new Paragraph("车牌号：" + carInfo.getLicenseNo(), FontChinese));
                licenseNo.setColspan(1);
                licenseNo.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(licenseNo);

                Cell firstDay = new Cell(new Paragraph("初次登记日期：" + carInfo.getEnrollDate(), FontChinese));
                firstDay.setColspan(1);
                firstDay.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(firstDay);

                Cell useNature = new Cell(new Paragraph("使用性质：" + ConfigUtils.getValue(carInfo.getUseNatureCode()), FontChinese));
                useNature.setColspan(1);
                useNature.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(useNature);

                Cell seatCount_ton = new Cell(new Paragraph("座位数/吨位：" + carInfo.getSeatCount()+"/"+carInfo.getTonCount(), FontChinese));
                seatCount_ton.setColspan(1);
                seatCount_ton.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(seatCount_ton);

                Cell carkind = new Cell(new Paragraph("厂牌车型：" + carInfo.getPlatmodelname(), FontChinese));
                carkind.setColspan(2);
                carkind.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(carkind);

                Cell owner = new Cell(new Paragraph("行驶证车主：" + carInfo.getCarOwner(), FontChinese));
                owner.setColspan(2);
                owner.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(owner);

                String platmodelcode=carInfo.getPlatmodelcode();
                String rbCode=carInfo.getRbCode();
                Cell platModelCode = new Cell(new Paragraph("车型编码：本地:" +rbCode+"/平台:"+platmodelcode, FontChinese));
                platModelCode.setColspan(2);
                platModelCode.setBorder(Rectangle.NO_BORDER);
                carTable.addCell(platModelCode);

                if( pdfInfo.getInsuredList()[1].getInsuredType().equals("1")&&!(carInfo.getCarOwner().equals(""))&&!(pdfInfo.getInsuredList()[1].getInsuredName().equals(""))){
                    if("01".equals(pdfInfo.getInsuredList()[1].getIdentifyType())){
                        int insuredAge = ConfigUtils.getAge(pdfInfo.getInsuredList()[1].getIdentifyNumber());
                        String insuredSex = pdfInfo.getInsuredList()[1].getSex().equals("1") ? "男" : "女";
                        Cell insuredName = new Cell(new Paragraph("被保险人名称：" + pdfInfo.getInsuredList()[1].getInsuredName()+"("+insuredAge+"岁，"+insuredSex+")", FontChinese));
                        insuredName.setColspan(2);
                        insuredName.setBorder(Rectangle.NO_BORDER);
                        carTable.addCell(insuredName);
                    }
                     else {
                        String insuredSex = pdfInfo.getInsuredList()[1].getSex().equals("1") ? "男" : "女";
                        Cell insuredName = new Cell(new Paragraph("被保险人名称：" + pdfInfo.getInsuredList()[1].getInsuredName()+"("+insuredSex+")", FontChinese));
                        insuredName.setColspan(2);
                        insuredName.setBorder(Rectangle.NO_BORDER);
                        carTable.addCell(insuredName);
                    }

                }
                else{
                    Cell insuredName = new Cell(new Paragraph("被保险人名称：" + pdfInfo.getInsuredList()[1].getInsuredName(), FontChinese));
                    insuredName.setColspan(2);
                    insuredName.setBorder(Rectangle.NO_BORDER);
                    carTable.addCell(insuredName);
                }

                document.add(carTable);

                MainRequest main = pdfInfo.getMain();
                Table dateTable = new Table(4);

                dateTable.setWidths(widths);
                dateTable.setWidth(100);
                dateTable.setPadding(2);
                if (main.getStartDate() != null && main.getEndDate() != null) {
                    String startDate = main.getStartDate();
                    String[] startDateSplit = startDate.split("-");
                    String endDate = main.getEndDate();
                    String[] endDateSplit = endDate.split("-");
                    Cell syxDate = new Cell(new Paragraph("商业险保险期限：" + startDateSplit[0] + "年" + startDateSplit[1] + "月" + startDateSplit[2] + "日" + "00时至" + endDateSplit[0] + "年" + endDateSplit[1] + "月" + endDateSplit[2] + "日24时", FontChinese));
                    syxDate.setColspan(4);
                    syxDate.setBorder(Rectangle.NO_BORDER);
                    dateTable.addCell(syxDate);
                }

                if (main.getBzStartDate() != null && main.getBzEndDate() != null && (pdfInfo.getCombosList().length == 2)) {

                    String bzStartDate = main.getBzStartDate();
                    String[] bzStartDateSplit = bzStartDate.split("-");
                    String bzEndDate = main.getBzEndDate();
                    String[] bzEndDateSplit = bzEndDate.split("-");
                    Cell jxqDate = new Cell(new Paragraph("交强险保险期限：" + bzStartDateSplit[0] + "年" + bzStartDateSplit[1] + "月" + bzStartDateSplit[2] + "日" + "00时至" + bzEndDateSplit[0] + "年" + bzEndDateSplit[1] + "月" + bzEndDateSplit[2] + "日24时", FontChinese));
                    jxqDate.setColspan(4);
                    jxqDate.setBorder(Rectangle.NO_BORDER);
                    dateTable.addCell(jxqDate);

                }
                if (pdfInfo.getCombosList().length == 1) {
                    Cell jxqDate = new Cell(new Paragraph(""));
                    jxqDate.setColspan(2);
                    jxqDate.setBorder(Rectangle.NO_BORDER);
                    dateTable.addCell(jxqDate);
                }

                document.add(dateTable);




                Table kindTable = new Table(4);
                int kindWidths[] = {40, 15, 15, 30};
                kindTable.setWidths(kindWidths);
                kindTable.setWidth(100);
                kindTable.setPadding(2);

                Cell syxName = new Cell(new Paragraph("商业险", FontChinese));
                syxName.setColspan(4);
//      syxName.setBorder(Rectangle.NO_BORDER);
                syxName.setHorizontalAlignment(Element.ALIGN_CENTER);
                kindTable.addCell(syxName);

                Cell kindCode = new Cell(new Paragraph("险别", FontChinese));
                kindCode.setColspan(1);
//      kindCode.setBorder(Rectangle.NO_BORDER);
                kindTable.addCell(kindCode);

                Cell amount = new Cell(new Paragraph("保险金额(元)", FontChinese));
                amount.setColspan(1);
//      amount.setBorder(Rectangle.NO_BORDER);
                kindTable.addCell(amount);

                Cell premium = new Cell(new Paragraph("实收保费(元)", FontChinese));
                premium.setColspan(1);
//      premium.setBorder(Rectangle.NO_BORDER);
                kindTable.addCell(premium);

                Cell note = new Cell(new Paragraph("相关说明", FontChinese));
                note.setColspan(1);
//      note.setBorder(Rectangle.NO_BORDER);
                kindTable.addCell(note);


                for (int i = 0; i < syxItemKindList.length; i++) {
                    if (syxItemKindList[i].getDeductableFlag().equals("1")) {
                        if("001".equals(syxItemKindList[i].getKindCode())){
                            String m1Value=syxItemKindList[i].getM1Value();
                            kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName()+"(绝对免赔额："+m1Value+"元)", FontChinese));
                        }
                        else {
                            kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName(), FontChinese));
                        }
                        kindTable.addCell(new Paragraph(syxItemKindList[i].getAmount(), FontChinese));
                        kindTable.addCell(new Paragraph(syxItemKindList[i].getPremium(), FontChinese));
                        String deducTableKindCode = ConfigUtils.getValue(syxItemKindList[i].getKindCode());
                        for (int j = 0; j < syxItemKindList.length; j++) {
                            if (syxItemKindList[j].getKindCode().equals(deducTableKindCode)) {
                                kindTable.addCell(new Paragraph("包含不计免赔金额：" + syxItemKindList[j].getPremium() + "元", FontChinese));
                                break;
                            }
                        }

                    }
                    if (syxItemKindList[i].getDeductableFlag().equals("0") && !(syxItemKindList[i].getKindCode().substring(0, 1).equals("3"))) {
//                        kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName(), FontChinese));
                        if ("201".equals(syxItemKindList[i].getKindCode())) {
                            if ("1".equals(syxItemKindList[i].getModeCode())) {
                                kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName() + "(国产玻璃)", FontChinese));
                            }
                            if ("2".equals(syxItemKindList[i].getModeCode())) {
                                kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName() + "(进口玻璃)", FontChinese));
                            }
                        } else {
                            kindTable.addCell(new Paragraph(syxItemKindList[i].getKindName(), FontChinese));
                        }
                        kindTable.addCell(new Paragraph(syxItemKindList[i].getAmount(), FontChinese));
                        kindTable.addCell(new Paragraph(syxItemKindList[i].getPremium(), FontChinese));
                        kindTable.addCell(new Paragraph("", FontChinese));
                    }

                }

                Cell syxSumPremium = new Cell(new Paragraph("商业险保费合计：" + pdfInfo.getCombosList()[0].getSumPremium() + "元，保单折扣系数："+pdfInfo.getCombosList()[0].getRatioInfo().getFinalRatio(), FontChinese));
                syxSumPremium.setColspan(4);
//      kindCode.setBorder(Rectangle.NO_BORDER);
                syxSumPremium.setHorizontalAlignment(Element.ALIGN_CENTER);
                kindTable.addCell(syxSumPremium);

                if (pdfInfo.getCombosList().length == 2) {
                    Cell jqxSumPremium = new Cell(new Paragraph("交强险保费合计：" + pdfInfo.getCombosList()[1].getSumPremium() + "元，保单折扣系数："+pdfInfo.getCombosList()[1].getSumDiscount(), FontChinese));
                    jqxSumPremium.setColspan(4);
//      kindCode.setBorder(Rectangle.NO_BORDER);
                    jqxSumPremium.setHorizontalAlignment(Element.ALIGN_CENTER);
                    kindTable.addCell(jqxSumPremium);

                    Cell cqxPremium = new Cell(new Paragraph("车船税税款合计：" + pdfInfo.getCarShipTaxInfo().getSumPayTax() + "元", FontChinese));
                    cqxPremium.setColspan(4);
//      kindCode.setBorder(Rectangle.NO_BORDER);
                    cqxPremium.setHorizontalAlignment(Element.ALIGN_CENTER);
                    kindTable.addCell(cqxPremium);
                }

//计算总保费
                BigDecimal totalPremium = new BigDecimal(0.00);
                CombosDataRequest[] combosList = pdfInfo.getCombosList();
                for (int i = 0; i < combosList.length; i++) {
                    totalPremium = new BigDecimal(combosList[i].getSumPremium()).add(totalPremium);
                }
                if (combosList.length == 2) {
                    totalPremium = new BigDecimal(pdfInfo.getCarShipTaxInfo().getSumPayTax()).add(totalPremium);
                }

                Cell sumPremium = new Cell(new Paragraph("您需要支付的保费及税款合计：" + totalPremium + "元", FontChinese));
                sumPremium.setColspan(4);
//      kindCode.setBorder(Rectangle.NO_BORDER);
                sumPremium.setHorizontalAlignment(Element.ALIGN_CENTER);
                kindTable.addCell(sumPremium);

                document.add(kindTable);

//                上年理赔记录
                ClaimDataRequest[] claimList = pdfInfo.getClaimList();
                if(claimList!=null){
                    Table claimTable = new Table(4);
                    int claimWidths[] = {25, 25, 25, 25};
                    claimTable.setWidths(claimWidths);
                    claimTable.setWidth(100);
                    claimTable.setPadding(2);
                    claimTable.setBorder(Rectangle.NO_BORDER);

                    Cell claimInfoCell = new Cell(new Phrase("上年理赔记录：", FontChinese));
                    claimInfoCell.setColspan(4);
                    claimInfoCell.setBorder(Rectangle.NO_BORDER);
                    claimTable.addCell(claimInfoCell);

                    Cell riskCell = new Cell(new Phrase("险种", FontChinese));
                    riskCell.setColspan(1);
                    claimTable.addCell(riskCell);

                    Cell accidentTimeCell = new Cell(new Phrase("出险时间", FontChinese));
                    accidentTimeCell.setColspan(1);
                    claimTable.addCell(accidentTimeCell);

                    Cell endcaseTimeCell = new Cell(new Phrase("结案时间", FontChinese));
                    endcaseTimeCell.setColspan(1);
                    claimTable.addCell(endcaseTimeCell);

                    Cell claimAmountCell = new Cell(new Phrase("赔付金额(元)", FontChinese));
                    claimAmountCell.setColspan(1);
                    claimTable.addCell(claimAmountCell);


                        for(int i=0;i<claimList.length;i++){
                            claimTable.addCell(new Paragraph("V".equals(claimList[i].getDemandNo().substring(0,1))?"商业险":"交强险",FontChinese));
                            claimTable.addCell(new Paragraph(claimList[i].getAccidentTime(),FontChinese));
                            claimTable.addCell(new Paragraph(claimList[i].getEndcaseTime(),FontChinese));
                            claimTable.addCell(new Paragraph(String.valueOf(claimList[i].getClaimAmount()),FontChinese));
                        }



                    document.add(claimTable);
                }


                document.close();
                byte[] bytes = bos.toByteArray();


                if (response instanceof HashMap) {
                    HashMap map = (HashMap) response;
                    map.put(demandNo, bytes);
                    return response;
                }

            } catch (Exception e) {

                e.printStackTrace();
                return null;
            } finally {


            }

        }
        return null;
    }

    @Override
    public void asynWtireLog(LogDTO logDTO) {

    }


}
