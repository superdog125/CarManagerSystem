<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>运输公司货车管理系统主页</title>
</head>
<body><!-- style="width:1000px;height:400px;" -->
	<center>
		<div id="main">
	        <h1>运输管理系统主页</h1>
	        <h3>欢迎登录：<s:property value="#session.user.loginName"/></h3>
	        <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" id="honehoneclock">
				<param name="allowScriptAccess" value="always">
				<param name="movie" value="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf">
				<param name="quality" value="high">
				<param name="bgcolor" value="#ffffff">
				<param name="wmode" value="transparent">
				<embed wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf" quality="high" bgcolor="#ffffff" width="1200" height="400" name="honehoneclock" allowscriptaccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
			</object>

	        <div id="time">
	       		<script charset="Shift_JIS" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_wh.js"></script>
	        </div> 
	    </div>
	</center>
</body>
</html>