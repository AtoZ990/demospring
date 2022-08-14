package com.example.protest;


import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class testProgram {
    @Autowired
    private UserRepo userRepo;

    @Test
    @Sql("/data-test.sql")
   // @Sql(scripts ="classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testProgramRun() {

        System.out.println("dkhjskjf");

    }

    @Test
    public void sampleTests() {
//        assertArrayEquals(new int[] {2}, arrayDiff(new int [] {1,2}, new int[] {1}));
//        assertArrayEquals(new int[] {2,2}, arrayDiff(new int [] {1,2,2}, new int[] {1}));
//        assertArrayEquals(new int[] {1},arrayDiff(new int [] {1,2,2}, new int[] {2}));
//        assertArrayEquals(new int[] {1,2,2}, arrayDiff(new int [] {1,2,2}, new int[] {}));
//        assertArrayEquals(new int[] {}, arrayDiff(new int [] {}, new int[] {1,2}));

        assertEquals(true, isIsogram("Dermatoglyphics"));
//        assertEquals(true, isIsogram("isogram"));
//        assertEquals(false, isIsogram("moose"));
//        assertEquals(false, isIsogram("isIsogram"));
//        assertEquals(false, isIsogram("aba"));
//        assertEquals(false, isIsogram("moOse"));
//        assertEquals(true, isIsogram("thumbscrewjapingly"));
//        assertEquals(true, isIsogram(""));
    }

    public static int[] arrayDiff(int[] a, int[] b) {
//        int ind = 0;
//        int size_cnt = 0;
//        if(a.length == 0 || b.length == 0)return a;
//
//            for (int i=0;i<b.length;i++)
//            {
//                for (int t=0;t<a.length;t++)
//                {
//                    if(a[t] == b[i])
//                    {
//                        a[t] = 999;
//                        size_cnt++;
//                    }
//
//                }
//            }
//            int[] c = new int[a.length-size_cnt];
//            for (int i=0;i<a.length;i++)
//            {
//                if(a[i] != 999)
//                {
//                    c[ind] = a[i];
//                    ind++;
//                }
//            }
//            return c;

         //return Arrays.stream(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
         return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();

    }


        public static boolean  isIsogram(String str) {
           if(str == "")return true;
           str = str.toLowerCase();
           Set<String> sl = Arrays.stream(str.split("")).map(it->it).collect(Collectors.toSet());

            List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);
            List<Integer> list01 = list.stream().distinct().collect(Collectors.toList());
            System.out.println(list01);


           return str.length() == str.toLowerCase().chars().distinct().count();
          // return (sl.size() != str.length())?false:true;
        }

        @Test
        public void tes01(){
       // String s= "-H-H-H-HH-";
        String s= "HH-HH";
        String d = s.replaceAll("H-H","a").replaceAll("-H","a").replaceAll("H-","a");
            System.out.println(d);
//        if(Arrays.stream(d.split("")).filter(it->it.equals("H")).count() > 0) return -1l;
//        else return Arrays.stream(d.split("")).filter(it->it.equals("a")).count();
        }


}


