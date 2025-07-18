// src/mazeSolverRecursivoCompleto.java
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class mazeSolverRecursivoCompleto implements mazeSolver {
    @Override
    public mazeResult solve(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];
        dfs(grid, start, end, visitedGrid, path);

        Set<Cell> visited = new LinkedHashSet<>();
        for (int i = 0; i < visitedGrid.length; i++) {
            for (int j = 0; j < visitedGrid[0].length; j++) {
                if (visitedGrid[i][j]) {
                    visited.add(new Cell(i, j));
                }
            }
        }
        return new mazeResult(path, visited);
    }

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        return solve(grid, start, end).getPath();
    }

    @Override
    public Set<Cell> getVisited(boolean[][] grid, Cell start, Cell end) {
        return solve(grid, start, end).getVisited();
    }

    private boolean dfs(boolean[][] grid,
                        Cell cur,
                        Cell end,
                        boolean[][] visitedGrid,
                        List<Cell> path) {
        int r = cur.row, c = cur.cole;
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
         || !grid[r][c] || visitedGrid[r][c]) {
            return false;
        }
        visitedGrid[r][c] = true;

        if (r == end.row && c == end.cole) {
            path.add(cur);
            return true;
        }

        if (dfs(grid, new Cell(r - 1, c), end, visitedGrid, path)
         || dfs(grid, new Cell(r, c + 1), end, visitedGrid, path)
         || dfs(grid, new Cell(r + 1, c), end, visitedGrid, path)
         || dfs(grid, new Cell(r, c - 1), end, visitedGrid, path)) {
            path.add(cur);
            return true;
        }
        return false;
    }
}
