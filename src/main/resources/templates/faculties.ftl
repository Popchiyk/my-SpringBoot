<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Faculties</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light mb-2">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="container">
                <ul class="navbar-nav">
                    <a class="navbar-brand" href="/">Faculty</a>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/ui/v1/faculties/">Table</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/api/v1/faculties/" target="_blank">API</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="page-add" target="_blank">Add</a>
                    </li>
                </ul>
            </div>
            </div>
        </div>
    </nav>

</header>
<main>
<div class="container">
<h1 class="mb-3" style="text-align: center">List table</h1>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Name Manager</th>
        <th>Name Faculty</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>CreateAt</th>
        <th>UpdateAt</th>
        <th>Delete</th>
        <th>Edit</th>


    </tr>
    <#list faculties as faculty>
        <tr>
            <#if faculty??>
            <td>${faculty.id}</td>
            <td>${faculty.name}</td>
            <td>${faculty.nameFaculty}</td>
            <td>${faculty.description}</td>
            <td>${faculty.quantityStudent}</td>
                <td><#if faculty.creatAt??>
                        ${faculty.creatAt}
                    <#else >No create :(
                    </#if>
            <td><#if faculty.updateAt??>
                    ${faculty.updateAt}
                    <#else >No update :(
            </#if>
            </td>
            <td><a href="delete/${faculty.id}" class="btn btn-outline-danger">Delete</a></td>
            <td> <a href="page-edit/${faculty.id}" class="btn btn-outline-dark" target="_blank">Edit</a></td>
            <#else> empty faculty
            </#if>
        </tr>
    </#list>

</table>
</div>
</main>
<div class="container">
    <footer class="py-3 my-4">
        <p class="text-center text-muted">© 2022 Company, <em>Popiuk Roman</em></p>
    </footer>
</div>
</body>
</html>