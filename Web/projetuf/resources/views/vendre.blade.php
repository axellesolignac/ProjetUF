@extends('layouts.app')

@section('content')
  <section id="info--1">
    <div class="container">
      <div class="row mt-5 align-items-center">
        <div class="col d-none d-md-block align-self-end">
          <img src="https://res.cloudinary.com/axelle/image/upload/v1591024697/samples/telephone_lvmgcb.png"/>
        </div>
        <div class="col">
          <h6 class="text-uppercase text-black-40">
          Plus d'informations
        </h6>
        <h2>Vous voulez connaitre la valeur de votre bien ?</h2>
        <p>Nous pouvons envoyer des experts qui se deplaceront pour estimer votre bien.</p>
 <div class="row">
   
 </div>
        </div>
      </div>
    </div>   
  </section>
<!--bg-dark= dark background-->
  <section id="info--2" class="bg-dark">
    <div class="container">
      <div class="row align-items-center fill-80-viewport">
        
        <div class="col-12 col-md-6 my-5 order-2 order-md-1">
          <p class="text-uppercase text-white-40"><strong>Choix agence</strong></p>
       <h2 class="text-white">Choisir son agence en fonction de votre emplacement</h2>
       <p class="lead text-white-70">Pour votre confort nous vous presentons toutes les agences disponibles. Choisissez en une proche du bien a estimer et nous vous mettront en contact avec un des agents de l'agence selectionnee.</p>
       <a class="btn btn-light d-block d-md-inline-block py-3" href="{{ url('/nosagences') }}" role="button">Nos agences</a>
     </div>
   </div>
 </div>
</section>
@endsection