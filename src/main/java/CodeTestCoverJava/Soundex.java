public class Soundex {

  private static final Map<Character, Character> SOUNDEXMAP = new HashMap<Character, Character>() {

    {
      put('B', '1');
      put('F', '1');
      put('P', '1');
      put('V', '1');
      put('C', '2');
      put('G', '2');
      put('J', '2');
      put('K', '2');
      put('Q', '2');
      put('S', '2');
      put('X', '2');
      put('Z', '2');
      put('D', '3');
      put('T', '3');
      put('L', '4');
      put('M', '5');
      put('N', '5');
      put('A', '0');
      put('I', '0');
      put('O', '0');
      put('U', '0');
      put('H', '0');
      put('W', '0');
      put('E', '0');
      put('R', '6');
      put('Y', '0');
    }
  };


public static void main(String[] args) {
      System.out.println(generateSoundex("Rot"));
    }

  /**
   * @param string
   * @throws Exception
   */
  private static String generateSoundex(String name)  {
      return name == null || name.isEmpty()?"":processSoundexCode(name.toUpperCase());

  }

  /**
   * @param soundex
   * @return
   */
  private static String padSoundex(StringBuilder soundex) {
    while (soundex.length() < 4) {
      soundex.append('0');
    }
    return soundex.toString();
  }

  /**
   * @param name
   * @throws Exception
   */
  private static String processSoundexCode(String name)  {
    StringBuilder soundex = new StringBuilder();
    soundex.append(name.charAt(0));
    try {
    char prevCode = getSoundexCode(name.charAt(0));
    for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
      char code = getSoundexCode(name.charAt(i));
      if (code != '0' && code != prevCode) {
        soundex.append(code);
        prevCode = code;
      }
    }
    }
    catch (Exception exception) {
      return exception.getLocalizedMessage();
    }
    padSoundex(soundex);

    return soundex.toString();

  }

  /**
   * @param charAt 
   * @return
   * @throws Exception
   */
  private static char getSoundexCode(char charAt) throws Exception {
    if (SOUNDEXMAP.get(charAt) != null) {
      return SOUNDEXMAP.get(charAt);
    }
  
      throw new Exception("Invalid Character");

  }

}
