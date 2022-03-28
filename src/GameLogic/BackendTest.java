package src.GameLogic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BackendTest {

    //-------- Setup --------//

    LevelBoard playground1;
    LevelBoard playground2;

    @Before
    public void setup() {

        System.out.println("Setting up Playground 1 for Testing ...");
        playground1 = new LevelBoard(
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
        System.out.println("Loaded Simulated Level 1.\n");

        System.out.println("Setting up Playground 2 for Testing ...");
        playground2 = new LevelBoard(




            // Yo Manuj make a test under testLevel1Loading for 2 also plz in addition to the other tests ty





            "10 10 100\n" + 
            "X91 --- --- --- --- --- --- --- --- X19\n" + 
            "X19 r11 ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| ... ... ... ... ... ... ... ... |||\n" + 
            "||| X91 --- --- --- --- --- --- --- ---"
        );
        System.out.println("Loaded Simulated Level 2.\n");
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
        System.out.println("    Test Complete (Default PASSED): testLevelLoading.\n");
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

}
