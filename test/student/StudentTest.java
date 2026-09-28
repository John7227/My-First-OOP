package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student myStudent;

    @BeforeEach
    public void startWith() {
        myStudent = new Student("Peterson", 11);
    }

    @Test
    public void testThatTheStudentNameAndGradeLevelDisplays() {

        assertEquals("My Name is Peterson, and I am in grade 11", myStudent.introduce());
    }

    @Test
    public void testThatWhenAStudentIsPromoted_TheGradeLevelIncreases() {

        assertEquals(12, myStudent.promote());
    }

    @Test
    public void testThatWhenTheGradeLevelIsPromptedToIncreaseAbove12_ItStillRemainsAtItState() {
        myStudent.promote();
        myStudent.promote();
        myStudent.promote();
        assertEquals(12,myStudent.promote());
    }

    @Test
    public void testThatITakeAScore_AndItReturnsTrueIfItIsAPass() {

        assertTrue(myStudent.has_passed(90));
    }

    @Test
    public void testThatIUpdateTheName_AndItChanges() {
        assertEquals("Daniel", myStudent.update_name("Daniel"));
    }

    @Test
    public void testIfTheStudentIsInTheFinalGradeLevelItReturnsTrue() {

        myStudent.promote();
        assertTrue(myStudent.is_graduating());
    }

    @Test
    public void testIfTheStudentIsInAnyLevelAside12ItReturnsFalse() {
        
        assertFalse(myStudent.is_graduating());
    }

}
