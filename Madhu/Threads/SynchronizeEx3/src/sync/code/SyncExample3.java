package sync.code;
class Table {   
    synchronized static void printTable(int n) {  
        for(int i = 1; i <= 5; i++){  
            System.out.println(n*i);  
            try{  
                Thread.sleep(400);  
            }catch(Exception e) {
                e.printStackTrace(); 
            }  
        }  
    }  
}  

class MyThread1 extends Thread {  
    public void run() {  
        Table.printTable(1);  
    }  
}  

class MyThread2 extends Thread {  
    public void run() {  
        Table.printTable(10);  
    }  
}  

class MyThread3 extends Thread {  
    public void run() {  
        Table.printTable(100);  
    }  
}  
public class SyncExample3 {  
    public static void main(String args[]) {  
        MyThread1 t1 = new MyThread1();  
        MyThread2 t2 = new MyThread2();  
        MyThread3 t3 = new MyThread3();   
        t1.start();  
        t2.start();  
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End of main");

    }  
}
