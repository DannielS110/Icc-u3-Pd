import java.util.List;

public interface mazeSolver {
    List<Cell> getPath(boolean [][] grid, Cell start,Cell end);
}