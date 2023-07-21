package _04_Morse_Code;


import java.util.Scanner;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;

public class MorseDecoder {

    BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

    public static void main(String[] args) {

        MorseDecoder md = new MorseDecoder();
        md.initialize();
        
        // md.decode();
        
        md.translate();

    }

    public void initialize() {

        mcTree.insert(new MorseCode("start", ""));
        mcTree.insert(new MorseCode("e", "."));
        mcTree.insert(new MorseCode("t", "-"));

        mcTree.insert(new MorseCode("i", ".."));
        mcTree.insert(new MorseCode("a", ".-"));
        mcTree.insert(new MorseCode("n", "-."));
        mcTree.insert(new MorseCode("m", "--"));

        mcTree.insert(new MorseCode("s", "..."));
        mcTree.insert(new MorseCode("u", "..-"));
        mcTree.insert(new MorseCode("r", ".-."));
        mcTree.insert(new MorseCode("w", ".--"));
        mcTree.insert(new MorseCode("d", "-.."));
        mcTree.insert(new MorseCode("k", "-.-"));
        mcTree.insert(new MorseCode("g", "--."));
        mcTree.insert(new MorseCode("o", "---"));

        mcTree.insert(new MorseCode("h", "...."));
        mcTree.insert(new MorseCode("v", "...-"));
        mcTree.insert(new MorseCode("f", "..-."));
        mcTree.insert(new MorseCode("l", ".-.."));
        mcTree.insert(new MorseCode("p", ".--."));
        mcTree.insert(new MorseCode("j", ".---"));
        mcTree.insert(new MorseCode("b", "-..."));
        mcTree.insert(new MorseCode("x", "-..-"));
        mcTree.insert(new MorseCode("c", "-.-."));
        mcTree.insert(new MorseCode("y", "-.--"));
        mcTree.insert(new MorseCode("z", "--.."));
        mcTree.insert(new MorseCode("q", "--.-"));

        mcTree.printVertical();

    }

    /*
     * 1.) See if you can decode the following message using the binary tree and
     * print it to the console:
     * 
     * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
     * 
     * 
     * 2.) Then use the binary tree and the scanner class to create a morse code
     * translator. The user should be able to type multiple letters in morse
     * code on a single line and have it repeated back to them, decoded into the
     * english alphabet.
     * 
     */
    void decode() {
    	
    	    	   	
    	String morseCode = ". . . . . . .";
        	
    	String[] split = morseCode.split(" ");
    	
    	
    	
    	StringBuilder bob = new StringBuilder();
    	
    	
    	
    	for(int i = 0; i < split.length; i++) {
    		
    		Node<MorseCode> temp = mcTree.search(new MorseCode(split[i]));
    		
    		// System.out.println(temp.getValue());
    		
    		bob.append(temp.getValue());
    	}
    	
    	System.out.println(bob);
    	
    }
    
    
    
    void translate() {
    		
    	Scanner scan = new Scanner(System.in);
    	
    	
    	boolean doAgain = true;
    	
    	while(doAgain) {
    	
	    	System.out.println("Enter morse code:");
	        
	    	String morseCode = scan.nextLine();
	    	
	    	String[] split = morseCode.split(" ");
	    	
	    	
	    	
	    	StringBuilder bob = new StringBuilder();
	    	
	    	
	    	
	    	for(String s : split) {
	    		
	    		Node<MorseCode> temp = mcTree.search(new MorseCode(s));
	    		
	    		// System.out.println(temp.getValue());
	    		
	    		bob.append(temp.getValue());
	    	}
	    	
	    	System.out.println(bob);
	    	
	    	System.out.println("Do you want to translate again? (y/n)");
	    	
	    	String result = scan.nextLine();
	    	
	    	if(result.equals("y")) {
	    		doAgain = true;
	    	}
	    	else {
	    		doAgain = false;
	    	}
    	
    	}
        
    	
        scan.close();
    }

}
