package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PFArray {

    private final List<int[]> arrays = new ArrayList<>();

    /**
     * This function creates new array with random length and values
     */
    public void createRandomArray() {
        Random random = new Random();

        // create random length of new array from 1-10
        int length = random.nextInt(10) + 1;
        //declare new array and add random value to array
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }

        arrays.add(arr);
    }

    /**
     * this function creates new array with values of user input
     * @param input input numbers
     */
    public void createManualArray(String input) {
        if (input == null) return;
        // split numbers with comma and store them in parts array
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];

        //convert string numbers to integer and store them in new array
        for (int i = 0; i < parts.length; i++) {
            try {
                arr[i] = Integer.parseInt(parts[i].trim());
            } catch (NumberFormatException _) {
                System.out.println("Invalid number:" + parts[i]);
                return;
            }
        }

        arrays.add(arr);
    }

    /**
     * this function prints all arrays and their values
     */
    public void printAllArrays() {
        if (arrays.isEmpty()) {
            System.out.println("No arrays created yet.");
            return;
        }

        for (int i = 0; i < arrays.size(); i++) {
            System.out.print("Array " + i + ": ");
            for (int n : arrays.get(i)) System.out.print(n + " ");
            System.out.println();
        }
    }

    /**
     * this function prints values of specific array
     * @param index index of an array
     */
    public void printArray(int index) {
        if (index < 0 || index >= arrays.size()) {
            System.out.println("Invalid index.");
            return;
        }

        //print values in specific array
        for (int n : arrays.get(index)) System.out.print(n + " ");
        System.out.println();
    }

    /**
     * this function adds number to an array
     * @param index index of an array
     * @param number number to add
     */
    public void addNumber(int index, int number) {
        int[] old = arrays.get(index);
        int[] newArr = new int[old.length + 1];

        //copy old array values into new array
        System.arraycopy(old, 0, newArr, 0, old.length);
        //insert number in the end of array
        newArr[newArr.length - 1] = number;

        arrays.set(index, newArr);
    }

    /**
     * this function returns max value of an array
     * @param index index of an array
     * @return return max number
     */
    public int findMax(int index) {
        int[] arr = arrays.get(index);
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    /**
     * this function returns min number of an array
     * @param index index of an array
     * @return return min number
     */
    public int findMin(int index) {
        int[] arr = arrays.get(index);
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    /**
     * this function return sum of array
     * @param index index of an  array
     * @return return sum of array
     */
    public int sum(int index) {
        int total = 0;
        for (int n : arrays.get(index)) total += n;
        return total;
    }

    /**
     * this function removes specific number from an array
     * @param index index of an array
     * @param number number to remove
     */
    public void removeNumber(int index, int number) {
        int[] arr = arrays.get(index);
        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            if (n != number) {
                list.add(n);
            }
        }

        int[] newArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArr[i] = list.get(i);
        }
        arrays.set(index, newArr);
    }

    /**
     * this function regenerate random numbers to an existing array
     * @param index index of an array
     */
    public void regenerate(int index) {
        Random random = new Random();
        int[] arr = arrays.get(index);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
    }

    /**
     * this function delete an array
     * @param index index of an array
     */
    public void deleteArray(int index) {
        arrays.remove(index);
    }

    /**
     * size of an array
     * @return array size
     */
    public int size() {
        return arrays.size();
    }

    /**
     * get values in array
     * @param index index of array
     * @return values in array
     */
    public int[] getArray(int index) {
        return arrays.get(index);
    }
}
