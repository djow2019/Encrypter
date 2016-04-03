import java.util.Random;

/**
 * @author Derek Class Name: Encrypter Description: Contains encrypt methods and
 *         decrypt methods for translating text
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
	 * Description: converts each character into its ascii, then assigns each
	 * digit to a character between the ascii code 33 and 49, which then
	 * determines how many times it should be repeated based on its divisibility
	 * by the maximum ascii value. The only real significant characters are the
	 * first character and the tilde, which separates characters for decrypting.
	 * 
	 * @param phrase
	 *            the phrase to encrypt
	 * @return the encrypted phrase
	 */
	public String encrypt(String phrase) {

		String result = "";

		for (int i = 0; i < phrase.length(); i++) {

			int ascii = (int) phrase.charAt(i);

			// first character it will be displayed as
			int character = (ascii % RANGE) + BOTTOM;

			// the number of times a filler character will be displayed
			// this tracks the number of times the range divides the ascii
			// + 1 is for the first initial character
			int times = ascii / RANGE + 1;

			for (int j = 0; j < times; j++) {
				result += (char) character;
				character = random.nextInt(END_ASCII - 1 - BOTTOM) + BOTTOM;
			}

			result += (char) END_ASCII;

		}

		return result;
	}

	/**
	 * Description:
	 * 
	 * @param phrase
	 *            the phrase to decrypt
	 * 
	 * @return the original phrase
	 */
	public String decrypt(String phrase) {

		String result = "";

		int index = 0;

		// processes the phrase until there are no characters left
		while (index < phrase.length()) {

			// the first ascii character
			int first = phrase.charAt(index++);
			
			// number of characters between the first character and the tilde
			int times = 0;

			try {
				while (phrase.charAt(index) != END_ASCII) {
					index++;
					times++;
				}
				// will throw an exception if there is no tilde
			} catch (Exception e) {
				System.err.println("The message was not properly encrypted");
				return "";
			}
			
			// translate the first character to the remainder, and add it to 
			// the number of times RANGE divided the ascii
			// then add the char to the result
			result += (char) ((first - BOTTOM) + (times * RANGE));

			// go to the next character after the tilde
			index++;

		}

		return result;
	}

}
