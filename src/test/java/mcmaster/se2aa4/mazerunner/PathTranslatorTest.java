package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.PathTranslator;

class PathTranslatorTest {
    private PathTranslator translator;

    @BeforeEach
    public void setup() {
        this.translator = new PathTranslator();
    }

    @Test
    void testTranslateToFact() {
        String canonical = "FFLLLRRRR";
        String expectedFact = "2F 3L 4R ";
        assertEquals(expectedFact, translator.translateToFact(canonical));        
        assertEquals("", translator.translateToFact(""));
    }

    @Test
    void testTranslateToCanon() {
        String factorized = "2F 3L 4R ";
        String expectedCanonical = "FFLLLRRRR";
        assertEquals(expectedCanonical, translator.translateToCanon(factorized));
    }
}
