<#import "../parts/template.ftlh" as c>
<#import "../assigns.ftlh" as a>

<@c.page>
    <h1>Products list</h1>
    <a href="/products/create">Create new product</a>
    <div class="products">
        <#list products as prod>
            <div class="product">
                <img width="100" height="100" src="${prod.image}" alt="">
                <div>${prod.name}</div>
                <div>${prod.description}</div>
            </div>
        </#list>
    </div>
</@c.page>