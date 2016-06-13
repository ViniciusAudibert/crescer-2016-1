<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Formulario - Pessoa</h1><br><br>
            <form action="pessoa" method="POST">
                <div class="form-group">
                    <label for="nome">Nome da Pessoa</label>
                    <input type="text" class="form-control" id="nome" name="pessoa.nome" placeholder="Nome">
                </div>
                <div class="form-group">
                    <label for="idade">Idade</label>
                    <input type="number" class="form-control" id="idade" name="pessoa.idade" placeholder="Idade">
                </div>
                <label class="radio-inline">
                    <input type="radio" name="pessoa.sexo" id="" value="Masculino"> Masculino
                </label>
                <label class="radio-inline">
                    <input type="radio" name="pessoa.sexo" id="" value="Feminino"> Feminino
                </label>
                <label class="radio-inline">
                    <input type="radio" name="pessoa.sexo" id="" value="Outro"> Outro
                </label>
                <button type="submit" class="btn btn-danger">Enviar</button>
            </form>

        </div>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>
