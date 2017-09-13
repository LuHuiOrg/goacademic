var home = {
	addTab:function(url, text, iconCls){
		var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"
            + url + "'></iframe>";
        $("#tabs").tabs("add", {
            title : text,
            iconCls : iconCls,
            closable : true,
            content : content
        });
	},
	openTab:function(text, url, iconCls){
		if ($("#tabs").tabs("exists", text)) {
            $("#tabs").tabs("close", text);
            home.addTab(url, text, iconCls);
            $("#tabs").tabs("select", text);
        } else {
        	home.addTab(url, text, iconCls);
        }
	},
	logout:function(){
		$.messager.confirm("system prompt","Do you want to exit?",function(r) {
           if (r) {
               window.location.href = common.getRootPath() + "/admin/logout";
           }
        });
	}
}