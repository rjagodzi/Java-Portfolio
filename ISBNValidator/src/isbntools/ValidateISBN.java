package isbntools;

public class ValidateISBN {

	private static final int LONG_ISBN_MULTIPLIER = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int SHORT_ISBN = 10;
	private static final int LONG_ISBN = 13;

	public boolean checkISBN(String isbn) {

		if (isbn.length() == LONG_ISBN) {
			return validateALongISBN(isbn);
		} else if (isbn.length() == SHORT_ISBN) {
			return validateAShortISBN(isbn);

//		if (isbn.matches("(?=.*[a-z]")) throw new NumberFormatException("ISBN numbers must all contain numbers");

		}
		throw new NumberFormatException("ISBN numbers must be ten or thirteen digits long");
	}

	private boolean validateAShortISBN(String isbn) {
		int total = 0;

		for (int i = 0; i < SHORT_ISBN; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				} else {
					throw new NumberFormatException("ISBN numbers can only contain numeral digits ");
				}

			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN - i);
			}

		}

		return (total % SHORT_ISBN_MULTIPLIER == 0);

	}

	private boolean validateALongISBN(String isbn) {
		int total = 0;

		for (int i = 0; i < LONG_ISBN; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		return (total % LONG_ISBN_MULTIPLIER == 0);

	}

}
