package game;

import java.util.Arrays;
import java.util.HashSet;

public class SudokuGameSetup {
    public static final int DIMENSION=9;

    public int[][] getBoard() {
        return board;
    }

    private int [][] board;

    public SudokuGameSetup(){

    }
    public SudokuGameSetup(int[][]board){
        this.board=new int[DIMENSION][DIMENSION];
        copyDefinedGridToTheBoard(board);
        isBoardSetupOk(this.board);
        String result=toString();
        System.out.println(result);
    }

    /**
     * Method copy defined board to new board and check if the board is valid
     * @param boardFromUser User would take Defined grid from class DefinedGrid
     */
    private void copyDefinedGridToTheBoard(int[][]boardFromUser) {
        for (int i = 0; i < DIMENSION; i++) {
            System.arraycopy(boardFromUser[i], 0, this.board[i], 0, DIMENSION);
        }
    }
    int[] getColumn(int[][] matrix, int column) {
        return Arrays.stream(matrix).mapToInt(ints -> ints[column]).toArray();
    }
    private void checkDuplicatesInRows(int[] selectedRow, int rowNum) {
        for (int i = 0; i < selectedRow.length; i++) {
            for (int j = i + 1; j < selectedRow.length; j++) {
                if (selectedRow[i] == selectedRow[j] && selectedRow[i]!=0)
                    throw new RuntimeException("There are duplicate num "+selectedRow[i]+" in row: "+ rowNum);
            }
        }
    }
    private void checkDuplicatesInColumn(int[] selectedColumn, int columnNum) {
        for (int i = 0; i < selectedColumn.length; i++) {
            for (int j = i + 1; j < selectedColumn.length; j++) {
                if (selectedColumn[i] == selectedColumn[j] && selectedColumn[i]!=0)
                    throw new RuntimeException("There are duplicate num "+selectedColumn[i]+" in column: "+ columnNum);
            }
        }
    }
    private void isDuplicatesIn3x3Box(int[][] board) {
        if (board.length % 3 != 0) {
            throw new RuntimeException("Wrong format of the defined board");
        }
        for (int i=0;i<DIMENSION;i=i+3){
           for (int j=0;j<DIMENSION;j++){
               isInBox(i,j,board);
           }
           }

    }
    private void isInBox(int row, int col,int [][]board) {
        HashSet<Integer> numbersInBox = new HashSet<>();
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++){
            for (int j = c; j < c + 3; j++){
                if (board[i][j]==0){
                    continue;
                }
                if (!numbersInBox.add(board[i][j])){
                    throw new RuntimeException("There is a duplicate number "
                            +board[i][j]
                            +"on matrix position "
                            +i+" in x coordinate "+
                            +j+" in y coordinate "
                            +"in 3x3 box");
                }
            }
        }
        numbersInBox.clear();


    }

    public boolean isBoardSetupOk(int[][] board){
        isDuplicatesIn3x3Box(board);
        for (int i=0;i<DIMENSION;i++){
            checkDuplicatesInRows(board[i],i);
            checkDuplicatesInColumn(getColumn(board,i),i);
        }
        System.out.println("Board is valid");
        return true;

    }
    @Override
    public String toString() {
        StringBuilder aString = new StringBuilder();
        for(int row = 0; row < DIMENSION; row++) {
            for(int col = 0; col < DIMENSION; col++) {
                aString.append(" ").append(board[row][col]);
            }
            aString.append("\n");
        }
        return aString.toString();
    }

}
