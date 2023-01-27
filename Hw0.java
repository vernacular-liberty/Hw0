package com.gradescope.hw0;

//imports
import java.util.Arrays;

class Hw0{

    /*
     * adds elements in array.
     * @param a array of integers to be added
     * @return sum of the integers in the array
     */
    static int addAll(int[] a){
        int sum = 0;

        for (int i = 0; i < 50; i++){
            sum += i;
        }

        return sum;

    }

    public static void main(String[] args){
        int[] a = new int[50];

        for (int i = 0; i<a.length; i++){
            a[i] = i;
        }

        System.out.println(Arrays.toString(a));

        System.out.println("Sum: " + addAll(a));


    }
}
