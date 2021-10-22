package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,10,-78,678);
        findMinMax(stream,Integer::compareTo, (a,b) -> System.out.println(a+" "+b) );
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        list.sort(order);
        if(list.isEmpty())
            minMaxConsumer.accept(null, null);
        else
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }
}
