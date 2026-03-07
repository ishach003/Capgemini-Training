package Capp;

import java.util.*;

class Solution {

    // function to check common substring
    public static boolean hasCommonSubstring(String s1, String s2) {

        // write logic here
        for (char c:s1.toCharArray()){
//            for (char s:s2.toCharArray()){
//                if(c==s){
//                    return true;
//
//                }
//            }
            if(s2.contains(String.valueOf(c))){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // define arrays in code
        String[] a = {"ab", "cd","ab" ,"ef"};
        String[] b = {"af", "ee", "na","ef"};

        int n = a.length;

        // compare pairs
        for(int i = 0; i < n; i++) {

            boolean result = hasCommonSubstring(a[i], b[i]);

            if(result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }


    }
}
