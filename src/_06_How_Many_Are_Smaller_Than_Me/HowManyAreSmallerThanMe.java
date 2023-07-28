package _06_How_Many_Are_Smaller_Than_Me;

import _03_Intro_to_Binary_Trees.Node;
import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {

    	Node<Integer> root = avlTree.getRoot();
    	
    	if(root.getValue() < me) {
    		return BFS(root,me) + 1;
    	}
    	
    	else {
    		return BFS(root,me);
    	}

    }
    
    public int BFS(Node<Integer> node, int me) {
    	Node<Integer> left = node.getLeft();
    	Node<Integer> right = node.getRight();
    	
    	
    	int smallerThanMe = 0;
    	
    	
    	if(right != null && left != null && right.getValue() < me) {
    		smallerThanMe = smallerThanMe+2;
    	}
    	
    	if((right == null && left != null) ||
    			(left == null && right != null && right.getValue() < me)) {
    		smallerThanMe++;
    	}
    	
    	
    	
    	
    	
    	if(left != null && right != null) {
    		
    		System.out.println(left.getValue());
    		System.out.println(right.getValue());
    		
    		return smallerThanMe + BFS(left,me) + BFS(right,me);
    		
        	}
    	
    	if(left != null && right == null) {
    		System.out.println(left.getValue());
    		
    		return smallerThanMe + BFS(left,me);
    	}
    	
    	if(left == null && right != null) {
    		System.out.println(right.getValue());
    		
    		return smallerThanMe + BFS(right, me);
    	}
    	
    	else {
    		return smallerThanMe;
    	}
    	
    }
}
