package game;

public class SudokuGame {
    public static final int DIMENSION=9;
    private int [][] board;

    public SudokuGame(int[][]board){
        this.board=new int[DIMENSION][DIMENSION];
        copyDefinedGridToTheBoard(board);
    }

    /**
     * Method copy defined board to new board and check if the board is valid
     * @param board
     * @return
     */
    private boolean copyDefinedGridToTheBoard(int[][]board) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                this.board[i][j] = board[i][j];
            }

        }
        return true;
    }

}
