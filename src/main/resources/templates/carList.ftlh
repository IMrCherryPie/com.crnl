<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
           aria-controls="collapseExample" xmlns="http://www.w3.org/1999/html">
            Add new car
        </a>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form action="/registrationCar" method = "post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" name="stateNumber" placeholder="Введите регисрационный номер" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="brand" placeholder="Введите марку" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="model" placeholder="Введите модель" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="color" placeholder="Введите цвет" />
                    </div>
                    <div class="form-group">
                        <input type="Date" class="form-control" name="yearOfManufacture" placeholder="Введите дату произваодства" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="vinBody" placeholder="Введите VIN кузова" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="vinEngine" placeholder="Введите VIN двигателя" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="costOfRental" placeholder="Введите стоимость аренды" />
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="inRental" value="false" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="registrationCertificate" placeholder="Введите № ПТС" />
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input type="file" name="file" id="customFile" />
                            <label class="custom-file-label" for="customFile">Choice file</label>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </#if>

    <H2>Car list</H2>
    <#list cars as car>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Марка автомобиля
                </div>
                <div class="col-10">
                    ${car.brand!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Регистрационный номер
                </div>
                <div class="col-10">
                    ${car.stateNumber!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Модель
                </div>
                <div class="col-10">
                    ${car.model!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Цвет
                </div>
                <div class="col-10">
                    ${car.color!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Год производства
                </div>
                <div class="col-10">
                    ${car.yearOfManufacture!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    VIN кузова
                </div>
                <div class="col-10">
                    ${car.vinBody!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    VIN двигателя
                </div>
                <div class="col-10">
                    ${car.vinEngine!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    Стоимость аренды
                </div>
                <div class="col-10">
                    ${car.costOfRental!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    № ПТС
                </div>
                <div class="col-10">
                    ${car.registrationCertificate!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <a href="/car/${car.id}">Edit</a>
                </div>
                <div class="col-10">
                </div>
            </div>
        </div>
        <span class="d-block p-2 bg-primary text-white"></span>
    </#list>

</@c.page>