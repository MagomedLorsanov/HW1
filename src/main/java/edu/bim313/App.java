package edu.bim313;

import org.paukov.combinatorics3.Generator;


import java.util.*;





public class App
{

    public static void main( String[] args ){

        String[] cities = TurkishNetwork.cities;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 81; i++) map.put(cities[i],i + 1);

        Generator.combination(cities)
                .simple(3)
                .stream()
                .forEach((value) -> {

                            calc(map.get(value.get(0)),
                                    map.get(value.get(1)),
                                    map.get(value.get(2)));

                        }





                );


    }
    public static void calc(int a, int b, int c){

        int [][] distances = TurkishNetwork.distance;
        String[] cities = TurkishNetwork.cities;

        int disAB = distances[a - 1][b - 1];
        int disAC = distances[a - 1][c - 1];
        int disBC = distances[b - 1][c - 1];


        if((disAB >= (disAC + disBC))|
                (disAC >= (disAB + disBC))|
                (disBC >= (disAB + disAC))) {
            System.out.println(cities[a - 1] + " " + cities[b - 1] + " " + cities[c - 1]);
        }


    }

}
