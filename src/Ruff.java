import java.util.*;

public class Ruff {

    public void f1(){
        System.out.println("f1");
    }

    public static void f2(){

        Ruff ruff = new Ruff();
        ruff.f1();

    }

    public static void main(String[] args) {

    }

}
