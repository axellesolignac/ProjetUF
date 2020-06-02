<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use App\Agence;

class NosagencesController extends Controller
{

    public function index()
    {
        $ag = Agence::all();
        return view('nosagences',compact('ag'));
    }
    
}
