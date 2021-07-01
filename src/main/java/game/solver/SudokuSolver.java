package game.solver;

import game.SudokuGameSetup;

import java.util.Scanner;

/**
 * Solves defined grid
 */
public class SudokuSolver  extends SudokuRules {
    int[][] currentBoard;
    public SudokuSolver(int[][]userBoard){
        this.currentBoard=userBoard;
    }

    public boolean solveByBacktracking(){
        long start = System.nanoTime();
        for (int row=0;row<currentBoard.length;row++){
            for (int col=0;col<currentBoard.length;col++){

                if (isTheSpaceEmpty(row,col,currentBoard)){
                    for (int i=1;i<=currentBoard.length;i++){
                        int attemptNum=i;
                        if (isOkToUse(row,col,attemptNum,currentBoard)){
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


    private boolean anotherSolution(){
        Scanner sc = new Scanner(System.in);


        System.out.println("There are the solution\n"+ toString());
        System.out.println("Do you want another solution: write y\n");
        System.out.println("For end of program write any keys except y\n");
        String s=sc.nextLine();

        return s.equals("y");

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
