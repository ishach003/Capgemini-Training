package Thread;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for(int i=1;i<11;i++){
            System.out.print(i +" ");
        }
    }
}

class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Runnable");
    }
}
//
//public synchronized void M1(){
//    wait();
//}
//
//public synchronized void M2(){
//    notify();
//}


public class customThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();

        MyThread1 myThread1=new MyThread1();
        Thread t1=new Thread(myThread1);

        t1.setPriority(Thread.MAX_PRIORITY);
        //myThread.run(); //  stored in heap area
        myThread.setName("3.14");
        myThread.start();
//        myThread.join();



        t1.start();
//        t1.join();


        System.out.println("Main");
    }
}
