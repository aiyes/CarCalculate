<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试页面</title>
<style>
	textarea {
		border: 1px solid #94BBE2;width:900px;font-size:16px;font-family:微软雅黑;
	}
</style>
</head>

<body>
<h2>请求报文：</h2>
<div>
<form id="frm" name="frm">
<!-- <textarea id="dat" name="dd" rows="10">
{"RequestType":"5","Operator":"","licenseNo":"BD8558","EngineNo":"","FrameNo":""}
</textarea ><br> -->
请求类型:<input id="requestType" name = "requestType" value = "5"> 
操作员:<input id="operator" name="operator" value=""><br>
号牌号码:<input id="licenseNo" name = "licenseNo" value="粤BD8558" />
发动机号:<input id="engineNo" name="engineNo" value=""><br>
车架号:<input id="frameNo" name="frameNo" value=""><br>
<input type="reset" value="重置"/>
<input type="button" value="提交" id="submit">
</form>
</div>
<h2>返回报文：</h2>
<div>
<form>
<textarea id="resultData" rows="10"></textarea><br>
<input type="reset" value="清空">
</form>
</div>
 <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
 <script type="text/javascript" src="js/test.js"></script>
</body>
</html>