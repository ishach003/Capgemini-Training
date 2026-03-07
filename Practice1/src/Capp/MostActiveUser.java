package Capp;

import java.util.*;

public class MostActiveUser {

    public static String getMostActiveUser(List<List<String>> logs){
        Map<String,Integer> map=new HashMap<>();

        for(List<String> a: logs)
        {
            if(a.get(3).equals("LOGIN")){
                String name= a.get(0);
                   map.put(name,map.getOrDefault(name,0)+1);
            }

        }
        String resultUser="";
        int maxCount=0;

        for(Map.Entry<String,Integer> e: map.entrySet()){
            String user=e.getKey();
            int count=e.getValue();

            if(count>maxCount){
                maxCount=count;
                resultUser=user;
            } else if (count==maxCount) {
                if(user.compareTo(resultUser)<0){
                    resultUser=user;
                }
            }
        }

        return resultUser;
    }

    public static void main(String[] args) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(Arrays.asList("Isha","01-01-2023","10:00","LOGIN"));
        logs.add(Arrays.asList("Rahul","01-01-2023","11:00","LOGIN"));
        logs.add(Arrays.asList("Isha","01-01-2023","12:00","LOGIN"));
        logs.add(Arrays.asList("Rahul","01-01-2023","13:00","LOGOUT"));
        logs.add(Arrays.asList("Isha","02-01-2023","09:00","LOGIN"));

        String ans = getMostActiveUser(logs);

        System.out.println("Most Active User: " + ans);
    }
}
