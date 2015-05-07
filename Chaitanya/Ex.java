class A {
    void a1()
    {
        System.out.println("class A");
    }
}
interface B {
    void a1();
}
class C extends A implements B{
    public void a1(){
System.out.println("This is imple3mneted class");
    }
}
class Ex {
public static void main(String[] args) {
    C oc = new C();
    oc.a1();
}
}
