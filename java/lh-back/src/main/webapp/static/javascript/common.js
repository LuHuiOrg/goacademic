var common = {
		//上传图片
		change:function(imgId, fileId){
			var pic = document.getElementById(imgId);
		    var file = document.getElementById(fileId);
		    
		    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
		 	
		    // gif在IE浏览器暂时无法显示
		    if(ext != 'png' && ext != 'jpg' && ext != 'jpeg'){
		    	file.value = "";
		    	showMsg("图片格式必须是png、jpg或jpeg");
		        return;
		    }
		    var isIE = navigator.userAgent.match(/MSIE/) != null;
		    var isIE6 = navigator.userAgent.match(/MSIE 6.0/) != null;
		 
		    if(isIE) {
		    	file.select();
		        file.blur();
		        var reallocalpath = document.selection.createRange().text;
		        // IE6浏览器设置img的src为本地路径可以直接显示图片
		        if (isIE6) {
		            pic.src = reallocalpath;
		        }else {
		            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
		        	pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
		            // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
		            pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
		        }
		    }else {
		        common.html5Reader(file, imgId);
		    }
		},
		//上传图片，显示图片
		html5Reader:function(file,imgId){
			var file = file.files[0];
		    var reader = new FileReader();
		    reader.readAsDataURL(file);
		    reader.onload = function(e){
		        var pic = document.getElementById(imgId);
		        pic.src=this.result;
		    }
		}
}

/* easyui自定义表单验证 */
$.extend($.fn.validatebox.defaults.rules, {
    // 验证整数或小数
    intOrFloat: {
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: "请输入数字，并确保格式正确"
    }
})

