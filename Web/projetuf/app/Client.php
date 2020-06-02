<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Client extends Model
{
    protected $fillable = ['id','username','password','lastname','firstname','gender','birthdate','phone','email','address','city','nationality','id_agent',];

    public function users(){
      return $this->belongsToOne('App\User');
    }
}

