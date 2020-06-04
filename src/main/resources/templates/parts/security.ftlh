<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    userId = user.getId()
    isAdmin= user.isAdmin()
    actualyPersonalData = user.isActivePersonalData()

    >
<#else>
    <#assign
    name = "uncnown"
    isAdmin = false
    userId = ""
    actualyPersonalData = false
    >
</#if>