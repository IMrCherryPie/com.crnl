<#import "parts/common.ftlh" as c>

<#include "parts/security.ftlh">
<@c.page>

    <div class="alert alert-primary" role="alert">
        <center><H2>Персональные данные пользователя "${personalData.getFio()}"</H2></center>
    </div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample1" role="button" aria-expanded="true"
   aria-controls="collapseExample" xmlns="http://www.w3.org/1999/html">
    Personal Data
</a>
<div class="collapse" id="collapseExample1">
    <div class="form-group mt-3">
        <form action="/user/addPersonalData" method = "post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="fio" value="${personalData.getFio()!""}" placeholder="Фамилия Имя Отчество через пробел"  />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="gender" placeholder="Пол" value="${personalData.getGender()!""}" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="passportSeries" value="${personalData.passportSeries!""}" placeholder="Серия паспорта"  />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="passportNumber" value="${personalData.getPassportNumber()!""}" placeholder="Номер паспорта" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="departmentCode" value="${personalData.getDepartmentCode()!""}" placeholder="Код подразделения" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="issuedBy" value="${personalData.getIssuedBy()!""}" placeholder="Паспорт выдан" />
            </div>
            <div class="form-group">
                <input type="Date" class="form-control" name="dateOfIssue" value="${personalData.getDateOfIssue()!""}" placeholder="Дата выдачи" required />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="placeOfBirth" value="${personalData.getPlaceOfBirth()!""}" placeholder="Место выдачи" />
            </div>
            <div class="form-group">
                <input type="Date" class="form-control" name="dateOfBirth" value="${personalData.getDateOfBirth()!""}" placeholder="Дата рождения" required />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="placeOfResidence" value="${personalData.getPlaceOfResidence()!""}" placeholder="Место регистрации" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="phone" value="${personalData.getPhone()!""}" placeholder="Контактный телефон" />
            </div>
            <div class="form-group">
                <input type="hidden" name="userId" value="${user.getId()!""}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>

    </div>
</div>
</@c.page>