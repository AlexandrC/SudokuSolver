package game;

import game.boardExample.DefinedGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SudokuGameSetupTest {
    SudokuGameSetup underTest;



    @BeforeEach

    void setUp() {

    }

    @Test
    void itShouldcheckTheBoardSetupIsOkay() {
        //Given

        //When
        underTest=new SudokuGameSetup(DefinedGrid.GRID_TO_SOLVE_EASY);
        boolean boardSetupOk=underTest.isBoardSetupOk(underTest.getBoard());
        //Then
        assertTrue(boardSetupOk);
    }

    @Test
    void itShouldfindDuplicateNumerInRow() {
        //Given

        final int[][] DUPLICATE_IN_ROW_GRID = {
                {0,1,3,8,0,0,4,0,5},
                {0,2,4,6,0,5,0,0,0},
                {0,8,7,0,0,0,9,3,0},
                {4,9,0,3,0,6,0,0,0},
                {0,0,1,0,0,0,5,0,0},
                {0,0,0,7,0,1,0,9,3},
                {0,6,9,0,0,0,7,4,0},
                {4,0,0,2,0,7,6,8,0},
                {1,0,2,0,0,8,3,5,0},
        };

        //When

        underTest = new SudokuGameSetup();

        //Then
        assertThatThrownBy(()->underTest.isBoardSetupOk(DUPLICATE_IN_ROW_GRID))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("There are duplicate num 4 in column: 0");

    }
}