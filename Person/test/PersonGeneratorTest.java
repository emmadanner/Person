import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonGeneratorTest
{
    PersonGenerator p1, p2, p3, p4, p5;

    @BeforeEach
    void setUp() {
        p1 = new PersonGenerator("000001", "Bilbo", "Baggins", "Esq.", 1060);
        p2 = new PersonGenerator("000002", "Frodo", "Baggins", "Esq.", 1120);
        p3 = new PersonGenerator("000003", "Sanwise", "Gamgee", "Esq.", 1125);
        p4 = new PersonGenerator("000004", "Peregrin", "Took", "Esq.", 1126);
        p5 = new PersonGenerator("000005", "Meridoc", "Brandybuck", "Esq.", 1126);
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000A");
        assertEquals("00000A", p1.getIDNum());

    }

    @Test
    void setFirstName() {
        p1.setFirstName("Billy");
        assertEquals("Billy", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Boggins");
        assertEquals("Boggins", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mr.");
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void setYearOfBirth() {
        p1.setYearOfBirth(1062);
        assertEquals(1060, p1.getYearOfBirth());
    }
}