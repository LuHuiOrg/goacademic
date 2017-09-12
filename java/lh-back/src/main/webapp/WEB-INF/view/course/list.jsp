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
<title>课程维护页面</title>
<%@ include file="../common/top.jsp" %>
</head>
<body style="margin: 1px;">
    <table id="dg" title="课程维护" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true" url="${ctx}/course/list" fit="true" toolbar="#tb">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="80" align="center" hidden="true">id</th>
				<th field="name" width="80" align="center">课程名字</th>
				<th field="price" width="80" align="center">课程价格</th>
				<th data-options="field:'cover',width:80,align:'center',formatter:imgFormatter">课程封面</th>
				<th field="description" width="80" align="center">课程详情</th>
				<th field="content" width="200" align="center"   formatter="formatHref">操作</th>
            </tr>
        </thead>
    </table>
    <div id="tb">
        <div>
            <a href="javascript:course.openDeptAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a> 
            <a href="javascript:course.openDeptModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a> 
            <a href="javascript:course.deleteDept()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div>
            &nbsp;课程名字：&nbsp;<input type="text" id="s_name" size="20" onkeydown="if(event.keyCode==13) course.searchDept()" />
            <a href="javascript:course.searchDept()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查找</a>
        </div>
    </div>

    <div id="dlg" class="easyui-dialog" style="width: 500px; padding: 10px 20px" closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" enctype="multipart/form-data">
            <table cellspacing="8px">
                <tr>
                    <td>课程名字:</td>
                    <td><input type="text" id="name" name="name" style="width: 180px" class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
                </tr>
                <tr>
                    <td>课程价格:</td>
                    <td><input type="text" id="price" name="price" style="width: 180px" class="easyui-validatebox" data-options="required:true,validType:'intOrFloat'" />&nbsp;<font color="red">*</font>元</td>
                </tr>
                <tr>
                    <td>课程封面:</td>
                    <td>
	                    <input id="coverFile" name="coverFile" type="file" onchange="common.change('coverImg','coverFile');" required="true"/>&nbsp;<font color="red">*</font> 
	                    <input id="cover" type="text" name="cover" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" />
	                    <img id="coverImg" border="0" src="${ctx }/static/img/no-img.jpg" style="width:80%;display:table;border: 1px solid;height:80px;width: 80px;">
                    </td>
                </tr>
                <tr>
                    <td>课程描述:</td>
                    <td><textarea id="description" name="description" style="width: 180px;height:80px;" class="easyui-validatebox" required="true"></textarea>&nbsp;<font color="red">*</font></td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
        <a href="javascript:course.saveDept()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:course.closeDeptDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>
	<%@ include file="../common/bottom.jsp" %>
	<script src="${ctx }/static/javascript/course.js"></script>
</body>
</html>