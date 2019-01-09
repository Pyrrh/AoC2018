package com.company;

import java.io.File;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new Exception("This program takes only one argument");
            }

            ArrayList<Integer> intValues = readValues(args[0]);
            int totalSum = calculateTotal(intValues);
            int repeatFrequency = calculateFirstRepeatFrequency(intValues);
            System.out.println("the total is: " + totalSum);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static ArrayList<Integer> readValues(String fileToRead) {
        try {
            Scanner scanner = new Scanner(new File(fileToRead));
            ArrayList<Integer> intArray = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String next = scanner.nextLine();
                intArray.add(Integer.valueOf(next));
            }


            return intArray;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    static int calculateTotal(ArrayList<Integer> toSum) {
        int finalSum = 0;

        if (toSum!= null) {
            for (int i = 0; i < toSum.size(); ++i) {
                finalSum += toSum.get(i);
                System.out.println(finalSum);

            }
        }

        return finalSum;
    }

    static int calculateFirstRepeatFrequency(ArrayList<Integer> inputs) {
        int sum = 0;
        HashMap<Integer, Integer> firstRepeat = new HashMap<>();
        firstRepeat.put(sum, sum);
        boolean repeatFound = false;

        while (!repeatFound) {
            if (inputs != null) {
                for (int i = 0; i < inputs.size(); ++i) {
                    sum += inputs.get(i);
                    if (!firstRepeat.containsValue(sum)) {
                        firstRepeat.put(sum, sum);
                    } else {
                        System.out.println("Repeat frequency: " + sum);
                        repeatFound = true;
                        break;
                    }
                }
            }

        }
        return sum;
    }
}