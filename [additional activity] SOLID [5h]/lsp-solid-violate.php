<?php

# Overwriting a method that does nothing
class Voluntario extends ContratodeTrabalho
{
    public function remuneration()
    {
        // does nothing
    }
}


# Throwing an unexpected exception
class MusicPlay
{
    public function play($file)
    {
        // play the music  
    }
}

class Mp3MusicPlay extends MusicPlay
{
    public function play($file)
    {
        if (pathinfo($file, PATHINFO_EXTENSION) !== 'mp3') {
            throw new Exception;
        }
        
        // play the music
    }
}


# Returning values of different types
class Auth
{
    public function checkCredentials($login, $password)
    {
        // Do something
        
        return true;
    }
}

class AuthApi extends Auth
{
    public function checkCredentials($login, $password)
    {
        // Do something
        
        return ['auth' => true, 'status' => 200];
    }
}