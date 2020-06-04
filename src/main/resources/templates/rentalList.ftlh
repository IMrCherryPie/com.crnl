<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>

    <div class="alert alert-primary" role="alert">
        <center><H2>Rental list</H2></center>
    </div>

    <table class="table table-borderless table-dark">
        <thead>
        <tr>
            <th scope="col">Арендатор</th>
            <th scope="col">Арендованный автомобиль</th>
            <th scope="col">Дата аренды</th>
            <th scope="col">Дата окончания аренды</th>
            <th scope="col">НДС</th>
            <th scope="col">Стоимость аренды</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <#if rentals??>
            <#list rentals as rental>
                <tr>
                    <td>${rental.lessee.username!""}</td>
                    <td>${rental.carnumber.brand} ${rental.carnumber.model!""} ${rental.carnumber.stateNumber}</td>
                    <td>${rental.rentalStartDate!""}</td>
                    <td>${rental.rentalEndDate!""}</td>
                    <td>${rental.nds!""}</td>
                    <td>${rental.rentPrice!""}</td>
                    <td><a href="/rental/${rental.id}">edit</a></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

</@c.page>