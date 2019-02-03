<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <span class="navbar-brand mb-0 h1" style="margin: auto">Выгрузка кредитных организаций</span>
</nav>
<br>
<br>
<!-- Button trigger modal -->
<button style="display: block; width: auto; height: auto; margin: 0 auto;" type="button" class="btn btn-primary"
        data-toggle="modal" data-target="#exampleModal">
    Приступить к задаче
</button>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Информация</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Начать скачивание кредитных организаций?
            </div>
            <div class="modal-footer">
                <button id="ok-button" onclick="disableButton(); download()" type="button" class="btn btn-secondary">
                    OK
                </button>
                <form action="/organizations/list">
                    <button id="view-button" type="submit" disabled="disabled" class="btn btn-primary">
                        Посмотреть результаты
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function download() {
        $.ajax({
            url: "/organizations/download",
            type: "GET",
            cache: false,
            success: function () {
                $('#view-button').removeAttr("disabled");

            },
            error: function () {
                alert("Данные не были успешно скачены, будут предоставлены не актуальные данные!");
                $.ajax({
                    url: "/organizations/list",
                    type: "GET",
                })
            }
        });
    }

    function disableButton() {
        $('#ok-button').attr("disabled", "disabled");
        alert('Началась загрузка данных, пожалуйста подождите! После окончания загрузки, кнопка \"Посмотреть результаты\" станет активной');
    }
</script>
</body>
</html>
