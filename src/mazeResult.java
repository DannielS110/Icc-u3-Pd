import java.util.List;
import java.util.Set;

public class mazeResult {
    private final List<Cell> path;
    private final Set<Cell> visited;

    public mazeResult(List<Cell> path, Set<Cell> visited) {
        this.path = path;
        this.visited = visited;
    }

    public List<Cell> getPath() {
        return path;
    }

    public Set<Cell> getVisited() {
        return visited;
    }
}
