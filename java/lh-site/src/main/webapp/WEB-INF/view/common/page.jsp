<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="taglibs.jsp" %>

<c:if test="${pageInfo.total > 0 }">
	<nav aria-label="Page navigation">
	  <ul class="pagination">
	    <c:choose>
  			<c:when test="${pageInfo.pageNum > 1}">
  				<li><a href="JavaScript:pages.pageSelect(${pageInfo.pageNum-1});" title="前一页">&laquo;</a></li>
  			</c:when>
  			<c:otherwise>
				<li><a href="javascript:void(0);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
  			</c:otherwise>
  		</c:choose>
	    <c:if test="${pageInfo.firstPage > 1}">
    		<li><a href="JavaScript:pages.pageSelect(1);">1</a></li>
    	</c:if>
	    <c:if test="${pageInfo.firstPage-1 > 1}">
    		<li><a href="javascript:void(0);">...</a></li>
		</c:if>
	    <c:if test="${pageInfo.pages != 0 }">
	    	<c:forEach var="i" items="${pageInfo.navigatepageNums }">
	    		<c:choose>
	    			<c:when test="${pageInfo.pageNum == i}">
	    				<li><a href="javascript:void(0)">${pageInfo.pageNum}</a></li>
	    			</c:when>
	    			<c:otherwise>
	    				<li><a href="javascript:pages.pageSelect(${i});">${i}</a></li>
	    			</c:otherwise>
	    		</c:choose>
	    	</c:forEach>
	    </c:if>
	    <c:if test="${pageInfo.pages-1 > pageInfo.lastPage}">
			<li><a href="javascript:void(0);">...</a></li>
		</c:if>
		<c:if test="${pageInfo.pages > pageInfo.lastPage}">
    		<li><a href="JavaScript:pages.pageSelect(${pageInfo.pages});">${pageInfo.pages}</a></li>
    	</c:if>
    	<c:choose>
  			<c:when test="${pageInfo.pages > pageInfo.pageNum}">
  				<li><a href="JavaScript:pages.pageSelect(${pageInfo.pageNum+1});" title="后一页">&raquo;</a></li>
  			</c:when>
  			<c:otherwise>
  				<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
  			</c:otherwise>
  		</c:choose>
	  </ul>
	</nav>
</c:if>
<script type="text/javascript" src="${ctx }/static/js/common.js"></script>
<script type="text/javascript">
var pages = {
	pageSelect : function(pageNo) {
		window.location.href = common.getUrlParam("pageNum") != null ? common
				.replaceParamVal(window.location.href, "pageNum", pageNo)
				: common.urlUpdateParams(window.location.href, "pageNum", pageNo);
	}
}
</script>