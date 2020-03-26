/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailycodingproblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author s.rana
 */
public class Problem1 {

    public void solveProblem() {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();

        int data[] = new int[arrayLength];
        int i;

        for (i = 0; i < arrayLength; i++) {
            data[i] = scanner.nextInt();
        }

        int number = scanner.nextInt();

        if (checkIfAnyTwoAddUpToNumberBruteForce(data, number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("False");
        }

        if (checkIfAnyTwoAddUpToNumberHashTable(data, number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("False");
        }
        
        if (checkIfAnyTwoAddUpToNumberSortedArray(data, number)) {
            System.out.println("TRUE");
        } else {
            System.out.println("False");
        }

    }

    private boolean checkIfAnyTwoAddUpToNumberBruteForce(int[] data, int number) {

        System.out.println("checkIfAnyTwoAddUpToNumberBruteForce start " + System.currentTimeMillis());

        int arrLength = data.length;
        int i, j;
        for (i = 0; i < arrLength - 1; i++) {
            for (j = i + 1; j < arrLength; j++) {
                if (data[i] + data[j] == number) {
                    System.out.println("checkIfAnyTwoAddUpToNumberBruteForce end " + System.currentTimeMillis());
                    return true;
                }
            }
        }

        System.out.println("checkIfAnyTwoAddUpToNumberBruteForce end " + System.currentTimeMillis());
        return false;
    }

    private boolean checkIfAnyTwoAddUpToNumberHashTable(int[] data, int number) {
        System.out.println("checkIfAnyTwoAddUpToNumberHashTable start " + System.currentTimeMillis());

        int arrLength = data.length;
        int i;

        HashSet<Integer> set = new HashSet<>();

        for (i = 0; i < arrLength; i++) {
            if (set.contains(data[i])) {
                System.out.println("checkIfAnyTwoAddUpToNumberHashTable end " + System.currentTimeMillis());
                return true;
            } else {
                set.add(number - data[i]);
            }
        }

        System.out.println("checkIfAnyTwoAddUpToNumberHashTable end " + System.currentTimeMillis());
        return false;
    }
    
        private boolean checkIfAnyTwoAddUpToNumberSortedArray(int[] data, int number) {
            
        Arrays.sort(data);
            
        System.out.println("checkIfAnyTwoAddUpToNumberSortedArray start " + System.currentTimeMillis());

        int arrLength = data.length;
        int i = 0; int j =  arrLength-1;;

        while (i<j) {
            if(data[i]+data[j]==number){
                System.out.println("checkIfAnyTwoAddUpToNumberSortedArray end " + System.currentTimeMillis());
                return true;
            }else if(data[i]+data[j]>number){
                j--;
            }else{
                i++;
            }
        }

        System.out.println("checkIfAnyTwoAddUpToNumberSortedArray end " + System.currentTimeMillis());
        return false;
    }
}
