package com.teachmeskills.lesson23.runner;

import java.util.Scanner;

import static com.teachmeskills.lesson23.parser.DomParser.parserDom;
import static com.teachmeskills.lesson23.parser.SaxParser.parserSax;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - SaxParser\n2 - DomParser");
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1: {
                    parserSax();
                    break;
                }
                case 2: {
                    parserDom();
                    break;
                }
                default:{
                    System.out.println("Значение введено не верно");
                    break;
                }
            }
        }else {
            System.out.println("Значение введены не верно, можно вводить только цифры");
        }
    }
}
