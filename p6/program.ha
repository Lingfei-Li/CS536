

int g1;
int g2;

bool func() {
    return true;
}

int recursion(int x) {
    if(x == 0) {
        return 0;
    }
    else {
        return recursion(x-1)+x;
    }
}

//Test arithmetic in while loop
int whileFunc1(int a) {
    int cnt;
    cnt = 0;
    while(a > 0) {
        cnt = cnt + a;
        cnt = cnt - a;
        a++;
        a--;
        a--;
    }
    return cnt;
}

//Test return stmt in while loop
int whileFunc2(int a) {
    while(a > 0) {
        a = 1;
        return a;
    }
    return a;
}

//Test func call in while loop
int whileFunc3(int a) {
    while(a > 0) {
        return recursion(a);
    }
    return a;
}

int whileIfFunc(int a, int b) {
    while(a > 0) {
        while(b > 0) {
            if(a + b > 2) {
                return 1;
            }
            return 2;
        }
        return 3;
    }
    return 4;
}


bool boolFunc(bool a, bool b) {
    if(a && b) {
        return true;
    }
    else {
        return false;
    }
}


void main() {


    cout<<"recursion(0)\n";
    cout<<recursion(0);
    cout<<"\n";

    cout<<"recursion(1)\n";
    cout<<recursion(1);
    cout<<"\n";

    cout<<"recursion(5)\n";
    cout<<recursion(5);
    cout<<"\n";

    cout<<"whileFunc1(5)\n";
    cout<<whileFunc1(5);
    cout<<"\n";



}



