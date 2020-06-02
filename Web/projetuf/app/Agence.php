<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Agence extends Model
{
            /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = ['id','number', 'city', 'nbAgent', 'photo'];

    public function users(){
      return $this->belongsToOne('App\User');
    }
}
