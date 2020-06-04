<#import "parts/common.ftlh" as c>
<@c.page>
    Company Editor<br/>

        <form action="/editCompany" method="post" enctype="multipart/form-data" class="mt-6">
            <div class="form-group mt-3">
                <div class="form-group">
                    <input type="text" name="titleCompany" value="${company.titleCompany!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="inn" value="${company.inn!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="ogrn" value="${company.ogrn!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="bik" value="${company.bik!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="k_c" value="${company.k_c!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="legalAddress" value="${company.legalAddress!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="address" value="${company.address!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="phone" value="${company.phone!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="checkingAccount" value="${company.checkingAccount!""}" />
                </div>
                <div class="form-group">
                    <input type="date" name="dateRegistration" value="${company.dateRegistration!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="contractTemplate" value="${company.contractTemplate!""}" />
                </div>
                <div class="form-group">
                    <input type="text" name="deliveryCertificateTemplate" value="${company.deliveryCertificateTemplate!""}" />
                </div>
                <div class="form-group">
                    <input type="hidden" value="${company.id!""}" name="companyId" />
                    <input type="hidden" value="${_csrf.token}" name="_csrf" />
                    <button type="submit" >Save</button>
                </div>
            </div>
        </form>
</@c.page>