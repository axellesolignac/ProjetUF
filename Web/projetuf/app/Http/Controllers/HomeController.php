<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use App\Bien;
use App\User;
use App\Client;

class HomeController extends Controller
{
    
    public function index()
    {
        return view('home');
    }
    
}
