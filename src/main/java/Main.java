import game.SudokuGameSetup;
import game.boardExample.DefinedGrid;
import game.solver.SudokuSolver;

public class Main {


    public static void main (String[] args){

        SudokuGameSetup sudokuGameSetup = DefinedGrid.chooseGrid();

        SudokuSolver sudokuSolver = new SudokuSolver(sudokuGameSetup.getBoard());
        sudokuSolver.solveByBacktracking();
        System.out.println(sudokuSolver.toString());
    }


}
