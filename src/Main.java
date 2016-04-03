import java.util.Scanner;

/**
 * @author Derek
 * Main class that runs the program
 */
public class Main {

	/**
	 * First method that is called when executing this program
	 * @param args run time arguments
	 */
	public static void main(String[] args) {

		// reads input
		Scanner scanner = new Scanner(System.in);

		// determines if the input will encrypt or decrypt
		boolean encrypt = true;

		// sets the encrypt mode
		System.out.println("Type e for encrypt mode or d for decrypt mode: ");
		if (scanner.next().equals("d")) {
			System.out.println("Decrypt Mode");
			encrypt = false;
		} else {
			System.out.println("Encrypt Mode");
			encrypt = true;
		}
		// flush the buffer
		scanner.nextLine();

		System.out.println("Enter a phrase to translate: ");

		String input = scanner.nextLine();

		Encrypter encrypter = new Encrypter();

		// constantly runs until input is blank
		while (!input.equals("")) {

			// either encrypts or decrypts the data
			if (encrypt)
				System.out.println(encrypter.encrypt(input));
			else
				System.out.println(encrypter.decrypt(input));

			// sets the encrypt mode
			System.out.println("Type e for encrypt mode or d for decrypt mode: ");
			if (scanner.next().equals("d")) {
				System.out.println("Decrypt Mode");
				encrypt = false;
			} else {
				System.out.println("Encrypt Mode");
				encrypt = true;
			}
			// flush the buffer
			scanner.nextLine();

			System.out.println("Enter a phrase: ");

			input = scanner.nextLine();
		}

		scanner.close();

	}

}
