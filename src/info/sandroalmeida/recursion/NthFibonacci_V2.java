package info.sandroalmeida.recursion;

public class NthFibonacci_V2 {

    public static int getNthFib(int n) {
        if(n == 1)
            return 0;
        else if(n == 2)
            return 1;
        else
            return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(1));
        System.out.println(getNthFib(2));
        System.out.println(getNthFib(3));
        System.out.println(getNthFib(4));
        System.out.println(getNthFib(5));
        System.out.println(getNthFib(6));
    }
}
