package game;

import game.SudokuGameSetup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Solves defined grid
 */
public class SudokuSolver {
    int[][] currentBoard;
    public SudokuSolver(int[][]userBoard){
        this.currentBoard=userBoard;
    }

    public boolean solveByBacktracking(){
        long start = System.nanoTime();
        for (int row=0;row<currentBoard.length;row++){
            for (int col=0;col<currentBoard.length;col++){

                if (isTheSpaceEmpty(row,col)){
                    for (int i=1;i<=currentBoard.length;i++){
                        int attemptNum=i;
                        if (isOkToUse(row,col,attemptNum)){
                            currentBoard[row][col]=attemptNum;
                            if (solveByBacktracking()){
                                return true;
                            }
                            else {
                                currentBoard[row][col]=0;
                            }
                        }
                    }
                    if (row==0 &&col==0){
                        System.out.println("There are no solution");
                    }
                    return false;

                }



            }
        }
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end-start));
        start=0;
        end=0;
        return !anotherSolution(); // sudoku done
    }
    private boolean isTheSpaceEmpty(int row, int column){
        if (currentBoard[row][column]==0){
            return true;
        }
        return false;
    }


    private boolean anotherSolution(){
        Scanner sc = new Scanner(System.in);


        System.out.println("There are the solution\n"+ toString());
        checkValidGrid(currentBoard);
        System.out.println("Do you want another solution: write y\n");
        System.out.println("For end of program write any keys except y\n");
        String s=sc.nextLine();

        return s.equals("y");

    }

    private void checkValidGrid(int[][] currentBoard){
        SudokuGameSetup sudokuGameSetup = new SudokuGameSetup();
        sudokuGameSetup.isBoardSetupOk(currentBoard);
    }


    private boolean isItInRow(int row, int attemptNum){
        for (int i=0;i< currentBoard.length;i++){
            if (currentBoard[row][i]==attemptNum){
                return true;
            }

        }
        return false;
    }
    private boolean isItInColumn(int column, int attemptNum){
        for (int i = 0; i < currentBoard.length; i++)
            if (currentBoard[i][column] == attemptNum)
                return true;

        return false;
    }

    private boolean isInBox(int row, int col, int number) {
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
    private boolean isOkToUse(int row, int col, int number) {
        return !isItInRow(row, number)  &&  !isItInColumn(col, number)  &&  !isInBox(row, col, number) ;
    }

    @Override
    public String toString() {
        StringBuilder aString = new StringBuilder();
        for(int row = 0; row < currentBoard.length; row++) {
            for(int col = 0; col < currentBoard.length; col++) {
                aString.append(" ").append(currentBoard[row][col]);
            }
            aString.append("\n");
        }
        return aString.toString();
    }
}
