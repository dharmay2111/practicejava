package com.mysite.core.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String args[]){
        /* System.out.println("hello1");

        List list = new ArrayList();
        list.add("list1");
        list.add("list2");

        System.out.print(list); */

        //Day-1
      /*  Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to first day");
        System.out.println("Enter your First name please");
        String  First_Name = scanner.nextLine();
        System.out.println("Enter your Last name please");
        String Last_Name = scanner.nextLine();
        System.out.println("Enter your age");
        int Age= scanner.nextInt();
        System.out.println("Hi "+First_Name+" "+Last_Name+" "+Age); */

        //POJO Class IMPL
        Day2 day2 = new Day2();
        day2.setFirstname("Dharma");
        System.out.println("Your first name is "+ day2.getFirstname());

    }
}
