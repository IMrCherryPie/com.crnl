<#include "security.ftlh">
<#import  "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Car Rental</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rental">Rental list</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/car">Car list</a>
                </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/companyList">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/carPrice">Car price</a>
            </li>



        </ul>
        <#if name != "uncnown"> <a href="/user/personalData/${userId}"> </#if>
            <div class="navbar-text mr-3">${name}</div>
            <#if name != "uncnown"> </a> </#if>
        <@l.logout />
    </div>
</nav>