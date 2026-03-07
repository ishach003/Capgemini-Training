package Capp;

import java.util.*;

public class cap {

    public static List<List<String>> extractSuccessfulTransactions(List<List<String>> transactions) {

        List<List<String>> result = new ArrayList<>();

        // Step 1: Filtering
        for (List<String> row : transactions) {

            String status = row.get(3);
            int amount = Integer.parseInt(row.get(4));

            if (status.equals("SUCCESS") && amount > 1000) {
                result.add(row);
            }
        }

        // Step 2: Sorting (Descending by Date + Time)
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {

                // Convert date DD-MM-YYYY → YYYYMMDD
                String da = a.get(0).substring(6,10)
                        + a.get(0).substring(3,5)
                        + a.get(0).substring(0,2);

                String db = b.get(0).substring(6,10)
                        + b.get(0).substring(3,5)
                        + b.get(0).substring(0,2);

                // Add time
                String ta = da + a.get(1).substring(0,2) + a.get(1).substring(3,5);
                String tb = db + b.get(1).substring(0,2) + b.get(1).substring(3,5);

                // Descending order
                return tb.compareTo(ta);
            }
        });

        return result;
    }

    public static void main(String[] args) {

        List<List<String>> transactions = new ArrayList<>();

        transactions.add(Arrays.asList("01-01-2023","10:30","T1","SUCCESS","1500"));
        transactions.add(Arrays.asList("01-01-2023","12:00","T2","FAILED","2000"));
        transactions.add(Arrays.asList("02-01-2023","09:00","T3","SUCCESS","5000"));

        List<List<String>> ans = extractSuccessfulTransactions(transactions);

        for(List<String> row : ans){
            System.out.println(row);
        }
    }
}





