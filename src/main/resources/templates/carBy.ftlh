<#import "parts/common.ftlh" as c>

<#include "parts/security.ftlh">
<@c.page>
    <div class="card my-3">
        <div>
            <#if car.filename??>
                <img src="/img/${car.filename}" width="10" height="250" class="card-img-top">
            </#if>
        </div>
        <div class="m-2">

            <span>${car.brand}</span>
            <i>${car.model}</i>
            <#if isAdmin>
                <a href="/car/${car.id}">Edit</a>
            </#if>
        </div>
        <div class="card-footer text-muted">
            ${car.costOfRental} p/д
        </div>
    </div>

    <#if name != "uncnown">
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
           aria-controls="collapseExample" xmlns="http://www.w3.org/1999/html">
            Lease
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form action="/rentalCar/${car.id},#{user.id}" method = "post" enctype="multipart/form-data">

                    <div class="container">
                        <div class="row">
                            <div class="col-3 ">
                                Дата начала аренды
                            </div>
                            <div class="col-9">
                                <input type="Date" class="form-control" name="rentalStartDate" />
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-3 ">
                                Дата завершения аренды
                            </div>
                            <div class="col-9">
                                <input type="Date" class="form-control" name="rentalEndDate" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="hidden" name="userId" value="${user.getId()!""}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-primary">Произвести расчёт</button>
                    </div>
                </form>

            </div>
        </div>
    </#if>

    <#if a != "">
        <div class="container">
            <div class="row">
                <div class="col-3 ">
                    <span>Стоимость аренды составит: </span>
                </div>
                <div class="col-9">
                    ${costRental} руб.
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3 ">
                    <span>НДС составит: </span>
                </div>
                <div class="col-9">
                    ${nds} руб.
                </div>
            </div>
        </div>
        <#if user.isActivePersonalData()>
            <form action="/registerADeal" method="post" enctype="multipart/form-data" class="mt-6">
                <input type="hidden" value="${user.id}" name="userId" />
                <input type="hidden" value="${car.id}" name="carId" />
                <input type="hidden" value="${rentalStartDate}" name="rentalStartDate" />
                <input type="hidden" value="${rentalEndDate}" name="rentalEndDate" />
                <input type="hidden" value="${_csrf.token}" name="_csrf" />
                <button type="submit" class="btn btn-primary">Оформить в один клик</button>
            </form>
        <#else >
            <a href="/user/personalData/${user.id}">
                <button type="submit" class="btn btn-primary">Необходимо заполнить персональные данные для покупки</button>
            </a>
        </#if>

    </#if>



</@c.page>