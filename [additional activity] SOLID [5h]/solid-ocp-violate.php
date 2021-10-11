<?php

class ContractClt
{
    public function salary()
    {
        //...
    }
}

class Internship
{
    public function grantScholarship()
    {
        //...
    }
}

class Payroll
{
    protected $balance;
    
    public function calculate($employee)
    {
        if ( $employee instanceof ContractClt ) {
            $this->balance = $employee->salary();
        } else if ( $employee instanceof Internship) {
            $this->balance = $employee->grantScholarship();
        }
    }
}