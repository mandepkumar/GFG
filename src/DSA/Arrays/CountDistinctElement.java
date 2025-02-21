package DSA.Arrays;

import java.util.HashSet;

public class CountDistinctElement {
    public static void main(String[] args) {
        System.out.println(countDistinct(new Integer[]{1,4,3,5,5,5,5}));
        System.out.println(countDistinct(new String[]{"man","man","boi","boy"}));
    }
    public static <T> int countDistinct(T arr[]){
        HashSet<T> set = new HashSet<>();
        for(T x : arr){
            set.add(x);
        }
        return  set.size();
    };
}
