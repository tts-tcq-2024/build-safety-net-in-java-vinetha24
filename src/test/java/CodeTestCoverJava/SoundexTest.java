package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

   
    @Test
    public void testEmptyString() {
        assertTrue(Soundex.generateSoundex("").equals(""));
    }

    @Test
    public void testSingleVowelCharacter() {
      String[] vowels = {"A","E","I","O","U","a","e","i","o","u"};
      for(String character: vowels) {
         assertTrue(Soundex.generateSoundex(character).equals(character.toUpperCase() + "000"));
      }
    }
    @Test
    public void testNullString(){
        assertTrue(Soundex.generateSoundex(null).equals(""));
    
	}
	@Test
	public void testWordOfSameSound(){
		assertEquals(Soundex.generateSoundex("rat"),Soundex.generateSoundex("rot"));
	}
	
	@Test
	public void testConsonants() {
	  assertTrue(Soundex.generateSoundex("BK").equals("B200"));
	}
	
	@Test 
	public void testNumbers() {
	  assertTrue(Soundex.generateSoundex("1234").equals("1000"));
	}
	
	@Test
	public void testSpecialCharacters() {
	   assertTrue(Soundex.generateSoundex("!@#$%^&").equals("!000"));

	}
	
	@Test
	public void testMixedString() {
	   assertTrue(Soundex.generateSoundex("ROT1@").equals("R300"));

	}
	@Test
    public void testNamewithGtThreeCharacters() {
       assertTrue(Soundex.generateSoundex("HoneYMAn").equals("H500"));
       assertTrue(Soundex.generateSoundex("Ashcraft").equals("A261"));

    }
	
}
