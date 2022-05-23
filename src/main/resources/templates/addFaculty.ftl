<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Add faculty</title>
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
<div class="container-sm">
    <h1 class="mb-3" style="text-align: center">Add faculty</h1>
    <fieldset>
    <form name="faculty" action="/ui/v1/faculties/add" method="POST" >
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name University</label>
            <@spring.formInput "facultyForm.name" "class='form-control'"  "text" />
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Name faculty</label>
            <@spring.formSingleSelect  "facultyForm.nameFaculty",nameOfFaculty "class='form-select'" />
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Quantity Student</label>
            <@spring.formInput "facultyForm.quantityStudent" "class='form-control'"  "number" />
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Description</label>
            <@spring.formInput "facultyForm.description" "class='form-control'"  "text" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </fieldset>
</div>
</main>
<div class="container">
    <footer class="py-3 my-4">
        <p class="text-center text-muted">© 2022 Company, <em>Popiuk Roman</em></p>
    </footer>
</div>
</body>
</html>