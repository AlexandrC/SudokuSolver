package game;

import game.boardExample.BoardPostion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
    int[] getColumn(int[][] matrix, int column) {
        return Arrays.stream(matrix).mapToInt(ints -> ints[column]).toArray();
    }
    private boolean isNumberSingleDigit(int number, int row, int column){
        if (number<=9 &&number>=0){
            return true;
        }
        else {
            throw new RuntimeException("number in row"+row+ "and column"+column+" is not single digit");

        }

    }
//    private boolean isNumberUniqueInRow(int row,int numberToCompare){
//        for(int i=0;i<DIMENSION;i++){
//            if (this.board[row][i]==0 &&i==BoardPostion.column &&row==BoardPostion.row){
//                break;
//            }
//            if (this.board[row][i]==numberToCompare ){
//                throw new RuntimeException("number "+numberToCompare+"in row"+row+"and column"+i+"is not unique");
//            }
//        }
//        return true;
//    }
    private boolean isNumberUniqueInRow(List<Integer> numberInRows, int numberToCompare){
        if (numberInRows.contains(numberToCompare)){
            return true;
        }
        else {
            return false;
        }

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
            return (isNumberSingleDigit(numberToCompare,row,column)); //&&
                    //isNumberUniqueInRow(row, numberToCompare) &&
                    //isNumberUniqueInColumn(column, numberToCompare));
        }

    }
    private boolean checkDuplicatesInRows(int[] selectedRow,int rowNum) {
        for (int i = 0; i < selectedRow.length; i++) {
            for (int j = i + 1; j < selectedRow.length; j++) {
                if (selectedRow[i] == selectedRow[j] && selectedRow[i]!=0)
                    throw new RuntimeException("There are duplicate num "+selectedRow[i]+" in row: "+ rowNum);
            }
        }
        return true;
    }
    private boolean checkDupliactesInColumn(int[] selectedColumn,int columnNum) {
        for (int i = 0; i < selectedColumn.length; i++) {
            for (int j = i + 1; j < selectedColumn.length; j++) {
                if (selectedColumn[i] == selectedColumn[j] && selectedColumn[i]!=0)
                    throw new RuntimeException("There are duplicate num "+selectedColumn[i]+" in column: "+ columnNum);
            }
        }
        return true;
    }
    private boolean checkDuplicatesIn3x3Box(int[][] board) {
        if (board.length % 3 != 0) {
            throw new RuntimeException("Wrong format of the defined board");
        }
        int[][] specificBoard = new int[3][3];
    return true;

    }



    public void isBoardSetupOk(){
        checkDuplicatesIn3x3Box(board);
        for (int i=0;i<DIMENSION;i++){
            checkDuplicatesInRows(board[i],i);
            checkDupliactesInColumn(getColumn(board,i),i);
        }

    }


}
