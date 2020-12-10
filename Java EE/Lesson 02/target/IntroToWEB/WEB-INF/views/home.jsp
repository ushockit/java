<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

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
    <title><%= title %></title>
    <meta charset="utf-8">
</head>
<body>
    <jsp:include page="templates/header.jsp" />
    <%
    %>
    <h1>Hello Java EE</h1>
    <h3>Hello JSP</h3>
    <h4>${message}</h4>
    <a href="/demo">Go to /demo</a>
    <form method='post'>
        <input type='text' name='login' placeholder='Enter your login'>
        <input type='password' name='password' placeholder='Enter your password'>
        <input type='submit' value='Log in'>
    </form>
    <!-- Вывод Java в HTML -->
    <p><%= LocalDate.now().getYear() %></p>
    <div>
        <p><%= counter1++ %></p>
        <p><%= counter2++ %></p>
    </div>

    <ul>
    <%
        String[] languages = (String[])request.getAttribute("languages");
        for (String lang : languages) {
            out.println("<li>" + lang + "</li>");
        }
    %>
    </ul>

    <!-- Получение данных из сессии -->
    <%
        ArrayList<String> values = (ArrayList<String>)session.getAttribute("values");
    %>
    <%= values.stream().count() == 0 ? "Empty" : String.format("Count values = %d", values.stream().count()) %>
</body>
</html>
