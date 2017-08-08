<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="taglibs.jsp" %>
	<div class="col-sm-12 text-center copyright">
		<a href="#">联系我们</a> |
		<a href="#">关于我们</a> |
		<a href="#">网站首页</a>
		<p>Copyright © 2017- www.szy.com All Rights Reserved 版权所有 苏ICP备15009923号</p>
	</div>
<script type="text/javascript" src="${ctx }/static/plugin/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/static/plugin/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx }/static/plugin/layer/layer.js"></script>
<script type="text/javascript">
function logout() {
	window.location.href = "${ctx }/passport/logout";
}
</script>