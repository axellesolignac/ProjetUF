<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use App\Bien;

class AcheterController extends Controller
{
    public function index()
    {
  
        return view('acheter');
    }
    
    public function show()
    {
        
        $biens = Bien::where('status','En vente')->get();
        return view('acheter',compact('biens'));
    }
    
    public function details($id)
    {
        
        $biens = Bien::where('id',$id)->first();
        return view('bien',compact('biens'));
    }
}
