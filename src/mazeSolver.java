import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public interface mazeSolver {
    /**
     * Resuelve el laberinto y devuelve both ruta óptima y celdas visitadas.
     */
    mazeResult solve(boolean[][] grid, Cell start, Cell end);

    /**
     * Ruta óptima en forma de lista de celdas.
     * Valor por defecto delega a solve().
     */
    default List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        return solve(grid, start, end).getPath();
    }

    /**
     * Celdas visitadas en orden.
     * Valor por defecto delega a solve().
     */
    default Set<Cell> getVisited(boolean[][] grid, Cell start, Cell end) {
        return new LinkedHashSet<>(solve(grid, start, end).getVisited());
    }
}
