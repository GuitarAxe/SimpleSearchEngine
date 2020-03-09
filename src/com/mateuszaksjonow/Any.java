package com.mateuszaksjonow;

import java.util.Map;
import java.util.Set;

public class Any extends Strategy {

    @Override
    public boolean search(Map<String, Set<String>> map, String data) {
        String[] splittedData = data.toLowerCase().split(" ");
        for (String string : splittedData) {
            if (map.containsKey(string.toLowerCase())) {
                Set<String> print = map.get(string);
                for (String string2 : print) {
                    System.out.println(string2);
                }
            }else {
                System.out.println("No matching people found.");
                return false;
            }
        }

        return true;
    }

}
