package com.example.bitsamericas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaSortListObject {
    public static void main(String[] args) {
        List<Data> dl = new ArrayList<>();
        dl.add(new Data(1));
        dl.add(new Data(9));
        dl.add(new Data(2));
        dl.add(new Data(3));
        dl.add(new Data(1));
        dl.add(new Data(5));
        dl.add(new Data(8));
        System.out.println("Original List::"+dl);
        List<Data> d2 = dl.stream().sorted(Comparator.comparing(Data::getId)).collect(Collectors.toList());
        System.out.println("Naturally Sorted List::"+d2);
    }

public static class Data {
    private int id;
    public Data(int i) {
        this.id = i;
    }
    public int getId() {
        return id;
    }
}
}