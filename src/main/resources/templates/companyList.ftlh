<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
       aria-controls="collapseExample" xmlns="http://www.w3.org/1999/html">
        Add new company
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form action="/addCompany" method = "post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="titleCompany" placeholder="Введите название компании" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="inn" placeholder="Введите ИНН" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="ogrn" placeholder="Введите ОГРН" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="bik" placeholder="Введите БИК" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="k_c" placeholder="Введите К/С" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="legalAddress" placeholder="Введите юридический адрес" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Введите адрес фактический" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phone" placeholder="Введите номер телефона" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="checkingAccount" placeholder="Введите расчётный счёт" />
                </div>
                <div class="form-group">
                    <input type="date" class="form-control" name="dateRegistration" placeholder="Введите дату регистрации компании" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="contractTemplate" placeholder="Добавьте файл шаблона договора" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="deliveryCertificateTemplate" placeholder="добавьте шаблон акта сдачи" />
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    </#if>
    <#list companys as company>
        <div class="container">
            <div class="row">
                <div class="col-3 ">
                    Название компании
                </div>
                <div class="col-9">
                    ${company.titleCompany!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    ИНН
                </div>
                <div class="col-9">
                    ${company.inn!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    ОГРН
                </div>
                <div class="col-9">
                    ${company.ogrn!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    БИК
                </div>
                <div class="col-9">
                    ${company.bik!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    К/С
                </div>
                <div class="col-9">
                    ${company.k_c!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    Юридический адрес
                </div>
                <div class="col-9">
                    ${company.legalAddress!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    Физический адрес
                </div>
                <div class="col-9">
                    ${company.address!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    Телефон
                </div>
                <div class="col-9">
                    ${company.phone!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    Расчётный счёт
                </div>
                <div class="col-9">
                    ${company.checkingAccount!""}
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    Дата регистрации
                </div>
                <div class="col-9">
                    ${company.dateRegistration!""}
                </div>
            </div>
        </div>
        <#if isAdmin>
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <a href="/company/${company.id}">Edit</a>
                </div>
                <div class="col-9">
                </div>
            </div>
        </div>
        </#if>
        </br>

    </#list>
    <br>
    <div align="center" class="mt-5">
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3083.780031208645!2d39.780285826702965!3d47.24757515091594!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sru!4v1590994124536!5m2!1sru!2sru" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
    </div>

</@c.page>