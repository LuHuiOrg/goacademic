<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="taglibs.jsp" %>
<nav class="navbar navbar-default navbar-embossed navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">学一手</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li <c:if test="${param.urlactive eq 'home' }">class="active"</c:if>><a href="${ctx}/?urlactive=home">首页</a></li>
        <c:if test="${empty sessionScope.StudentInfo}">
        <li <c:if test="${param.urlactive eq 'login' }">class="active"</c:if>><a href="${ctx }/passport/login?urlactive=login">登录</a></li>
        <li <c:if test="${param.urlactive eq 'toregister' }">class="active"</c:if>><a href="${ctx }/passport/toregister?urlactive=toregister">注册</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.StudentInfo.nickname}">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.StudentInfo.nickname}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">个人资料</a></li>
            <li><a href="${ctx}/office/myCourse">我的课程</a></li>
            <li> <a href="${ctx }/passport/logout" data-method="post">注销</a></li>
          </ul>
        </li>
        </c:if>
        <li <c:if test="${param.urlactive eq 'tocart' }">class="active"</c:if>><a href="${ctx }/shop/cart?urlactive=tocart"><span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>购物车</a></li>
        <li><a href="#">质讯</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">记住网站<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">收藏网站</a></li>
            <li><a href="#">设为主页</a></li>
            <li><a href="#">保存到桌面</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关注微信号<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <img alt="公众号二维码" src="${ctx }/static/img/q-code.jpg" class="qcode"/>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container -->
</nav>
<div class="box50px"></div>
 
 