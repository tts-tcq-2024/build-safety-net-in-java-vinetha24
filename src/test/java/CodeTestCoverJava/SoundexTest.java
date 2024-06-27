package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
         assertTrue("", Soundex.generateSoundex(""));
    }

    @Test
    public void testSingleCharacter() {
         assertTrue("A000", Soundex.generateSoundex("A"));
    }
}
