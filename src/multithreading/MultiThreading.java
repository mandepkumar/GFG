package multithreading;

class myThread extends Thread{
    @Override
    public void run() {
        for (int i=1;i<=50;i++){
            System.out.println("["+Thread.currentThread().getName()+"]\t i:"+i);
        }
    }
}

class myThread2 implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=5;i++){
            System.out.println("["+Thread.currentThread().getName()+"]\t i:"+i);
        }
    }
}

public class MultiThreading {
    public MultiThreading(){
        System.out.println("MultiThreading");

        myThread t1 = new myThread();
        t1.setName("Thread A");
        t1.start();

        Thread t2 = new Thread(new myThread2());
        t2.setName("Thread B");
        t2.start();
    }
}
