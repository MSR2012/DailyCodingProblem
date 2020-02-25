/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailycodingproblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author s.rana
 */
public class Problem4 {

    public void solveProblem() {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();

        int data[] = new int[arrayLength];
        int i;

        for (i = 0; i < arrayLength; i++) {
            data[i] = scanner.nextInt();
        }

        int lowestPositiveInteger;

        lowestPositiveInteger = getLowestPositiveIntegerBruteForce(data);

        System.out.println(lowestPositiveInteger);

        lowestPositiveInteger = getLowestPositiveIntegerHashTable(data);

        System.out.println(lowestPositiveInteger);

        lowestPositiveInteger = getLowestPositiveIntegerSort(data);

        System.out.println(lowestPositiveInteger);
        lowestPositiveInteger = getLowestPositiveIntegerSegregatePositiveAndNegative(data);

        System.out.println(lowestPositiveInteger);
    }

    private int getLowestPositiveIntegerBruteForce(int[] data) {

        System.out.println("getLowestPositiveIntegerBruteForce start " + System.currentTimeMillis());

        int arrayLength = data.length;

        int i;

        int maxValue = -1;

        for (i = 0; i < arrayLength; i++) {
            if (data[i] > maxValue) {
                maxValue = data[i];
            }
        }

        if (maxValue <= 0) {
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (i = 1; i <= maxValue + 1; i++) {
            map.put(i, 0);
        }

        for (i = 0; i < arrayLength; i++) {
            if (map.containsKey(data[i])) {
                map.put(data[i], 1);
            }
        }

        for (i = 1; i <= maxValue + 1; i++) {
            if (map.get(i) == 0) {

                System.out.println("getLowestPositiveIntegerBruteForce end " + System.currentTimeMillis());
                return i;
            }
        }

        System.out.println("getLowestPositiveIntegerBruteForce end " + System.currentTimeMillis());

        return 1;
    }

    private int getLowestPositiveIntegerSort(int[] data) {

        System.out.println("getLowestPositiveIntegerSort start " + System.currentTimeMillis());

        Arrays.sort(data);

        int arrayLength = data.length;

        int i;

        int temp = 0;

        for (i = 0; i < arrayLength; i++) {
            if (data[i] - temp > 1) {
                System.out.println("getLowestPositiveIntegerSort end " + System.currentTimeMillis());
                return temp + 1;
            } else if (data[i] - temp == 1) {
                temp++;
            }
        }

        System.out.println("getLowestPositiveIntegerSort end " + System.currentTimeMillis());

        return temp + 1;
    }

    private int getLowestPositiveIntegerHashTable(int[] data) {

        System.out.println("getLowestPositiveIntegerHashTable start " + System.currentTimeMillis());

        int arrayLength = data.length;

        int i;

        HashSet<Integer> set = new HashSet<>();

        for (i = 0; i < arrayLength; i++) {
            set.add(data[i]);
        }

        i = 1;
        while (true) {
            if (!set.contains(i)) {
                System.out.println("getLowestPositiveIntegerHashTable end " + System.currentTimeMillis());

                return i;
            }
            i++;
        }
    }

    private int getLowestPositiveIntegerSegregatePositiveAndNegative(int[] data) {

        System.out.println("getLowestPositiveIntegerSegregatePositiveAndNegative start " + System.currentTimeMillis());

        int arrayLength = data.length;

        int i, j = 0;

        int shiftPosition = segregatePositiveAndNegative(data);

        int newArray[] = new int[arrayLength - shiftPosition];

        for (i = shiftPosition; i < arrayLength; i++) {
            newArray[j++] = data[i];
        }

        int size = newArray.length;

        for (i = 0; i < size; i++) {
            int x = Math.abs(newArray[i]);
            if (x - 1 < size && newArray[x - 1] > 0) {
                newArray[x - 1] = -newArray[x - 1];
            }
        }

        for (i = 0; i < size; i++) {
            if (newArray[i] > 0) {
                System.out.println("getLowestPositiveIntegerSegregatePositiveAndNegative start " + System.currentTimeMillis());
                return i + 1;
            }
        }

        System.out.println("shiftPosition " + shiftPosition);
        System.out.println("getLowestPositiveIntegerSegregatePositiveAndNegative start " + System.currentTimeMillis());
        return size + 1;
    }

    private int segregatePositiveAndNegative(int[] data) {
        int i, j = 0;

        for (i = 0; i < data.length; i++) {
            if (data[i] <= 0) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                j++;
            }
        }

        return j;
    }
}
