# lh-site

导入此项目时需要注意的：
1.如果能正常解压node-package.7z那么请解压完成后导入此maven项目
2.如果不能正常解压node-package.7z那么需要在lh-site\node_modules\node-sass\vendor\win32-x64-11\binding.node添加上
并修改gulp-rev-append:index.js和gulp-asset-rev:index.js

打包命令：
mvn clean package -Pproduction -Dmaven.test.skip=true -Dgulp.build=production

gulp插件需要修改的地方：
gulp-rev-append:index.js
if(normPath.indexOf("${ctx}") === 0){
	dependencyPath="src/main/webapp/"+normPath.replace("${ctx}", "");
}else{
	if (normPath.indexOf(path.sep) === 0) {
        dependencyPath = path.join(file.base, normPath);
    }
    else {
       dependencyPath = path.resolve(path.dirname(file.path), normPath);
    }
}

gulp-asset-rev:index.js
//src = src.replace(verStr, '').replace(/(\.[^\.]+)$/, verStr + "$1");
src=src+"?v="+verStr;

测试：autoprefixer
display: flex; ----> display: -webkit-box; display: -ms-flexbox; display: flex;

参考网址：
http://www.lefxtv.com/
https://www.wegene.com/
http://www.runoob.com/bootstrap/bootstrap-tutorial.html
http://v3.bootcss.com/components/#glyphicons-how-to-use

此项目网址：
http://47.92.123.48/