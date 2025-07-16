public class App {
       public static void main(String[] args) throws Exception {
        runEjerciciosPD();
    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration);

        System.out.println("Fibonacci Recursivo Caching");
        start = 0;  
        resultado = ejerciciosPD.getFibonacciPD(50);
        end = 0;
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration);
    }
}