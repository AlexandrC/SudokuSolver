package game;

import game.boardExample.BoardPostion;

public class SudokuGameSetup {
    public static final int DIMENSION=9;
    private int [][] board;
    int[][] position;

    public SudokuGameSetup(int[][]board){
        this.board=new int[DIMENSION][DIMENSION];
        copyDefinedGridToTheBoard(board);
        isBoardSetupOk();
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
                isNumberOk(number,i,j);
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
    private boolean isNumberUniqueInRow(int row,int numberToCompare){
        for(int i=0;i<DIMENSION;i++){
            if (this.board[row][i]==0 &&i==BoardPostion.column &&row==BoardPostion.row){
                break;
            }
            if (this.board[row][i]==numberToCompare ){
                throw new RuntimeException("number "+numberToCompare+"in row"+row+"and column"+i+"is not unique");
            }
        }
        return true;
    }
    private boolean isNumberUniqueInColumn(int column, int numberToCompare){
        for (int i=0;i<DIMENSION;i++){
            if (this.board[i][column]==0&&i==BoardPostion.row &&column==BoardPostion.column){
                break;
            }
            if (this.board[i][column]==numberToCompare ){
                throw new RuntimeException("number "+numberToCompare+"in row"+i+"and column"+column+"is not unique");
            }
        }
        return true;
    }
    private boolean isNumberOk(int numberToCompare, int row, int column){
        if (numberToCompare==0){
            return true;
        }
        else {
            return (isNumberSingleDigit(numberToCompare,row,column) &&
                    isNumberUniqueInRow(row, numberToCompare) &&
                    isNumberUniqueInColumn(column, numberToCompare));
        }

    }
    public void isBoardSetupOk(){
        for (int row=0;row<DIMENSION;row++){
            for (int column=0;column<DIMENSION;column++){
                int numberToCompare=board[column][row];
                BoardPostion boardPostion = new BoardPostion(column,row);
                if (!isNumberOk(numberToCompare, row, column)){
                    throw new RuntimeException("Board is not valid");
                }

            }
        }

    }

}
