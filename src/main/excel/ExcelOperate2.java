package main.java.excel;


import java.util.ArrayList;
import java.util.Iterator;

public class ExcelOperate2 {
    public static void main(String[] args) {
        a(10000);
        a(1000000);
        a(10000000);
    }

    private static void a(int size) {
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(1);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            data.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(java.lang.String.format("%s fori花费: %s", size, (end - start)));

        start = System.currentTimeMillis();
        for (Integer integer : data) {

        }
        end = System.currentTimeMillis();
        System.out.println(java.lang.String.format("%s foreach花费: %s", size, (end - start)));

        Iterator<Integer> iterator = data.iterator();
        start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println(java.lang.String.format("%s iterator花费: %s", size, (end - start)));
    }
}