package DSA.Arrays;

import java.util.Arrays;

public class CheckIfArrayIsSortedOrNot {
    public static void main(String[] args) {
        isArraySorted(new int[]{10,20,30,40,50,50,60});
        isArraySorted(new int[]{10,20,19,40,50,50,60});
    }
    public  static boolean isArraySorted(int arr[]){
        System.out.println(Arrays.toString(arr));

        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
            {
                System.out.println("Not Sorted !!");
                return false;
            }
        }
        System.out.println("Sorted !!");
        return  true;
    }
}
