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
<link rel="stylesheet" href="${ctx}/static/css/passport/register.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<form class="form-horizontal container" role="form" id="fm" action="${ctx }/passport/register" method="post"> 
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
	    <div class="col-sm-8">
	        <input type="text" class="form-control" id="nickname" name="nickname"  value="${studentInfo.nickname}" placeholder="请输入昵称">
			<span class="help-block" style="color:red;" id="">* 必填项</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
	    <div class="col-sm-8">
	        <input type="password" class="form-control" id="password" name="password" value="${studentInfo.password}" placeholder="请输入密码">
		    <span class="help-block" style="color:red;">* 必填项</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
	    <div class="col-sm-8">
	        <input type="password" class="form-control" id="checkpassword" name="checkpassword" placeholder="请再次输入密码">
		    <span class="help-block" style="color:red;">* 必填项</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号</label>
	    <div class="col-sm-8">
	        <input type="text" class="form-control" id="mobile" name="mobile" value="${studentInfo.mobile}" placeholder="请输入手机号">
		    <span class="help-block" style="color:red;">* 必填项</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="verify" class="col-sm-2 control-label">验&nbsp;&nbsp;证&nbsp;&nbsp;码</label>
	    <div class="col-sm-6">
	      <input type="text" class="form-control" id="verify" name="verify" placeholder="请输入验证码">
	      <span class="help-block" style="color:red;">* 必填项</span>
	    </div>
	    <div class="col-sm-2">
	        <button type="button" class="btn btn-primary btn-block">发送验证码</button>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="email" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	    <div class="col-sm-8">
	        <input type="text" class="form-control" id="email" name="email" value="${studentInfo.email}" placeholder="请输入邮箱">
	    	<span class="help-block" style="color:red;">* 必填项</span>
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="lastname" class="col-sm-2 control-label"></label>
	    <div class="col-sm-4">
	      <select class="form-control" id="specialty" name="specialty">
		      <option>专业</option>
		      <option value="1">2</option>
		      <option value="2">3</option>
		      <option value="3">4</option>
		      <option value="4">5</option>
		    </select>
	    </div>
	    <div class="col-sm-4">
	      <select class="form-control" id="grade" name="grade" >
		      <option>年级</option>
		      <option value="1">大一</option>
		      <option value="2">大二</option>
		      <option value="3">大三</option>
		      <option value="4">大四</option>
		    </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-8">
	      <button type="button" onclick="javascript:register();" class="btn btn-default btn-lg btn-block">注册</button>
	    </div>
	  </div>
	</form>
	<%@ include file="../common/bottom.jsp" %>
	<script type="text/javascript">
	function register() {
		var nickname = $("#nickname").val();
		var password = $("#password").val();
		var checkpassword = $("#checkpassword").val();
		var mobile = $("#mobile").val();
		var email = $("#email").val();
		var verify = $("#verify").val();
		if (nickname == null || nickname == "") {
			layer.alert('昵称不能为空', {icon: 6});
			return;
		}
		if (password == null || password == "") {
			layer.alert('密码不能为空', {icon: 6});
			return;
		}
		if (checkpassword == null || checkpassword == "") {
			layer.alert('确认密码不能为空', {icon: 6});
			return;
		}
		if (checkpassword!=password) {
			layer.alert('两次密码不同，请重新输入', {icon: 6});
			return;
		}
		if (mobile == null || mobile == "") {
			layer.alert('电话不能为空', {icon: 6});
			return;
		}
		if (verify == null || verify == "") {
			layer.alert('验证码不能为空', {icon: 6});
			return;
		}
		if (email == null || email == "") {
			layer.alert('邮箱不能为空', {icon: 6});
			return;
		}
		$("#fm").submit();
	
	}
	if ('${errorMsg}' != '') {
		alert('${errorMsg}');
		$("#nickname").focus();
	}
	if ('${message}' != '') {
		alert('${message}');
	}
	</script>
</body>
</html>