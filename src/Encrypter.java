
/* Class Name: Encrypter
 * Description: Contains
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
				character = ((character + 1) % RANGE) + BOTTOM;
			}

			result += (char) END_ASCII;

		}

		return result;
	}

}
