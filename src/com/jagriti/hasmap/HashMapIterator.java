/*
 * Copyright (c) 2020.
 * Ways to iterate over hashmap
 * KeySet, Iterator, EntrySet, streams, foreach
 * Using entrySet() in for-each loop :50
 * Using entrySet() and iterator : 50
 * Using keySet() in for-each loop : 76
 * Using keySet() and iterator : 75
 *
 * Best way to iterate over Map in Java, including any implementation e.g. HashMap,
 * TreeMap, LinkedHashMap, ConcurrentHashMap and Hashtable.
 * Java 1.5 foreach loop is most elegant and combined with entry set also gives best performance,
 * but not suitable for removing entries, as you don't have reference to internal Iterator.
 * Only way to remove entries from Map without throwing ConcurrentModificationException * is
 * to use Iterator and while loop.

Read more: https://www.java67.com/2013/08/best-way-to-iterate-over-each-entry-in.html#ixzz6XLkGyPrs
 */

package com.jagriti.hasmap;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapIterator {

    static HashMap<String,Integer> testMap = new HashMap<String,Integer>();

    static
    {
        for(int i=0; i< 100; i++)
        {
            testMap.put("key_" + i, i);
        }
    }

    public static void main(String args[]) {

        long startTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Startup : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        //First way using entrySet in for-each loop
        for (Map.Entry<String,Integer> entry : testMap.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        System.out.println("Using entrySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        //Second way using keySet() in for-each loop
        for (String key : testMap.keySet()) {
            testMap.get(key);
        }

        System.out.println("Using keySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        //Third way using Iterator on entrySet() in while loop
        Iterator<Map.Entry<String,Integer>> itr1 = testMap.entrySet().iterator();
        while(itr1.hasNext())
        {
            Map.Entry<String,Integer> entry = itr1.next();
            entry.getKey();
            entry.getValue();
        }

        System.out.println("Using entrySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        //Fourth way using Iterator on keySet() in while loop
        Iterator<String> itr2 = testMap.keySet().iterator();
        while(itr2.hasNext())
        {
            String key = itr2.next();
            testMap.get(key);
        }

        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        //Fifth way using Java8 streams
        testMap.entrySet().stream().forEach(e->System.out.println("key= "+e.getKey()+" Value=+ "+e.getValue()));

        //Sixth way using Java8 foreach
        testMap.forEach((key,value)->
                        System.out.println("key= "+key+" Value=+ "+value)
                );

        //System.out.println(testMap.values());
        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        testMap.entrySet().stream().map(i->i.getValue()*2).collect(Collectors.toList()).forEach(
                System.out::println
        );
        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        testMap.entrySet().parallelStream().map(i->i.getValue()*2).collect(Collectors.toList()).forEach(
                System.out::println
        );
        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));

    }

}
