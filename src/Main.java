import java.util.Scanner;

public class Main {

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

		Encrypter encryptor = new Encrypter();

		// constantly runs until input is blank
		while (!input.equals("")) {

			if (encrypt)
				System.out.println(encryptor.encrypt(input));

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
