<#import "parts/common.ftlh" as c>

<#include "parts/security.ftlh">

<@c.page>
    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Filter
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="form-check">
                    <p>
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                        <label class="form-check-label" for="defaultCheck1">
                            Иномарки
                        </label>
                    </p>
                    <p>
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
                        <label class="form-check-label" for="defaultCheck1">
                            Отечественные
                        </label>
                    </p>
                </div>
                <p>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Дороже
                        </label>
                <p>
                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option2" checked>
                    <label class="form-check-label" for="exampleRadios1">
                        Дешевле
                    </label>
                </p>
            </div>
            </p>
        </div>
    </div>
    </div>

    <div class="card-columns">
        <#list cars as car>
            <div class="card my-3">
                <div>
                    <#if car.filename??>
                        <a href="/carBy/${car.id}/${userId}"><img src="/img/${car.filename}" class="card-img-top"></a>
                    </#if>
                </div>
                <div class="m-2">
                    <a href="/carBy/${car.id},${userId}">
                        <span>${car.brand}</span>
                        <i>${car.model}</i>
                    </a>
                    <#if isAdmin>
                        <a href="/car/${car.id}">Edit</a>
                    </#if>
                </div>
                <div class="card-footer text-muted">
                    ${car.costOfRental} p/д
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>