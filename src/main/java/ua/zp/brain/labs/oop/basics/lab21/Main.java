package ua.zp.brain.labs.oop.basics.lab21;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] s1 = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"};
        List<String> list1 = new ArrayList<>();
        fillList(s1, list1);

        List<String> list2 = new ArrayList<>(list1);
        List<String> list3 = Arrays.asList(s1);

        list2.addAll(list2.size() / 2, list3);

        System.out.println(list2);
        Collections.sort(list2, Comparator.reverseOrder());
        System.out.println(list2);

        ListIterator listIterator = list2.listIterator();

        int i = 1;
        while (listIterator.hasNext()) {
            listIterator.next();
            if (i % 2 == 0) {
                listIterator.remove();
            }
            i++;
        }
        System.out.println(list2);

        System.out.println("===============================================");

        Set<String> set1 = new HashSet<>();

        set1.add(new String("Произвольная строка 1"));
        set1.add("Произвольная строка 2");

        set1.addAll(list1);
        set1.addAll(list2);

        System.out.println(set1);

        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(list2);
        set2.addAll(list3);

        System.out.println(set2);

        System.out.println("===============================================");

        Map<Integer, String> map1 = new LinkedHashMap<>();
        for (Month m : Month.values()) {
            map1.put(map1.size(),
                    m.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("UK")));
        }
        System.out.println(map1.get(0));
        System.out.println(map1.get(11));

        map1.put(5, "ОТПУСК");

        System.out.println(map1.get(5));

        Map<Integer, String> map2 = new HashMap<>();
        map2.putAll(map1);

        System.out.println("map1 --------------------------------");
        printEntrySet(map1.entrySet());
        System.out.println("map2 --------------------------------");
        printEntrySet(map2.entrySet());

        System.out.println("===============================================");

        Map<String, Set<String>> students = new HashMap<>();
        students.put("Пупкин",
                new HashSet<String>(
                        Arrays.asList("23223234234", "post@net.net", "111832222")));
        System.out.println(students);

        System.out.println("===============================================");
        System.out.println("------------- without hashcode ----------------");
        Set userSet = new HashSet();

        User1 u11 = new User1("Вася", 12, "222333222");
        User1 u12 = new User1("Вася", 12, "222333222");
        User1 u13 = new User1("Вася", 13, "222333222");

        userSet.add(u11);
        userSet.add(u12);
        userSet.add(u13);

        userSet.forEach(System.out::println);

        System.out.println("--------------- name hashcode -----------------");

        userSet.clear();
        User2 u21 = new User2("Вася", 12, "222333222");
        User2 u22 = new User2("Вася", 12, "222333222");
        User2 u23 = new User2("Вася", 13, "222333222");

        userSet.add(u21);
        userSet.add(u22);
        userSet.add(u23);

        userSet.forEach(System.out::println);
        System.out.println("------------- name old phone hashcode ---------");

        userSet.clear();
        User3 u31 = new User3("Вася", 12, "222333222");
        User3 u32 = new User3("Вася", 12, "222333222");
        User3 u33 = new User3("Вася", 13, "222333222");

        userSet.add(u31);
        userSet.add(u32);
        userSet.add(u33);

        userSet.forEach(System.out::println);

    }

    public static void printEntrySet(Set<Map.Entry<Integer, String>> set) {
        set.forEach(System.out::println);
    }

    public static void fillList(String[] arr, List<String> list) {
        for (String s : arr) {
            list.add(s);
        }
    }
}
