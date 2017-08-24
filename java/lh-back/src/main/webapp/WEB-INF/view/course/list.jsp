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
<link rel="stylesheet" type="text/css" href="${ctx}/static/plugin/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/plugin/jquery-easyui-1.3.3/themes/icon.css">
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
	                    <img id="coverImg" border="0" src="${ctx }/static/img/no-img.jpg" style="width:80%;display:table;border: 1px solid;">
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
	<script src="${ctx}/static/plugin/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script src="${ctx}/static/plugin/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script src="${ctx }/static/javascript/common.js"></script>
	<script>
		var course = {
			url:"",
			/* 根据条件查询部门 */	
			searchDept:function(){
				$("#dg").datagrid('load', {
		            "name" : $("#s_name").val()
		        });
			},
			resetValue:function(){
				$("#dlg").dialog("close");
		        $("#name").val("");
		        $("#cover").val("");
		        $("#price").val("");
		        $("#description").val("");
		        var file = $("#coverFile");
		        file.after(file.clone().val(''));
		        file.remove();
			},
			openDeptAddDialog:function(){
				$("#dlg").dialog("open").dialog("setTitle", "添加新课程");
		        course.url = "${ctx}/course/save";
			},
			/* 保存部门，根据不同的 url 选择是添加还是修改 */
			saveDept:function(){
				$("#fm").form("submit", {
		            url : course.url,
		            onSubmit : function() {
		                return $(this).form("validate");
		            },
		            success : function(data) {
		            	eval("var result = " + data);
		            	if(result.flag){
		            		$.messager.alert("系统提示", "保存成功！");
			                course.resetValue();
			                $("#dlg").dialog("close");
			                $("#dg").datagrid("reload");
		            	}
		            }
		        });
			},
			openDeptModifyDialog:function(){
				var selectedRows = $("#dg").datagrid('getSelections');
		        if (selectedRows.length != 1) {
		            $.messager.alert("系统提示", "请选择要编辑的数据 ！");
		            return;
		        }
		        var row = selectedRows[0];
		        $("#dlg").dialog("open").dialog("setTitle","修改课程信息");
		        $('#fm').form('load', row);
		        course.url = "${ctx}/course/save?id=" + row.id;
			},
			closeDeptDialog:function(){
				course.resetValue();
			},
			/* 删除课程，可以是多个 */
			deleteDept:function(){
				var selectedRows = $("#dg").datagrid('getSelections');
		        if (selectedRows.length == 0) {
		            $.messager.alert("系统提示", "请选择要删除的数据!");
		            return;
		        }
		        var strIds = [];
		        for ( var i = 0; i < selectedRows.length; i++) {
		            strIds.push(selectedRows[i].id);
		        }
		        $.messager.confirm("系统提示","您确定要删除这些数据 <font color=red>"+ selectedRows.length + "</font> data?",function(r) {
		        	if (r) {
		           		$.post("${ctx}/course/delete",{"ids" : JSON.stringify(strIds)},function(data) {
			                if (data.flag) {
			                    $.messager.alert("系统提示","删除成功!");
			                    $("#dg").datagrid("reload");
			                } else {
			                    $.messager.alert("系统提示","删除失败，没有找到这个课程!");
			                }
		                }, "json");
		            }
		       });
			}
		}
		  //将url转换成图片    
	    function imgFormatter(value,row,index){  
			var rvalue ='';
	        if('' != value && null != value){    
				if(value.indexOf('http')>-1){
					 rvalue = "<img  style='width:66px; height:60px;margin-left:3px;' src='"+ value+" ' title='点击查看图片'/>";
				}else{
					rvalue = "<img  style='width:66px; height:60px;margin-left:3px;' src='${ctx}"+ +value+" ' title='点击查看图片'/>";
				}
	          }     
	        return  rvalue;          
	       }
	</script>
</body>
</html>