package Capp;

import java.util.*;

public class ShortestSubstring {

    public static int findShortestSubstring(String s) {
        int n=s.length();
        int remove =n;
        Map<Character,Integer>  map=new HashMap<>();

        for (char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int left=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            map.put(c,map.get(c)-1);

            while (allDistinct(map)){
                remove=Math.min(remove,r-left+1);

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) + 1);

                left++;
            }

        }
        return  remove;

    }

    public static boolean allDistinct(Map<Character,Integer> map){
        for (int count:map.values()){
            if(count>1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String s = "abcbback";   // given example

        int result = findShortestSubstring(s);

        System.out.println(result);
    }
}