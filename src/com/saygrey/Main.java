package com.saygrey;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добавить полицию?");
        if (in.nextLine().equals("Да"))
            new Deal(true).startDeal();
        else
            new Deal(false).startDeal();
    }
}
