package com.teachmeskills.lesson23.runner;

import static com.teachmeskills.lesson23.parser.DomParser.parserDom;
import static com.teachmeskills.lesson23.parser.SaxParser.parserSax;

public class Runner {
    public static void main(String[] args){
        parserDom();
        parserSax();
    }
}
