import java.util.List;
import java.util.ArrayList;

public class mazeSolverRecursivoCompleto implements mazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) return path;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (dfs(grid, start, end, visited, path)) {
            List<Cell> forward = new ArrayList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                forward.add(path.get(i));
            }
            return forward;
        }
        return path; 
    }

    private boolean dfs(boolean[][] grid,
                        Cell cur,
                        Cell end,
                        boolean[][] visited,
                        List<Cell> path) {
        int r = cur.getFila();
        int c = cur.getColumna();

        if (r < 0 || c < 0
         || r >= grid.length
         || c >= grid[0].length
         || !grid[r][c]
         || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        if (r == end.getFila() && c == end.getColumna()) {
            path.add(cur);
            return true;
        }

        if ( dfs(grid, new Cell(r - 1, c), end, visited, path)  // arriba
          || dfs(grid, new Cell(r, c + 1), end, visited, path)  // derecha
          || dfs(grid, new Cell(r + 1, c), end, visited, path)  // abajo
          || dfs(grid, new Cell(r, c - 1), end, visited, path)  // izquierda
        ) {
            path.add(cur);
            return true;
        }

        
        return false;
    }
}
