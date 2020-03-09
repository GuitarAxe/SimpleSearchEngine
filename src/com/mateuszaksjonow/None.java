package com.mateuszaksjonow;

import java.util.*;

public class None {

    public boolean search(Set<String> set, String data) {

        Set<String> newSet = new HashSet<>();
        String[] splittedData = data.split(" ");

        for (String string : set) {
            boolean match = false;
            String[] splittedSet = string.split(" ");
            for (String string1 : splittedData) {
                for (String string2 : splittedSet) {
                    if (string1.equalsIgnoreCase(string2)) {
                        match = true;
                    }
                }
            }
            if (!match) {
                newSet.add(string);
            }
        }

        if (!newSet.isEmpty()) {
            System.out.println("Found people:");
            for (String string : newSet) {
                System.out.println(string);
            }
        }else {
            System.out.println("No matching people found.");
            return false;
        }
        return true;
    }
}
