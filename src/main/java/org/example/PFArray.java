package org.example;

import java.util.Random;

public class PFArray {
    private int[][] data;

    public PFArray() {
        this.data = null;
    }

    public void createRandomArray(int arrayIndex) {
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        data[arrayIndex] = new int[length];
        for (int i = 0; i < length; i++) {
            data[arrayIndex][i] = random.nextInt(200) - 100;
        }
    }

    public void createManualArray(int arrayIndex, String input) {
        String[] parts = input.split(",");
        data[arrayIndex] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            data[arrayIndex][i] = Integer.parseInt(parts[i].trim());
        }
    }

    public void printArray() {
        if (data == null) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Array " + i + " = ");
                System.out.print(" |" + data[i][j]);
            }
            System.out.println();

        }
        System.out.println();
    }

    public void getArray(int arrayIndex) {
        if (data == null) {
            System.out.println("Array number "+ arrayIndex +" is empty");
            return;
        }
        for (int value : data[arrayIndex]) {
            System.out.print("| " + value);
        }
        System.out.println();
    }

    public void addNumber(int number, int arrayIndex) {
        if (data == null) {
            data[arrayIndex] = new int[]{number};
            return;
        }
        int[] newArray = new int[data[arrayIndex].length + 1];
        System.arraycopy(data[arrayIndex], 0, newArray, 0, data.length);
        newArray[newArray.length -1] = number;
        data[arrayIndex] = newArray;
    }

    public int findMax(int arrayIndex) {
        int max = 0;
        for (int value : data[arrayIndex]) {
            if (value > max) max = value;
        }
        return max;
    }

    public int findMin(int arrayIndex) {
        int min = 0;
        for (int value : data[arrayIndex]) {
            if (value < min) min = value;
        }
        return min;
    }

    public int sum(int arrayIndex) {
        int sum = 0;
        for (int value : data[arrayIndex]) {
            sum += value;
        }
        return sum;
    }

    public void removeNumber(int number, int arrayIndex) {
        int count = 0;
        for (int value : data[arrayIndex]) {
            if (value == number) count++;
        }
        int[] newArray = new int[data.length - count];
        int index = 0;
        for (int value : data[arrayIndex]) {
            if (value != number) {
                newArray[index] = value;
                index++;
            }
        }
        data[arrayIndex] = newArray;
    }

    public void deleteArray(int arrayIndex) {
        data[arrayIndex] = null;
    }

    public void generateNumber(int arrayIndex) {
        Random random = new Random();
        for (int i = 0; i < data[arrayIndex].length; i++) {
            data[arrayIndex][i] = random.nextInt(200) - 100;
        }

    }
}
