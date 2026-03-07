package Capp;

import java.util.*;

public class cap3 {

    public static List<List<String>> getFailedLogins(List<List<String>> logs){
        List<List<String>> result=new ArrayList<>();

        Map<String,List<String>> map=new HashMap<>();
        for(List<String> a:logs){
            if(a.get(3).equals("FAILED")){
                String key=a.get(0)+a.get(1);
                if(!map.containsKey(key)){
                    map.put(key,a);
                }
                else{
                    List<String > existing=map.get(key);
                    String existingTime=existing.get(2);

                    String t1=existingTime.replace(":","");
                    String t2=a.get(2).replace(":","");

                    if(t2.compareTo(t1)<0){
                        map.put(key,a);
                    }
                }
            }
        }
        result.addAll(map.values());

        Collections.sort(result,new Comparator<List<String>>(){
            @Override
            public int compare(List<String>a,List<String>b){
                String ea=a.get(0);
                String eb=b.get(0);
                int datacompare=ea.compareTo(eb);

                if(datacompare!=0){
                    return datacompare;
                }

                String da=a.get(0).substring(6,10)
                        +a.get(0).substring(3,5)
                        +a.get(0).substring(0,2);
                String db=b.get(0).substring(6,10)
                        +b.get(0).substring(3,5)
                        +b.get(0).substring(0,2);

                return da.compareTo(db);
            }
        });



        return result;
    }

    public static void main(String[] args) {

        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("Isha","01-01-2023","10:00","FAILED"));
        logs.add(Arrays.asList("Isha","01-01-2023","09:00","FAILED"));
        logs.add(Arrays.asList("Rahul","02-01-2023","08:00","FAILED"));
        logs.add(Arrays.asList("Isha","01-01-2023","11:00","SUCCESS"));

        List<List<String>> ans = getFailedLogins(logs);

        for(List<String> row : ans){
            System.out.println(row);
        }
    }
}
