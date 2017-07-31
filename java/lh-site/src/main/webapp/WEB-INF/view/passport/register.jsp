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
<link rel="stylesheet" href="${ctx}/static/css/register.css">
</head>
<body>
	<%@ include file="../common/top.jsp" %>
	<form class="form-horizontal container" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">昵称</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="firstname" placeholder="请输入昵称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">姓名</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入姓名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请再次输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">手机号</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入手机号">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">验证码</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入验证码">
	    </div>
	    <div class="col-sm-2">
	      <button type="submit" class="btn btn-primary btn-block">发送验证码</button>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">邮箱</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入邮箱">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label for="lastname" class="col-sm-2 control-label">邮箱</label>
	    <div class="col-sm-3">
	      <select class="form-control">
		      <option>学校</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
	    </div>
	    <div class="col-sm-3">
	      <select class="form-control">
		      <option>专业</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
	    </div>
	    <div class="col-sm-4">
	      <select class="form-control">
		      <option>年级</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default btn-lg btn-block">注册</button>
	    </div>
	  </div>
	</form>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>