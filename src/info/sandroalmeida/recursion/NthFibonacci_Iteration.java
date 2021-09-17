package info.sandroalmeida.recursion;

public class NthFibonacci_Iteration {

    public static int getNthFib(int n) {

        int n1 = 0, n2 = 1;
        if(n == 1) return n1;
        if(n == 2) return n2;

        for(int i = 3; i <= n; i++){
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n2;
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
