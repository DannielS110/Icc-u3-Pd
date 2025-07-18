// src/mazeSolverRecursivoCompletoBT.java
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class mazeSolverRecursivoCompletoBT implements mazeSolver {
    private final List<Cell> path = new ArrayList<>();
    private final Set<Cell> visited = new LinkedHashSet<>();
    private boolean[][] grid;
    private Cell end;

    @Override
    public mazeResult solve(boolean[][] grid, Cell start, Cell end) {
        this.grid = grid;
        this.end = end;
        path.clear();
        visited.clear();
        findPath(start);
        return new mazeResult(path, visited);
    }

    private boolean findPath(Cell cur) {
        if (!inBounds(cur) || !grid[cur.row][cur.cole] || visited.contains(cur)) {
            return false;
        }
        visited.add(cur);
        path.add(cur);
        if (cur.equals(end)) {
            return true;
        }
        if (findPath(new Cell(cur.row,     cur.cole + 1))  // derecha
         || findPath(new Cell(cur.row + 1, cur.cole    ))  // abajo
         || findPath(new Cell(cur.row,     cur.cole - 1))  // izquierda
         || findPath(new Cell(cur.row - 1, cur.cole    ))) // arriba
        {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    private boolean inBounds(Cell c) {
        return c.row >= 0 && c.row < grid.length
            && c.cole >= 0 && c.cole < grid[0].length;
    }
}
