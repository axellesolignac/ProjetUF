@extends('layouts.app')

@section('content')
<style>
:root {
    
}
body {
    background-color: #FFFFFF;
}
.card {
    border-radius:0;
    margin:10px auto;
}
.card-title {
	text-transform: uppercase;
	color: #E44424;
}

.card-text {
	margin-top:10px;
	margin-bottom: 10px;
	background-color:#FFFFFF;
	color:#000000;
}
a.btn, a.btn:visited {
    color:#333333;
}
hr {
  margin-top: 1rem;
  margin-bottom: 1rem;
  border: 0;
  border-top: 1px solid rgba(0, 0, 0, 0.1);
}
</style>



<div class="container">

@foreach($ag as $agence)
    <div class="row">
    	<div class="card col-md-12 p-3">
    		<div class="row ">
    			<div class="col-md-4">
    				<img class="w-100" src="{{$agence->photo}}">
    			</div>
    			<div class="col-md-8">
    				<div class="card-block">
    					<h6 class="card-title">Agence {{$agence->city}}</h6>
    					<p class="card-text text-justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    					<a href="https://www.google.com" class="btn btn-primary">Voir cette agence</a>
    				</div>
    			</div>
    		</div>
    	</div>
@endforeach

@endsection