var course = {
		playFlash:function(courseId,id){
			var playForm = '<form action="'+common.getRootPath()+'/course/play" method="POST" id="playForm"><input type="text" name="id" value="'+id+'"><input type="text" name="courseId" value="'+courseId+'"></form>';
			$("body").append(playForm);
			$("#playForm").submit();
		}
}