package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack myStack;

    @BeforeEach
    public void startWith() {
        myStack = new Stack();
    }

    @Test
    public void testThatStackIsEmpty() {
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testTestStackIsEmpty_ThenIPushX_AndStackIsNoLongerEmpty() {
        assertTrue(myStack.isEmpty());

        myStack.push("Lawrence");
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testThatStackIsEmpty_ThenIPushXAndTheStackIsNotEmpty_AndIPopX_AndTheStackIsEmptyAgain() {
        assertTrue(myStack.isEmpty());

        myStack.push("Lawrence");
        myStack.pop();

        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testThatStackIsEmpty_ThenIPushFirst_AndIPushSecondAndCheckItIsNotEmpty_ThenIMakeSureItReturnsSecondBeforeFirst() {
        assertTrue(myStack.isEmpty());

        myStack.push("First");
        myStack.push("Second");

        assertFalse(myStack.isEmpty());

        assertEquals("Second", myStack.pop());
        assertEquals("First", myStack.pop());

        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testThatStackIsEmpty_AndTryToPopAnEmptyStack_AndMakeSureItThrowsException() {
        assertTrue(myStack.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> myStack.pop());
    }

    @Test
    public void testThatStackIsEmpty_AddThreeElements_PopOneAndPeekTheLastOne_AndMakeSureItPeeksTheLastAmongThoseTwoRemaining_ThenIPopIt() {
        assertTrue(myStack.isEmpty());

        myStack.push("First");
        myStack.push("Second");
        myStack.push("Third");

        assertEquals("Third", myStack.pop());
        assertEquals("Second", myStack.peek());

        assertEquals("Second", myStack.pop());
    }

    @Test
    public void testThatStackIsEmpty_AndTryToPeekAnEmptyStack_AndMakeSureItThrowsException() {
        assertTrue(myStack.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> myStack.peek());
    }

    @Test
    public void testThatStackIsEmpty_AndIPushThreeElements_AndSearchForX_AndItReturnsThePositionInStack() {
        assertTrue(myStack.isEmpty());

        myStack.push("First");
        myStack.push("Second");
        myStack.push("Third");

        assertEquals(1, myStack.search("Third"));
    }

    @Test
    public void testThatStackIsEmpty_AndIPushThreeElements_AndSearchForXWhichIsNotInTheElement_AndItReturnsMinusOneBecauseItIsNotInTheStack() {
        assertTrue(myStack.isEmpty());

        myStack.push("First");
        myStack.push("Second");
        myStack.push("Third");

        assertEquals(-1, myStack.search("Last"));
    }
}
