@extends('layouts.app')
@section('content')
<head>
  <style>

  </style>
</head>
<body>
<section class="bg-light">
  <div class="container">
    
    <div class="row">
      <header class="col-lg-12 my-4 text-center">
        <h1 class="text-muted">Liste des biens a louer</h1>
      </header>
    </div>
    <div class="row">
    @foreach($biens as $bien)
    
      <article class="col-lg-4">
        <div class="card border-0 rounded shadow">
          <img class="card-img-top img-fluid" src="{{ $bien->photo }}" alt="Image bien">
          <div class="card-body text-center p-4">
            <header>
              <h4 class="card-title">Lieu:{{ $bien->city }}</h4>
            </header>
            <p class="card-text"><strong>Type:</strong>{{ $bien->categorie }}<br/><strong>Prix:</strong>{{ $bien->prix }}&#128;</p>
            <a href="{{ route('details',['id'=>$bien->id]) }}" title="card link" class="btn btn-dark text-uppercase">Details</a>
          </div>
        </div>
      </article>
      @endforeach
     

</body>


@endsection

