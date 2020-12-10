<#macro form title="" isRegistration=false>
    <h1>${title}</h1>
    <form method="post" action="${isRegistration?string("/auth/registration", "/auth/login")}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>
            <label>Login:
                <input type="text" name="username" placeholder="Enter your login">
            </label>
        </div>
        <div>
            <label>Password:
                <input type="password" name="password" placeholder="Enter your password">
            </label>
        </div>
        <#if isRegistration>
            <button>Регистрация</button>
        <#else>
            <button>Авторизация</button>
        </#if>
    </form>
    <a href="/">Back to home page</a>
</#macro>