<#import "../parts/template.ftlh" as c>
<#import "../parts/form.ftlh" as f>


<@c.page>
    <#if message??>
        <h4 style="color: red;font-style: italic;">${message}</h4>
    </#if>
    <@f.form "Регистрация нового пользователя" true/>
</@c.page>