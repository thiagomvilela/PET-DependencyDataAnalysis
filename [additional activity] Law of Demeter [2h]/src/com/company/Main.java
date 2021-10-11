package com.company;

// Rule 01: Methods of the X object itself.
public class ClassX {

    public void method1() {
        method2();
    }

    public void method2() {
        method2();

    }
// The method invoking another method of the class itself.
}


// Rule 02: Objects that are Parameters of the M method itself.
Public class ClassX {
    public void method1(ClassTwo classTwo) {
        classTwo.method1();
    }
// As ClassTwo is method1 parameter, it can invoke ClassTwo methods.
}



// Rule 03: Objects created or instantiated by the M method itself.
public class ClassX {
    public void method1() {
        ClassTwo classTwo = new ClassTwo();
        classTwo.method1();
    }
}

public class ClassTwo {
    public void method1() {
    }
}
// Since ClassTwo was instantiated within method1, it can invoke ClassTwo's methods.



// Rule 04 - Objects that are attributes of X.
public class ClassX {

    private ClassTwo classTwo;

    public void method1() {
        classTwo = new ClassTwo() ();
        classTwo.method1();
    }
}

public class ClassTwo {

    public void method1() {
    }
}

// As ClassTwo is assigned, its methods can be invoked by ClassX methods.