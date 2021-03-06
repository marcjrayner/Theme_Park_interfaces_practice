package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(12, 123.5, 20.50);
        visitor2 = new Visitor(18, 163.5, 200.50);
        visitor3 = new Visitor(10, 100.5, 200.50);
        visitor4 = new Visitor(20, 200.5, 200.50);
    }


    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canCheckVisitorAgainstAgeAndHeightLimitFalse() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void canCheckVisitorAgainstAgeAndHeightLimitFalse2() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void canCheckVisitorAgainstAgeAndHeightLimitTrue() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.1);
    }

    @Test
    public void canGetDoublePriceIfVisitorOver200cm() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor4), 0.1);
    }

    @Test
    public void doesNotDoublePriceIfVisitorUnder200cm() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor2), 0.1);
    }
}
