

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
	for (int i=0; i < plainText.length(); i++) {
			char x = plainText.charAt(i);
			if (x < LOWER_BOUND || x > UPPER_BOUND)
		{
			return false;
		}
		
	}
	return true;
	}
	

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		String encryptedText = "" ;  
		 for (int i = 0; i < plainText.length(); i++) {
		        // Get the ASCII value of the current character
		        int asciiValue = (int) plainText.charAt(i);
		        asciiValue = (asciiValue + key);
		        // If the character is uppercase, shift it by the key
		        while (asciiValue > UPPER_BOUND) { 
		            asciiValue = (asciiValue) - RANGE;
		        }

		        // Append the encrypted character to the encrypted text
		        encryptedText += (char) asciiValue;
		    }

		    return encryptedText;
		}
	
	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each characater in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
	    String  encryptedText = "";
	    int bellaso = bellasoStr.length();
	    int plainAscii;
	    int bellasoAscii;
	    int encryptedAscii =0;
	 
	    for (int i = 0; i < plainText.length(); i++) {
	        // get the ASCII values of the plain text and bellaso strings' characters
	        plainAscii = (int) plainText.charAt(i);
	        bellasoAscii = (int) bellasoStr.charAt(i % bellaso);
	        
	        // calculate the encrypted character's ASCII value
	        
	        encryptedAscii = (plainAscii + bellasoAscii);
	        while (encryptedAscii > UPPER_BOUND) { 
	        	encryptedAscii = (encryptedAscii) - RANGE;
	        }
	        encryptedText += (char)encryptedAscii;
	        
	        // add the encrypted character to the result
	        
	    }
	    return encryptedText;//.toString();
	}
	
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		    String decryptedText = " ";
		    for (int i = 0; i < encryptedText.length(); i++) {
		        //char encryptedChar = encryptedText.charAt(i);
		        //char decryptedChar;
		        int asciiValue = (int) encryptedText.charAt(i);
		        asciiValue = (asciiValue - key);
		        // If the character is uppercase, shift it by the key
		        while (asciiValue < LOWER_BOUND) { 
		            asciiValue = (asciiValue) + RANGE;
		        }
		        decryptedText += (char) asciiValue;
		    }
		    return decryptedText;
		}
	
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		    String decryptedText = "";
		    int bellasoLen = bellasoStr.length();
		    int bellaso;
		    int  encryptedChar;
		    int bellasoInt;
		    for (int i = 0; i < encryptedText.length(); i++) {
		        encryptedChar = (int) encryptedText.charAt(i);
		        bellaso = (int) bellasoStr.charAt(i % bellasoLen);
		        
		        bellasoInt = (encryptedChar - bellaso);
		        while (bellasoInt < LOWER_BOUND) { 
		        	bellasoInt = (bellasoInt) + RANGE;
		        }
		        decryptedText += (char)bellasoInt;
		        
		       
		    }
		    return decryptedText;
		}
	}

