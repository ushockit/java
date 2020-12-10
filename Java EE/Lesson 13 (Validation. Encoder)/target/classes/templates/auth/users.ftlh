<#import "../parts/template.ftlh" as c>


<@c.page>
    <ul>
    <#list users as user>
        <li>
            <div class="user-info">
                <div class="username">${user.username}</div>
                <div class="user-active">${user.active?string("Active", "Disable")}</div>
                <div class="user-roles">
                    <#list user.roles as role>
                        ${role}<#sep> |
                    </#list>
                </div>
                <a href="/auth/user-edit/${user.id}">Edit</a>
            </div>
        </li>
    </#list>
    </ul>
</@c.page>