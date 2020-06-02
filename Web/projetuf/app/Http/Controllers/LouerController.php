<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use App\Bien;

class LouerController extends Controller
{

    public function index()
    {
        return view('louer');
    }
    
    public function show()
    {
        
        $biens = Bien::where('status','A loue')->get();
        return view('louer',compact('biens'));
    }
}
