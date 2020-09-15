/*
 * Copyright (c) 2020.  This class is used for
 */

package com.jagriti.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DropTakeWhile {

    public static  void main(String s[]) {
        // create a stream of names
        Stream<String> stream
                = Stream.of("aman", "amar", "suraj",
                "suvam", "Zahafuj");

        // apply dropWhile to drop all the names
        // matches passed predicate

        List<String> list
                = stream.dropWhile(name -> (name.charAt(0) == 'a'))
                .collect(Collectors.toList());

        // print list
        System.out.println(list);

        List<String> list2
                = stream.takeWhile(name -> (name.contains("ama")))
                .collect(Collectors.toList());

        // print list
        System.out.println(list2);
    }
}
