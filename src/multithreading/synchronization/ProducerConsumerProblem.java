package multithreading.synchronization;
class Memory{
    int buffer;
    boolean isItemReady =false;

    synchronized public void  produceItem(int item) throws InterruptedException {
        if(isItemReady){
            //if isItemReady == true
            //if item is ready them wait for consume to get consume the item!
            wait();
        }
        buffer=item;
        System.out.println("Produced Item :"+buffer);
        isItemReady =true; //item got produce so ready to consume
        notify();
    }
    synchronized public int consumeItem() throws InterruptedException {
        if(!isItemReady){
            // if isItemReady == false
            // if item is not already it mean consumer should wait till it get produce and item get ready
            wait();
        }
        System.out.println("Consumed Item :"+buffer);
        isItemReady = false; //Item got consume so make it false
        notify();
        return buffer ^ (buffer=-1); //return old value before updating
    }
}
class Producer extends Thread{
    Memory memory;
    Producer(Memory memory){
        this.memory=memory;
    }

    @Override
    public void run() {
        int i=100;
        while (true) {
            try {
                memory.produceItem(i);
                i+=10;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consume extends Thread{
    Memory memory;
    Consume(Memory memory){
        this.memory=memory;
    }

    @Override
    public void run() {
        while (true){
            try {
                int item = memory.consumeItem();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class ProducerConsumerProblem {
    public static void main(String[]args) throws InterruptedException {
        Memory memory = new Memory();
        Producer producer = new Producer(memory);
        Consume consume = new Consume(memory);

        producer.start();
        consume.start();
    }
}
