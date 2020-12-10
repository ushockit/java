<!-- Импорт шаблона -->
<#import "../parts/template.ftlh" as c>
<#import "../parts/person-form.ftlh" as f>
<@c.page>
    <h1>Hello, Spring Boot</h1>
<!--    <h3>{{name}}</h3>-->
<!--    {{#age}}-->
<!--        <h4>{{age}}y.o.</h4>-->
<!--    {{/age}}-->

    <!-- Отображение списка объектов -->
<#--    <ul>-->
<#--        {{#people}}-->
<#--            <li>{{lastName}} {{firstName}} {{age}}.y.o</li>-->
<#--        {{/people}}-->
<#--    </ul>-->
    <ul>
        <#list people as person>
            <li>${person.lastName} ${person.lastName} ${person.age}y.o.</li>
        </#list>
    </ul>

    <!-- Отображение списка строк -->
<#--    <ul>-->
<#--        {{#items}}-->
<#--            <li>{{.}}</li>-->
<#--        {{/items}}-->
<#--    </ul>-->
    <!-- Встраивание макроса -->
    <@f.form />

    <div>
        <a href="/auth/login">Login</a>
        <br/>
        <a href="/auth/registration">Registration</a>
        <br>
        <a href="/products/">View products</a>
    </div>


</@c.page>