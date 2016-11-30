

struct s1 {
    int sa;
    bool sb;
};

struct s2 {
    struct s1 next;
};


void voidFunc() { 
    //Return stmt node
    return 1;
}

int func(int a, bool a2) {
    bool b;
    struct s2 c;


    //Unary Minus Exp
    a = -true;
    a = -false;
    a = -"string";
    b = -b;     //arithmetic op applied to non-numeric
    a = -c;
    a = -c.next;

    //Post Inc
    b ++;
    c ++;
    func ++;
    s1 ++;

    //Post Dec
    b --;
    c --;
    func --;
    s1 --;

    //Write
    cout<<func;
    cout<<s1;
    cout<<c;
    cout<<voidFunc();

    //Read
    cin>>func;
    cin>>s1;
    cin>>c;

    //Call Exp
    a();
    func(1, 2, 3);
    func(1, 2);


    //Return stmt
    return;
    return true;
    return -(!(!false+1));

    //Plus Node
    b = 1 + true;
    b = true + 1;
    b = true + false;
    b = b + c;
    b = func + s1;
    //other arithmetic binary expr
    b = func - s1;
    b = func * s1;
    b = func / s1;

    //logical expr (!, ||, &&)
    a = !123;
    a = !"string";
    a = !a;     //logical applied to non-bool
    b = !c;
    b = !c.next;
    b = !c.next.sa;
    b = func || s1;
    b = 1 || a;
    b = true || a;
    b = func && s1;
    b = 1 && a;
    b = true && a;

    //relational expr (<, >, <=, >=)
    b = true < 1;
    b = a > b;
    b = false <= s1;
    b = b >= func;

    //Assign Exp
    a = true;
    a = "string";
    a = b;
    a = c;
    a = b = c;
    func = func;
    s1 = s1;
    c = c;

    //Equals / Not-Equals
    a = a == b;
    a = 1 == true;
    a = func == s1;
    a = func == func;
    a = s1 == s1;
    a = c == c;
    a = voidFunc() == voidFunc();
    a = a != b;
    a = 1 != true;
    a = func != s1;
    a = func != func;
    a = s1 != s1;
    a = c != c;
    a = voidFunc() != voidFunc();

    //while stmt
    while(1+true) {
        a = false;  //should still be processed
    }

    //if stmt
    if(1) { a = false; }
    if(1+true) { a = false; }
    if(a) { }
    if(c.next.sa) { }
    if(a = 1) { }
    if("str" == "str") { }
    if(func(1,true)) { }
    if(voidFunc()) { }
    if(1+true) { } else { }

}


int testWhile(int a, bool a2) {
    while(true) {

        bool b;
        struct s2 c;


        //Unary Minus Exp
        a = -true;
        a = -false;
        a = -"string";
        b = -b;     //arithmetic op applied to non-numeric
        a = -c;
        a = -c.next;

        //Post Inc
        b ++;
        c ++;
        func ++;
        s1 ++;

        //Post Dec
        b --;
        c --;
        func --;
        s1 --;

        //Write
        cout<<func;
        cout<<s1;
        cout<<c;
        cout<<voidFunc();

        //Read
        cin>>func;
        cin>>s1;
        cin>>c;

        //Call Exp
        a();
        func(1, 2, 3);
        func(1, 2);


        //Return stmt
        return;
        return true;
        return -(!(!false+1));

        //Plus Node
        b = 1 + true;
        b = true + 1;
        b = true + false;
        b = b + c;
        b = func + s1;
        //other arithmetic binary expr
        b = func - s1;
        b = func * s1;
        b = func / s1;

        //logical expr (!, ||, &&)
        a = !123;
        a = !"string";
        a = !a;     //logical applied to non-bool
        b = !c;
        b = !c.next;
        b = !c.next.sa;
        b = func || s1;
        b = 1 || a;
        b = true || a;
        b = func && s1;
        b = 1 && a;
        b = true && a;

        //relational expr (<, >, <=, >=)
        b = true < 1;
        b = a > b;
        b = false <= s1;
        b = b >= func;

        //Assign Exp
        a = true;
        a = "string";
        a = b;
        a = c;
        a = b = c;
        func = func;
        s1 = s1;
        c = c;

        //Equals / Not-Equals
        a = a == b;
        a = 1 == true;
        a = func == s1;
        a = func == func;
        a = s1 == s1;
        a = c == c;
        a = voidFunc() == voidFunc();
        a = a != b;
        a = 1 != true;
        a = func != s1;
        a = func != func;
        a = s1 != s1;
        a = c != c;
        a = voidFunc() != voidFunc();

        //while stmt
        while(1) {
            a = false;  //should still be processed
        }

        //if stmt
        if(1) { a = false; }
        if(a) { }
        if(c.next.sa) { }
        if(a = 1) { }
        if("str" == "str") { }
        if(func(1,true)) { }
        if(voidFunc()) { }
        if(1) { } else { }

    }
}

int testIf(int a, bool a2) {
    if(true) {
        bool b;
        struct s2 c;


        //Unary Minus Exp
        a = -true;
        a = -false;
        a = -"string";
        b = -b;     //arithmetic op applied to non-numeric
        a = -c;
        a = -c.next;

        //Post Inc
        b ++;
        c ++;
        func ++;
        s1 ++;

        //Post Dec
        b --;
        c --;
        func --;
        s1 --;

        //Write
        cout<<func;
        cout<<s1;
        cout<<c;
        cout<<voidFunc();

        //Read
        cin>>func;
        cin>>s1;
        cin>>c;

        //Call Exp
        a();
        func(1, 2, 3);
        func(1, 2);


        //Return stmt
        return;
        return true;
        return -(!(!false+1));

        //Plus Node
        b = 1 + true;
        b = true + 1;
        b = true + false;
        b = b + c;
        b = func + s1;
        //other arithmetic binary expr
        b = func - s1;
        b = func * s1;
        b = func / s1;

        //logical expr (!, ||, &&)
        a = !123;
        a = !"string";
        a = !a;     //logical applied to non-bool
        b = !c;
        b = !c.next;
        b = !c.next.sa;
        b = func || s1;
        b = 1 || a;
        b = true || a;
        b = func && s1;
        b = 1 && a;
        b = true && a;

        //relational expr (<, >, <=, >=)
        b = true < 1;
        b = a > b;
        b = false <= s1;
        b = b >= func;

        //Assign Exp
        a = true;
        a = "string";
        a = b;
        a = c;
        a = b = c;
        func = func;
        s1 = s1;
        c = c;

        //Equals / Not-Equals
        a = a == b;
        a = 1 == true;
        a = func == s1;
        a = func == func;
        a = s1 == s1;
        a = c == c;
        a = voidFunc() == voidFunc();
        a = a != b;
        a = 1 != true;
        a = func != s1;
        a = func != func;
        a = s1 != s1;
        a = c != c;
        a = voidFunc() != voidFunc();

        //while stmt
        while(1) {
            a = false;  //should still be processed
        }

        //if stmt
        if(1) { a = false; }
        if(a) { }
        if(c.next.sa) { }
        if(a = 1) { }
        if("str" == "str") { }
        if(func(1,true)) { }
        if(voidFunc()) { }
        if(1) { } else { }

    }
}

int testIfElse(int a, bool a2) {
    if(true) {
        bool b;
        struct s2 c;


        //Unary Minus Exp
        a = -true;
        a = -false;
        a = -"string";
        b = -b;     //arithmetic op applied to non-numeric
        a = -c;
        a = -c.next;

        //Post Inc
        b ++;
        c ++;
        func ++;
        s1 ++;

        //Post Dec
        b --;
        c --;
        func --;
        s1 --;

        //Write
        cout<<func;
        cout<<s1;
        cout<<c;
        cout<<voidFunc();

        //Read
        cin>>func;
        cin>>s1;
        cin>>c;

        //Call Exp
        a();
        func(1, 2, 3);
        func(1, 2);


        //Return stmt
        return;
        return true;
        return -(!(!false+1));

        //Plus Node
        b = 1 + true;
        b = true + 1;
        b = true + false;
        b = b + c;
        b = func + s1;
        //other arithmetic binary expr
        b = func - s1;
        b = func * s1;
        b = func / s1;

        //logical expr (!, ||, &&)
        a = !123;
        a = !"string";
        a = !a;     //logical applied to non-bool
        b = !c;
        b = !c.next;
        b = !c.next.sa;
        b = func || s1;
        b = 1 || a;
        b = true || a;
        b = func && s1;
        b = 1 && a;
        b = true && a;

        //relational expr (<, >, <=, >=)
        b = true < 1;
        b = a > b;
        b = false <= s1;
        b = b >= func;

        //Assign Exp
        a = true;
        a = "string";
        a = b;
        a = c;
        a = b = c;
        func = func;
        s1 = s1;
        c = c;

        //Equals / Not-Equals
        a = a == b;
        a = 1 == true;
        a = func == s1;
        a = func == func;
        a = s1 == s1;
        a = c == c;
        a = voidFunc() == voidFunc();
        a = a != b;
        a = 1 != true;
        a = func != s1;
        a = func != func;
        a = s1 != s1;
        a = c != c;
        a = voidFunc() != voidFunc();

        //while stmt
        while(1) {
            a = false;  //should still be processed
        }

        //if stmt
        if(1) { a = false; }
        if(a) { }
        if(c.next.sa) { }
        if(a = 1) { }
        if("str" == "str") { }
        if(func(1,true)) { }
        if(voidFunc()) { }
        if(1) { } else { }

    }
    else {
        bool b;
        struct s2 c;


        //Unary Minus Exp
        a = -true;
        a = -false;
        a = -"string";
        b = -b;     //arithmetic op applied to non-numeric
        a = -c;
        a = -c.next;

        //Post Inc
        b ++;
        c ++;
        func ++;
        s1 ++;

        //Post Dec
        b --;
        c --;
        func --;
        s1 --;

        //Write
        cout<<func;
        cout<<s1;
        cout<<c;
        cout<<voidFunc();

        //Read
        cin>>func;
        cin>>s1;
        cin>>c;

        //Call Exp
        a();
        func(1, 2, 3);
        func(1, 2);


        //Return stmt
        return;
        return true;
        return -(!(!false+1));

        //Plus Node
        b = 1 + true;
        b = true + 1;
        b = true + false;
        b = b + c;
        b = func + s1;
        //other arithmetic binary expr
        b = func - s1;
        b = func * s1;
        b = func / s1;

        //logical expr (!, ||, &&)
        a = !123;
        a = !"string";
        a = !a;     //logical applied to non-bool
        b = !c;
        b = !c.next;
        b = !c.next.sa;
        b = func || s1;
        b = 1 || a;
        b = true || a;
        b = func && s1;
        b = 1 && a;
        b = true && a;

        //relational expr (<, >, <=, >=)
        b = true < 1;
        b = a > b;
        b = false <= s1;
        b = b >= func;

        //Assign Exp
        a = true;
        a = "string";
        a = b;
        a = c;
        a = b = c;
        func = func;
        s1 = s1;
        c = c;

        //Equals / Not-Equals
        a = a == b;
        a = 1 == true;
        a = func == s1;
        a = func == func;
        a = s1 == s1;
        a = c == c;
        a = voidFunc() == voidFunc();
        a = a != b;
        a = 1 != true;
        a = func != s1;
        a = func != func;
        a = s1 != s1;
        a = c != c;
        a = voidFunc() != voidFunc();

        //while stmt
        while(1) {
            a = false;  //should still be processed
        }

        //if stmt
        if(1) { a = false; }
        if(a) { }
        if(c.next.sa) { }
        if(a = 1) { }
        if("str" == "str") { }
        if(func(1,true)) { }
        if(voidFunc()) { }
        if(1) { } else { }

    }
}

