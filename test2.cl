;
CLASS ll Main oo{
    a : Int <- 1 * 5;
    b : Bool <- false;
    c : String <- "Hola"; 
    c : Int <- "Hola"; 

    main() : SELF_TYPE {
        {
            a <- 1+2;
            b<- b+c;
            a <- b<=c; 
            a <- ~a;
            not b;
        }
    } ;

    add(num: Int, num2: Int) : SELF_TYPE {
        {
            d <- ~a;
            not b;
        }
    } ;

};

CLASS Main {
    a : Int <- 1 * 5;
    b : Bool <- false;
    c : String <- "Hola"; 
    c : Bool;

    main() : SELF_TYPE {
        {
            a <- ~a;
            not b;
            add(1,2);
        }
    } ;


};