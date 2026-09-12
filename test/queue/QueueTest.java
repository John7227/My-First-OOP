package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {

    private Queue myQueue;

    @BeforeEach
    public void startWith() {
        myQueue = new Queue();
    }

    @Test
    public void testThatQueueIsEmpty() {
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testThatIAddElementIntoTheQueue_AndItReturnsTrueIfItIsSuccessfullyAdded() {
        myQueue.add("Ban");

        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatItThrowsAnIllegalStateExceptionIfNoSpaceIsCurrentlyAvailable() {
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");
        myQueue.add("Fourth");
        myQueue.add("Fifth");

        assertThrows(IllegalArgumentException.class, () -> myQueue.add("Sixth"));
    }

    @Test
    public void testThatIAddThreeElements_AndRemove_AndMakeSureItRemovesFromTheFirst() {
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");

        assertEquals("First", myQueue.remove());
        assertEquals("Second", myQueue.remove());
        assertEquals("Third", myQueue.remove());

    }

    @Test
    public void testThatItThrowsNoSuchElementExceptionIfTheQueueIsEmpty () {
        assertThrows(NoSuchElementException.class, () -> myQueue.remove());
    }

    @Test
    public void testThatIAddThreeElements_AndPoll_AndItReturnsTheHeadOfTheQueue() {
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");

        assertEquals("First", myQueue.poll());
        assertEquals("Second", myQueue.poll());
        assertEquals("Third", myQueue.poll());
    }

    @Test
    public void testThatItReturnsNullIfTheQueueIsEmptyWhenIWantToPoll() {
        assertNull(myQueue.poll());
    }

    @Test
    public void testThatIAddThreeElements_AndPeek_AndItRetrievesTheFirstElements_AndIRemove_AndItRemovesTheFirstElements_ToConfirmThatPeekDoesNotRemoveAnElementItOnlyRetrievesIt() {
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");

        assertEquals("First", myQueue.peek());
        assertEquals("First", myQueue. poll());
    }

    @Test
    public void testThatItReturnsNullIfTheQueueIsEmptyWhenIWantToPeekAtTheFirstIndex() {
        assertNull(myQueue.peek());
    }

}


