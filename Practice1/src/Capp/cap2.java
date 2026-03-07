package Capp;
import java.util.*;


public class cap2 {

    public static List<List<String>> getHighPriorityOpenTickets(List<List<String>> tickets) {

        List<List<String>> result = new ArrayList<>();

        for(List<String> row:tickets){
            String priority= row.get(3);
            String Status=row.get(4);

            if(priority.equals("HIGH") && Status.equals("OPEN")){
                result.add(row);
            }
        }
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                String da = a.get(1).substring(6,10)
                        + a.get(1).substring(3,5)
                        + a.get(1).substring(0,2);

                String db = b.get(1).substring(6,10)
                        + b.get(1).substring(3,5)
                        + b.get(1).substring(0,2);

                int datacompare=da.compareTo(db);

                if(datacompare!=0){
                    return datacompare;
                }
                String ta = a.get(2).substring(0,2) + a.get(2).substring(3,5);
                String tb = b.get(2).substring(0,2) + b.get(2).substring(3,5);

                return ta.compareTo(tb);
            }
        });

return result;
    }

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("T1","01-01-2023","10:00","HIGH","OPEN"));
        tickets.add(Arrays.asList("T2","01-01-2023","09:00","HIGH","OPEN"));
        tickets.add(Arrays.asList("T3","02-01-2023","11:00","LOW","OPEN"));

        List<List<String>> ans = cap2.getHighPriorityOpenTickets(tickets);

        for(List<String> row : ans){
            System.out.println(row);
        }
    }
}
