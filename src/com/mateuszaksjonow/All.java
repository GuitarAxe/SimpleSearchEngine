package com.mateuszaksjonow;

import java.util.Map;
import java.util.Set;

public class All extends Strategy {

    @Override
    public boolean search(Map<String, Set<String>> map, String data) {
        if (map.containsKey(data.toLowerCase())) {
            System.out.println("Found people:");
            Set<String> print = map.get(data);
            for (String string : print) {
                System.out.println(string);
            }
        }else {
            System.out.println("No matching people found.");
            return false;
        }
        return true;
    }
}
