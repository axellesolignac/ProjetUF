@extends('layouts.app')

@section('content')
<head>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    
<style>
    body {
        padding: 0;
        margin: 0;
    }
    
    .list-menu li {
        display: inline-block;
        margin-right: 12px;
        border-right: 1px solid black;
        padding-right: 12px;
    }
    
    .list-menu > a {
        text-decoration: none;
        color: black;
    }
    
    .profile {
        padding: 55px;
    }
    
    .file-upload {
        font-size: 11px;
    }
    
    .tab-content > p {
        font-size: 12px;
    }
    
    .form-group > label {
        margin-bottom: 0;
    }
    
    .btn-lg {
        padding: 10px;
        font-size: 12px;
    }

</style>
</head>
<body>

<div class="container bootstrap snippet">
    <div class="row">
  		<div class="col-sm-10"><h1>Mon compte</h1></div>
    </div>
    <div class="row">
  		<div class="col-sm-3 profile"><!--left col-->
            <br />
      <div class="text-center">
        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
        <p>Enregistrer de nouvelles photos</p>
        <input type="file" class="text-center center-block file-upload">
      </div><hr/><br>

               
          <div class="card">
            <div class="card-header">Site internet<i class="fa fa-link fa-1x"></i></div>
            <div class="card-body"><a href="ynov.com">ynov.com</a></div>
          </div>
          
        </div><!--/col-3-->
    	<div class="col-sm-9">
            <ul class="list-menu">
                <li class="active"><a data-toggle="tab" href="#home" style="color: black;">Mes preferences de compte </a></li>
                <li><a data-toggle="tab" href="#annonce" style="color: black;">Mes annonces </a></li>
                <li><a data-toggle="tab" href="#notifications" style="color: black;">Mes notifications</a></li>
            </ul>

              
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                  <form class="form" action="##" method="post" id="registrationForm">
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name"><p>Prenom</p></label>
                              <input type="text" class="form-control" name="first_name" id="first_name" placeholder="Votre prenom">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><p>Nom</p></label>
                              <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Votre nom">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><p>Numero de telephone</p></label>
                              <input type="text" class="form-control" name="phone" id="phone" placeholder="Votre numero de telephone">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="address"><p>Adresse</p></label>
                              <input type="text" class="form-control" name="adresse" id="address" placeholder="Votre adresse">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="city"><p>Ville</p></label>
                              <input type="text" class="form-control" name="ville" id="city" placeholder="Votre ville">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><p>Email</p></label>
                              <input type="email" class="form-control" id="email" placeholder="Votre email">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="password"><p>Mot de passe</p></label>
                              <input type="password" class="form-control" name="password" id="password" placeholder="Votre mot de passe">
                          </div>
                      </div>
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-primary" href="#">Sauvegarder</button>
                               	<button class="btn btn-lg" type="reset">Annuler</button>
                            </div>
                      </div>
              	</form>
              
              <hr>
              
             </div><!--/tab-pane-->
             <div class="tab-pane" id="annonce">
               
               <hr>
                  <form class="form" action="##" method="post" id="registrationForm">
                      <br />
                         <div class="card" style="width: 18rem;">
                              <img src="https://www.depreux-construction.com/wp-content/uploads/2018/11/depreux-construction.jpg" class="card-img-top" alt="maison espacia">
                              <div class="card-body">
                                <h5 class="card-title">Maison espacia</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <a href="#" class="btn btn-info">Voir en details</a>
                              </div>
                        </div>
              	</form>
               
                 
             </div><!--/tab-pane-->
             <div class="tab-pane" id="notifications">
<div class="alert alert-warning alert-dismissible fade show" role="alert">
                            Vous avez recu un commentaire sur votre annonce Maison espacia !
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
</div>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
                            Vous avez recu un message sur votre annonce Maison espacia !
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
</div><div class="alert alert-warning alert-dismissible fade show" role="alert">
                            Vous avez recu un commentaire sur votre annonce Maison espacia !
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
</div>
                    <div class="form-group">
                          
                      </div>
              	</form>
              </div>
              </div><!--/tab-pane-->
          </div><!--/tab-content-->

        </div><!--/col-9-->
</div><!--/row-->
</body>
@endsection
