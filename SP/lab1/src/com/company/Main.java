package com.company;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;


public class Main {
    public static void main(String[] args) {

        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get("text.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = Arrays.asList(text.toLowerCase().replaceAll("[-.?!)(,:;'–\n]", "").split(" "));

        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            if (word.length() > 30) {
                System.out.println(word.substring(0, 30) + ": " + Collections.frequency(list, word));
            } else
                System.out.println(word + ": " + Collections.frequency(list, word));
        }
        }
    }

