<#import "../parts/template.ftlh" as c>

<@c.page>
    <form action="/auth/user-edit" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="exampleInputUsername">Username</label>
            <input type="text" class="form-control" name="username" value="${user.username}" id="exampleInputUsername">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword">
        </div>
        <div class="form-group">
            <#list roles as role>
                <div class="form-check">
                    <input class="form-check-input"
                           name="${role}"
                            ${user.roles?seq_contains(role)?string("checked", "")}
                           type="checkbox"
                           id="defaultCheck${role}">
                    <label class="form-check-label" for="defaultCheck${role}">
                        ${role}
                    </label>

                </div>
            </#list>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@c.page>