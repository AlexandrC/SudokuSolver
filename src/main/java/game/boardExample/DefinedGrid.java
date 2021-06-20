package game.boardExample;

import game.SudokuGameSetup;

import java.util.Scanner;

public class DefinedGrid {

    public static final int[][] GRID_TO_SOLVE_EASY = {
            {0,1,3,8,0,0,4,0,5},
            {0,2,4,6,0,5,0,0,0},
            {0,8,7,0,0,0,9,3,0},
            {4,9,0,3,0,6,0,0,0},
            {0,0,1,0,0,0,5,0,0},
            {0,0,0,7,0,1,0,9,3},
            {0,6,9,0,0,0,7,4,0},
            {0,0,0,2,0,7,6,8,0},
            {1,0,2,0,0,8,3,5,0},
    };
    public static final int[][] GRID_TO_SOLVE_HARD={
            {0,0,2,0,0,0,0,4,1},
            {0,0,0,0,8,2,0,7,0},
            {0,0,0,0,4,0,0,0,9},
            {2,0,0,0,7,9,3,0,0},
            {0,1,0,0,0,0,0,8,0},
            {0,0,6,8,1,0,0,0,4},
            {1,0,0,0,9,0,0,0,0},
            {0,6,0,4,3,0,0,0,0},
            {8,5,0,0,0,0,4,0,0},
    };
    public static final int[][] GRID_TO_SOLVE_Hard2={
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,8,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,2,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},

    };
    public static final int[][] GRID_TO_SOLVE_2_SOLUTIONS={
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,0,0},

    };

    public static SudokuGameSetup chooseGrid(){
        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Easy Sudoku");
        System.out.println("2 - Hard Sudoku");
        System.out.println("3 - Very Hard Sudoku");
        System.out.println("4 - 2 choices Sudoku");


        selection = input.nextInt();
        switch (selection){
            case 1:{
                return new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_EASY);
            }
            case 2:{
                return new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_HARD);
            }
            case 3:{
               return new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_Hard2);
            }
            case 4:{
                return new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_2_SOLUTIONS);
            }
            default:{
                throw new RuntimeException("Bad choice");
            }

        }
    }

}
