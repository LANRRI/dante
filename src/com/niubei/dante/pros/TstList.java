package com.niubei.dante.pros;

import java.util.ArrayList;
import java.util.List;

public class TstList {
    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        System.out.println(a.retainAll(b));
        System.out.println(a);


    }
}
