package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {
    public static int findSecondLargest(int[] arr){
        return Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        int[] arr={20,20,5,20,8};
        System.out.println(findSecondLargest(arr));
    }
}
