//登录注册模块
var passport = {
		//登录功能
		login:{
			login:function() {
				var nickname = $("#nickname").val();
				var password = $("#password").val();
				if (nickname == null || nickname == "") {
					layer.alert("昵称不能为空", {icon: 6});
					return;
				}
				if (password == null || password == "") {
					layer.alert("密码不能为空", {icon: 6});
					return;
				}
				$("#fm").submit();
			},
			init:function(){
				//用户名、密码回车提交登录
				$("#nickname,#password").keyup(function(event){
					if(event.keyCode == 13){
						passport.login.login();
					}
				});
			}
		},
		//注册功能
		register:function() {
			var nickname = $("#nickname").val();
			var password = $("#password").val();
			var checkpassword = $("#checkpassword").val();
			var mobile = $("#mobile").val();
			var email = $("#email").val();
			var verify = $("#verify").val();
			if (nickname == null || nickname == "") {
				layer.alert('昵称不能为空', {icon: 6});
				return;
			}
			if (password == null || password == "") {
				layer.alert('密码不能为空', {icon: 6});
				return;
			}
			if (checkpassword == null || checkpassword == "") {
				layer.alert('确认密码不能为空', {icon: 6});
				return;
			}
			if (checkpassword!=password) {
				layer.alert('两次密码不同，请重新输入', {icon: 6});
				return;
			}
			if (mobile == null || mobile == "") {
				layer.alert('电话不能为空', {icon: 6});
				return;
			}
			if (verify == null || verify == "") {
				layer.alert('验证码不能为空', {icon: 6});
				return;
			}
			if (email == null || email == "") {
				layer.alert('邮箱不能为空', {icon: 6});
				return;
			}
			$("#fm").submit();
		}
}