package game.solver;

public abstract class SudokuRules implements SudokuSolverInterface {

    protected boolean isTheSpaceEmpty(int row, int column, int[][] currentBoard) {
        if (currentBoard[row][column]==0){
            return true;
        }
        return false;
    }
    private boolean isItInRow(int row, int attemptNum,int[][]currentBoard){
        for (int i=0;i< currentBoard.length;i++){
            if (currentBoard[row][i]==attemptNum){
                return true;
            }

        }
        return false;
    }
    private boolean isItInColumn(int column, int attemptNum,int[][]currentBoard){
        for (int i = 0; i < currentBoard.length; i++)
            if (currentBoard[i][column] == attemptNum)
                return true;

        return false;
    }

    private boolean isInBox(int row, int col, int number,int[][]currentBoard) {
        // For example
        //  If row is 5 then row % 3 is 2 => 5-2=3. And that's the start row position in a grid of that Box
        // If col is 3 then col % 3 =0 => 3-0 = 3. And that's the start col postion in a grid of that Box.
        int r = row - row % 3;
        int c = col - col % 3;

        // With Start position 3 and 3 we're checking centre box in a 9x9 grid

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (currentBoard[i][j] == number)
                    return true;

        return false;
    }

  protected boolean isOkToUse(int row, int col, int number, int[][] currentBoard) {
        return !isItInRow(row, number,currentBoard)  &&
                !isItInColumn(col, number,currentBoard)  &&
                !isInBox(row, col, number,currentBoard);
    }
}
