package com.mateuszaksjonow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File("src/data.txt");
        Set<String> listOfPeople = new HashSet<>();
        Set<String> set;
        Map<String, Set<String>> map = new HashMap<>();

        //Reading list from a file, creating a map
        try (Scanner fileScanner = new Scanner(file);) {
            while (fileScanner.hasNext()) {
                String person = fileScanner.nextLine();
                listOfPeople.add(person);
                String[] strings = person.toLowerCase().split(" ");
                for (String string : strings) {
                    if (map.containsKey(string)) {
                        map.get(string).add(person);
                    }else {
                        set = new HashSet<>();
                        set.add(person);
                        map.put(string, set);
                    }
                }

            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            switch (scanner.nextLine()) {
                case "1":
                    searchStrategy(scanner, map, scanner);
                    break;
                case "2":
                    System.out.println("=== List of people ===");
                    for (String person : listOfPeople) {
                        System.out.println(person);
                    }
                    break;
                case "0":
                    System.out.println("Bye!");
                    exit = true;
                    break;
            }
        }
    }

    public static void searchStrategy(Scanner scanner1, Map<String, Set<String>> map, Scanner scanner2) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE:");
        String string = scanner1.nextLine();
        String data;
        switch (string) {
            case "ANY":
                System.out.println("Enter name or email:");
                data = scanner2.nextLine();
                Strategy strategyAny = new Any();
                strategyAny.search(map, data);
                break;
            case "ALL":
                System.out.println("Enter name or email:");
                data = scanner2.nextLine();
                Strategy strategyAll = new All();
                strategyAll.search(map, data);
                break;
            case "NONE":
                System.out.println("Enter name or email:");
                data = scanner2.nextLine();
                None strategyNone = new None();
                strategyNone.search(map, data);
                break;
        }
    }
}
