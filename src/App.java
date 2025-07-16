import java.util.Arrays;
import java.util.List;

public class App {
       public static void main(String[] args) throws Exception {
        //runEjerciciosPD();
        runMaze();
    }

    //private static void runEjerciciosPD() {
       /*  EjerciciosPD ejerciciosPD = new EjerciciosPD();

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
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration);*/
     

    //}


private static void runMaze(){
        boolean [][] predefinedMaze= {
            {true, true,true,true},
            {false,true,true,true} ,       
            {true,true,false,false},
            {true,true,true,true}};
            //Clase MAZE variable globla predefinedMaze 
    Maze maze = new Maze(predefinedMaze);
            System.out.println("Version 2.0");
        System.out.println("Autor: Daniel Sanchez\n");
   
    System.out.println("\n========= Laberinto:\n");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end   = new Cell(3, 3);

        List<mazeSolver> solvers = Arrays.asList(
            new mazeSolverRecursivo()
        );
        mazeSolver solver = solvers.get(0);

        List<Cell> path = solver.getPath(maze.getGrid(), start, end);

        System.out.println("\nCamino Encontrado:\n");
        System.out.println(path);
    }
}