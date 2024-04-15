package com.teachmeskills.lesson23.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DomParser {
    public static void parserDom() {

        String domParserTitle = "resource/";//TODO constants

        Document doc = null;
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.getMessage());
        }

        Node rootNode = doc.getFirstChild();
        Node authorNode = null;
        Node linesNode = null;

        NodeList linesChildren = null;
        NodeList rootChildren = rootNode.getChildNodes();

        for (int i = 0; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (rootChildren.item(i).getNodeName()) {
                case "author": {
                    authorNode = rootChildren.item(i);
                    domParserTitle += searchFileName(authorNode.getChildNodes());
                    break;
                }
                case "title": {
                    domParserTitle += "_" + rootChildren.item(i).getTextContent() + "_Dom.txt";
                    break;
                }
                case "lines": {
                    linesNode = rootChildren.item(i);
                    linesChildren = linesNode.getChildNodes();
                    break;
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(domParserTitle, true))) {
            for (int i = 0; i < linesChildren.getLength(); i++) {
                if (linesChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                writer.write(linesChildren.item(i).getTextContent() + "\n");
            }
        } catch (IOException e) {
        }

    }

    private static String searchFileName(NodeList authorChildren) {
        String firstName = "";
        String lastName = "";
        for (int i = 0; i < authorChildren.getLength(); i++) {
            if (authorChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (authorChildren.item(i).getNodeName().equals("firstName")) {
                firstName += authorChildren.item(i).getTextContent();
            }
            if (authorChildren.item(i).getNodeName().equals("lastName")) {
                lastName += authorChildren.item(i).getTextContent();
            }
        }
        return firstName + "_" + lastName;
    }

    private static Document buildDocument() throws Exception {
        File file = new File("resource/file.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.parse(new File("resource/file.xml"));
        return document;
    }
}
