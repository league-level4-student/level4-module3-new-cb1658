package _05_Intro_to_AVL_Trees;

import java.util.Random;

import _03_Intro_to_Binary_Trees.BinaryTree;

public class AVLTreeDemo {

    /*
     * An AVLTree is a special BinaryTree that is capable of balancing itself.
     * With a regular binary tree, depending on the elements inserted, you might
     * have a root with one very long right branch and one very long left branch
     * with nothing else in between.
     * 
     * 1.) Read through the AVLNode and AVLTree. Notice that the methods are
     * similar to those in BinaryTree with two important distinctions:
     * 
     * a) Each Node has a balance factor that keeps track of how many levels
     * "down" it is relative to the rest of the tree.
     * 
     * b) There are "rotate" helper methods used when a given node gets too
     * unbalanced(> 1 level out of sync with the rest of the tree) to rotate
     * branches back into place.
     * 
     * 2.) Create a BinaryTree and an AVLTree.
     * 
     * 3.) Insert the same values into both trees and observe how they differ
     * using the print method. Make sure the values you pick unbalance the
     * binary tree.
     * 
     * 4.) Try removing elements from both and see how they change using one of
     * the print methods.
     */

    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree();
    	AVLTree avl = new AVLTree();
    	
    	tree.insert(0);
    	tree.insert(-1);
    	tree.insert(-3);
    	tree.insert(-100);
    	tree.insert(-200);
    	
    	
    	avl.insert(0);
    	avl.insert(-1);
    	avl.insert(-3);
    	avl.insert(-100);
    	avl.insert(-200);
    	
    	
    	tree.printHorizontal();
    	
    	
    	
    	avl.printHorizontal();
    	
    }

}
