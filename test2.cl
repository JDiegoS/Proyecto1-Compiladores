class Main {
    a : Int <- 1 * "Hola";
    b : Int <- 1 + 5;
    c : Int <- 3 - true; 

    main() : SELF_TYPE {
        {
            a <- "errrooooooor" + 1;
            self;
        }
    } ;

};