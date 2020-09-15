/*
 * Copyright (c) 2020.  This class is used for
 */

package com.jagriti.streams;

import java.util.*;
import java.util.stream.Collectors;

// flatMap() is the combination of a map and a flat operation i.e, it first applies map function and than flattens
// the result.
// This [ ["G", "E", "E"], ["K", "S", "F"], ["O", "R", "G"], ["E", "E", "K", "S"] ]
// to ["G", "E", "E", "K", "S", "F", "O", "R", "G", "E", "E", "K", "S"]
public class FlatMap {

    // Java code for Stream flatMap(Function mapper)

    public static void main(String[] args)
        {
            // Creating a list of Prime Numbers
            List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

            // Creating a list of Odd Numbers
            List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

            // Creating a list of Even Numbers
            List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

            List<List<Integer>> listOfListofInts =
                    Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

            System.out.println("The Structure before flattening is : " +
                    listOfListofInts);

            // Using flatMap for transformating and flattening.
            List<Integer> listofInts = listOfListofInts.stream()
                    .flatMap(list -> list.stream()).sorted()
                    .collect(Collectors.toList());

            System.out.println("The Structure after flattening is : " +
                    listofInts);
        }
    }


