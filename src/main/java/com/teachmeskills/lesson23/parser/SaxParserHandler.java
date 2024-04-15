package com.teachmeskills.lesson23.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaxParserHandler extends DefaultHandler {
    private String currentTagName;
    private String firstName;
    private String lastName;
    private String title;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        currentTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length){
        if (currentTagName != null) {
            switch (currentTagName) {
                case "firstName" -> {
                    firstName = new String(ch, start, length);
                }
                case "lastName" -> {
                    lastName = new String(ch, start, length);
                }
                case "title" -> {
                    title = new String(ch, start, length);
                }
                case "line" -> {
                    try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter("resource/" + firstName + "_" + lastName + "_" + title + "_Sax.txt", true))
                    ) {
                        writer.write(new String(ch, start, length) + "\n");
                    } catch (Exception e) {
                        System.out.println("Writing sax parsing error " + e);
                    }
                }
            }
        }
    }


}
