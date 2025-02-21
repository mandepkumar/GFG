package stream.parallel;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] ={1,2,6,7,8,9,10,12,13,40,60,80,90};
        int ans = Arrays.stream(arr).parallel().filter(n->n%6==0).findFirst().orElse(-1);
        System.out.println(ans);
    }
}
