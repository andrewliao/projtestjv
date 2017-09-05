import java.util.Scanner;

public class BinaryDecoder {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Please input your binary message!");
		String binarymessage = console.nextLine();
		
		//test if the message is valid, when converted to ascii it is 8 bits of characters
		boolean result = false;
		if(binarymessage.length() % 8 != 0) {
			System.out.println("Invalid binary message!");
		} else {
			result = true;
		}
		
		if(result) {
			System.out.println(convertToMessage(binarymessage));
		}
		
		
		
	}
	
	public static String convertToMessage(String binaryMessage) {
		int lengthOfMessage = binaryMessage.length();
		int numberOfLoops = lengthOfMessage / 8;
		String returnMessage = "";
		int numberofletter = 0;
		char ch;
		
		//loop through and add to the string return message
		for(int i = 0; i < numberOfLoops; i++) {
				//you want to loop through each of the 8 numbers that represent the letter
				for(int j = 0; j < 8; j++) {
					//find out if the character is one or 0
					if (binaryMessage.charAt(i * 8 + j) == '1' ) {
						if(j == 0) {
							numberofletter += 128;
						} else if(j == 1) {
							numberofletter += 64;
						} else if(j == 2) {
							numberofletter += 32;
						} else if(j == 3) {
							numberofletter += 16;
						} else if(j == 4 ) {
							numberofletter += 8;
						} else if(j == 5) {
							numberofletter += 4;
						} else if(j == 6) {
							numberofletter += 2;
						} else if (j == 7) {
							numberofletter += 1;
							//check the number at the end of the loop to convert to a letter
							ch = (char) numberofletter;  
							returnMessage += ch;
							numberofletter = 0;
						}
					} else {
						if(j == 7) {
							//check the number at the end of the loop to convert to a letter
							ch = (char) numberofletter;
							returnMessage += ch;
							numberofletter = 0;	
							continue;
					}	
				}	
			}
		}
			return returnMessage;

	}
}
