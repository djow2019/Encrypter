import java.util.Random;

/**
 * @author Derek
 * Class Name: Encrypter 
 * Description: Contains encrypt methods and decrypt
 * methods for translating text
 */
public class Encrypter {

	// lower ascii
	public static final int BOTTOM = 33;

	// upper ascii
	public static final int TOP = 49;

	// base 16
	public static final int RANGE = TOP - BOTTOM;

	// highest ascii value, must be a multiple of base
	public static final int MAX_ASCII = 256;

	// separates characters, ~
	public static final int END_ASCII = 126;
	
	private Random random = new Random();

	/**
	 * Description: converts each character into its ascii, then 
	 * assigns each digit to a character between the ascii code 33 and 49, which
	 * then determines how many times it should be repeated based on its divisibility
	 * by the maximum ascii value. The only real significant characters are the first
	 * character and the tilde, which separates characters for decrypting.
	 * @param phrase the phrase to encrypt
	 * @return the encrypted phrase
	 */
	public String encrypt(String phrase) {

		String result = "";

		for (int i = 0; i < phrase.length(); i++) {

			int ascii = (int) phrase.charAt(i);

			// which character it will be displayed as
			int character = (ascii % RANGE) + BOTTOM;

			// the number of times that character will be displayed
			int times = ascii / RANGE + 1;

			for (int j = 0; j < times; j++) {
				result += (char) character;
				character = random.nextInt(MAX_ASCII);
			}

			result += (char) END_ASCII;

		}

		return result;
	}

}
