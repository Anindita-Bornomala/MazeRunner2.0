package mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.PathTranslator;

class PathTranslatorTest {

    @Test
    void testTranslateToFact() {
        PathTranslator translator = new PathTranslator();

        String canonical = "FFLLLRRRR";
        String expectedFact = "2F 3L 4R ";
        assertEquals(expectedFact, translator.translateToFact(canonical));        
        assertEquals("", translator.translateToFact(""));
    }

    @Test
    void testTranslateToCanon() {
        PathTranslator translator = new PathTranslator();

        String factorized = "2F 3L 4R ";
        String expectedCanonical = "FFLLLRRRR";
        assertEquals(expectedCanonical, translator.translateToCanon(factorized));
    }
}
