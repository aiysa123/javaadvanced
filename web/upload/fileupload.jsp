<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form method="post" action="../uploadFile" enctype="multipart/form-data">
        文件名：<input type="text" name="name" id="name" /><br/>
        选择文件：<input type="file" name="file" id="file" /><br/>
        <input type="submit" value="上传" /><br/>
    </form>
</body>
</html>
