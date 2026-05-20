package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PFArray {

    private final List<int[]> arrays = new ArrayList<>();

    public void createRandomArray() {
        Random random = new Random();
        int length = random.nextInt(10) + 1;

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }

        arrays.add(arr);
    }

    public void createManualArray(String input) {
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        arrays.add(arr);
    }

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

    public void printArray(int index) {
        if (index < 0 || index >= arrays.size()) {
            System.out.println("Invalid index.");
            return;
        }

        for (int n : arrays.get(index)) System.out.print(n + " ");
        System.out.println();
    }

    public void addNumber(int index, int number) {
        int[] old = arrays.get(index);
        int[] newArr = new int[old.length + 1];

        System.arraycopy(old, 0, newArr, 0, old.length);
        newArr[newArr.length - 1] = number;

        arrays.set(index, newArr);
    }

    public int findMax(int index) {
        int[] arr = arrays.get(index);
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public int findMin(int index) {
        int[] arr = arrays.get(index);
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    public int sum(int index) {
        int total = 0;
        for (int n : arrays.get(index)) total += n;
        return total;
    }

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

    public void regenerate(int index) {
        Random random = new Random();
        int[] arr = arrays.get(index);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100;
        }
    }

    public void deleteArray(int index) {
        arrays.remove(index);
    }

    public int size() {
        return arrays.size();
    }

    public int[] getArray(int index) {
        return arrays.get(index);
    }
}
