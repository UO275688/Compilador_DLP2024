package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}

		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}

		return -1;
	}

	public static char lexemeToChar(String str) {
		if (str.equals("'\\n'")) {
			return '\n';
		} else if (str.equals("'\\t'")) {
			return '\t';
		} else if (str.charAt(1) == '\\') {
			try {
				return (char) Integer.parseInt(str.substring(2, str.length() - 1));
			} catch (NumberFormatException e) {
				System.out.println(e);
			}
		}
		return str.charAt(1);



		/*char[] chars = str.toCharArray();

		if(chars[1] == '\\'){
			if(chars[2] == 'n')
				return '\n';
			else if (chars[2] == 't')
				return '\t';
			else //ASCII
				return (char) Character.getNumericValue(Integer.parseInt(str.substring(2, str.length()-1)));
		}

		return chars[1];

		/*

		if(str.length() == 3)
			return str.charAt(1); // The second char is the digit o word

		// Remove the apostrophes ('')
		String charString = str.substring(1,str.length()-1);

		if(charString.equals("\\n"))
			return '\n';
		else if(charString.equals("\\t"))
			return '\t';
		else
			return (char) Integer.parseInt(charString.substring(1));*/
	}

}
