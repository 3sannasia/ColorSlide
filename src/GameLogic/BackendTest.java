package src.GameLogic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BackendTest {

    //-------- Setup --------//

    LevelBoard playground1;
    LevelBoard playground2;
    LevelBoard playground3;

    @Before
    public void setup() {

        System.out.println("Setting up Playground 1 for Testing ...");
        playground1 = new LevelBoard(
            "10 10 100 20\n" + 
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
        System.out.println("Loaded Simulated Level 1.\n");

        System.out.println("Setting up Playground 2 for Testing ...");
        playground2 = new LevelBoard(
            "10 10 100 20\n" + 
            "X91 --- --- --- --- --- --- --- --- X19\n" + 
            "X19 ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... X21 --- ... ... |||\n" + 
            "||| R22 --- ... ... r22 ||| X12 ... |||\n" + 
            "||| ||| ||| ... ... --- ||| ||| ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... R21 --- ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| X91 --- --- --- --- --- --- --- ---"
        );
        System.out.println("Loaded Simulated Level 2.\n");

        System.out.println("Setting up Playground 3 for Testing ...");
        playground3 = new LevelBoard(
            "10 10 100 20\n" + 
            "X91 --- --- --- --- --- --- --- --- X19\n" + 
            "X19 ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... X21 --- ... ... |||\n" + 
            "||| R23 --- ... ... r22 ||| X12 ... |||\n" + 
            "||| ||| ||| ... ... --- ||| ||| ... |||\n" + 
            "||| ||| ||| ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... R21 --- ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| X91 --- --- --- --- --- --- --- ---"
        );
        System.out.println("Loaded Simulated Level 3.\n");
    }

    //-------- Make Sure Setup worked --------//

    @Test
    public void testLevel1Loading() {

        String[] recieved = playground1.getBoardGrid().split("\n");
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
        System.out.println("    Test Complete (Default PASSED): testLevelLoading1.\n");
    }

    @Test
    public void testLevel2Loading() {

        String[] recieved = playground2.getBoardGrid().split("\n");
        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X . . . . . . . . X \n" + 
            "X . . . . X X . . X \n" + 
            "X R R . . r r X . X \n" + 
            "X R R . . r r X . X \n" + 
            "X . . . . . . . . X \n" + 
            "X . . . . . . . . X \n" + 
            "X . . . . R R . . X \n" + 
            "X . . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testLevelLoading2.\n");
    }

    @Test
    public void testLevel3Loading() {

        String[] recieved = playground3.getBoardGrid().split("\n");
        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X . . . . . . . . X \n" + 
            "X . . . . X X . . X \n" + 
            "X R R . . r r X . X \n" + 
            "X R R . . r r X . X \n" + 
            "X R R . . . . . . X \n" + 
            "X . . . . . . . . X \n" + 
            "X . . . . R R . . X \n" + 
            "X . . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): testLevelLoading3.\n");
    }

    //-------- Basic Movement Tests --------//

    @Test
    public void testBasicBlockPushUp() {

        // Push the White block
        int block = playground1.BlockIndexAt(450, 350);
        playground1.push(block, Direction.UP);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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
        int block = playground1.BlockIndexAt(450, 350);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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
        int block = playground1.BlockIndexAt(450, 350);
        playground1.push(block, Direction.RIGHT);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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
        int block = playground1.BlockIndexAt(450, 350);
        playground1.push(block, Direction.LEFT);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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
        int block = playground1.BlockIndexAt(50, 50);
        playground1.push(block, Direction.LEFT);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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
        int block = playground1.BlockIndexAt(850, 350);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

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

    @Test
    public void testNoPushTwoBlocks() {

        // Try to push two blocks at once (shouldn't work)
        int block = playground1.BlockIndexAt(750, 150);
        playground1.push(block, Direction.DOWN);
        block = playground1.BlockIndexAt(850, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . . Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . P P X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): testNoPushTwoBlocks.\n");
    }

    @Test
    public void testPushTwoBlocks() {

        // Try to push a two blocks, the second after the first has stopped
        int block = playground1.BlockIndexAt(750, 350);
        playground1.push(block, Direction.LEFT);
        playground1.update(5);
        block = playground1.BlockIndexAt(850, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B . X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W R R Y X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): testPushTwoBlocks.\n");
    }

    //-------- Color Merging Tests --------//

    @Test
    public void testYellowAndBlue() {

        // Try to merge yellow and blue
        int block = playground1.BlockIndexAt(450, 150);
        playground1.push(block, Direction.RIGHT);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . . G . B Y X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): testYellowAndBlue.\n");
    }

    @Test
    public void testRedAndBlue() {

        // Try to merge red and blue
        int block = playground1.BlockIndexAt(750, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . . Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . P P X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): testRedAndBlue.\n");
    }

    @Test
    public void testRedAndYellow() {

        // Try to merge red and yellow
        int block = playground1.BlockIndexAt(850, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B . X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . O O X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): testRedAndYellow.\n");
    }

    @Test
    public void noMergeNeutral() {

        // Try to merge with neutral (shouldn't work)
        int block = playground1.BlockIndexAt(450, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . . Y . B Y X \n" + 
            "X . X . B . . . . X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): noMergeNeutral.\n");
    }

    @Test
    public void noMergePrimSec() {

        // Try to merge a primary and secondary color (shouldn't work)
        int block = playground1.BlockIndexAt(750, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);
        block = playground1.BlockIndexAt(850, 150);
        playground1.push(block, Direction.DOWN);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . . . X \n" + 
            "X . X . . . . . Y X \n" + 
            "X . X . W W . P P X \n" + 
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
        System.out.println("    Test Complete (Default PASSED): noMergePrimSec.\n");
    }

    @Test
    public void noMergeSecSec() {

        // Try to merge two secondary colors (shouldn't work)
        int block = playground1.BlockIndexAt(350, 750);
        playground1.push(block, Direction.RIGHT);
        playground1.update(5);

        String[] recieved = playground1.getBoardGrid().split("\n");

        String expectedLevel = 
            "X X X X X X X X X X \n" + 
            "X r . . B Y . B Y X \n" + 
            "X . X . . . . . . X \n" + 
            "X . X . W W . R R X \n" + 
            "X . X . W W . X X X \n" + 
            "X . X . . . . X X X \n" + 
            "X . X . G . Y . . X \n" + 
            "X . . . O P . . . X \n" + 
            "X R . . . . . . . X \n" + 
            "X X X X X X X X X X ";
        String[] expected = expectedLevel.split("\n");
        
        for(int i = 0; i < expected.length; i++){
            assertEquals(recieved[i], expected[i]);
        }
        System.out.println("    Test Complete (Default PASSED): noMergeSecSec.\n");
    }

    @Test
    public void goalPartial() {

        // Only partially filling the goal should not result in win
        int block = playground2.BlockIndexAt(550, 750);
        playground2.push(block, Direction.UP);
        playground2.update(10);

        assertEquals(false, playground2.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): goalPartial.\n");
    }

    @Test
    public void goalOverFilled() {

        // Only partially filling the goal should not result in win
        int block = playground3.BlockIndexAt(150, 350);
        playground3.push(block, Direction.RIGHT);
        playground3.update(10);

        assertEquals(false, playground3.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): goalOverFilled.\n");
    }

    @Test
    public void goalSatisfied() {

        // Fully filling the goal should result in win
        int block = playground2.BlockIndexAt(150, 350);
        playground2.push(block, Direction.RIGHT);
        playground2.update(10);

        assertEquals(true, playground2.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): goalSatisfied.\n");
    }

    @Test
    public void goalSatisfied2() {

        // Pushing blocks against block at exact goal should not result in win due to merge
        int block = playground2.BlockIndexAt(550, 750);
        playground2.push(block, Direction.UP);
        playground2.update(10);

        block = playground2.BlockIndexAt(150, 350);
        playground2.push(block, Direction.RIGHT);
        playground2.update(10);

        assertEquals(false, playground2.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): goalSatisfied2.\n");
    }

    @Test
    public void correctMoveCount() {

        int block = playground2.BlockIndexAt(150, 350);
        //Should have counted exactly 17 moves
        for(int i = 0; i <= 16; i++)
        {
            if(i%2 == 0) playground2.push(block, Direction.RIGHT);
            else playground2.push(block, Direction.LEFT);
            playground2.update(10);
        }

        assertEquals(17, playground2.getMoves());
        
        System.out.println("    Test Complete (Default PASSED): correctMoveCount.\n");
    }

    @Test
    public void correctMoveCount2() {

        int block = playground2.BlockIndexAt(150, 350);
        //Should have counted exactly 17 moves even if in some moves the state does not change.
        for(int i = 0; i <= 16; i++)
        {
            playground2.push(block, Direction.RIGHT);
            playground2.update(10);
        }

        assertEquals(17, playground2.getMoves());
        
        System.out.println("    Test Complete (Default PASSED): correctMoveCount2.\n");
    }

    @Test
    public void validMoveCount() {

        int block = playground2.BlockIndexAt(150, 350);
        //17 is within the allowed number of moves (20)
        for(int i = 0; i <= 16; i++)
        {
            if(i%2 == 0) playground2.push(block, Direction.RIGHT);
            else playground2.push(block, Direction.LEFT);
            playground2.update(10);
        }

        assertEquals(true, playground2.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): validMoveCount.\n");
    }

    @Test
    public void tooManyMoves() {

        int block = playground2.BlockIndexAt(150, 350);
        //21 is more than the allowed number of moves (20)
        for(int i = 0; i < 21; i++)
        {
            if(i%2 == 0) playground2.push(block, Direction.RIGHT);
            else playground2.push(block, Direction.LEFT);
            playground2.update(10);
        }

        assertEquals(false, playground2.isComplete());
        
        System.out.println("    Test Complete (Default PASSED): tooManyMoves.\n");
    }

}
