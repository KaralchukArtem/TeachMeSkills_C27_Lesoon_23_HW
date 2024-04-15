package com.teachmeskills.lesson23.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {
    public static void parserSax() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error " + e);
        }

        File file = new File("resource/file.xml");
        try {
            assert parser != null;
            parser.parse(file, handler);
        } catch (Exception e) {
            System.out.println("Open sax parsing error " + e);
        }
    }
}
