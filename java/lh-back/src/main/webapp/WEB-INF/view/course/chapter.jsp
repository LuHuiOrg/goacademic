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
    <table id="dg" title="${course.name }章节维护" class="easyui-datagrid" fitColumns="true" url="${ctx}/chapter/list" fit="true" toolbar="#tb" idField="id" treeField="name">
        <thead>
            <tr>
                <th field="cb" checkbox="true" align="center"></th>
                <th field="id" width="80" align="center" hidden="true">id</th>
                <th field="name" width="80" align="center">章节名称</th>
                <th field="url" width="80" align="center">章节地址</th>
                <th field="content" width="80" align="center"   formatter="formatHref">操作</th>
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
                        class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
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
            	<input id="courseId" type="text" name="courseId" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" value="${course.id }"/>
                <tr>
                    <td>章节名称:</td>
                    <td><input type="text" id="name" name="name" style="width: 180px" class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
                </tr>
                <tr>
                	<td>所属章节:</td>
                    <td>
                    	<select id="parentId" name="parentId" >
							<option value="" disabled selected>请选择章节</option>
							<c:forEach items="${timeEnumValues }" var="time">
								<option value="${time.getCode() }">${time.getDescription() }</option>
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

    <div id="dlg-buttons">
        <a href="javascript:saveChapter();" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:closeChapterDialog();" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </div>

	<%@ include file="../common/bottom.jsp" %>
	<script>
	
	var url;
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
        $.messager.confirm("Please choose a data to edit!","Do you want to delete the <font color=red>" + selectedRows.length + "</font> data?",
        function(r) {
             if (r) {
                 $.post("${ctx}/post/delete",{ids : ids},
                   function(result) {
                       if (result.success) {
                           $.messager.alert("system prompt","Delete successful!");
                           $("#dg").datagrid("reload");
                       } else {
                           $.messager.alert("system prompt","Delete error!");
                       }
                 }, "json");
             }
         });
    }

    function openChapterAddDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加章节");
        url = "${ctx}/chapter/save";

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
        var ue = UE.getEditor('myEditor');
        ue.ready(function() {
            ue.setContent(row.content);
        });

        url = "${ctx}/post/save?id=" + row.id;
    }

    function formatHref(val, row) {
    	if(row.parent_id == 0){
    	return "";	
    	}else{
    		return "<a href='${ctx}/post/getById?id="
            + row.id + "' target='_blank'>预览内容</a>";
    	}
        
    }

    function resetValue() {
        $("#title").val("");
        $("#container").val("");
    }

    function closeChapterDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }
	</script>
</body>
</html>