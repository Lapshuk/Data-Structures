import static org.junit.Assert.*;

/**
 * Created by stephanieclaudinodaffara on 6/30/17.
 */
public class MeasurementTest {

    @org.junit.Test
    public void testConstructor(){
        Measurement m = new Measurement();
        assertNotNull(m);
        assertTrue(m.getFeet() == 0);
        assertTrue(m.getInches() == 0);
    }

    @org.junit.Test
    public void testConstructorFeet(){
        int feet = 1;
        Measurement m = new Measurement(feet);
        assertNotNull(m);
        assertTrue(m.getFeet() == feet);
        assertTrue(m.getInches() == 0);
    }

    @org.junit.Test
    public void testConstructorFeetInches(){
        int feet = 1;
        int inches = 5;
        Measurement m = new Measurement(feet, inches);
        assertNotNull(m);
        assertTrue("Expected: 10 feet; Actual: " + m.getFeet(), m.getFeet() == 1);
        assertTrue("Expected: 5 in; Actual: " + m.getInches(), m.getInches() == 5);

        feet = 1;
        inches = 12;
        m = new Measurement(feet, inches);
        assertNotNull(m);
        assertTrue("Expected: 2 feet; Actual: " + m.getFeet(), m.getFeet() == 2);
        assertTrue("Expected: 0 in; Actual: " + m.getInches(), m.getInches() == 0);
    }

    @org.junit.Test
    public void testGetFeet(){
        int feet = 1;
        int inches = 5;
        Measurement m = new Measurement(feet, inches);
        assertTrue("Expected: 10 feet; Actual: " + m.getFeet(), m.getFeet() == 1);

        Measurement m1 = new Measurement();
        assertTrue("Expected: 0 feet; Actual: " + m1.getFeet(), m1.getFeet() == 0);
    }

    @org.junit.Test
    public void testGetInches(){
        int feet = 1;
        int inches = 5;
        Measurement m = new Measurement(feet, inches);
        assertTrue("Expected: 5 in; Actual: " + m.getInches(), m.getInches() == 5);

        Measurement m1 = new Measurement();
        assertTrue("Expected: 0 in; Actual: " + m1.getInches(), m1.getInches() == 0);
    }

    @org.junit.Test
    public void testPlus(){
        plusBaseCase();
        plusOverflowCase();
    }

    public void plusBaseCase() {
        Measurement m = new Measurement(1, 5);
        Measurement m1 = new Measurement(1, 5);
        Measurement r = m.plus(m1);
        assertTrue("Expected: 10 in, Actual: " + r.getInches(), r.getInches() == 10);
        assertTrue("Expected: 2 feet, Actual: " + r.getFeet(), r.getFeet() == 2);
    }

    public void plusOverflowCase() {
        Measurement m = new Measurement(1, 5);
        Measurement m1 = new Measurement(1, 10);
        Measurement r = m.plus(m1);
        assertTrue("Expected: 3 in, Actual: " + r.getInches(), r.getInches() == 3);
        assertTrue("Expected: 3 feet, Actual: " + r.getFeet(), r.getFeet() == 3);
    }


    @org.junit.Test
    public void testMinus(){
        int feet = 1;
        int inches = 5;
        Measurement m = new Measurement(feet, inches);
        Measurement m1 = new Measurement(feet, inches);
        Measurement r = m.minus(m1);
        assertTrue("Expected: 0 in, Actual: " + r.getInches(), r.getInches() == 0);
        assertTrue("Expected: 0 feet, Actual: " + r.getFeet(), r.getFeet() == 0);

        inches = 10;
        Measurement m2 = new Measurement(feet, inches);
        Measurement m3 = new Measurement(feet, 5);
        Measurement r1 = m2.minus(m3);
        assertTrue("Expected: 5 in, Actual: " + r1.getInches(), r1.getInches() == 5);
        assertTrue("Expected: 0 feet, Actual: " + r1.getFeet(), r1.getFeet() == 0);
    }

    @org.junit.Test
    public void testMultiple(){

        int feet = 10;
        int inches = 8;
        int multiple = 0;
        Measurement m0 = new Measurement(feet, inches);
        Measurement r0 = m0.multiple(multiple);
        assertTrue(r0.toString().equals("0'0\""));

        Measurement m00 = new Measurement(5, 0);
        Measurement r00 = m00.multiple(2);
        assertTrue(r00.toString().equals("10'0\""));

        feet = 1;
        inches = 3;
        multiple = 2;
        Measurement m1 = new Measurement(feet, inches);
        Measurement r1 = m1.multiple(multiple);
        assertTrue("Expected: 6 in; Actual: " + r1.getInches(), r1.getInches() == 6);
        assertTrue("Expected: 2 feet; Actual: " + r1.getFeet(), r1.getFeet() == 2);

        feet = 0;
        inches = 7;
        multiple = 2;
        Measurement m2 = new Measurement(feet, inches);
        Measurement r2 = m2.multiple(multiple);
        assertTrue("Expected: 2 in; Actual: " + r2.getInches(), r2.getInches() == 2);
        assertTrue("Expected: 1 feet; Actual: " + r2.getFeet(), r2.getFeet() == 1);

        multiple = -1;
        Measurement m3 = new Measurement(feet, inches);
        Measurement r3 = m3.multiple(multiple);
        assertTrue("Expected: -7 in; Actual: " + r3.getInches(), r3.getInches() == -7);
        assertTrue("Expected: 0 feet; Actual: " + r3.getFeet(), r3.getFeet() == 0);

    }

    @org.junit.Test
    public void testToString() {
        Measurement m = new Measurement();
        assertEquals("0\'0\"", m.toString());

        int feet = 1;
        int inches = 5;
        Measurement m1 = new Measurement(feet, inches);
        assertEquals("1\'5\"", m1.toString());
    }


}