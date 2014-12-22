package sync.code;
class Print {
  synchronized  void print(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(n*i);
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
public class SyncExample1 {
    public static void main(String args[]) {
        Print p = new Print();
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);
        t1.start();
        t2.start();
    }
}
class Thread1 extends Thread {
    Print p;
    Thread1(Print p) {
      this.p = p;
    }
    public void run() {
       //Print p = new Print();
        p.print(10);
    }
}
class Thread2 extends Thread {
    Print p;
    Thread2(Print p) {
        this.p = p;
    }
    public void run() {
       // Print p1 = new Print();
        p.print(100);
    }   
}  
