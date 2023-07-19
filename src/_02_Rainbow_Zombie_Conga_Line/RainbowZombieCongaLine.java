package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	
    	Node<Zombie> temp = congaLine.getHead();
    	
    	Node<Zombie> newNode = new Node<Zombie>(dancer); 
    	
    	temp.setPrev(newNode);
    	
    	newNode.setNext(temp);
    	
    	congaLine.setHead(newNode);
    	
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {

    	Node<Zombie> temp = congaLine.getTail();
    	
    	Node<Zombie> newNode = new Node<Zombie>(dancer);
    	
    	temp.setNext(newNode);
    	
    	newNode.setPrev(temp);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	
    	Node<Zombie> oldPrev = congaLine.getHead();
    	
    	for(int i = 0; i < position; i++) {
    		oldPrev = oldPrev.getNext();
    	}
    	
    	Node<Zombie> oldNext = congaLine.getHead();
    	
    	for(int i = 0; i < position+1; i++) {
    		oldNext = oldNext.getNext();
    	}
    	
    	Node<Zombie> newNode = new Node<Zombie>(dancer);
    	
    	oldPrev.setNext(newNode);
    	newNode.setPrev(oldPrev);
    	
    	oldNext.setPrev(newNode);
    	newNode.setNext(oldNext);
    }

    
    
    
    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	ZombieHatColor color = dancer.getZombieHatColor();
    	
    	Node<Zombie> temp = congaLine.getHead();
    	
    	for(int i = 0; i < congaLine.size(); i++) {
    		if(temp.getValue().getZombieHatColor() == color) {
    			congaLine.remove(i);
    		}
    		else {
    			temp = temp.getNext();
    		}
    		
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> temp = congaLine.getHead();
    	
    	ZombieHatColor color = dancer.getZombieHatColor();
    	
    	boolean killedZombie = false;
    	
    	int position = 0;
    	
    	while(!killedZombie) {
    		
    		if(temp.getValue().getZombieHatColor() == color) {
    			congaLine.remove(position);
    			killedZombie = true;
    		}
    		else {
    			position++;
    			temp = temp.getNext();
    		}
    		
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	
    	ZombieHatColor color = dancer.getZombieHatColor();
    	
    	// Adding one to the front //
    	
    	Node<Zombie> temp = congaLine.getHead();
    	
    	Node<Zombie> newNode = new Node<Zombie>(dancer); 
    	
    	temp.setPrev(newNode);
    	
    	newNode.setNext(temp);
    	
    	congaLine.setHead(newNode);
    	
    	// Adding one to the back //
    	
    	Node<Zombie> temp2 = congaLine.getTail();
    	
    	Node<Zombie> newNode2 = new Node<Zombie>(dancer);
    	
    	temp.setNext(newNode2);
    	
    	newNode.setPrev(temp2);
    	
    	// Adding one in the middle //
    	
    	jumpInTheLine(dancer, (int) Math.ceil(congaLine.size()/2) );
    	
    	
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	if(congaLine.getHead() != null) {
    		Node<Zombie> temp = congaLine.getHead();
        	
        	Node<Zombie> newNode = new Node<Zombie>(dancer); 
        	
        	temp.setPrev(newNode);
        	
        	newNode.setNext(temp);
        	
        	congaLine.setHead(newNode);
        	
        	
        	// Do everything else
    	}
    	
    	else {
    		Node<Zombie> newNode = new Node<Zombie>(dancer); 
    		congaLine.setHead(newNode);
    		
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
