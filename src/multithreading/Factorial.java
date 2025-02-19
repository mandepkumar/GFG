package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FactorialThread extends Thread{
    @Override
    public void run() {

    }
}
public class Factorial {
    public static int factorial(int num){
        if(num<=1)
            return 1;
        return factorial(num-1)*num;
    }
    public static void main(String[] args) {
        /*
            * We are given an array of numbers and need to calculate the factorial for each using three different approaches:
            * Sequential Processing
            * Parallel Streams
            * Multithreading
        */
        int input[] ={1,2,3,4,5,6,7,8,9,10};
        sequential(input);
        System.out.println("----------------------------------------------------------");
        parallelStream(input); //Does not Preserve order while printing
        System.out.println("----------------------------------------------------------");
        parallelStreamAndCollectIt(input); //Preserves order because it is storing in list then we are printing
        System.out.println("----------------------------------------------------------");
        multithreading(input);
        System.out.println("----------------------------------------------------------");
    }



    private static void multithreading(int[] input) {
        long startTime = System.nanoTime();
        {
            for (int i =0;i<input.length;i++){

            }
        }
        long endTime = System.nanoTime();
        System.out.println("Execution Time : "+(endTime-startTime)/1000);
    }

    private static void parallelStreamAndCollectIt(int[] input) {
        long startTime = System.nanoTime();
        {
            System.out.println("Parallel Stream Processing collecting to list");
            IntStream convertedToIntStream = Arrays.stream(input);
            List<Integer> list = convertedToIntStream.parallel().mapToObj(Factorial::factorial).collect(Collectors.toList());
            System.out.println(list);
        }
        long endTime = System.nanoTime();
        System.out.println("Execution Time : "+(endTime-startTime)/1000);
    }

    private static void parallelStream(int[] input) {
        /*
         * Java splits the task into multiple threads automatically.
         * Each number's factorial is computed in parallel using ForkJoinPool.
         * Execution order is unpredictable because multiple threads run simultaneously.
         *
         * Java automatically creates multiple threads using a common ForkJoinPool.
         * Each number is processed in parallel, so results are printed as threads finish.
         */
        long startTime = System.nanoTime();
        {
            System.out.println("Parallel Stream Processing");
            //Arrays.stream(numbers).parallel() converts the array into a parallel stream.
            Arrays.stream(input).parallel().forEach(num-> System.out.println(num+"! =\t"+factorial(num)));
        }
        long endTime = System.nanoTime();
        System.out.println("Execution Time : "+(endTime-startTime)/1000);
    }

    private static void sequential(int[] input) {
        /*
        * The numbers are processed one by one, in the same order they appear in the array
        * Each number's factorial is computed in a single thread (main thread)
        * This approach is deterministic, meaning the output order always matches the input order.
        */
        long startTime = System.nanoTime();
        {
            System.out.println("Sequential Process");
            IntStream convertedToIntStream = Arrays.stream(input);
            convertedToIntStream.forEach(num-> System.out.println(num+"! =\t"+factorial(num)));
        }
        long endTime = System.nanoTime();
        System.out.println("Execution Time : "+(endTime-startTime)/1000);
    }
}
