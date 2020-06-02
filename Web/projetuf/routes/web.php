<?php

use Illuminate\Support\Facades\Route;
use App\Bien;
use App\User;
use App\Agence;
use App\Client;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});


Route::get('/home/', 'HomeController@index')->name('home');
Route::get('/acheter', 'AcheterController@show')->name('acheter');
Route::get('/acheter/{id}/details', 'AcheterController@details')->name('details');
Route::get('/louer', 'LouerController@show')->name('louer');
Route::get('/vendre', 'VendreController@index')->name('vendre');
Route::get('/conseil', 'ConseilController@index')->name('conseil');
Route::get('/nosagences', 'NosagencesController@index')->name('nosagences');

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');
