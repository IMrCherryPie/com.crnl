<#import "parts/common.ftlh" as c>
<@c.page>
    <H2>Car Editor</H2><br/>

    <form action="/carSave" method="post" enctype="multipart/form-data" class="mt-6">
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    <label>Гос номер:</label>
                </div>
                <div class="col-10">
                    <input type="text" name="stateNumber" value="${car.stateNumber!""}" />
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    <label>Модель:</label>
                </div>
                <div class="col-10">
                    <input type="text" name="model" value="${car.model!""}" />
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    <#if car.filename??>
                        <label>Выберете файл: </label>
                    </#if>
                </div>
                <div class="col-10">
                    <input type="file" name="file" id="customFile" />
                    <#if car.filename??>
                        <img src="/img/${car.filename}" class="card-img-top">
                    </#if>

                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-2 ">
                    <input type="hidden" value="${car.id!""}" name="carId" />
                    <input type="hidden" value="${car.filename!""}" name="oldFileName" />
                    <input type="hidden" value="${_csrf.token}" name="_csrf" />
                    <button type="submit" >Save</button>
                </div>
                <div class="col-10">
                </div>
            </div>
    </form>


</@c.page>