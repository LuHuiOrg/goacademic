var course = {
		playFlash:function(courseId,id){
			var playForm = '<form action="'+common.getRootPath()+'/course/play" method="POST" id="playForm"><input type="text" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" name="id" value="'
							+id+'"><input type="text" style="width: 0px; height: 0px; border: 0px; visibility: hidden;" name="courseId" value="'+courseId+'"></form>';
			$("body").append(playForm);
			$("#playForm").submit();
		}
}