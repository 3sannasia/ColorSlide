package src.GameLogic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BackendTest {

    //-------- Setup --------//

    LevelBoard playground;

    @Before
    public void setup() {

        System.out.println("Setting up for Testing ...");
        playground = new LevelBoard(
            "10 10 100\n" + 
            "X91 --- --- --- --- --- --- --- --- X19\n" + 
            "X19 r11 ... ... B11 Y11 ... B11 Y11 |||\n" + 
            "||| ... X15 ... ... ... ... ... ... |||\n" + 
            "||| ... ||| ... W22 --- ... R21 --- |||\n" + 
            "||| ... ||| ... ||| ||| ... X22 --- |||\n" + 
            "||| ... ||| ... ... ... ... ||| --- |||\n" + 
            "||| ... ||| ... G11 ... Y11 ... ... |||\n" + 
            "||| ... ... O11 ... P11 ... ... ... |||\n" + 
            "||| R11 ... ... ... ... ... ... ... |||\n" + 
            "||| X91 --- --- --- --- --- --- --- ---"
        );
        System.out.println("Loaded Simulated Level.\n");
    }

    //-------- Make Sure Setup worked --------//

    @Test
    public void testLevelLoading() {

        String[] recieved = playground.getBoardGrid().split("\n");
        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . R R X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testLevelLoading.\n");
    }

    //-------- Basic Movement Tests --------//

    @Test
    public void testBasicBlockPushUp() {

        // Push the White block
        int block = playground.BlockIndexAt(450, 350);
        playground.push(block, Direction.UP);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . W W . . . X \n" + 
            "X . X . W W . R R X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testBasicBlockPushUp.\n");
    }


    @Test
    public void testBasicBlockPushDown() {

        // Push the White block
        int block = playground.BlockIndexAt(450, 350);
        playground.push(block, Direction.DOWN);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . . . . R R X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testBasicBlockPushDown.\n");
    }


    @Test
    public void testBasicBlockPushRight() {

        // Push the White block
        int block = playground.BlockIndexAt(450, 350);
        playground.push(block, Direction.RIGHT);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . . W W R R X \n" + 
            "X . X . . W W X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testBasicBlockPushRight.\n");
    }

    @Test
    public void testBasicBlockPushLeft() {

        // Push the white block
        int block = playground.BlockIndexAt(450, 350);
        playground.push(block, Direction.LEFT);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X W W . . R R X \n" + 
            "X . X W W . . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testBasicBlockPushLeft.\n");
    }

    //-------- Edge Movement Tests --------//

    @Test
    public void testPushWallAttempt() {

        // Try to push an obstacle (shouldn't move)
        int block = playground.BlockIndexAt(50, 50);
        playground.push(block, Direction.LEFT);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . R R X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testPushWallAttempt.\n");
    }

    @Test
    public void testPushIntoWall() {

        // Try to push a wall into another obstacle (shouldn't move)
        int block = playground.BlockIndexAt(850, 350);
        playground.push(block, Direction.DOWN);
        playground.update(5);

        String[] recieved = playground.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . R R X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . O . P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testPushIntoWall.\n");
    }

}
