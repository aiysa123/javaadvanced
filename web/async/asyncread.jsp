<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>非阻塞式IO读取数据结果</title>
</head>
<body>
    <h2>读取数据结果</h2>
    浏览器提交的数据为： ${info}
    <% out.println("业务调用结束的时间：" + new Date());
        if(request.isAsyncStarted()){
            //完成异步调用
            request.getAsyncContext().complete();
        }
    %>

</body>
</html>
