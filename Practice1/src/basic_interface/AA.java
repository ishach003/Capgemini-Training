package basic_interface;

public interface AA {
    public void m1();
}
class A_main {
    public static void main(String[] args) {
        AA a=new AA(){
            @Override
            public void m1(){
                System.out.println("Overriding m1 in class B ");
            }
        };
        a.m1();
    }
}
