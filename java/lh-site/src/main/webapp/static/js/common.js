var common = {
		//获得当前项目的根路径  
		getRootPath : function(){
		    //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
		    var curWwwPath = window.document.location.href;
		    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
		    var pathName = window.document.location.pathname;
		    var pos = curWwwPath.indexOf(pathName);
		    //获取主机地址，如： http://localhost:8080
		    //var localhostPath = curWwwPath.substring(0, pos);
		    var a = curWwwPath.split("/",3)
		    var localhostPath = a[0] + "//" + a[2];
		    //获取带"/"的项目名，如：/ems
		    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		    if(projectName == "/lh-site") { //暂时解决没有项目名问题
		    	return (localhostPath + projectName);
		    } else {
		    	return localhostPath;
		    }
		},
		//获取url中的参数
		getUrlParam : function(name){
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); //匹配目标参数
			if (r != null) return unescape(r[2]); return null; //返回参数值
		},
		//替换url中参数的值
		replaceParamVal : function(oldUrl, paramName, replaceWith){
			var re = eval('/(' + paramName + '=)([^&]*)/gi');
		    return oldUrl.replace(re, paramName + '=' + replaceWith);
		},
		//给url追加参数
		urlUpdateParams: function (url, name, value) {
		    var r = url;
		    if (r != null && r != 'undefined' && r != "") {
		        value = encodeURIComponent(value);
		        var reg = new RegExp("(^|)" + name + "=([^&]*)(|$)");
		        var tmp = name + "=" + value;
		        if (url.match(reg) != null) {
		            r = url.replace(eval(reg), tmp);
		        }else {
		        	r =  (url.match("[\?]")) ?  url + "&" + tmp : url + "?" + tmp;
		        }
		    }
		    return r;
		},
		//检查手机号
		checkMobilePhone : function(str){
			return (str.match("^1([0-9][0-9])\\d{8}$") == null) ? false : true;
		}
}
