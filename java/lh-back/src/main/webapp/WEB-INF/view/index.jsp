<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>会计后台管理系统</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="${ctx}/static/css/main.css?rev=@@hash">
</head>
<body class="layout-boxed">
	<div class="container">
		<div class="header">
			<div class="inner_logo"></div>
			<div class="welcome">
				<div class="welcome_content">
					<a href="#"><span class="wel_msg">3</span></a>
				</div>
				<div class="welcome_user">
					欢迎你登录<br /> <span>${sysUserName }</span>
				</div>
				<div class="clear"></div>
			</div>
			<div class="top_area">
				<a href="#" class="rp_home" title="主页"></a> 
				<a href="#" class="rp_help" title="帮助"></a> 
				<a href="${ctx }/logout" class="rp_logout" title="退出"></a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="mainbody">
			<div class="sidebar">
				<a href="#" class="close"></a>
				<ul>
					<li><div class="dan">
							<a href="#"><span class="left_menu01"></span>阅卷准备</a>
						</div></li>
					<li>
						<div class="dan">
							<a href="#"><span class="left_menu02"></span>销售统计</a>
						</div>
						<ul class="sub_menu">
							<span class="top_arr"></span>
							<li class="first"><a href="${ctx}/contract/list">合同管理</a></li>
						</ul>
					</li>
					<li>
						<div class="dan">
							<a href="#"><span class="left_menu03"></span>系统设置</a>
						</div>
						<ul class="sub_menu">
							<span class="top_arr"></span>
							<li class="first"><a href="${ctx}/customerInfo/list">业主信息管理</a></li>
							<li><a href="#">学段年级信息设定</a></li>
							<li><a href="#">学校信息设定</a></li>
							<li><a href="#">科别信息设定</a></li>
							<li><a href="#">不参加统计规则设定</a></li>
							<li><a href="#">上报DBF参数设定</a></li>
						</ul>
					</li>
					<li><div class="dan">
							<a href="#"><span class="left_menu04"></span>权限设置</a>
						</div></li>
				</ul>
			</div>
			<div class="content">
				<iframe id="iFrame1" name="iFrame1" src="${ctx}/welcome" width="100%" height="100%" frameborder="0"></iframe>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	
	<!--# mergeTo:${ctx}/static/js/main.js -->
		<!-- build:js ../../static/js/main.js -->
	    <script replace="gulp" src="${ctx}/static/plugin/jquery/1.11.3/jquery.min.js"></script>
		<script replace="gulp" src="${ctx}/static/javascript/common.js"></script>
		<script replace="gulp" src="${ctx}/static/javascript/main.js"></script>
	    <!-- endbuild -->
	<!--# mergeTo -->
</body>
</html>