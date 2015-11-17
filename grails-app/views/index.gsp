<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-${request.contextPath}/theme/assets/ico/favicon.png">

    <title>Bienvenido a Forum 2.0 </title>

    <!-- Bootstrap core CSS -->
    <link href="${request.contextPath}/theme/assets/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="${request.contextPath}/theme/assets/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="${request.contextPath}/theme/assets/js/hover.zoom.js"></script>
    <script src="${request.contextPath}/theme/assets/js/hover.zoom.conf.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- Static navbar -->
<div class="container" >
    <center><img class= "text-vertical-center" src="${request.contextPath}/theme/assets/img/forum.png" width="200px" height="auto"/></center>
</div>

<!-- Static navbar -->
<div class="navbar">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <p class="navbar-brand">FORUM 2.0</p>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="work.html">Mi Perfil</a></li>
                <li><a href="about.html">Mis Post</a></li>
                <li><a href="blog.html">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<!-- +++++ Welcome Section +++++ -->
<div id="ww">
    <div class="container">
        <div class="row mt centered">
            <div class="col-lg-4">
                <h3>Bienvenido a la aplicación FORUM 2.0</h3>
                <p>Consultar:</p>
                <li><p><a href= "http://localhost:8080/DesarrolloGrails/forum/index">Foros</a></p></li>
                <li><p><a href= "http://localhost:8080/DesarrolloGrails/user/create">Usuarios</a></p></li>
                <li><p><a href= "http://localhost:8080/DesarrolloGrails/post/index">Entradas (post)</a></p></li>
                <p><a>Archivos</a></p>
            </div>
            <div class="col-lg-4">
                <h3>Ultimas entradas (Post)</h3>
                <div class="container" id="box">
                    Aquí verás los post recientes...
                    <p>post 1</p>
                    <p>post 2</p>
                    <p>post 3</p>
                    <p>post 4</p>
                    <p>post 5</p>
                    <p>post 6</p>
                    <p>post 7</p>
                </div>

            </div>
            <div class="col-lg-4">
                <h3>Foros con más entradas</h3>
                <div class ="container" id="box">
                    Aquí verás los foros más populares...
                    <p>entrada 1</p>
                    <p>entrada 2</p>
                    <p>entrada 3</p>
                    <p>entrada 4</p>
                    <p>entrada 5</p>
                    <p>entrada 6</p>
                    <p>entrada 7</p>
                </div>

            </div>
        </div><!-- /row -->
    </div> <!-- /container -->
</div><!-- /ww -->

<!-- +++++ Footer Section +++++ -->

<div id="footer">
    <div class="container">
        <div>
            <center><p>Aplicación hecha por: <strong>PreventRisk</strong></p></center>
        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${request.contextPath}/theme/assets/js/bootstrap.min.js"></script>
</body>
</html>
