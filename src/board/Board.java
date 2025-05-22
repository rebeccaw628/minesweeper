package board;

public class Board {
    private Cell[][] grid;
    private int rows;
    private int columns;
    private int totalMines;

    public Board(int rows, int columns, int totalMines) {
        this.rows = rows;
        this.columns = columns;
        this.totalMines = totalMines;
        this.grid = new Cell[rows][columns];
        initializeGrid();
        placeBombs();
        setMineCounts();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(false);
            }
        }
    }

    public void printGrid() {
        //print column labels
        System.out.print("    ");
        for (int col = 1; col <= columns; col++) {
            System.out.print(" " + col + " ");

        }
        System.out.println();

        //print game grid
        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d| ", i + 1); //print row labels
            for (int j = 0; j < columns; j++) {
                if (!grid[i][j].getIsRevealed()) {
                    System.out.print(" ■ ");
                } else if (grid[i][j].getIsMine()) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + grid[i][j].getAdjacentMines() + " ");
                }
            }
            System.out.println();
        }
    }

    private void placeBombs() {
        int count = 0;

        while (count < totalMines) {
            int randomRow = (int) (Math.random() * rows);
            int randomColumn = (int) (Math.random() * columns);
            if (!grid[randomRow][randomColumn].getIsMine()) {
                grid[randomRow][randomColumn].setIsMine(true);
                count++;
            }
        }
    }

    private void setMineCounts() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!grid[i][j].getIsMine()) {
                    grid[i][j].setAdjacentMines(countAdjacentMines(i, j));
                }
            }
        }
    }

    private int countAdjacentMines(int row, int column) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i < 0 || i >= rows || j < 0 || j >= columns || i == row && j == column) {
                    continue;
                } else if (grid[i][j].getIsMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean revealCell(int rowInput, int columnInput) {
        Cell selectedCell = grid[rowInput - 1][columnInput - 1];
        if (selectedCell.getIsMine()) {
            System.out.println("BOOM! You hit a mine. You lost :(");
            selectedCell.setIsRevealed(true);
            return true; //mine hit
        }
        else if (selectedCell.getIsRevealed()) {
            System.out.println("The cell in row " + rowInput + ", column " + columnInput + " has already been revealed.  Select another cell.");
        }
        else if (selectedCell.getAdjacentMines() == 0){
            selectedCell.setIsRevealed(true);
            revealNeighbourCells(rowInput - 1, columnInput - 1);
        }
        else {
            selectedCell.setIsRevealed(true);
        }

        return false;
    }

    private void revealNeighbourCells (int row, int column) {
        if (grid[row][column].getAdjacentMines() != 0) { //termination condition
            return;
        }
        else {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = column - 1; j <= column + 1; j++) {
                    if (i < 0 || i >= rows || j < 0 || j >= columns || i == row && j == column || grid[i][j].getIsRevealed()) {
                        continue;
                    }
                    grid[i][j].setIsRevealed(true);
                    revealNeighbourCells(i,j); //recursive call
                }
            }
        }
    }

    public boolean isGameWon () {
        int safeCellsRevealed = 0;
        int totalSafeCells = rows * columns - totalMines;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j].getIsRevealed()) {
                    safeCellsRevealed++;
                }
            }
        }
        return safeCellsRevealed == totalSafeCells;
    }
}




