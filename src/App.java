import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private static void runMaze() {
        // Definición del laberinto
        boolean[][] predefinedMaze = {
            { true,  true,  true,  true },
            { false, true,  true,  true },
            { true,  true,  false, false },
            { true,  true,  true,  true }
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Versión 3.0");
        System.out.println("Autor: Daniel Sánchez\n");
        System.out.println("\n========= Laberinto:\n");
        maze.printMaze();

        // Punto de inicio y fin
        Cell start = new Cell(0, 0);
        Cell end   = new Cell(3, 3);

        // Lista de solvers disponibles
        List<mazeSolver> solvers = Arrays.asList(
            new mazeSolverRecursivo(),            // índice 0: explora sólo derecha/abajo
            new mazeSolverRecursivoCompleto()     // índice 1: explora 4 direcciones y evita ciclos
        );

        // Elige el solver por índice (0 o 1)
        mazeSolver solver = solvers.get(1);

        // Calcula el camino
        List<Cell> path = solver.getPath(maze.getGrid(), start, end);

        // Muestra el resultado
        System.out.println("\nCamino Encontrado:\n");

String ruta = path.stream()
    .map(Cell::toString)
    .collect(Collectors.joining(" ---> "));
System.out.println("Camino encontrado (" + path.size() + " pasos):");
System.out.println(ruta);    }
}