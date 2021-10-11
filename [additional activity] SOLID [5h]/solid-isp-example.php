<?php

use Birds as GlobalBirds;

interface Birds
{
    public function setLocalizacao($longitude, $latitude);
    public function renderizar();
}

interface BirdsThatFly extends Birds
{
    public function setAltitude($altitude);
}

class Parrot implements BirdsThatFly
{
    public function setLocalizacao($longitude, $latitude)
    {
        //Do something
    }
    
    public function setAltitude($altitude)
    {
        //Do something
    }
    
    public function renderizar()
    {
        //Do something
    }
}

class Penguin implements Birds
{
    public function setLocalizacao($longitude, $latitude)
    {
        //Do something
    }
    
    public function renderizar()
    {
        //Do something
    }
}