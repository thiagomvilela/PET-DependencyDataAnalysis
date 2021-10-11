<?php

interface Remunerable
{
    public function remunerable();
}

class ContractClt implements Remunerable
{
    public function remunerable()
    {
        //...
    }
}

class Internship implements Remunerable
{
    public function remunerable()
    {
        //...
    }
}

class Payroll
{
    protected $balance;
    
    public function calculate(Remunerable $employee)
    {
        $this->balance = $employee->remunerable();
    }
}