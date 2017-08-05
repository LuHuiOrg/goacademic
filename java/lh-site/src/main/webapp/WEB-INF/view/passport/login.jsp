<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta name="renderer" content="webkit">
<title>一个专门做视频教学的网站---注册</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/base.css">
<link rel="stylesheet" href="${ctx}/static/css/passport/login.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<form class="form-horizontal container" role="form" id="fm" action="${ctx }/passport/login" method="post"> 
	<div class="jumbotron">
		<div class="container">
			<div class="col-sm-5">
				<h1>欢迎登陆页面！</h1>
				<p>登陆后你就可以看到很多很多你想看的视频</p>
				<p><a class="btn btn-primary btn-lg" role="button" href="${ctx}/">学习更多</a></p>
			</div>
			<div class="col-sm-2"></div>
			<div class="panel panel-default col-sm-5">
			    <div class="panel-heading">
			        <h3 class="panel-title">登陆</h3>
			    </div>
			    <div class="panel-body">
			        <form role="form">
					  <div class="form-group">
					    <label for="name">用户名</label>
					    <input type="text" class="form-control" id="nickname" name="nickname" value="${studentInfo.nickname}" placeholder="请输入昵称/邮箱/手机号">
					  </div>
					  <div class="form-group">
					    <label for="name">密码</label>
					    <input type="password" class="form-control" id="password" name="password"  value="${studentInfo.password}" placeholder="请输入密码">
					  </div>
					  <div class="checkbox">
					    <label>
					      <input type="checkbox">记住密码
					    </label>
					    <a class="pull-right" href="javascript:void(0);">忘记密码</a>
					  </div>
					  <button type="button" onclick="javascript:validate();" class="btn btn-default btn-lg btn-block">登录</button>
					</form>
			    </div>
			</div>
		</div>
	</div>
	</form>
	<%@ include file="../common/bottom.jsp" %>
	<script type="text/javascript" src="${ctx}/static/plugin/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript">
	function validate() {
		var nickname = $("#nickname").val();
		var password = $("#password").val();

		if (nickname == null || nickname == "") {
			alert("昵称不能为空");
			return;
		}
		if (password == null || password == "") {
			alert("密码不能为空");
			return;
		}
		
		$("#fm").submit();
	
	}
	if ('${errorMsg}' != '') {
		alert('${errorMsg}');
	}
	if ('${message}' != '') {
		alert('${message}');
	}
	</script>
</body>
</html>