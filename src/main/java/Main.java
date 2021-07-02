import game.SudokuGameSetup;
import game.boardExample.DefineSudokuBoard;
import game.solver.SudokuSolver;

public class Main {


    public static void main (String[] args){

        int[][] userBoard= DefineSudokuBoard.chooseSudokuBoard();
        SudokuGameSetup sudokuGameSetup = new SudokuGameSetup(userBoard);
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuGameSetup.getBoard());
        sudokuSolver.solveByBacktracking();
        System.out.println(sudokuSolver.toString());
    }


}
