import java.io.*;
import java.util.Scanner;
public class BinaryEncoder {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("This is a binary encoder. Typer in your message and we will return you a binary version of it!");
		//getting the message from the user
		String code = console.nextLine();
		//this is the message returned to the user
		String binarymessage = "";	
		int lengthofmessage = code.length();
		int charvalue;
		
		//go through the entire code sequence
		for(int i = 0; i < lengthofmessage; i++) {
				//value of the character in ascii
				charvalue = (int) code.charAt(i);
					for(int j = 0; j < 8; j++) {
						if( j == 0) {
							if (charvalue >= 128 ) {
								binarymessage += '1';
								charvalue -= 128;
							} else {
								binarymessage += '0';
							}
						} else if (j == 1) {
							if (charvalue >= 64) {
								binarymessage += '1';
								charvalue -= 64;
							} else {
								binarymessage += '0';
							}
						} else if (j == 2) {
							if (charvalue >= 32) {
								binarymessage += '1';
								charvalue -= 32;
							} else {
								binarymessage += '0';
							}
				     	} else if (j == 3) {
						    if (charvalue >= 16) {
							binarymessage += '1';
							charvalue -= 16;
						    } else {
							   binarymessage += '0';
						  }	
				        } else if (j == 4) {
						    if (charvalue >= 8) {
							binarymessage += '1';
							charvalue -= 8;
						} else {
							binarymessage += '0';
						}
				       } else if (j == 5) {
						if (charvalue >= 4) {
							binarymessage += '1';
							charvalue -= 4;
						} else {
							binarymessage += '0';
						}
				      } else if (j == 6) {
						if (charvalue >= 2) {
							binarymessage += '1';
							charvalue -= 2;
						} else {
							binarymessage += '0';
						}
				 	} else if (j == 7) {
						if (charvalue >= 1) {
							binarymessage += '1';
							charvalue -= 1;
						} else {
							binarymessage += '0';
						}
				 	}
				}	
			}
		
		System.out.println(binarymessage);
	}
}
