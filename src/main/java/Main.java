import game.SudokuGameSetup;
import game.boardExample.DefinedGrid;
import game.boardExample.SudokuSolver;

public class Main {

    public static void main (String[] args){


        SudokuGameSetup sudokuGameSetup = new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_HARD);

        SudokuSolver sudokuSolver = new SudokuSolver(sudokuGameSetup.getBoard());
        sudokuSolver.solveByBacktracking();


    }
}
