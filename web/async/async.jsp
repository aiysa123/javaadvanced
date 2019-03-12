<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book}</li>
    </c:forEach>
</ul>
<% out.println("业务调用结束的时间：" + new Date());
    if(request.isAsyncStarted()){
        //完成异步调用
        request.getAsyncContext().complete();
    }
%>
