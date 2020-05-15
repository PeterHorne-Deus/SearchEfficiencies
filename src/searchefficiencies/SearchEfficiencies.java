/*
 * Peter Horne-Deus
 * This program calculates the efficency of different searching algorithms
 * SearchEfficencies.java
 * May 14, 2020
 */

package searchefficiencies;

import javax.swing.*;
import java.util.Arrays;

/**
 *
 * @author Peter
 */
public class SearchEfficiencies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int toGenerate = Integer.parseInt(JOptionPane.showInputDialog("Enter the "
                + " number of random numbers you \n "
                + "would like generated"));
        int[] randomNums = randomNum(toGenerate);
        int key = Integer.parseInt(JOptionPane.showInputDialog("What number are "
                + "you searching for?"));
        linear(randomNums,key);
        sortedLinear(randomNums,key);
        binary(randomNums,key);
    }
    
    /**
     * This method generates random numbers between 1 - 1000
     * @param toGenerate
     * @return 
     */
    public static int[] randomNum(int toGenerate){
        //Varaibles
        int[] numbers = new int[toGenerate];
        
        //Ensuring inputed data is suitable
        if(toGenerate <= 0){
            System.out.println("Incorrect range");
            return numbers;
        }
        else{
            //Generating the random numbers
            System.out.println("Here are the numbers:");
            for(int i = 0; i < toGenerate; i++){
                numbers[i] = (int)(Math.random()*1000 + 1);
                System.out.println(numbers[i]);
            }
        }
        return numbers;
    }
    
    /**
     * This program linear searches through an unsorted list for a key with linear search
     * @param randomNums
     * @param key 
     */
    public static void linear(int[] randomNums, int key){
        //Varaibles
        long startTime = System.nanoTime();
        int comparisons = 0;
        int loops = 0;
        boolean found = false;
        
        //Checking one by one for the key (Linear Searching)
        for(int i = 0; i < randomNums.length; i++){
            //Adding to the comparisons and loops counter
            comparisons ++;
            loops++;
            //Finding the key 
            if(randomNums[i] == key){
                found = true;
                break;
            }
        }
        //Finishing the time tracking
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        
        //Final Output
        System.out.println("\n");
        System.out.println("Linear (unsorted)");
        System.out.println("------------------");
        System.out.println("Number found = " + found);
        System.out.println("Number of loops = " + loops);
        System.out.println("Number of comparisons = " + comparisons);
        System.out.println("Time to complete = " + time / 1000000 + "ms");
    }
    
    /**
     * This method linear searches through a sorted list
     * @param randomNums
     * @param key 
     */
    public static void sortedLinear(int[] randomNums, int key){
        //Sorting the random numbers
        Arrays.sort(randomNums);
        
        //Varaibles
        long startTime = System.nanoTime();
        int comparisons = 0;
        int loops = 0;
        boolean found = false;
        
        //Checking one by one for the key (Linear Searching)
        for(int i = 0; i < randomNums.length; i++){
            //Adding to the comparisons and loops counter
            comparisons ++;
            loops++;
            //Finding the key 
            if(randomNums[i] == key){
                found = true;
                break;
            }
        }
        //Finishing the time tracking
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        
        //Final Output
        System.out.println("\n");
        System.out.println("Linear (sorted)");
        System.out.println("------------------");
        System.out.println("Number found = " + found);
        System.out.println("Number of loops = " + loops);
        System.out.println("Number of comparisons = " + comparisons);
        System.out.println("Time to complete = " + time / 1000000 + "ms");
    }
    
    /**
     * This method complete a binary search for the key
     * @param randomNums
     * @param key 
     */
    public static void binary(int[] randomNums, int key){
        //Sorting the random numbers
        Arrays.sort(randomNums);
        
        //Variables
        int comparisons = 0;
        int loops = 0;
        boolean found = false;
        int low = 0;
        int high = randomNums.length - 1;
        
        //Tracking time to exicute search
        long startTime = System.nanoTime();
        
        //Completing the binary search
        while(low <= high)
        {
            loops++;
            
            int mid = (low + high) / 2;
            int cur = randomNums[mid];
            
            if(cur == key)
            {
                comparisons++;
                found = true;
                break;
            }
            else if(cur < key)
            {
                comparisons = comparisons +2;
                low = mid + 1;
            }
            else
            {
                comparisons = comparisons +3;
                high = mid - 1;
            }
        }
        
        //Finishing time tracking
        long endTime = System.nanoTime();
        long time = endTime-startTime;
        
        //Final output
        System.out.println("\n");
        System.out.println("Binary");
        System.out.println("------------------");
        System.out.println("Number found = " + found);
        System.out.println("Number of loops = " + loops);
        System.out.println("Number of comparisons = " + comparisons);
        System.out.println("Time to complete = " + time / 1000000 + "ms");
    }
}
