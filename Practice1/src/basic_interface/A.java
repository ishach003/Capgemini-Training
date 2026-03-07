package basic_interface;

public interface A {
    public void m1();
    public  void m2();
    public void m3();

    default void m4(){
        System.out.println("m4 for A");
    }
}

class B implements A {
    @Override
    public void m1() {
        System.out.println("M1 Method");
    }

    public void m2() {
        System.out.println("M2 Method");
    }

    public void m3() {
        System.out.println("M3 Method");
    }
}

class C implements A {
    @Override
    public void m1() {
        System.out.println("M1 Method of C");
    }

    public void m2() {
        System.out.println("M2 Method");
    }

    public void m3() {
        System.out.println("M3 Method");
    }
}

class D implements A {
    @Override
    public void m1() {
        System.out.println("M1 Method of D");
    }
    public void m2() {
        System.out.println("M2 Method");
    }

    public void m3() {
        System.out.println("M3 Method");
    }
}
