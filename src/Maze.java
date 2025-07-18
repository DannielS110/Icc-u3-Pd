import java.util.List;
import java.util.Set;

public class Maze {
    private final boolean[][] grid;

    public Maze(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Imprime el laberinto marcando cada celda visitada (visited) con '> ',
     * muros con '* ' y celdas libres no visitadas con '- '.
     */
    public void printMaze(Set<Cell> visited) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    System.out.print("* ");
                } else if (visited.contains(new Cell(i, j))) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Imprime el laberinto marcando solamente el camino óptimo (path) con '> ',
     * muros con '* ' y celdas libres fuera del camino con '- '.
     */
    public void printMaze(List<Cell> path) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    System.out.print("* ");
                } else if (path.contains(new Cell(i, j))) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
