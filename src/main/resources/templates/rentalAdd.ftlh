<#import "parts/common.ftlh" as c>

<@c.page>


    <form action="/registrationRental" method = "post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="col-md-3 mb-3">
                <label for="user">User</label>
                <select class="custom-select is-invalid" name="userId" id="user" required>
                    <option selected disabled value="">Не выбрано</option>
                    <#list users as user>
                        <option value="${user.id}" label="${user.getUsername()}"></option>
                    </#list>
                </select>
                <div class="invalid-feedback">
                    Please select a valid User.
                </div>
            </div>

            <div class="col-md-3 mb-3">
                <label for="car">Car</label>
                <select class="custom-select is-invalid" name="carId" id="car" required>
                    <option selected disabled value="">Не выбрано</option>
                    <#list cars as car>
                        <#if !car.inRental>
                            <option value="${car.id}" label="${car.brand} ${car.model} ${car.stateNumber}"></option>
                        </#if>
                    </#list>
                </select>
                <div class="invalid-feedback">
                    Please select a valid Car.
                </div>
            </div>

            <div class="col-md-3 mb-3">
                <label for="company">Company</label>
                <select class="custom-select is-invalid" name="companyId" id="company" required>
                    <option selected disabled value="">Не выбрано</option>
                    <#list companys as company>
                        <option value="${company.id}" label="${company.titleCompany}"></option>
                    </#list>
                </select>
                <div class="invalid-feedback">
                    Please select a valid Company.
                </div>
            </div>

            <div class="col-md-3 mb-3">
                <label for="rentalStartDate">Дата начала аренды</label>
                <input type="Date" class="form-control" name="rentalStartDate"  required/>
                <div class="invalid-feedback">
                    Please set a valid date.
                </div>
            </div>

            <div class="col-md-3 mb-3">
                <label for="rentalEndDate">Дата окончания аренды</label>
                <input type="Date" class="form-control" name="rentalEndDate" required/>
                <div class="invalid-feedback">
                    Please set a valid date.
                </div>
            </div>
        </div>

        <input type="hidden" value="${_csrf.token}" name="_csrf" />
        <button type="submit" class="btn btn-primary">Зарегистрировать аренду</button>
    </form>

</@c.page>