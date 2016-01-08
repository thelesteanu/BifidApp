package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        PolybiusSquare polybiusSquare = new PolybiusSquare();
        BifidCoder bifidCoder = new BifidCoder(polybiusSquare);
        BifidDecoder bifidDecoder = new BifidDecoder(polybiusSquare);

        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String choice = "";
        String text = "";

        do {
            System.out.println("\n");
            System.out.println("Pentru codare apasati 1, pentru decodare 2: ");
            System.out.println("Scrieti 'stop' pentru a iesi din program.");
            try {
                choice = br.readLine();
                showDescription(choice);
                if (userCorrectValue(choice)) {
                    try {
                        text = br.readLine();
                        if (choice.equals("1")) {
                            String codedString = bifidCoder.getCodedString(text);
                            System.out.println(codedString);
                        } else if (choice.equals("2")) {
                            String decodedString = bifidDecoder.getDecodedString(text);
                            System.out.println(decodedString);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!choice.equals("stop"));

    }

    private static boolean userCorrectValue(String choice) {
        return (choice.equals("1") || choice.equals("2"));
    }

    private static void showDescription(String choice) {
        System.out.println("\n");
        if (choice.length() > 0 && choice.equals("1")) {
            System.out.println("Introduceti textul ce trebuie codat");
        } else if (choice.length() > 0 && choice.equals("2")) {
            System.out.println("Introduceti textul ce trebuie decodat");
        }
    }
}
