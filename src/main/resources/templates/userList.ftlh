<#import "parts/common.ftlh" as c>
<@c.page>
     <div class="alert alert-primary" role="alert">
          <center><h2>Пользователи сайта!</h2></center>
     </div>
     <table class="table table-borderless table-dark">
          <thead>
          <tr>
               <th scope="col">id</th>
               <th scope="col">Имя пользователя</th>
               <th scope="col">Role</th>
               <th scope="col">E-mail</th>
               <th scope="col">Edit</th>
          </tr>
          </thead>
          <tbody>
          <#list users as user>
               <tr>
                    <th scope="row">${user.id!""}</th>
                    <td>${user.username!""}</td>
                    <td><#list user.roles as role>${role!""}<#sep>, </#list></td>
                    <td>${user.email!""}</td>
                    <td><a href="/user/${user.id!""}">edit</a></td>
               </tr>
          </#list>
          </tbody>
     </table>

</@c.page>