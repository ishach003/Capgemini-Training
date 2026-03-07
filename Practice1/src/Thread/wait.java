package Thread;

class SleepDemo extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=3;i++){
            System.out.println("Running "+ i);

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class wait {
    public static void main(String[] args) {
        SleepDemo sleepDemo=new SleepDemo();
        sleepDemo.start();
    }
}

// yield()
