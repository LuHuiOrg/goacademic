//首页模块
var home = {
		//加入购物车
		addCart:function(params){
			$.ajax({
				url: common.getRootPath() + "/shop/addCart",
				data:{"courseId":$(params).attr("courseId")},
				type:"post",
				cache:false,
				async:false,
				dataType:'json',
				success:function(data){
					if(data.flag){
						layer.alert('已成功加入购物车，请到购物车结算', {icon: 6});
					}else{
						layer.alert(data.msg, {icon: 6});
					}
				},
				error:function(){
					layer.alert("请先登录再购买", {icon: 6});
				}
			});
		}
}