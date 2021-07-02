import game.solver.SudokuSolver;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SudokuSolverTest {

    SudokuSolver underTest;


    @Test
    void itShouldFindOnlyOneSolution() {
        //Given
        final int[][] EXPECTED_USER_GRID={
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
        String input="n";
        System.out.println("Automated Input: "+input);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //When
        underTest= new SudokuSolver(EXPECTED_USER_GRID);
        //Then
        assertThat(underTest.solveByBacktracking()).isTrue();
    }


}
