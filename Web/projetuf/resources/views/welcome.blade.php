<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Stephie Place</title>

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,600" rel="stylesheet">

    <!-- Styles -->
    <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        /* ----------------
    Hero section
     -------------------*/
        .hero-section {
            height: 100%;
            padding-top: 120px;
            padding-bottom: 30px;
            background-image: url("https://www.journaldelagence.com/wp-content/uploads/2019/03/cr%C3%A9er-son-agence-immobili%C3%A8re-en-2019-1024x695.png");
            margin: 0;
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .hero-warp {
            padding: 40px 40px 40px;
            background: rgba(34, 36, 43, 0.83);
        }

        .main-search-form {
            font-family: "Lato", sans-serif;
            text-align: center;
        }

        .main-search-form p {
            font-size: 12px;
            color: #b6b6b6;
            font-style: italic;
            margin-bottom: 0;
        }

        .search-type .st-item {
            display: inline-block;
            text-align: center;
        }

        .search-type .st-item input {
            position: absolute;
            visibility: hidden;
            opacity: 0;
            z-index: -1;
        }

        .search-type .st-item input:checked+label {
            padding: 30px 100px;
            background: #60C2CF;
        }

        .search-type .st-item input:checked+label:after {
            bottom: -15px;
            opacity: 1;
            -webkit-transition: all 0.2s ease 0.3s;
            transition: all 0.2s ease 0.3s;
        }

        .search-type label {
            position: relative;
            font-family: "Lato", sans-serif;
            font-weight: 700;
            color: #fff;
            padding: 11px 20px;
            margin-right: 50px;
            margin-left: 50px;
            margin-bottom: 15px;
            cursor: pointer;
            text-align: center;
            -webkit-transition: all 0.4s;
            transition: all 0.4s;
        }

        /* la petite flèche */
        .search-type label:after {
            position: absolute;
            content: "";
            bottom: -25px;
            left: calc(50% - 4px);
            border-left: 9px solid transparent;
            border-right: 9px solid transparent;
            border-bottom: 10px solid #fff;
            opacity: 0;
        }

        .row {
            display: flex;
            flex-direction: row;
            padding: 50px;
            margin: auto;
        }

        .search_button {
            display: flex;
            flex-direction: row;
            margin: auto;
            margin-left: 70px;
        }

        .input_ville,
        .input_piece,
        .input_budget {
            flex: auto;
            padding: 20px;
            margin: 10px;
        }

        .search-input input {
            height: 50px;
            padding-left: 47px;
            color: #3a3a3a;
            font-style: italic;
            border: none;
            width: 100%;
            border-radius: 35px;
        }

        .search-input.si-v-2 input {
            width: calc(100% - 384px);
        }

        .search-input.si-v-2 .sb-light {
            margin-left: 25px;
            min-width: 203px;
        }

        .search_button button {
            color: white;
            background: #60C2CF;
            border: none;
            width: auto;
            border-radius: 35px;
            padding: 13px;
            margin-left: 15px;
        }

        .maison,
        .appartement,
        .plus {
            flex: initial;
        }

        .button_search button {
            color: white;
            background: #60C2CF;
            border: none;
            width: auto;
            border-radius: 35px;
            padding: 20px;
            margin-left: 30px;
        }
    </style>
    <script>
        function controle() {
            let saisie = document.getElementById("city").value;
            alert("vous avez saisi " + saisie);
        }
    </script>
</head>

<body>
    <div id="app">
        <nav class="navbar navbar-expand-md navbar-dark bg-primary shadow-sm">
            <div class="container">
                <a class="navbar-brand" href="{{ url('/') }}">
                    Stephie Place Real Estate
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="{{ __('Toggle navigation') }}">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- Left Side Of Navbar -->
                    <ul class="navbar-nav mr-auto">

                    </ul>

                    <!-- Right Side Of Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a class="nav-link" href="{{ url('/acheter') }}">Acheter</a></li>
                        <li class="nav-item"><a class="nav-link" href="{{ url('/louer') }}">Louer</a></li>
                        <li class="nav-item"><a class="nav-link" href="{{ url('/vendre') }}">Vendre</a></li>
                        <li class="nav-item"><a class="nav-link" href="{{ url('/conseil') }}">Conseil</a></li>
                        <li class="nav-item"><a class="nav-link" href="{{ url('/nosagences') }}">Nos agences</a></li>

                        <!-- Authentication Links -->
                        @guest
                        <li class="nav-item">
                            <a class="nav-link" href="{{ route('login') }}">{{ __('Se connecter') }}</a>
                        </li>
                        @if (Route::has('register'))
                        <li class="nav-item">
                            <a class="nav-link" href="{{ route('register') }}">{{ __('Inscription') }}</a>
                        </li>
                        @endif
                        @else
                        <li class="nav-item dropdown">
                            <a id="navbarDropdown" class="nav-link dropdown-toggle" href="{{ route('home') }}" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                                {{ Auth::user()->name }} <span class="caret"></span>
                            </a>

                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="{{ route('home') }}">
                                    Profil
                                </a>
                                <a class="dropdown-item" href="{{ route('logout') }}" onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                    {{ __('Deconnexion') }}
                                </a>

                                <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                                    @csrf
                                </form>
                            </div>
                        </li>
                        @endguest
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Hero Section end -->
        <section class="hero-section set-bg">
            <div class="container">
                <div class="hero-warp">
                    <form class="main-search-form">
                        <div class="search-type">
                            <div class="st-item">
                                <input type="radio" name="st" id="buy" checked>
                                <label for="buy">Acheter</label>
                            </div>
                            <div class="st-item">
                                <input type="radio" name="st" id="rent">
                                <label for="rent">Louer</label>
                            </div>
                            <div class="st-item">
                                <input type="radio" name="st" id="sell">
                                <label for="sell">Vendre</label>
                            </div>
                        </div>
                        <div class="search-input">
                            <div class="row">
                                <div class="input_ville">
                                    <input type="text" placeholder="Dans quelle ville ?" id="city" value="">
                                </div>
                                <div class="input_piece">
                                    <input type="text" placeholder="Nombre de piece " id="piece" value="">
                                </div>
                                <div class="input_budget">
                                    <input type="text" placeholder="Quel budget ?" id="prix" value="">
                                </div>
                            </div>
                        </div>

                        <div class="search_button">
                            <div class="maison">
                                <button class="btn-maison">Maison</button>
                            </div>
                            <div class="appartement">
                                <button class="btn-appart">Appartement</button>
                            </div>
                            <div class="plus">
                                <button class="btn-plus">X</button>
                            </div>
                        </div>
                        <div class="button_search">
                            <button class="site-btn" onclick="controle()">Rechercher</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>

<script>
     function controle() {
         let ville = document.getElementById("city").value;
         let piece = document.getElementById("piece").value;
         let prix = document.getElementById("prix").value;
         alert("La ville : "+ ville + " Budget: " + prix + "euro");
     }
</script>
</body>

</html>