package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {

    	Node<TrainCar> head = train.getHead();
    	
    	HashMap<String, Integer> nameToNumber = new HashMap<String, Integer>();
    	
    	
    	
    	
    	while(head != null) {
    		
    		
    		
    		String testimony = head.getValue().questionPassenger();
        	
        	String[] testimony_split = testimony.split(" ");
        	
        	
        	
        	
        	for(String x : clues) {
        		if(testimony.endsWith(x+".")) {  			
        			
        			//return testimony_split[13];
        			
        			String temp = testimony_split[13];
        			
        			if(! nameToNumber.containsKey(temp)) {
        				
        				nameToNumber.put(temp,1);
        			}
        			
        			else {
        				int temp2 = nameToNumber.get(temp);
        				nameToNumber.put(temp,temp2+1);
        			}
        			
        		}
        	}
        	     	
        	
        	
          	//for(String x : clues) {
        	//	System.out.println(x);
        	//}
        	
        	head = head.getNext();
    	}
    	
    	String maxSoFar = "";
		int maxSoFarNum = 0;
    	
    	for(Entry e : nameToNumber.entrySet()) {
    		
    		if((int) e.getValue() > maxSoFarNum) {
    			maxSoFarNum = (int) e.getValue();
    			maxSoFar = (String) e.getKey();
    		}
    		System.out.println(e.getKey() + " " + e.getValue());
    	}
    	
    	
    	
        return maxSoFar;

    }

}
