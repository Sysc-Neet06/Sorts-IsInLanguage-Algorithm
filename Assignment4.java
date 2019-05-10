
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Neethan's PC
 */
public class Assignment4 {

    /**
     * Method is a selectionSort algorithm that starts from one side and moves
     * the largest number to the right side
     *
     * @param <T>
     * @param theArray The array that is used
     * @param n the size of the array
     */
    public static <T extends Comparable<? super T>>
            void recursiveSelectionSort(T[] theArray, int n) {

        if (n == 0) // if the whole array has been sorted do nothing
        {
        } else {
            int index = 0; // keeps track of which spot were swapping
            for (int i = 0; i < n; i++) {
                if (theArray[i].compareTo(theArray[index]) >= 0)// compares the two indexed to find the largest value 
                {
                    index = i; // saves that index in index
                }
            }

            T Temp = theArray[n - 1]; // temp variable used to store the last element
            theArray[n - 1] = theArray[index]; // the last index is used to store the largest number
            theArray[index] = Temp; // the index that was swapped now stores the temp variable value

            recursiveSelectionSort(theArray, n - 1); // recursive call for selectionsort
        }
    }

    /**
     * BubbleSort algorithm that swaps adjacent pairs from lowest to greatest
     *
     * @param <T>
     * @param theArray the array
     * @param n the size of the array
     */
    public static <T extends Comparable<? super T>>
            void recursiveBubbleSort(T[] theArray, int n) {
        int count = 0; // sets the count to zero
        for (int i = 0; i < n - 1; i++) {
            if (theArray[i].compareTo(theArray[i + 1]) < 1) // compares the two adjacent pairs
            {
                count++; //increments count
            }

        }
        if (count == theArray.length) {
            // the array is sorted so we do nothing
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (theArray[count].compareTo(theArray[count + 1]) >= 1) // if the index being referenced is bigger than the adjacent one then swap
                {
                    //swap code
                    T temp = theArray[i];
                    theArray[i] = theArray[i + 1];
                    theArray[i + 1] = temp;
                }
            }
            recursiveBubbleSort(theArray, n - 1); // recursive call
        }
    }

    /**
     * Recognition method to see if its in the language defined in the pdf
     *
     * @param str is a string
     * @return a boolean term either true or false
     */
    public static boolean isInLanguage(String str) {
        Queue queue = new LinkedList(); // initializing a que
        Stack<Character> stack = new Stack<Character>(); // initializing a stack

        int mid = str.length() / 2; // finds the middle index value of the string

        // if string is length one check to see if its the middle character needed to be in the language
        if (str.length() == 1) {
            return str.compareTo("$") == 0;
        }
        // if its divisible by 2 it cant be in the language cause only cares about odd numbers strings
        if (str.length() % 2 == 0) {
            return false;
        } // if the middle character is not the dollar sign returns false
        else if (str.charAt(mid) != '$') {
            return false;
        } //otherwise check the string
        else {
            // adds the respective sides to a que and stack
            for (int i = 0; i < mid; i++) {
                queue.add(str.charAt(i));
                stack.add(str.charAt(i + mid + 1));
            }
            // removes a character from both stacks and que to check if they equal
            for (int i = 0; i < mid; i++) {
                if (queue.remove().equals(stack.pop()) == false) {
                    return false;
                }
            }
            return true; // returns true
        }
    }

    /**
     *
     * @param str string inputted by user
     * @return returns the integer version of the string without spaces
     */
    public static int convertToNumber(String str) {
        Queue<Integer> que = new LinkedList<Integer>(); // initialize queue
        char[] chars = str.toCharArray(); // initialize a character array

        for (int i = 0; i < chars.length; i++) // iterate through the character array
        {
            if (chars[i] != ' ' && !Character.isDigit(chars[i])) // checks if illegal stuff has been put in
            {
                throw new IllegalArgumentException("Must be a digit or blank space"); // throws exception if so
            } 
            else if (chars[i] != ' ' && Character.isDigit(chars[i])) // checks the correct stuff 
            {
                que.add(Integer.parseInt(String.valueOf(chars[i]))); // adds it to the que
            }
        }

        int number = 0; // sets final number to zero
        while (!que.isEmpty()) // while the queue still exsists 
        {
            number = number + (int) (que.remove() * Math.pow(10, que.size())); // converts the number
        }
        return number;// returns number;
    }
}

    