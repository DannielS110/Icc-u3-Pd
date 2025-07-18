import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        runMaze();
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
            { true,  true,  true,  true },
            { false, true,  false,  true },
            { true,  true,  false, false },
            { true,  true,  true,  true }
        };

        Maze maze = new Maze(predefinedMaze);
        Cell start = new Cell(0, 0);
        Cell end   = new Cell(3, 3);

        mazeSolver solver = new mazeSolverRecursivoCompletoBT();
        mazeResult result = solver.solve(predefinedMaze, start, end);

        // Listado de coordenadas
        System.out.println("Autor: michael yumbla");
        System.out.println("RUTA VISITADA");
        String visitedList = result.getVisited().stream()
            .map(c -> "[" + c.row + "," + c.cole + "]")
            .collect(Collectors.joining(", "));
        System.out.println("[" + visitedList + "]");

        System.out.println("RUTA OPTIMA");
        String pathList = result.getPath().stream()
            .map(c -> "[" + c.row + "," + c.cole + "]")
            .collect(Collectors.joining(", "));
        System.out.println("[" + pathList + "]");

        System.out.println("Camino encontrado:");
        System.out.println("[" + pathList + "]");

        // Visualización en forma de laberinto
        System.out.println();
        System.out.println("Laberinto con las celdas visitadas:");
        maze.printMaze(result.getVisited());

        System.out.println();
        System.out.println("Laberinto con el camino recorrido:");
        maze.printMaze(result.getPath());
    }
}