package cipher;

import java.util.HashMap;

public class Caesar {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String numbers = "0123456789";
	
	public String encrypt(String inputText, int shift) {
		//Create a HashMap
		//A hash map takes keys and values, which are both Characters in this case.
		HashMap<Character, Character> alphaMap = new HashMap<Character, Character>();
		//Map every letter of the alphabet to another letter in the alphabet, shifted by x places.
		for(int i=0; i<alphabet.length(); i++){
			alphaMap.put(alphabet.charAt(i), alphabet.charAt((i+shift)%26));
			alphaMap.put(ALPHABET.charAt(i), ALPHABET.charAt((i+shift)%26));
			if (i<numbers.length()) {
				alphaMap.put(numbers.charAt(i), numbers.charAt((i+shift)%10));
			}
		}
		//Get input text and put it all to lower-case so it's easy to convert
		String outputText = "";
		//Go to each letter and switch it with it's shifted counterpart
		for(int j=0; j<inputText.length(); j++){
			char character = inputText.charAt(j);
			if ( (character >= 65 & character <= 90) | (character >= 97 & character <= 122) | (character >= 48 & character <= 57) ) {
				outputText = outputText.concat(alphaMap.get(character).toString());
			} else {
				outputText += character;
			}
		}
		//Output the encrypted text
		return outputText;
	}
	
	public String decrypt(String inputText, int shift) {
		HashMap<Character, Character> alphaMap = new HashMap<Character, Character>();
		for(int i=0; i<alphabet.length(); i++){
			alphaMap.put(alphabet.charAt((i+shift)%26), alphabet.charAt(i));
			alphaMap.put(ALPHABET.charAt((i+shift)%26), ALPHABET.charAt(i));
			if (i<numbers.length()) {
				alphaMap.put(numbers.charAt((i+shift)%10), numbers.charAt(i));
			}
		}
		String outputText = "";
		for(int j=0; j<inputText.length(); j++){
			char character = inputText.charAt(j);
			if ( (character >= 65 & character <= 90) | (character >= 97 & character <= 122) | (character >= 48 & character <= 57) ) {
				outputText = outputText.concat(alphaMap.get(character).toString());
			} else {
				outputText += character;
			}
		}
		return outputText;
	}
}
