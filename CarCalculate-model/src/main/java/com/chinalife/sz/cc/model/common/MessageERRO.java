package com.chinalife.sz.cc.model.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.prs.framework.util.IDCardUtils;

public class MessageERRO {
	public static final String[] SUSESS_MESSAGE = { "0000", "成功" };

	public static final String[] FAILURE_MESSAGE = { "0001", "失败" };

	public static final String RESPONSE = "Response";

	public static final String[] JSON_ERROR = { "9006", "json解析异常，请检查是否符合接口规范" };

	public static final String[] JSON_NULL_ERROR = { "9013", "json为空" };

	public static final String[] XML_ERROR = { "9015", "xml解析异常，请检查是否符合接口规范" };

	public static final String[] XML_NULL_ERROR = { "9016", "xml为空" };

	public static final String[] EXP_ERROR = { "9007", "后台操作失败，重复数据或数据无效" };

	public static final String[] EXP_APP_NO_ERROR = { "9301", "投保单号无效" };

	public static final String[] EXP_APP_NO_REP_ERROR = { "9302", "请检查是否重复投保" };

	public static final String[] EXP_DATE_NOW_ERROR = { "9303", "投保日期不能小于当前时间" };

	public static final String[] EXP_BUSINESS_ERROR = { "9304", "业务信息无效，请检查是否符合接口规范" };

	public static final String[] EXP_REQUEST_CODE_ERRO = { "9305", "REQUEST_CODE有误，请检查是否符合接口规范" };

	public static final String[] EXP_USER_ERRO = { "9306", "用户不存在" };
	public static final String[] EXP_PASSWORD_ERRO = { "9307", "密码错误" };
	public static final String[] EXP_PROD_ID_ERRO = { "9308", "险种代码不存在" };
	public static final String[] EXP_DEPT_ID_ERRO = { "9309", "承保机构代码不存在" };
	public static final String[] EXP_NO_RECORD_ERRO = { "9310", "未找到有效承保记录" };
	public static final String[] EXP_RE_SUBMIT_ERRO = { "9311", "请勿重复提交" };
	public static final String[] EXP_PRIMARY_GENERATER_ERROR = { "9312", "主键生成异常，请检查是否符合接口规范" };
	public static final String[] EXP_RE_POL_ERRO = { "9313", "保单已经完成，请勿重复请求" };

	public static final String[] EXP_POL_NO_ERROR = { "9312", "没有该保单号" };

	public static final String[] EXP_CERT_ID_ERRO_ERRO = { "9103", "被保险人证件号码/组织机构代码填写有误" };
	public static final String[] EXP_INSURED_NAME_ERRO_ERRO = { "9104", "被保险人中文名称填写有误" };

	public static final String SUSESS_QUERY_MESSAGE = "成功";
	public static final String FAILURE_QUERY_MESSAGE0 = "未找到对应保单信息";
	public static final String FAILURE_QUERY_MESSAGE1 = "未找到对应保单号";

	/**
	 * 报文头规则及说明 [0]:是否为空 [1]:长度 [2]:参考值多个参数采用 && 进行分割 [3]:错误代码 [4]:描述
	 */
	// ***************************************货运信息报文提示*******************************************************
	public static final String[] REQUEST_CODE_ERRO = { "Y", "2", "V1&&V2&&V3&&V4&&V5", "9001", "数据处理失败，请检查是否符合接口规范" };
	public static final String[] REQUEST_TYPE_ERRO = { "Y", "10", "Request", "9002", "错误的请求类型，请检查是否符合接口规范" };
	public static final String[] USER_ERRO = { "Y", "32", "", "9003", "用户格式填写有误" };
	public static final String[] PASSWORD_ERRO = { "Y", "32", "", "9004", "密码填写有误" };
	public static final String[] PROD_ID_ERRO = { "Y", "4", "", "9005", "险种代码有误" };
	public static final String[] DEPT_ID_ERRO = { "Y", "4", "", "9006", "承保机构代码有误" };

	// 0-个人、1-企业
	public static final String[] INSURED_TYPE_ERRO = { "Y", "1", "0&&1", "9101", "被保险人类型填写有误" };
	public static final String[] ACCIDENT_TYPE_ERRO = { "Y", "2", "01&&02&&03", "9101", "被保险人类型填写有误" };
	public static final String[] ACCIDENT_TYPE_NULL_ERRO = { "N", "2", "01&&02&&03", "9101", "被保险人类型填写有误" };
	public static final String[] VIP_ERRO = { "Y", "1", "0&&1", "9102", "VIP类型填写有误" };
	public static final String[] INSURED_CERT_ID_ERRO = { "Y", "64", "", "9103", "被保险人证件号码/组织机构代码填写有误" };
	public static final String[] CUSTOMER_ID_ERRO = { "Y", "30", "", "9103", "被保险人证件号码填写有误" };
	public static final String[] INSURED_NAME_ERRO = { "Y", "64", "", "9104", "被保险人中文名称填写有误" };
	public static final String[] CUSTOMER_NAME_ERRO = { "Y", "120", "", "9104", "客户名称填写有误" };
	// yyymmdd的格式验证
	public static final String[] DEPARTURE_FORMAT_DATE_ERRO = { "Y", "8", "", "9105", "起运日期格式有误" };
	public static final String[] DEPARTURE_FORMAT_DATE14_ERRO = { "Y", "14", "", "9105", "起运日期填写有误" };
	public static final String[] DEPARTURE_DATE_ERRO = { "Y", "8", "", "9125", "起运日期不能早于当天" };
	public static final String[] TRANS_WAY_ERRO = { "Y", "1", "0&&1", "9106", "运输方式填写有误" };
	public static final String[] DEST_ADDR_ERRO = { "Y", "128", "", "9107", "运输目的地填写有误" };
	public static final String[] CARRIER_NAME_ERRO = { "Y", "64", "", "9108", "承运人名称填写有误" };
	public static final String[] CARRIER_AMOUNT_ERRO = { "N", "14", "", "9109", "承运人委托投保保额填写有误" };
	public static final String[] TRACING_NO_ERRO = { "Y", "64", "", "9110", "运单/货票号码填写有误" };
	public static final String[] FROM_CITY_ERRO = { "Y", "128", "", "9111", "起运地/中转地填写有误" };
	// 整型0-999
	public static final String[] QUANTITY_ERRO = { "Y", "10", "", "9112", "件数/数量填写有误" };
	public static final String[] AMOUNT_ERRO = { "Y", "14", "", "9113", "保额填写有误" };
	public static final String[] AMOUNT_ERRO_1 = { "Y", "14", "3000000", "9113", "保额填写有误" };
	public static final String[] AMOUNT_ERRO_2 = { "Y", "14", "800000", "9113", "保额填写有误" };
	public static final String[] ORDER_ID_ERRO = { "Y", "32", "", "9114", "订单号填写有误" };
	public static final String[] CARGO_TYPE_ERRO = { "Y", "128", "", "9115", "货物类型填写有误" };
	// 承保时需要验证这三个接口
	public static final String[] CARGO_PREMIUM_ERRO = { "Y", "14", "", "9116", "保费填写有误" };
	public static final String[] CARGO_INPUT_DATE_ERRO = { "Y", "8", "", "9117", "对帐日期填写有误" };
	public static final String[] CARGO_APP_NO_ERRO = { "Y", "32", "", "9118", "投保单号填写有误" };
	// M F 格式
	public static final String[] ACCIDENT_SEX = { "Y", "1", "M&&F", "9119", "性别填写有误" };
	// yyyyMMddHHmmss的格式验证
	public static final String[] EFFECTIVE_FORMAT_DATE_ERRO = { "Y", "14", "", "9120", "保险起保日期格式有误" };
	public static final String[] EFFECTIVE_DATE_ERRO = { "Y", "14", "", "9121", "保险日期不能早于当前日期" };
	// 客户类型 1001:STUDENT;1002:TRAINER
	public static final String[] CLIENT_TYPE_ERRO = { "Y", "7", "1001&&1002", "9122", "客户类型填写有误" };
	// yyyyMMdd 出生日期
	public static final String[] BIRTHDAY_FORMAT_DATE_ERRO = { "Y", "8", "", "9123", "出生日期格式有误" };
	public static final String[] BIRTHDAY_DATE_ERRO = { "Y", "8", "", "9124", "出生日期与身份证日期不一致" };

	//
	public static final String[] CUSTOMER_CRIT_TYPE_ERRO = { "Y", "2", "01&&02&&03&&04&&05", "9126", "客户证件类型填写有误" };
	public static final String[] CUSTOMER_CRIT_TYPE_FORMAT_ERRO = { "Y", "2",
			"1&&2&&3&&4&&5&&6&&7&&8&&10&&12&&14&&15&&16&&17&&18&&19&&20&&21", "9126", "客户证件类型填写有误" };
	public static final String[] SUBSTATION_ID_ERRO = { "Y", "10", "", "9127", "站点编号填写有误" };
	public static final String[] SUBSTATION_NAME_ERRO = { "Y", "120", "", "9128", "起始站名称填写有误" };
	public static final String[] TO_NAME_ERRO = { "Y", "10", "", "9129", "终点站名称填写有误" };
	public static final String[] MILEAGE_ERRO = { "Y", "9", "", "9130", "公里数填写有误" };
	public static final String[] TKPRINT_NO_ERRO = { "Y", "10", "", "9131", "印刷号填写有误" };
	public static final String[] OPER_CODE_ERRO = { "N", "25", "", "9132", "操作员填写有误" }; // 可为空
	public static final String[] TICKET_NO_ERRO = { "Y", "10", "", "9133", "车票号填写有误" };
	public static final String[] SEAT_NO_ERRO = { "Y", "10", "", "9134", "座位号填写有误" };
	public static final String[] SERIAL_NO_ERRO = { "Y", "14", "", "9135", "业务流水号填写有误" };
	public static final String[] PHO_ERRO = { "Y", "11", "", "9136", "被保险人手机号填写有误" };
	public static final String[] INSURANCE_AGENT_ID_ERRO = { "Y", "10", "", "9148", "客运公司编号填写有误" };
	public static final String[] INSURANCE_AGENT_NAME_ERRO = { "Y", "120", "", "9149", "客运公司名称填写有误" };
	public static final String[] AREACODE_ERRO = { "Y", "4", "", "9150", "地区代码填写有误" };
	public static final String[] END_DATE_ERRO = { "Y", "14", "", "9151", "保单止保日期填写有误" }; // 保单止保日期填写有误
																							// (如此可避免格式错误和在其它时间之后的错误对比了)
	// 易到试驾
	public static final String[] LICENSE_NO_ERRO = { "Y", "16", "", "9137", "车牌号填写有误" };
	public static final String[] CITY_ERRO = { "Y", "64", "", "9138", "城市填写有误" };
	public static final String[] GET_ON_SPOT_ERRO = { "Y", "64", "", "9139", "上车地点填写有误" };
	public static final String[] DROP_OFF_AREA_ERRO = { "N", "32", "", "9140", "下车地点填写有误" }; // 可为空
	public static final String[] CLIENT_NAME_ERRO = { "N", "32", "", "9141", "乘客姓名填写有误" }; // 可为空
	public static final String[] MOBILE_PHONE_ERRO = { "Y", "32", "", "9142", "乘客手机号填写有误" };
	public static final String[] EFF_TM_ERRO = { "Y", "32", "", "9143", "开始时间填写有误" };
	public static final String[] EXP_TM_ERRO = { "Y", "32", "", "9144", "结束时间填写有误" };
	public static final String[] ACC_NAME_ERRO = { "Y", "64", "", "9145", "陪同人员姓名填写有误" };
	public static final String[] ACC_PHONE_ERRO = { "Y", "32", "", "9146", "陪同人员手机号填写有误" };
	public static final String[] QUERY_ID_ERRO = { "Y", "32", "", "9147", "查询号填写有误" };

	// 家政
	public static final String[] INS_NME = { "Y", "64", "", "9147", "被保险人填写有误" };
	public static final String[] INS_TEL = { "Y", "32", "", "9148", "被保险人联系电话填写有误" };
	public static final String[] INS_ADDR = { "Y", "64", "", "9149", "被保险人联系地址填写有误" };
	public static final String[] INS_AREA = { "Y", "32", "", "9150", "被保险人地区填写有误" };

	public static final String[] PERIOD = { "Y", "2", "01&&02&&03&&04&&05&&06&&07&&08&&09&&10&&11&&12", "9150",
			"保险期限填写有误" };
	public static final String[] SCHEME = { "Y", "1", "A&&B&&C", "9151", "投保方案填写有误" };
	public static final String[] HK_NME = { "Y", "64", "", "9152", "保姆姓名填写有误" };
	public static final String[] HK_CERT_ID = { "Y", "18", "", "9153", "保姆身份证号填写有误" };
	public static final String[] HK_CERT_ID_ERRO = { "Y", "18", "", "9154", "被保险人证件号码/组织机构代码填写有误" };
	public static final String[] INS_CERT_ID = { "Y", "32", "", "9155", "被保险人填写有误" };
	public static final String[] EFFECTIVE_FORMAT_DATE = { "Y", "19", "", "9156", "保险起保日期格式有误" };

	public static final String[] QYERT_LIST_ERRO = { "Y", "10", "", "9157", "查询条件填写有误" };
	public static final String[] QYERT_LIST20_ERRO = { "Y", "20", "", "9157", "查询条件填写有误" };

	// 恰恰 -萌萌学车
	public static final String[] HOURS_ERRO = { "Y", "2", "", "9158", "小时填写有误" };

	// 众辉达物流
	public static final String[] CARRIER_WORTH_ERRO = { "N", "14", "", "9159", "货物价值填写有误" };
	public static final String[] ACCEPT_NUM_ERRO = { "N", "9", "", "9160", "购买保险份数填写有误" };
	public static final String[] CARGO_NME_ERRO = { "Y", "128", "", "9161", "货物名称填写有误" };
	public static final String[] CUR_DIST_POINT_ERRO = { "Y", "128", "", "9162", "当前配送节点填写有误" };
	public static final String[] NEXT_DIST_POINT_ERRO = { "Y", "128", "", "9163", "下一配送节点填写有误" };
	public static final String[] LICENSE_NO32_ERRO = { "Y", "32", "", "9137", "车牌号填写有误" };
	public static final String[] BUSINESS_ID_ERRO = { "Y", "32", "", "9164", "业务ID填写有误" };
	public static final String[] CARGO_STATUS_ERRO = { "Y", "1", "0&&1&&2", "9165", "货物状态填写有误" };
	public static final String[] IS_FINISH_POINT_ERRO = { "Y", "1", "0&&1", "9166", "最终流转节点填写有误" };
	public static final String[] DEPARTURE_TM_ERRO = { "Y", "14", "", "9167", "发车时间填写有误" };

	public static final String[] POL_NO_ERRO = { "Y", "32", "", "9168", "保单号填写有误" };

	// 味库 食品安全
	public static final String[] DEPARTURE_TM_WC_ERRO = { "Y", "14", "", "9169", "送货时间填写有误" };
	public static final String[] CLEINT_NME_ERRO = { "Y", "32", "", "9170", "客户中文名称填写有误" };
	public static final String[] CLIENT_ID_ERRO = { "Y", "32", "", "9171", "客户ID填写有误" };
	public static final String[] FOOD_ID_ERRO = { "Y", "32", "", "9172", "菜品ID填写有误" };
	public static final String[] FOOD_NME_ERRO = { "Y", "64", "", "9173", "菜品名称填写有误" };
	public static final String[] ACCEPT_NUM_WC_ERRO = { "Y", "9", "", "9174", "菜品购买保险份数填写有误" };
	public static final String[] MFRS_NME_ERRO = { "Y", "64", "", "9175", "生产商名称填写有误" };
	public static final String[] DEST_ADDR_WC_ERRO = { "Y", "128", "", "9176", "配送地址填写有误" };
	public static final String[] MAKE_TM_ERRO = { "Y", "14", "", "9177", "制作时间填写有误" };

	// 微狐 app
	public static final String[] APP_NME_ERRO = { "Y", "32", "", "9178", "投保人姓名填写有误" };
	public static final String[] APP_NATURE_ERRO = { "Y", "1", "3&&4", "9179", "投保人性质填写有误" };
	public static final String[] APP_CERT_TYPE_ERRO = { "Y", "2", "01&&02&&03&&04&&05&&06&&07&&08&&10&&12&&13&&99",
			"9180", "投保人证件类型填写有误" };
	public static final String[] APP_CERT_ID_ERRO = { "Y", "32", "", "9181", "投保人证件号码填写有误" };
	public static final String[] APP_INS_REL_ERRO = { "Y", "2",
			"01&&10&&11&&12&&20&&30&&40&&50&&51&&52&&61&&62&&63&&64&&66&&67&&68&&80&&81&&99", "9182", "投被保险人关系填写有误" };
	public static final String[] INS_NME_ERRO = { "Y", "32", "", "9183", "被保人姓名填写有误" };
	public static final String[] INS_CERT_TYPE_ERRO = { "Y", "2", "01&&02&&03&&04&&05&&06&&07&&08&&10&&12&&13&&99",
			"9184", "被保人证件类型填写有误" };
	public static final String[] INS_NATURE_ERRO = { "Y", "1", "3&&4", "9185", "被保人客户性质填写有误" };
	// public static final String[] INS_CERT_ID_ERRO =
	// {"Y","32","","9186","被保人证件号码填写有误"};
	public static final String[] INS_SHL_NME_ERRO = { "Y", "64", "", "9187", "被保险人学校名称填写有误" };
	public static final String[] INS_SHL_CLS_ERRO = { "Y", "32", "", "9188", "被保险人班级填写有误" };
	public static final String[] INS_BRD_ERRO = { "N", "14", "", "9189", "被保险人出生日期填写有误" };
	public static final String[] INS_SEX_ERRO = { "N", "1", "1&&2", "9190", "被保险人性别填写有误" };

	// 微狐 pol
	public static final String[] I_APP_NME_ERRO = { "9222", "投保人姓名与投保查询时不一致,请重新投保查询" };
	public static final String[] I_APP_NATURE_ERRO = { "9223", "投保人性质与投保查询时不一致,请重新投保查询" };
	public static final String[] I_APP_CERT_TYPE_ERRO = { "9224", "投保人证件类型与投保查询时不一致,请重新投保查询" };
	public static final String[] I_APP_CERT_ID_ERRO = { "9225", "投保人证件号码与投保查询时不一致,请重新投保查询" };
	public static final String[] I_APP_INS_REL_ERRO = { "9226", "投被保险人关系与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_NME_ERRO = { "9227", "被保人姓名与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_NATURE_ERRO = { "9228", "被保人客户性质与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_SHL_NME_ERRO = { "9229", "被保险人学校名称与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_SHL_CLS_ERRO = { "9230", "被保险人班级与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_BRD_ERRO = { "9231", "被保险人出生日期与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INS_SEX_ERRO = { "9232", "被保险人性别与投保查询时不一致,请重新投保查询" };
	public static final String[] I_EFF_TM_ERRO = { "9233", "保险起保时间与投保查询时不一致,请重新投保查询" };
	public static final String[] I_QUERY_NO_ERRO = { "9234", "查询单号与投保查询时不一致,请重新投保查询" };

	public static final String[] GET_POL_NO_ERRO = { "9235", "获取保单号失败" };

	// 就你行 人身意外
	public static final String[] EMP_NME_ERRO = { "Y", "64", "", "9178", "雇主名字填写有误" };
	public static final String[] EMP_CERT_TYPE_ERRO = { "Y", "2", "", "9179", "雇主证件类型填写有误" };
	public static final String[] EMP_CERT_ID_ERRO = { "Y", "30", "", "9180", "雇主证件号码填写有误" };
	public static final String[] WORKER_NME_ERRO = { "Y", "64", "", "9181", "雇主名字填写有误" };
	public static final String[] WORKER_ID_ERRO = { "Y", "30", "", "9182", "工人身份证号填写有误" };
	public static final String[] WORKPLACE_ERRO = { "Y", "64", "", "9183", "工作地点填写有误" };
	public static final String[] WORK_CNT_ERRO = { "Y", "64", "", "9184", "工作内容填写有误" };

	// 知行致远
	public static final String[] ZXZY_ACC_NAME_ERRO = { "Y", "64", "", "9185", "代驾司机姓名填写有误" };
	public static final String[] ZXZY_ACC_PHONE_ERRO = { "Y", "32", "", "9186", "代驾司机手机号填写有误" };
	public static final String[] ZXZY_DROP_OFF_AREA_ERRO = { "Y", "32", "", "9187", "下车地点填写有误" }; // 可为空

	// ***************************************货运信息报文提示************==================************************

	// ***************************************承保和试算信息验证提示***************************************************
	public static final String[] I_REQUEST_CODE_ERRO = { "9014", "数据处理失败，请检查是否符合接口规范与投保查询时不一致,请重新投保查询" };
	public static final String[] I_REQUEST_TYPE_ERRO = { "9008", "错误的请求类型，请检查是否符合接口规范与投保查询时不一致,请重新投保查询" };
	public static final String[] I_USER_ERRO = { "9009", "用户格式填写有误与投保查询时不一致,请重新投保查询" };
	public static final String[] I_PASSWORD_ERRO = { "9010", "密码填写有误与投保查询时不一致,请重新投保查询" };
	public static final String[] I_PROD_ID_ERRO = { "9011", "险种代码有误与投保查询时不一致,请重新投保查询" };
	public static final String[] I_DEPT_ID_ERRO = { "9012", "承保机构代码有误与投保查询时不一致,请重新投保查询" };

	public static final String[] I_INSURED_TYPE_ERRO = { "9201", "被保险人类型与投保查询时不一致,请重新投保查询" };
	public static final String[] I_VIP_ERRO = { "9202", "VIP类型与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INSURED_CERT_ID_ERRO = { "9203", "被保险人证件号码/组织机构代码与投保查询时不一致,请重新投保查询" };
	public static final String[] I_INSURED_NAME_ERRO = { "9204", "被保险人中文名称与投保查询时不一致,请重新投保查询" };
	// yyymmdd的格式验证
	public static final String[] I_DEPARTURE_DATE_ERRO = { "9205", "起运日期与投保查询时不一致,请重新投保查询" };
	public static final String[] I_TRANS_WAY_ERRO = { "9206", "运输方式与投保查询时不一致,请重新投保查询" };
	public static final String[] I_DEST_ADDR_ERRO = { "9207", "运输目的地与投保查询时不一致,请重新投保查询" };
	public static final String[] I_TRACING_NO_ERRO = { "9208", "运单/货票号码与投保查询时不一致,请重新投保查询" };
	public static final String[] I_CARRIER_NAME_ERRO = { "9209", "承运人名称与投保查询时不一致,请重新投保查询" };
	public static final String[] I_CARRIER_AMOUNT_ERRO = { "9210", "承运人委托投保保额与投保查询时不一致,请重新投保查询" };
	public static final String[] I_FROM_CITY_ERRO = { "9211", "起运地/中转地与投保查询时不一致,请重新投保查询" };
	// 整型0-999
	public static final String[] I_QUANTITY_ERRO = { "9212", "件数/数量与投保查询时不一致,请重新投保查询" };
	public static final String[] I_AMOUNT_ERRO = { "9213", "保额与投保查询时不一致,请重新投保查询" };
	public static final String[] I_ORDER_ID_ERRO = { "9214", " 订单号与投保查询时不一致,请重新投保查询" };
	public static final String[] I_CARGO_TYPE_ERRO = { "9215", "货物类型与投保查询时不一致,请重新投保查询" };
	public static final String[] I_PREMIUM_ERRO = { "9216", "保费与投保查询时不一致,请重新投保查询" };
	// yyymmdd的格式验证
	public static final String[] I_INPUT_DATE_ERRO = { "9217", "对帐日期与投保查询时不一致,请重新投保查询" };
	public static final String[] I_APP_NO_ERRO = { "9218", "投保单号无效" };

	public static final String[] I_REPEAT_ORDERID_ERRO = { "9219", "订单号已存在" };

	public static final String[] ACCEPT_NUM_ISBIG_ERRO = { "9220", "购买保险份数大于货物的实际价值" };
	public static final String[] DEPARTURE_TM_BEFORE_ERRO = { "9221", "发车时间应该在开始时间之后" };
	// ***************************************承保和试算信息验证提示************==================****************************

	/**
	 * @param str
	 *            当前类的数据变量
	 * @param value
	 *            传入得实际值
	 * @return
	 */
	public static Map<String, Object> stringMessageError(String[] str, String value) {
		Map<String, Object> map = null;
		boolean isEmpty = "Y".equals(str[0]) ? true : false;
		int len = Integer.parseInt(str[1]);
		String reference = str[2];
		String responseCode = str[3];
		String responseDesc = str[4];
		if (StringUtils.isNotEmpty(value)) {// 当前值是否为空
			// 处理长度验证
			if (len < value.length()) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}
			if (StringUtils.isNotEmpty(reference)) {
				boolean flag = true;
				String[] refer = reference.split("&&");
				for (String ref : refer) {
					if (value.equals(ref)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					map = new HashMap<String, Object>();
					map.put("ERROR_CODE", responseCode);
					map.put("ERROR_DESC", responseDesc);
					return map;
				}
			}
		} else {
			if (isEmpty) {// 是否允许为空
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}
		}
		return map;
	}

	/**
	 * 日期比较
	 * 
	 * @param str
	 * @param value
	 * @param date
	 * @param param
	 *            日期格式
	 * @param equalDay
	 *            等于当天日期
	 * @return
	 */
	public static Map<String, Object> dateMessageError(String[] str, String value, Date date, String param) {
		Map<String, Object> map = null;
		String responseCode = str[3];
		String responseDesc = str[4];
		DateFormat dateFormat = null;
		boolean convertSuccess = true;
		if (StringUtils.isNotEmpty(param) && param.equals("small")) {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		} else if (StringUtils.isNotEmpty(param) && param.equals("format")) {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			dateFormat = new SimpleDateFormat("yyyyMMdd");
		}
		try {
			// 转换异常则日期格式不正确
			try {
				// 设置lenient为false.
				// 否则SimpleDateFormat会比较宽松地验证日期，比如2015/06/02会被接受
				dateFormat.setLenient(false);
				dateFormat.parse(value);
			} catch (Exception e) {
				convertSuccess = false;
			}
			if (!convertSuccess) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}

			if (date != null) {
				// 得到参考值时间转换成对于的值
				String valueDateStr = dateFormat.format(date);
				// 重新设置参考时间
				Date valueDate = (Date) dateFormat.parse(valueDateStr);
				// 实际值
				Date rvalue = (Date) dateFormat.parse(value);
				// 实际值小于 参考值
				if (rvalue.getTime() < valueDate.getTime()) {
					map = new HashMap<String, Object>();
					map.put("ERROR_CODE", responseCode);
					map.put("ERROR_DESC", responseDesc);
					return map;
				}
			}
		} catch (ParseException e) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", responseCode);
			map.put("ERROR_DESC", responseDesc);
			return map;
		}
		return map;
	}

	/**
	 * 件数的验证 0~999 验证 ^(0|([1-9]\d{0,2}))$
	 */
	public static Map<String, Object> intMessageError(String[] str, String value) {
		Map<String, Object> map = null;
		if (StringUtils.isNotEmpty(value)) {
			String responseCode = str[3];
			String responseDesc = str[4];
			Pattern pattern = Pattern.compile("^(0|([1-9]\\d{0,2}))$");
			Matcher matcher = pattern.matcher(value);
			if (!matcher.find()) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}
		}
		return map;
	}

	/**
	 * 正则匹配
	 * 
	 * @param str
	 * @param value
	 * @param regex:
	 *            ^()$
	 */
	public static Map<String, Object> regexMessageError(String[] str, String value, String regex) {
		Map<String, Object> map = null;
		if (StringUtils.isNotEmpty(value)) {
			String responseCode = str[3];
			String responseDesc = str[4];
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			if (!matcher.find()) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}
		}
		return map;
	}

	/**
	 * 金额的验证
	 */
	public static Map<String, Object> doubleMessageError(String[] str, String value) {
		Map<String, Object> map = null;
		if (StringUtils.isNotEmpty(value)) {
			String responseCode = str[3];
			String responseDesc = str[4];
			Pattern pattern = Pattern.compile("^(([0-9]{1}\\d*)|([0]{2}))(\\.(\\d){0,2})?$");
			Matcher matcher = pattern.matcher(value);
			if (!matcher.find()) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}
		}
		return map;
	}

	/**
	 * 金额的验证
	 */
	public static Map<String, Object> doubleMessageErrorLong(String[] str, String value) {
		Map<String, Object> map = null;
		String reference = str[2];
		String responseCode = str[3];
		String responseDesc = str[4];
		if (StringUtils.isNotEmpty(value)) {

			Pattern pattern = Pattern.compile("^(([0-9]{1}\\d*)|([0]{2}))(\\.(\\d){0,2})?$");
			Matcher matcher = pattern.matcher(value);
			if (!matcher.find()) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			} else {
				double ref = Double.parseDouble(reference);
				double val = Double.parseDouble(value);
				if (val > ref) {
					map = new HashMap<String, Object>();
					map.put("ERROR_CODE", responseCode);
					map.put("ERROR_DESC", responseDesc);
					return map;
				}
			}
		}
		return map;
	}

	/**
	 * 身份证证验证
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> iDCardmessageError(String[] str, String value) {
		Map<String, Object> map = null;
		String responseCode = str[3];
		String responseDesc = str[4];
		if (StringUtils.isNotEmpty(value)) {
			String IDCardNum = value;
			IDCardUtils idcard = new IDCardUtils();
			@SuppressWarnings("static-access")
			String message = idcard.IDCardValidate(IDCardNum);
			if (StringUtils.isNotEmpty(message)) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
			}
		}
		return map;
	}

	/**
	 * string单值比较赋值
	 * 
	 * @return
	 */
	public static Map<String, Object> stringCompare(String[] str, String value01, String value02) {
		Map<String, Object> map = null;
		if (!value01.equals(value02)) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * date单值比较赋值
	 */
	public static Map<String, Object> dateCompare(String[] str, Date date01, Date date02, String dateStr) {
		Map<String, Object> map = null;

		DateFormat dateFormat = new SimpleDateFormat(StringUtils.isNotEmpty(dateStr) ? dateStr : "yyyyMMdd");
		String value01 = dateFormat.format(date01);
		String value02 = dateFormat.format(date02);
		if (!value01.equals(value02)) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * float单值比较赋值
	 * 
	 * @return
	 */
	public static Map<String, Object> floatCompare(String[] str, float value01, float value02) {
		Map<String, Object> map = null;
		if (value01 != value02) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * double单值比较赋值
	 * 
	 * @return
	 */
	public static Map<String, Object> doubleCompare(String[] str, double value01, double value02) {
		Map<String, Object> map = null;
		if (value01 != value02) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * 整型单值比较赋值
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> intCompare(String[] str, int value01, int value02) {
		Map<String, Object> map = null;
		if (value01 != value02) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * 单值错误赋值
	 * 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> messageError(String[] str) {
		Map<String, Object> map = null;
		if (str != null) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", str[0]);
			map.put("ERROR_DESC", str[1]);
			return map;
		}
		return map;
	}

	/**
	 * 出生日期验证
	 * 
	 * @param str
	 * @param value
	 * @param date
	 * @return
	 */
	public static Map<String, Object> birthdayDateMessageError(String[] str, String value, String certType,
			String certId) {
		Map<String, Object> map = null;
		String responseCode = str[3];
		String responseDesc = str[4];
		boolean convertSuccess = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date birthday = null;
		Date certIdBirthday = null;

		try {
			// 转换异常则日期格式不正确
			try {
				// 设置lenient为false.
				// 否则SimpleDateFormat会比较宽松地验证日期，比如2015/06/02会被接受
				dateFormat.setLenient(false);
				birthday = (Date) dateFormat.parse(value);
			} catch (Exception e) {
				convertSuccess = false;
			}
			if (!convertSuccess) {
				map = new HashMap<String, Object>();
				map.put("ERROR_CODE", responseCode);
				map.put("ERROR_DESC", responseDesc);
				return map;
			}

			if (certId != null) {
				if (StringUtils.isNotEmpty(certType) && "01".equals(certType)) { // 证件类型
																					// 01.身份证
					String strYear = certId.substring(6, 10); // 年份
					String strMonth = certId.substring(10, 12); // 月份
					String strDay = certId.substring(12, 14); // 月份
					String strBirthday = strYear + strMonth + strDay;
					certIdBirthday = (Date) dateFormat.parse(strBirthday);
					// 验证出生日期是否与身份证日期一致 yyyyMMdd
					if (!DateUtils.isSameDay(birthday, certIdBirthday)) {
						map = new HashMap<String, Object>();
						map.put("ERROR_CODE", responseCode);
						map.put("ERROR_DESC", responseDesc);
						return map;
					}
				}
			}
		} catch (ParseException e) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", responseCode);
			map.put("ERROR_DESC", responseDesc);
			return map;
		}
		return map;
	}

	/**
	 * @param str
	 *            当前类的数据变量
	 * @param value
	 *            传入得实际值
	 * @return
	 */
	public static Map<String, Object> listMessageError(String[] str, List<Object> value) {
		String[] keys = { "POL_QUERY_NO", "ORDER_ID" };
		return listMessageError(str, value, keys);
	}

	public static Map<String, Object> listMessageError(String[] str, List<Object> value, String[] keys) {
		Map<String, Object> map = null;
		boolean isEmpty = "Y".equals(str[0]) ? true : false;
		int len = Integer.parseInt(str[1]);
		String responseCode = str[3];
		String responseDesc = str[4];
		try {
			if (value != null && !value.isEmpty()) {// 当前值是否为空
				// 处理长度验证
				if (len < value.size()) {
					map = new HashMap<String, Object>();
					map.put("ERROR_CODE", responseCode);
					map.put("ERROR_DESC", responseDesc);
					return map;
				}
				boolean flag = false;
				for (Object obj : value) {
					@SuppressWarnings("rawtypes")
					Map mapVal = (Map) obj;
					String POL_QUERY_NO = (String) mapVal.get(keys[0]);
					String ORDER_ID = (String) mapVal.get(keys[1]);
					if (StringUtils.isEmpty(POL_QUERY_NO) || 32 < POL_QUERY_NO.length()) {
						flag = true;
					}
					if (StringUtils.isEmpty(ORDER_ID) || 32 < ORDER_ID.length()) {
						flag = true;
					}
					if (flag) {
						map = new HashMap<String, Object>();
						map.put("ERROR_CODE", responseCode);
						map.put("ERROR_DESC", responseDesc);
						return map;
					}
				}
			} else {
				if (isEmpty) {// 是否允许为空
					map = new HashMap<String, Object>();
					map.put("ERROR_CODE", responseCode);
					map.put("ERROR_DESC", responseDesc);
					return map;
				}
			}
		} catch (Exception e) {
			map = new HashMap<String, Object>();
			map.put("ERROR_CODE", responseCode);
			map.put("ERROR_DESC", responseDesc);
			return map;
		}
		return map;
	}

	public static void main(String[] args) {
		// System.out.println(dateMessageError(EFFECTIVE_DATE_ERRO,
		// "20150813170879", null,"small"));
		// System.out.println(doubleMessageError(CARGO_PREMIUM_ERRO,
		// "3000000.11"));
		// System.out.println(stringMessageError(MessageERRO.AREACODE_ERRO,
		// "4403"));
		// System.out.println(MessageERRO.intMessageError(MessageERRO.HOURS_ERRO,
		// "02", "^([1-9]|0[1-9]|1[0-2])$"));
		// System.out.println(dateMessageError(MessageERRO.EFF_TM_ERRO,
		// "20150728161800", DateUtil.afterHour(new Date(), -1), "small")); //
		// TODO 开始时间
	}
}
