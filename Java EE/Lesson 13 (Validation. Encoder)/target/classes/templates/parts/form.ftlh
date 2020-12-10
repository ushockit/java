<#macro form title="" isRegistration=false>
    <h1>${title}</h1>
    <form method="post" action="${isRegistration?string("/auth/registration", "/auth/login")}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>
            <label>Login:
                <input type="text" name="username" value="<#if login??>${login}</#if>" placeholder="Enter your login">
            </label>
            <#if usernameError??>
                <span class="error">${usernameError}</span>
            </#if>
        </div>
        <div>
            <label>Password:
                <input type="password" name="password" placeholder="Enter your password">
            </label>
            <#if passwordError??>
                <span class="error">${passwordError}</span>
            </#if>
        </div>
        <#if isRegistration>
            <div>
                <label>Confirm password:
                    <input type="password" name="confirmPassword" placeholder="Enter confirm password">
                </label>
                <#if confirmPasswordError??>
                    <span class="error">${confirmPasswordError}</span>
                </#if>
            </div>
            <button>Регистрация</button>
        <#else>
            <button>Авторизация</button>
        </#if>
    </form>
    <a href="/">Back to home page</a>
</#macro>