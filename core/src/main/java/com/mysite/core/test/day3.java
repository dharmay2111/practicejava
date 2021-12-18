package com.mysite.core.test;

public class day3 {
    public static void main(String[] args){
       /* int a=10,b=15;
        System.out.println("before swap");
        System.out.println("Value of a="+ a);
        System.out.println("Value of b="+ b);

        a= a-b;
        b= a+b;
        a= b-a;

        System.out.println("After swap");
        System.out.println("Value of a="+ a);
        System.out.println("Value of b="+ b);

*/
        int a=10,b=5,temp;
        System.out.println("before swap");
        System.out.println("Value of a="+ a);
        System.out.println("Value of b="+ b);

        temp= a;
        a= b;
        b= temp;
        System.out.println("After swap");
        System.out.println("Value of a="+ a);
        System.out.println("Value of b="+ b);


    }
}
