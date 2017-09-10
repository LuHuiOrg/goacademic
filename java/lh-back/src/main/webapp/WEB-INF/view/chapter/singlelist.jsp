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
<link rel="stylesheet" type="text/css" href="${ctx}/static/plugin/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/plugin/jquery-easyui-1.3.3/themes/icon.css">
</head>
<body style="margin: 1px;" id="ff">
    <table id="dg" title="章节维护" class="easyui-treegrid"  pagination="true" rownumbers="true" fit="true" idField="id" treeField="name"
        data-options="pageSize:10"
        url="${ctx}/chapter/list" toolbar="#tb">
        <thead data-options="frozen:true">
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="10%" align="center" hidden="true">id</th>
                <th field="name" width="500" align="center">章节名称</th>
                <th field="courseName" width="150" align="center">所属课程</th>
                <th field="url" width="150" align="center">章节地址</th>
                <th field="content" width="200" align="center"   formatter="formatHref">操作</th>
            </tr>
        </thead>
    </table>
    <div id="tb">
        <div style="padding:3px;border:1px solid #ccc">
            <a href="javascript:openChapterAddDialog()" class="easyui-linkbutton"
                iconCls="icon-add" plain="true">增加</a> <a
                href="javascript:openChapterModifyDialog()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a> <a
                href="javascript:deleteChapter()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除</a>
        </div>
        <div >
             <table>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;章节名字:&nbsp;
                        <input type="text" id="c_name" size="20"
                        onkeydown="if(event.keyCode==13) searchChapter()" />
                    </td>
                    <td>&nbsp;所属课程:&nbsp; <input type="text" id="c_courseName" size="20"
                        onkeydown="if(event.keyCode==13) searchChapter()" />
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;<a href="javascript:searchChapter()"
                        class="easyui-linkbutton" iconCls="icon-search" plain="true">Search</a>
                    </td>
                </tr>
            </table>
                
        </div>
    </div>

    <div id="dlg" class="easyui-dialog"
        style="width: 850px; height: 555px; padding: 10px 20px; position: relative; z-index: 1000;"
        closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" enctype="multipart/form-data">
            <table cellspacing="8px">
                <tr>
                    <td>章节名称:</td>
                    <td><input type="text" id="name" name="name" style="width: 180px" class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
                </tr>
                <tr>
          <%--           <td>所属课程:</td>
                    <td>
						<select class="easyui-combobox" id="courseBelong" name="courseBelong"
						data-options="url:'${ctx}/course/getCourseCombobox',  
                                           method:'post',  
                                           valueField:'id',  
                                           textField:'name', 
                                           editable:false, 
                                           panelHeight:'auto'"
						style="width: 220px"></select>
&nbsp;<font color="red">*</font></td> --%>
                	<td>所属章节:</td>
                    <td><input type="text" id="price" name="price" style="width: 180px" class="easyui-validatebox" data-options="required:true,validType:'intOrFloat'" />&nbsp;<font color="red">*</font></td>
                
                </tr>
                <tr>
                    <td>上传视频:</td>
                    <td>
                    	<input type="file" class="easyui-filebox" id="videofile" name="videofile" style="width:260px;">
	               <%--      <input id="coverFile" name="coverFile" type="file" onchange="common.change('coverImg','coverFile');" required="true"/>&nbsp;<font color="red">*</font> 
	                    <input id="cover" type="text" name="cover" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" />
	                    <img id="coverImg" border="0" src="${ctx }/static/img/no-img.jpg" style="width:80%;display:table;border: 1px solid;height:80px;width: 80px;">
	                     --%>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="dlg-buttons">
        <a href="javascript:saveChapter()" class="easyui-linkbutton"
            iconCls="icon-ok">保存</a> <a href="javascript:closeChapterDialog()"
            class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>



	<script src="${ctx}/static/plugin/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script src="${ctx}/static/plugin/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script src="${ctx }/static/javascript/common.js"></script>
	<script>
	
	var url;
    function ResetEditor() {
        UE.getEditor('myEditor', {
            initialFrameHeight : 480,
            initialFrameWidth : 660,
            enableAutoSave : false,
            elementPathEnabled : false,
            wordCount : false,

        });
    }
    /* 根据条件查询公告 */
    function searchChapter() {
        $("#dg").datagrid('load', {
            /* "name" : $("#c_name").val(),
            "courseId" : $("#c_courseName").val(), */
        });
    }
    /* 删除公告，可以是多个 */
    function deleteChapter() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("system prompt", "Please choose a data to edit!");
            return;
        }
        var strIds = [];
        for ( var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].id);
        }
        var ids = strIds.join(",");
        $.messager
                .confirm(
                        "Please choose a data to edit!",
                        "Do you want to delete the <font color=red>"
                                + selectedRows.length + "</font> data?",
                        function(r) {
                            if (r) {
                                $
                                        .post(
                                                "${pageContext.request.contextPath}/post/delete",
                                                {
                                                    ids : ids
                                                },
                                                function(result) {
                                                    if (result.success) {
                                                        $.messager
                                                                .alert(
                                                                        "system prompt",
                                                                        "Delete successful!");
                                                        $("#dg").datagrid(
                                                                "reload");
                                                    } else {
                                                        $.messager
                                                                .alert(
                                                                        "system prompt",
                                                                        "Delete error!");
                                                    }
                                                }, "json");
                            }
                        });

    }

    function openChapterAddDialog() {
/*         var html = '<div id="myEditor" name="content"></div>';
        $('#editor').append(html);
        ResetEditor(editor);
        var ue = UE.getEditor('myEditor');
        ue.ready(function() {
            ue.setContent("");
        }); */

        $("#dlg").dialog("open").dialog("setTitle", "添加章节");
        url = "${pageContext.request.contextPath}/post/save";

    }
    /* 保存公告，根据不同的 url 选择是添加还是修改 */
    function saveChapter() {
        $("#fm").form("submit", {
            url : url,
            onSubmit : function() {
                return $(this).form("validate");
            },
            success : function(result) {
                $.messager.alert("system prompt", "Save successful!");
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
                resetValue();
            }
        });
    }

    function openChapterModifyDialog() {
        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("system prompt", "Please choose a data to edit!");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "Edit post");
        $('#fm').form('load', row);
        var html = '<div id="myEditor" name="content"></div>';
        $('#editor').append(html);
        ResetEditor(editor);
        var ue = UE.getEditor('myEditor');
        ue.ready(function() {
            ue.setContent(row.content);
        });

        url = "${pageContext.request.contextPath}/post/save?id=" + row.id;
    }

    function formatHref(val, row) {
    	if(row.parent_id == 0){
    	return "";	
    	}else{
    		return "<a href='${pageContext.request.contextPath}/post/getById?id="
            + row.id + "' target='_blank'>预览内容</a>";
    	}
        
    }

    function resetValue() {
        $("#title").val("");
        $("#container").val("");
        ResetEditor();
    }

    function closeChapterDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }
		/* var course = {
			url:"",
			// 根据条件查询部门 	
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
				$("#dlg").dialog("open").dialog("setTitle", "添加新章节");
		        course.url = "${ctx}/course/save";
			},
			// 保存部门，根据不同的 url 选择是添加还是修改 
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
		        $("#dlg").dialog("open").dialog("setTitle","修改章节信息");
		        $("#coverImg").attr('src',row["cover"]); 
		        $('#fm').form('load', row);
		        course.url = "${ctx}/course/save?id=" + row.id;
			},
			closeDeptDialog:function(){
				course.resetValue();
			},
			// 删除章节，可以是多个 
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
			                    $.messager.alert("系统提示","删除失败，没有找到这个章节!");
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
	       } */
	</script>
</body>
</html>