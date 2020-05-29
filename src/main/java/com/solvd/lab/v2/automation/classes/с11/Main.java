package com.solvd.lab.v2.automation.classes.с11;

import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.impl.file.StreamTextFileReader;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
//        // lists (how it works?)
//        List<String> arrList = new ArrayList<>(1000);
//        arrList.add("aaa");
//        arrList.add("bbb");
//        arrList.add("ccc");
//        System.out.println(arrList);
//        // Iterator vs. ListIterator
//        Iterator<String> iterator = arrList.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//        }
//
//        for (String listEntry : arrList) {
//            System.out.print(listEntry);
//        }
//
//        ListIterator<String> listIterator = arrList.listIterator();
//        listIterator.add("ddd");
//        listIterator.add("eee");
//        System.out.println(arrList);
//
//        List<String> linkedList = new LinkedList<>();
//        linkedList.add("aaa");
//        linkedList.add("bbb");
//        linkedList.add("ccc");
//        System.out.println(linkedList);
//        ListIterator<String> iterator1 = linkedList.listIterator(2); // lol
//        iterator1.add("ddd");
//        iterator1.add("eee");
//        System.out.println(linkedList);
//
//        // only object descents
//        List<Integer> a = new LinkedList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//        a.add(6);
//
//        List<Integer> b = new LinkedList<>();
//        b.add(2);
//        b.add(3);
//        b.add(4);
//        b.add(5);
//        b.add(6);
//
//        Map<Integer, Integer> m = new HashMap<>();
//        Iterator<Integer> ia = a.iterator();
//        while (ia.hasNext()) {
//            m.put(ia.next(), ia.next());
//        }
//
//        Iterator<Integer> ib = b.iterator();
//        while (ib.hasNext()) {
//            if (m.containsKey(ib.next())) {
//                System.out.println(ib.next());
//                break;
//            }
//        }
//
//        // hashCode
//        Set<String> offenses = new HashSet<>();
//        offenses.add("java");
//        offenses.add("string");
//        offenses.add("hashset");
//
//        String uname = "JaVa";
//
//        if (offenses.contains(uname.toLowerCase())) {
//            System.out.println("choose another");
//        }
//
//        Set<WeekDay> always = EnumSet.allOf(WeekDay.class);
//        Set<WeekDay> workDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
//
        Map<String, Collection<String>> listsToChoice = new HashMap<>();
        listsToChoice.put("Array", new ArrayList<>());
        listsToChoice.put("Linked", new LinkedList<>());
        listsToChoice.put("Stack", new ArrayDeque<>());

        Collection<String> c = listsToChoice.getOrDefault("Stack", null);




        String brokenCode = "class Main{ \n\t public static void main(String[] args {\n\t}";
        System.out.println(brokenCode);
//
        ArrayDeque<String> errors = new ArrayDeque<>();
//        stack.push("Peter") ;
//        stack.push("Paul") ;
//        stack.push("Mary") ;
//        while (! stack.isEmpty())
//            System.out.println(stack.pop());

        final List<Character> BRACES_BEGIN = Arrays.asList('{', '(', '[');
        final List<Character> BRACES_END = Arrays.asList(')', '}', ']');

        for (int i = 0; i < brokenCode.length(); i++) {
            if (BRACES_BEGIN.contains(brokenCode.charAt(i))) {
                errors.push(String.format("Error at %d", i));
            }
            if (BRACES_END.contains(brokenCode.charAt(i))) {
                errors.pop();
            }
        }

        if (!errors.isEmpty()) {
            System.out.println(errors);
        }

        aaa();


    }

    public static void aaa() {
        try {
            Set<String> offences = Arrays.stream(
                    new StreamTextFileReader("src/main/resources/words.txt")
                            .read()
                            .split("\n"))
                            .collect(Collectors.toSet());
            String word = "java";
            if (offences.contains(word)) {
                System.out.println("Offence was found");
            } else {
                System.out.println("No offence");
            }
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }
    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
        FRIDAY, SATURDAY, SUNDAY
    }

}
