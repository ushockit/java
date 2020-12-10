<#import "../parts/template.ftlh" as c>


<@c.page>
    <h1>Creating a new product</h1>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>
            <label>Image:
                <input type="text" name="image" placeholder="Product image...">
            </label>
        </div>
        <div>
            <label>Name:
                <input type="text" name="name" placeholder="Product name...">
            </label>
        </div>
        <div>
            <label>Price:
                <input type="number" name="price" placeholder="Product price...">
            </label>
        </div>
        <div>
            <label>Description:
                <input type="text" name="description" placeholder="Product description...">
            </label>
        </div>
        <button>Create</button>
    </form>
</@c.page>