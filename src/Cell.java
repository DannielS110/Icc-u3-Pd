public class Cell {
    public int row;
    public int cole;

    public Cell(int row, int cole) {
        this.row = row;
        this.cole = cole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell other = (Cell) o;
        return row == other.row && cole == other.cole;
    }

    @Override
    public int hashCode() {
        return 31 * row + cole;
    }
}