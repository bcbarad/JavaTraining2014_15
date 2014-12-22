package sync.code;
class Print {
    public synchronized  void print1(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(n+i);
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    public synchronized void print2(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(n-i);
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e);
            }
        } 
    }
}
public class SyncExample2 {
    public static void main(String args[]) {
        Print p = new Print();
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);
        System.out.println("Starting Thread 1");
        t1.start();
        System.out.println("Starting Thread 2");
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End of main");
    }
}
class Thread1 extends Thread {
    Print p;
    Thread1(Print p) {
      this.p = p;
    }
    public void run() {
       // Print p = new Print();
        p.print1(10);
    }
}
class Thread2 extends Thread {
    Print p;
    Thread2(Print p) {
        this.p = p;
    }
    public void run() {
       // Print p1 = new Print();
        p.print2(10);
    }   
}  
