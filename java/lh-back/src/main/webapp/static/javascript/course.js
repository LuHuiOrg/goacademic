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
		        course.url = common.getRootPath() + "/course/save";
			},
			/* 管理课程下章节信息 */
			addChapterTab:function(url, text, iconCls){
				var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"
	                + url + "'></iframe>";
		        $("#tabs").tabs("add", {
		            title : text,
		            iconCls : iconCls,
		            closable : true,
		            content : content
		        });
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
		        $("#coverImg").attr('src',row["cover"]); 
		        $('#fm').form('load', row);
		        course.url = common.getRootPath() + "/course/save?id=" + row.id;
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
		           		$.post(common.getRootPath() + "/course/delete",{"ids" : JSON.stringify(strIds)},function(data) {
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
					rvalue = "<img  style='width:66px; height:60px;margin-left:3px;' src='"+common.getRootPath()+value+" ' title='点击查看图片'/>";
				}
	          }     
	        return  rvalue;          
	       }
		//操作
	    function formatHref(val, row) {
			var link='';
	    	if(row.parent_id == 0){
	    	return "";	
	    	}else{
	    		return "<a href='"+common.getRootPath() + "/chapter/?courseId="+ row.id + "' target='_self'>管理章节</a>";
	    	}
	        
	    }