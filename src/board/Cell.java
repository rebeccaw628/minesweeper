package board;

public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

   public Cell(boolean isMine, boolean isRevealed, int adjacentMines) {
       this.isMine = isMine;
       this.isRevealed = isRevealed;
       this.adjacentMines = adjacentMines;
   }

   public boolean getIsMine () {
       return isMine;
   }

   public boolean getIsRevealed () {
       return isRevealed;
   }

   public int getAdjacentMines () {
       return adjacentMines;
   }

   public void setIsMine (boolean isMine) {
       this.isMine = isMine;
   }

   public void setIsRevealed (boolean isRevealed) {
       this.isRevealed = isRevealed;
   }

   public void setAdjacentMines (int adjacentMines) {
       this.adjacentMines = adjacentMines;
    }

}
