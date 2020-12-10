<#macro form title="" isRegistration=false>
    <h1>${title}</h1>
    <form method="post">
        <div>
            <label>Login:
                <input type="text" name="login" placeholder="Enter your login">
            </label>
        </div>
        <div>
            <label>Password:
                <input type="text" name="password" placeholder="Enter your password">
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