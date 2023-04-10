package org.example;
import java.util.*;
public class Port {

    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        int[][] numbers = convertIndexes(indexes);
        Set<List<Integer>> combinations = getAllCombinations(numbers);
        System.out.println(combinations);
    }
    public static int[][] convertIndexes(String[] indexes) {
        int[][] result = new int[indexes.length][];
        for (int i = 0; i < indexes.length; i++) {
            String[] parts = indexes[i].split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String part : parts) {
                String[] range = part.split("-");
                if (range.length == 1) {
                    numbers.add(Integer.parseInt(range[0]));
                } else {
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    for (int j = start; j <= end; j++) {
                        numbers.add(j);
                    }
                }
            }
            result[i] = new int[numbers.size()];
            for (int j = 0; j < numbers.size(); j++) {
                result[i][j] = numbers.get(j);
            }
        }
        return result;
    }

    public static Set<List<Integer>> getAllCombinations(int[][] numbers) {
        Set<List<Integer>> result = new HashSet<>();
        if (numbers.length == 0) {
            return result;
        }
        List<List<Integer>> tempResult = new ArrayList<>();
        for (int i = 0; i < numbers[0].length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(numbers[0][i]);
            tempResult.add(temp);
        }
        for (int i = 1; i < numbers.length; i++) {
            List<List<Integer>> newTempResult = new ArrayList<>();
            for (List<Integer> integers : tempResult) {
                for (int k = 0; k < numbers[i].length; k++) {
                    List<Integer> temp = new ArrayList<>(integers);
                    temp.add(numbers[i][k]);
                    newTempResult.add(temp);
                }
            }
            tempResult = newTempResult;
        }
        for (List<Integer> combination : tempResult) {
            Collections.sort(combination);
            result.add(combination);
        }
        return result;
    }


}