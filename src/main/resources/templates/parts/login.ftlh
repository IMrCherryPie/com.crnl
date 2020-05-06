<#include "security.ftlh">
<#macro login path isRegisterFrom>
    <form action="${path}" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> User Name : </label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="User name" required />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="password" required />
            </div>
        </div>
        <#if isRegisterFrom>
            <div class="form-group">
                <label class="col-sm-2 col-form-label"> Email: </label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="Email" required />
                </div>
            </div>
        </#if>
        <div class="form-group">
            <div class="col-sm-6">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Sign In</button>
                <#if !isRegisterFrom>
                    <a href="/registration">Add new user</a>
                </#if>
            </div>
        </div>
    </form>
</#macro>
<#macro logout>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <#if user??>
            <button type="submit" class="btn btn-primary">Sign out</button>
                <#else>
                    <button type="submit" class="btn btn-primary">Sign in</button>
            </#if>
        </form>
</#macro>