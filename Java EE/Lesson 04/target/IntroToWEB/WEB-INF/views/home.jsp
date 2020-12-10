<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.ArrayList" %>

<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- JSTL doc resource-->

<%!
    //объявление глобальной переменной
    int counter2 = 0;
%>

<%
    //Объявление локальной переменной
    String title = "Home";
    int counter1 = 0;
%>
<html>
<head>
    <!-- Вывод Java переменной -->
    <title><%= title %>
    </title>
    <meta charset="utf-8">
</head>
<body>
<%--    <jsp:include page="templates/header.jsp" />--%>
<c:import url="templates/header.jsp">
    <%--        <c:param name="" value="" />--%>
</c:import>
<a href="<c:url value="/upload" />">Upload file</a>
<h1>Hello Java EE</h1>
<h3>Hello JSP</h3>
<!-- Использование JSTL функций -->
<h4>${fn:toLowerCase(message)}</h4>
<a href="/demo">Go to /demo</a>
<form method='post'>
    <input type='text' name='login' placeholder='Enter your login'>
    <input type='password' name='password' placeholder='Enter your password'>
    <input type='submit' value='Log in'>
</form>
<!-- Вывод Java в HTML -->
<p><%= LocalDate.now().getYear() %>
</p>
<div>
    <p><%= counter1++ %>
    </p>
    <p><%= counter2++ %>
    </p>
</div>

<ul>
    <%
        String[] languages = (String[]) request.getAttribute("languages");
        for (String lang : languages) {
            out.println("<li>" + lang + "</li>");
        }
        boolean state = true;
    %>
</ul>

<!-- foreach -->
<ul>
    <c:forEach items="${languages}" var="lang">
        <li><c:out value="${lang}"></c:out></li>
    </c:forEach>
</ul>
<c:set value="${message}" var="demo"/>
<c:set value="${state}" var="state"/>

<!-- if -->
<h1>${demo}</h1>
<c:if test="${state}">
    <h1>True</h1>
</c:if>

<!-- choose -->
<c:set var="width" value="${width}"/>
<h1>Width = ${width}</h1>
<c:choose>
    <c:when test="${(width / 2) < 100}">
        <div style="color: green">Green</div>
    </c:when>
    <c:when test="${(width / 2) < 200}">
        <div style="color: red">Red</div>
    </c:when>
    <c:otherwise>
        <div style="color: blue">Blue</div>
    </c:otherwise>
</c:choose>


<!-- удаление объявленной переменной через "set" -->
<c:remove var="width"/>

<!-- обработка исключений -->
<c:catch var="ex">
    <%
        int a = 10, b = 0, c;
        c = a / b;
    %>
</c:catch>

<c:if test="${ex != null}">
    <div style="font-size: 1.5rem;color: red;">Exception: ${ex.message}</div>
</c:if>

<!-- Создание ссылок -->
<%--    <a href="/home/view">Home->View</a>--%>
<a href='<c:url value="home/view" />'>Home->View</a>

<h3>Number Format:</h3>
<c:set var = "now" value = "<%= new java.util.Date()%>" />

<p>Formatted Date (1): <fmt:formatDate type = "time"
                                       value = "${now}" /></p>

<p>Formatted Date (2): <fmt:formatDate type = "date"
                                       value = "${now}" /></p>

<p>Formatted Date (3): <fmt:formatDate type = "both"
                                       value = "${now}" /></p>

<p>Formatted Date (4): <fmt:formatDate type = "both"
                                       dateStyle = "short" timeStyle = "short" value = "${now}" /></p>

<p>Formatted Date (5): <fmt:formatDate type = "both"
                                       dateStyle = "medium" timeStyle = "medium" value = "${now}" /></p>

<p>Formatted Date (6): <fmt:formatDate type = "both"
                                       dateStyle = "long" timeStyle = "long" value = "${now}" /></p>

<p>Formatted Date (7): <fmt:formatDate pattern = "yyyy-MM-dd"
                                       value = "${now}" /></p>

<!-- Получение данных из сессии -->
<%
    ArrayList<String> values = (ArrayList<String>) session.getAttribute("values");
%>
<%= values.stream().count() == 0 ? "Empty" : String.format("Count values = %d", values.stream().count()) %>
</body>
</html>
