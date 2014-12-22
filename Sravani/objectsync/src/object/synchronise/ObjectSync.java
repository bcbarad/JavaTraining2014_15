package object.synchronise;
class A {
    synchronized void test1() {
        for (int i = 0; i < 50; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    synchronized void test2() {
        for (int i = 100; i < 150; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
class B extends Thread {
    private A a1;
    B(final A a1) {
        this.a1 = a1;
    }
    public void run() {
        a1.test1();
    }
}
class C extends Thread {
    private A a1;
    C(final A a1) {
        this.a1 = a1;
    }
    public void run() {
        a1.test2();
    }
}
public class ObjectSync {
    public static void main(final String[] args) {
        A a1 = new A();
        //A a2=new A();
        B b1 = new B(a1);
        C c1 = new C(a1);
        b1.start();
        System.out.println("============");
        c1.start();
    }
}
