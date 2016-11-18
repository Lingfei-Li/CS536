

struct s1 {
    int sa;
    bool sb;
};



struct s2 {
    struct s1 next;
};


int ga;
bool gb;
struct s1 gs1;
struct s2 gs2;

void voidFunc() {
    return;
}

int intFunc() {
    return 1;
    return ga + gs2.next.sa * ((1/1)-1);
    return intFunc();
}

bool boolFunc() {
    return true;
    return false;
    return gb;
    return gs2.next.sb;
    return boolFunc();
}

void paramFunc(int a, bool b) {}


int testFunc(int a, bool a2) {
    bool b;
    struct s2 c;

    //Unary Minus Exp
    a = -a+(1+1-1*1/1);

    //Post Inc
    a ++;

    //Post Dec
    a --;

    //Write
    cout<<a;
    cout<<b;
    cout<<c.next.sa;
    cout<<"str";
    cout<<-a+(1+1-1*1/1);

    //Read
    cin>>a;
    cin>>b;
    cin>>c.next.sa;

    //Call Exp
    voidFunc();
    paramFunc(-a+(1+1-1*1/1), !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b));


    //Return stmt
    return -a+(1+1-1*1/1);

    //Binary Arithmetic Operations
    a = -a+(1+1-1*1/1)+c.next.sa;

    //logical expr (!, ||, &&) and relational expr (<, >, <=, >=)
    b = !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b)&&c.next.sb;

    //Assign Exp
    a = c.next.sa;
    b = c.next.sb;

    //Equals / Not-Equals
    b = (a == a+1) != (b != !b);
    b = (1 == 2) != (true != !false);
    b = "str" == "str";

    //while stmt
    while(b) {

    }

    //if stmt
    if(b) {}
    if(b) {} else {}
}


int testWhile(int a, int a2) {
    bool b;
    struct s2 c;
    while(true) {
        //Unary Minus Exp
        a = -a+(1+1-1*1/1);

        //Post Inc
        a ++;

        //Post Dec
        a --;

        //Write
        cout<<a;
        cout<<b;
        cout<<c.next.sa;
        cout<<"str";
        cout<<-a+(1+1-1*1/1);

        //Read
        cin>>a;
        cin>>b;
        cin>>c.next.sa;

        //Call Exp
        voidFunc();
        paramFunc(-a+(1+1-1*1/1), !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b));


        //Return stmt
        return -a+(1+1-1*1/1);

        //Binary Arithmetic Operations
        a = -a+(1+1-1*1/1)+c.next.sa;

        //logical expr (!, ||, &&) and relational expr (<, >, <=, >=)
        b = !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b)&&c.next.sb;

        //Assign Exp
        a = c.next.sa;
        b = c.next.sb;

        //Equals / Not-Equals
        b = (a == a+1) != (b != !b);

        //while stmt
        while(b) {

        }

        //if stmt
        if(b) {}
        if(b) {} else {}


    }

}


int testIf(int a, int a2) {
    bool b;
    struct s2 c;
    if(true) {
        //Unary Minus Exp
        a = -a+(1+1-1*1/1);

        //Post Inc
        a ++;

        //Post Dec
        a --;

        //Write
        cout<<a;
        cout<<b;
        cout<<c.next.sa;
        cout<<"str";
        cout<<-a+(1+1-1*1/1);

        //Read
        cin>>a;
        cin>>b;
        cin>>c.next.sa;

        //Call Exp
        voidFunc();
        paramFunc(-a+(1+1-1*1/1), !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b));


        //Return stmt
        return -a+(1+1-1*1/1);

        //Binary Arithmetic Operations
        a = -a+(1+1-1*1/1)+c.next.sa;

        //logical expr (!, ||, &&) and relational expr (<, >, <=, >=)
        b = !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b)&&c.next.sb;

        //Assign Exp
        a = c.next.sa;
        b = c.next.sb;

        //Equals / Not-Equals
        b = (a == a+1) != (b != !b);

        //while stmt
        while(b) {

        }

        //if stmt
        if(b) {}
        if(b) {} else {}


    }

}

int testIfElse(int a, int a2) {
    bool b;
    struct s2 c;
    if(true) {
        //Unary Minus Exp
        a = -a+(1+1-1*1/1);

        //Post Inc
        a ++;

        //Post Dec
        a --;

        //Write
        cout<<a;
        cout<<b;
        cout<<c.next.sa;
        cout<<"str";
        cout<<-a+(1+1-1*1/1);

        //Read
        cin>>a;
        cin>>b;
        cin>>c.next.sa;

        //Call Exp
        voidFunc();
        paramFunc(-a+(1+1-1*1/1), !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b));


        //Return stmt
        return -a+(1+1-1*1/1);

        //Binary Arithmetic Operations
        a = -a+(1+1-1*1/1)+c.next.sa;

        //logical expr (!, ||, &&) and relational expr (<, >, <=, >=)
        b = !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b)&&c.next.sb;

        //Assign Exp
        a = c.next.sa;
        b = c.next.sb;

        //Equals / Not-Equals
        b = (a == a+1) != (b != !b);

        //while stmt
        while(b) {

        }

        //if stmt
        if(b) {}
        if(b) {} else {}


    }
    else {
        //Unary Minus Exp
        a = -a+(1+1-1*1/1);

        //Post Inc
        a ++;

        //Post Dec
        a --;

        //Write
        cout<<a;
        cout<<b;
        cout<<c.next.sa;
        cout<<"str";
        cout<<-a+(1+1-1*1/1);

        //Read
        cin>>a;
        cin>>b;
        cin>>c.next.sa;

        //Call Exp
        voidFunc();
        paramFunc(-a+(1+1-1*1/1), !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b));


        //Return stmt
        return -a+(1+1-1*1/1);

        //Binary Arithmetic Operations
        a = -a+(1+1-1*1/1)+c.next.sa;

        //logical expr (!, ||, &&) and relational expr (<, >, <=, >=)
        b = !(a<a)&&(a>a)||(a<=a)&&(a>=a)||(a==a)&&(b==b)&&(a!=a)||(b!=b)&&c.next.sb;

        //Assign Exp
        a = c.next.sa;
        b = c.next.sb;

        //Equals / Not-Equals
        b = (a == a+1) != (b != !b);

        //while stmt
        while(b) {

        }

        //if stmt
        if(b) {}
        if(b) {} else {}

    }

}
