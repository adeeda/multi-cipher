package cipher;

import java.util.HashMap;

public class Morse {
	private HashMap<Character, String> morseMap;
	private HashMap<String, Character> reverseMap;
	private String currentChar;
	
	public Morse () {
		// Make a hashmap
		morseMap = new HashMap<Character, String>();
		morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c',  "-.-.");
        morseMap.put('d',  "-..");
        morseMap.put('e',    ".");
        morseMap.put('f', "..-.");
        morseMap.put('g',  "--.");
        morseMap.put('h', "....");
        morseMap.put('i',   "..");
        morseMap.put('j', ".---");
        morseMap.put('k',   "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m',   "--");
        morseMap.put('n',   "-.");
        morseMap.put('o',  "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s',  "...");
        morseMap.put('t',   "-");
        morseMap.put('u',  "..-");
        morseMap.put('v', "...-");
        morseMap.put('w',  ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");
        morseMap.put('1', ".----");
        morseMap.put('2',"..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");
        morseMap.put('0', "-----");
        
        reverseMap = new HashMap<String, Character>();
		reverseMap.put(".-",'a');
        reverseMap.put("-...", 'b');
        reverseMap.put("-.-.",  'c');
        reverseMap.put("-..",  'd');
        reverseMap.put(".",    'e');
        reverseMap.put("..-.", 'f');
        reverseMap.put("--.",  'g');
        reverseMap.put("....", 'h');
        reverseMap.put("..",   'i');
        reverseMap.put(".---", 'j');
        reverseMap.put("-.-",   'k');
        reverseMap.put(".-..", 'l');
        reverseMap.put("--",   'm');
        reverseMap.put("-.",   'n');
        reverseMap.put("---",  'o');
        reverseMap.put(".--.", 'p');
        reverseMap.put("--.-", 'q');
        reverseMap.put(".-.", 'r');
        reverseMap.put("...",  's');
        reverseMap.put("-",   't');
        reverseMap.put("..-",  'u');
        reverseMap.put("...-", 'v');
        reverseMap.put(".--",  'w');
        reverseMap.put("-..-", 'x');
        reverseMap.put("-.--", 'y');
        reverseMap.put("--..", 'z');
        reverseMap.put(".----", '1');
        reverseMap.put("..---",'2');
        reverseMap.put("...--", '3');
        reverseMap.put("....-", '4');
        reverseMap.put(".....", '5');
        reverseMap.put("-....", '6');
        reverseMap.put("--...", '7');
        reverseMap.put("---..", '8');
        reverseMap.put("----.", '9');
        reverseMap.put("-----", '0');
	}
	
	public String encrypt(String inputText) {
		String outputText = "";
		inputText = inputText.toLowerCase();
		for(int j=0; j<inputText.length(); j++){
			char character = inputText.charAt(j);
			if ( (character >= 97 & character <= 122) | (character >= 48 & character <= 57) ) {
				outputText = outputText.concat(morseMap.get(character));
				outputText += ' ';
			}
		}
		return outputText;
	}
	
	public String decrypt(String inputText) {
		String outputText = "";
		currentChar = "";
		for (int i=0; i<inputText.length(); i++) {
			char input = inputText.charAt(i);
			if (input == '.' | input == '-') {
				currentChar += input;
			}
			else if (input == ' ') {
				if (currentChar != "") {
					outputText += reverseMap.get(currentChar);
					currentChar = "";
				}
			}
		}
		return outputText.toUpperCase();
	}
}
