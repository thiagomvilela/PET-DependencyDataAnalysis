<?php

class A 
{
    public function getNome()
    {
        echo 'My name is A';
    }
}

class B extends A 
{ 
    public function getNome()
    {
        echo 'My name is B';
    }
}

$objeto1 = new A;
$objeto2 = new B;

function imprimeNome(A $objeto)
{
    return $objeto->getNome();
}

imprimeNome($objeto1); // My name is A
imprimeNome($objeto2); // My name is B