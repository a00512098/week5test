package com.example.week5test;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private static ArrayList<String> subStrings = new ArrayList<>();
    private static StringBuilder builder = new StringBuilder();

    public static List<String> stringCombinations(String s, int position) {

        for (int i = position; i < s.length(); i++){
            builder.append(s.charAt(i));
            subStrings.add(builder.toString());
            stringCombinations(s, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }

        return subStrings;
    }

    public static void main(String[] args) {
        printList(stringCombinations("Frog", 0));
    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
