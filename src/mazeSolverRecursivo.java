import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class mazeSolverRecursivo implements mazeSolver {
    @Override
    public mazeResult solve(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = getPath(grid, start, end);
        // en este solver no rastreamos visited separado,
        // devolvemos path también en visited para marcar igual
        Set<Cell> visited = new LinkedHashSet<>(path);
        return new mazeResult(path, visited);
    }

    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) return path;
        findPath(grid, start, end, path);
        return path;
    }

    private boolean findPath(boolean[][] grid, Cell cur, Cell end, List<Cell> path) {
        int r = cur.row, c = cur.cole;
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || !grid[r][c]) return false;
        path.add(cur);
        if (r == end.row && c == end.cole) return true;
        if (findPath(grid, new Cell(r, c+1), end, path)
         || findPath(grid, new Cell(r+1, c), end, path)
         || findPath(grid, new Cell(r, c-1), end, path)
         || findPath(grid, new Cell(r-1, c), end, path)) return true;
        path.remove(path.size()-1);
        return false;
    }
}
