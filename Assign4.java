package com.company;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Scanner;

public class Assign4 {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    private enum ArrayType {
        IN_ORDER(1),
        RANDOM(2),
        REVERSE_ORDER(3);

        int value;

        ArrayType(int value) {
            this.value = value;
        }

        public static ArrayType of(int value) {
            switch (value) {
                case 1:
                    return ArrayType.IN_ORDER;
                case 2:
                    return ArrayType.RANDOM;
                case 3:
                    return ArrayType.REVERSE_ORDER;
                default:
                    return null;
            }
        }
    }

    private enum Algorithm {
        QUICK_SORT(1),
        MERGE_SORT(2),
        SELECTION_SORT(3),
        INSERTION_SORT(4);
        int value;

        Algorithm(int value) {
            this.value = value;
        }

        public static Algorithm of(int value) {
            switch (value) {
                case 1:
                    return Algorithm.QUICK_SORT;
                case 2:
                    return Algorithm.MERGE_SORT;
                case 3:
                    return Algorithm.SELECTION_SORT;
                case 4:
                    return Algorithm.INSERTION_SORT;
                default:
                    return null;
            }
        }
    }


    public static void main(String[] args) {
        int size = 0;
        int arrayType = 0;

        System.out.println("Input size of Arrays: ");
        size = input.nextInt();
        System.out.println("Input ArrayTYpe");
        System.out.println("InOrder: 1");
        System.out.println("Random: 2");
        System.out.println("Reverse Order: 3");
        Long arr[] = new Long[size];
        arrayType = input.nextInt();
        switch (arrayType) {
            case 1:
                arr = createArray(size, ArrayType.IN_ORDER);
                break;
            case 2:
                arr = createArray(size, ArrayType.RANDOM);
                break;
            case 3:
                arr = createArray(size, ArrayType.REVERSE_ORDER);
                break;
        }
        System.out.println("--------Before Sort----------");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("------------------------------");
        System.out.println("Choose Algorithm:");
        System.out.println("Quick Sort: 1");
        System.out.println("Merge Sort: 2");
        System.out.println("Selection Sort: 3");
        System.out.println("Insertion Sort: 4");
        int algorithm = input.nextInt();

        analyzeAlgorithm(arr, size, ArrayType.of(arrayType), Algorithm.of(algorithm));


    }

    private static void analyzeAlgorithm(Long arr[], int size, ArrayType type, Algorithm algorithm) {
        long start = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        try {
            switch (algorithm) {
                case MERGE_SORT:
                    SortArray.iterativeMergeSort(arr, size);
                    break;
                case SELECTION_SORT:
                    SortArray.selectionSort(arr, size);
                    break;
                case QUICK_SORT:
                    /* TODO */
                    System.out.println("Algorithm NOT Supported!!!!!");
                    break;
                case INSERTION_SORT:
                    SortArray.insertionSort(arr, size);
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            long duration = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli() - start;
            System.out.println("--------After Sort------------");
            for (int i = 0; i < size; i++) {
                System.out.println(arr[i]);
            }
            System.out.println("------------------------------");
            System.out.println(algorithm + " Spent " + duration + "ms for sorting array with size of " + size + ", Array Type:" + type);

        }
    }


    private static Long[] createArray(int size, ArrayType type) {
        switch (type) {
            case RANDOM:
                return createRandomArray(size);
            case IN_ORDER:
                return createInOrderArray(size);
            case REVERSE_ORDER:
                return createReverseOderArray(size);
            default:
                return null;
        }
    }

    private static Long[] createRandomArray(int size) {
        Long items[] = new Long[size];
        for (int i = 0; i < size; i++) {
            items[i] = (long) random.nextInt(10000000);
        }
        return items;
    }

    private static Long[] createInOrderArray(int size) {
        Long items[] = new Long[size];
        for (int i = 0; i < size; i++) {
            items[i] = (long) i;
        }
        return items;
    }

    private static Long[] createReverseOderArray(int size) {
        Long items[] = new Long[size];
        int max = size;
        for (int i = 0; i < size; i++) {
            items[i] = (long) max;
            max--;
        }
        return items;
    }

}
