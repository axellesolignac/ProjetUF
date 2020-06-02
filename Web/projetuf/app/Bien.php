<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Bien extends Model
{
            /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = ['id','categorie', 'title', 'prix', 'address', 'city', 'description', 'superficie', 'surfaceTerrain', 'dependance', 'photo', 'nbPiece', 'nbEtage', 'nbChambre', 'owner', 'status'];

    public function users(){
      return $this->belongsToOne('App\User');
    }
}
