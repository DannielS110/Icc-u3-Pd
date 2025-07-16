public class Maze {
    private boolean [][] grid;

    public Maze(boolean[][] grid) {
        this.grid = grid;
    }

    public void printMaze() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == true) System.out.print(" - ");
                else System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getMaze() {
        return grid;
    }

    public void setMaze(boolean[][] grid) {
        this.grid = grid;
    }
}