package multithreading.synchronization;

class Brackets{
    synchronized public void printBrackets(char open,char close){
        for(int i=0;i<100;i++){
            System.out.print(i<5?open:close);
        }
        System.out.println();
    }
}
public class Main {
    public static  void  main(String[] args){
        Brackets b1 = new Brackets();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                long startTime = System.currentTimeMillis();
                for(int i=0;i<30;i++)
                    b1.printBrackets('(',')');
                long endTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" : "+(endTime-startTime));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for(int i=0;i<30;i++)
                    b1.printBrackets('{','}');
                long endTime = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" : "+(endTime-startTime));
            }
        });
        t1.start();
        t2.start();
    }
}
