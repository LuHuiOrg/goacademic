<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>章节维护页面</title>
<%@ include file="../common/top.jsp" %>
</head>
<body style="margin: 1px;" id="ff">
    <table id="dg" class="easyui-treegrid" title="${resultMap.course.name }章节维护" 
       data-options=" 
	       	iconCls: 'icon-ok', 
	       	rownumbers: true,animate: true,
	        collapsible: true,fitColumns: true, 
	        url: '${ctx }/chapter/list',
	        idField: 'id', singleSelect:false,
	        treeField: 'name', fit:true,
	        toolbar:'#tb', showFooter: true">
	    <thead>
		    <tr>
		        <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="80" align="center" hidden="true">id</th>
                <th field="name" width="80" align="center">章节名称</th>
                <th field="url" width="80" align="center">章节地址</th>
                <th field="content" width="80" align="center" formatter="course.chapter.formatHref">操作</th>
		    </tr>
	    </thead>
	</table> 
    <div id="tb">
        <div style="padding:3px;border:1px solid #ccc">
            <a href="javascript:course.chapter.openChapterAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a> 
            <a href="javascript:course.chapter.openChapterModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
            <a href="javascript:course.chapter.deleteChapter()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
            <a href="${ctx }/course/" class="easyui-linkbutton" iconCls="icon-back" plain="true">返回课程维护页面</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
        style="width: 850px; height: 555px; padding: 10px 20px; position: relative; z-index: 1000;"
        closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" enctype="multipart/form-data">
            <table cellspacing="8px">
            	<input id="courseId" type="text" name="courseId" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" value="${resultMap.course.id }"/>
                <tr>
                    <td>章节名称:</td>
                    <td><input type="text" id="name" name="name" style="width: 180px" class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
                </tr>
                <tr>
                	<td>所属章节:</td>
                    <td>
                    	<select id="parentId" name="parentId" >
							<option value="">请选择章节</option>
							<c:forEach items="${resultMap.bigChapterList }" var="chapter">
								<option value="${chapter.id }">${chapter.name }</option>
							</c:forEach>
						</select>
                    </td>
                </tr>
                <tr>
                    <td>上传视频:</td>
                    <td><input type="file" class="easyui-filebox" id="chapterVideo" name="chapterVideo" style="width:260px;"></td>
                </tr>
            </table>
        </form>
    </div>
    
    <div id="playVideo" class="easyui-dialog"
        style="width: 850px; height: 555px; padding: 10px 20px; position: relative; z-index: 1000;"
        closed="true" buttons="#video-buttons">
    	<video src="" id="video" style="width: 100%;" controls autoplay></video>
    </div>
    <div id="video-buttons">
        <a href="javascript:course.chapter.closeVideo();" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>

    <div id="dlg-buttons">
        <a href="javascript:course.chapter.saveChapter();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:course.chapter.closeChapterDialog();" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>

	<%@ include file="../common/bottom.jsp" %>
	<script src="${ctx }/static/javascript/course.js"></script>
</body>
</html>