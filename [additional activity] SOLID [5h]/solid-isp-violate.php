<?php

interface Birds
{
    public function setLocalizacao($longitude, $latitude);
    public function setAltitude($altitude);
    public function renderizar();
}

class Parrot implements Birds
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
    
    // Interface Aves is forcing the Penguin Class to implement this method.
    // This violates the ISP principle.
    public function setAltitude($altitude)
    {
        //It doesn't do anything... Penguins are birds that don't fly!
    }
    
    public function renderizar()
    {
        //Do something
    }
}