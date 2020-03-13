package com.mateuszaksjonow;

import java.util.*;

public class None extends Strategy {

    @Override
    public boolean search(Map<String, Set<String>> map, String data) {

        Set<String> set = new HashSet<>();
        boolean isEmpty = true;
        String[] splittedData = data.toLowerCase().split(" ");
        for (String string1 : splittedData) {
            for (String string2 : map.keySet()) {
                if (!string1.equalsIgnoreCase(string2)) {
                    set.addAll(map.get(string2));
                    isEmpty = false;
                }
            }
        }
        if (!isEmpty) {
            System.out.println("Found people:");
            for (String string : set) {
                System.out.println(string);
            }
        }else {
            System.out.println("No matching people found.");
            return false;
        }
        return true;
    }
}
