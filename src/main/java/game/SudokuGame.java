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
     * @param boardFromUser
     * @return
     */
    private boolean copyDefinedGridToTheBoard(int[][]boardFromUser) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int number=boardFromUser[i][j];
                isNumberValid(number,i,j);
                this.board[i][j] = number;
            }

        }
        return true;
    }
    private boolean isNumberSingleDigit(int number, int row, int column){
        if (number<=9 &&number>=0){
            return true;
        }
        else {
            throw new RuntimeException("number in row"+row+ "and column"+column+" is not single digit");

        }

    }
    private boolean isNumberInRow(int number){
        return false;
    }
    private boolean isNumberValid(int number, int row, int column){
        return isNumberSingleDigit(number,row,column);
    }

}
