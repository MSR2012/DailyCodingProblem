/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailycodingproblem;

import java.util.Scanner;

/**
 *
 * @author s.rana
 */
public class Problem2 {

    public void solveProblem() {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();

        int data[] = new int[arrayLength];
        int i;

        for (i = 0; i < arrayLength; i++) {
            data[i] = scanner.nextInt();
        }

        int productArray[] = getProductArrayBruteForce(data);

        for (i = 0; i < productArray.length; i++) {
            System.out.println(productArray[i]);
        }

        productArray = getProductArrayLeftRightArray(data);

        for (i = 0; i < productArray.length; i++) {
            System.out.println(productArray[i]);
        }
        
        productArray = getProductArrayProductArray(data);

        for (i = 0; i < productArray.length; i++) {
            System.out.println(productArray[i]);
        }

    }

    private int[] getProductArrayBruteForce(int[] data) {

        System.out.println("getProductArrayBruteForce start " + System.currentTimeMillis());

        int arrLength = data.length;

        int productArray[] = new int[arrLength];

        int i, j, singleProduct;

        for (i = 0; i < arrLength; i++) {

            singleProduct = 1;

            for (j = 0; j < arrLength; j++) {
                if (i != j) {
                    singleProduct = singleProduct * data[j];
                }
            }

            productArray[i] = singleProduct;
        }

        System.out.println("getProductArrayBruteForce end " + System.currentTimeMillis());

        return productArray;
    }

    private int[] getProductArrayLeftRightArray(int[] data) {

        System.out.println("getProductArrayBruteForce start " + System.currentTimeMillis());

        int arrLength = data.length;

        int productArray[] = new int[arrLength];
        int leftArray[] = new int[arrLength];
        int rightArray[] = new int[arrLength];

        int i;

        leftArray[0] = 1;
        rightArray[arrLength - 1] = 1;

        for (i = 1; i < arrLength; i++) {
            leftArray[i] = leftArray[i - 1] * data[i - 1];
        }

        for (i = arrLength - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] * data[i + 1];
        }

        for (i = 0; i < arrLength; i++) {
            productArray[i] = rightArray[i] * leftArray[i];
        }

        System.out.println("getProductArrayBruteForce end " + System.currentTimeMillis());

        return productArray;
    }

    private int[] getProductArrayProductArray(int[] data) {

        System.out.println("getProductArrayProductArray start " + System.currentTimeMillis());

        int arrLength = data.length;

        int productArray[] = new int[arrLength];

        int i;
        
        int temp = 1;
        
        

        for (i = 0; i < arrLength; i++) {
            productArray[i] = temp;
            temp = temp * data[i];
        }

        temp = 1;
        
        for (i = arrLength - 1; i >= 0; i--) {
            productArray[i] = temp * productArray[i];
            temp = data[i] * temp;
        }

        System.out.println("getProductArrayProductArray end " + System.currentTimeMillis());

        return productArray;
    }
}
