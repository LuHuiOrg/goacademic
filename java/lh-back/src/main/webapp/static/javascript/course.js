var course = {
		//课程中list页面的功能
		list:{
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
		        course.list.url = common.getRootPath() + "/course/save";
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
		            url : course.list.url,
		            onSubmit : function() {
		                return $(this).form("validate");
		            },
		            success : function(data) {
		            	eval("var result = " + data);
		            	if(result.flag){
		            		$.messager.alert("系统提示", "保存成功！");
			                course.list.resetValue();
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
		        course.list.url = common.getRootPath() + "/course/save?id=" + row.id;
			},
			closeDeptDialog:function(){
				course.list.resetValue();
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
			},
			//将url转换成图片    
			imgFormatter:function(value,row,index){  
				var rvalue ='';
			    if('' != value && null != value){    
					if(value.indexOf('http')>-1){
						 rvalue = "<img  style='width:66px; height:60px;margin-left:3px;' src='"+ value+" ' title='点击查看图片'/>";
					}else{
						rvalue = "<img  style='width:66px; height:60px;margin-left:3px;' src='"+common.getRootPath()+value+" ' title='点击查看图片'/>";
					}
			      }     
			    return  rvalue;          
			},
			//操作
			formatHref:function(val, row) {
				var link='';
				if(row.parent_id == 0){
				return "";	
				}else{
					return "<a href='"+common.getRootPath() + "/chapter/?courseId="+ row.id + "' target='_self'>管理章节</a>";
				}
			}
		},
		//课程中章节模块
		chapter:{
			url:"",
		    init:function(){
		    	$("#parentId").change(function(){
		    		if($(this).val() != ""){
		    			$("#chapterVideo").parents("tr").show();
		    		}else{
		    			$("#chapterVideo").parents("tr").hide();
		    		}
		    	});
		    },
			openChapterAddDialog:function() {
		        $("#dlg").dialog("open").dialog("setTitle", "添加章节");
		        course.chapter.url = common.getRootPath() + "/chapter/save";
		    },
		    /* 保存公告，根据不同的 url 选择是添加还是修改 */
		    saveChapter:function() {
		        $("#fm").form("submit", {
		            url : course.chapter.url,
		            onSubmit : function() {
		                return $(this).form("validate");
		            },
		            success : function(result) {
		                $.messager.alert("系统提示", "保存成功!");
		                $("#dlg").dialog("close");
		                $("#dg").treegrid("reload");
		                course.chapter.resetValue();
		            }
		        });
		    },
		    openChapterModifyDialog:function() {
		        var selectedRows = $("#dg").treegrid('getSelections');
		        if (selectedRows.length != 1) {
		            $.messager.alert("系统提示", "请选择要编辑的数据!");
		            return;
		        }
		        var row = selectedRows[0];
		        if(row.url != "" && row.url != null){
		        	$("#chapterVideo").parents("tr").show();
	    		}else{
	    			$("#chapterVideo").parents("tr").hide();
	    		}
		        $("#dlg").dialog("open").dialog("setTitle", "修改章节");
		        $('#fm').form('load', row);
		        course.chapter.url = common.getRootPath() + "/chapter/save?id=" + row.id;
		    },
		    /* 删除章节，可以是多个 */
		    deleteChapter:function(){
				var selectedRows = $("#dg").treegrid('getSelections');
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
		           		$.post(common.getRootPath() + "/chapter/delete",{"ids" : JSON.stringify(strIds)},function(data) {
			                if (data.flag) {
			                    $.messager.alert("系统提示","删除成功!");
			                    $("#dg").treegrid("reload");
			                } else {
			                    $.messager.alert("系统提示","删除失败，没有找到这个课程!");
			                }
		                }, "json");
		            }
		       });
			},
			playVideo:function(){
				var selectedRows = $("#dg").treegrid('getSelections');
				if (selectedRows.length > 1) {
		            $.messager.alert("系统提示", "请选择要一条数据!");
		            return;
		        }
				var row = selectedRows[0];
		        $("#playVideo").dialog("open").dialog("setTitle", "播放视频");
		        $('#video').attr("src",row.url);
			},
		    formatHref:function(val, row) {
		    	if(row.parent_id == 0){
		    	return "";	
		    	}else{
		    		return "<a href='javascript:course.chapter.playVideo();'>预览内容</a>";
		    	}
		    },
		    resetValue:function() {
		        $("#title").val("");
		        $("#container").val("");
		    },
		    closeChapterDialog:function() {
		        $("#dlg").dialog("close");
		        course.chapter.resetValue();
		    },
		    closeVideo:function(){
		    	$("#playVideo").dialog("close");
		    	$('#video').attr("src","");
		    }
		}
}
