package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuGameSetupTest {

    final int[][] GRID_TO_SOLVE_EASY = {
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

    SudokuGameSetup underTest;

    @BeforeEach
    void setUp() {
        underTest = new SudokuGameSetup(GRID_TO_SOLVE_EASY);

    }

    @Test
    void itShouldIsBoardSetupOk() {
        //Given
        //When
        //Then
    }

    @Test
    void itShouldselectNumberInRow() {
        //Given
        int expectedRow=0;

        //When
       // underTest.callSelectNumInRows(0);
        //Then
    }
}