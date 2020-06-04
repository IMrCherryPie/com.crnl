<#import "parts/common.ftlh" as c>

<@c.page>
    <center><h2><p style="color: darkolivegreen">Отзывы от клиентов о компании</p></h2></center>
    <div class="form-group">
        <form method="get" action ="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag"/>
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true" aria-controls="collapseExample">
        Add new message
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method = "post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Введите сообщение" required />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="tag" placeholder="Придумайте тэг к своему отзыву" required />
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile" />
                        <label class="custom-file-label" for="customFile">Можете прикрепить одну фотографию</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <div>
                    <#if message.filename??>
                        <img src="/img/${message.filename}" class="card-img-top">
                    </#if>
                </div>
                <div class="m-2">
                    <span>${message.text}</span>
                    <span class="badge badge-primary"><i>${message.tag}</i></span>
                </div>
                <div class="card-footer text-muted">
                    ${message.getAuthorName()}
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>