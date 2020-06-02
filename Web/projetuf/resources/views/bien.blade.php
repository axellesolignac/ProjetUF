@extends('layouts.app')
@section('content')

<section class="container">
  <article class="jumbotron">
    <div class="row">
      <div class="col-12">
        <h1 class="text-center">{{$biens->title}}</h1>
    <section class="thumbnail col-12">
      <img  class="text-center col-12" src="/../{{ $biens->photo }}" alt="Image bien">
    </section>
  
    <ul>
       <li><strong>Lieu:</strong> {{ $biens->city }}</li>
       <li><strong>Statut:</strong> {{ $biens->status }}</li>
       <li><strong>Prix:</strong> {{ $biens->prix }}&#128;</li>
       <li><strong>Cat&#233;gorie du bien:</strong> {{ $biens->categorie }}</li>
       <li><strong>Superficie:</strong> {{ $biens->superficie }}m&#178;</li>
       <li><strong>Nombre d'&#233;tage:</strong> {{ $biens->nbEtage }}</li>
       <li><strong>Nombre de pi&#232;ce:</strong> {{ $biens->nbPiece }}</li>
       <li><strong>Nombre de chambre:</strong> {{ $biens->nbChambre }}</li>
       <li><strong>Propri&#233;taire:</strong> {{ $biens->owner }}</li>
    </ul>
       
          </div> <!-- col-xs-12 -->
      </div> <!-- row -->
  </article> <!-- Bootstrap Jumbotron -->
</section>

    <div class="pull-right">
        <a class="btn btn-primary" href="{{ url('/acheter') }}">Retour</a>
    </div>
@endsection