package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PortTest {
    @Test
    void convertIndexesTest() {
        String[] indexes = {"1,3-5", "2", "3-4"};
        int[][] expectedNumbers = {{1, 3, 4, 5}, {2}, {3, 4}};
        int[][] actualNumbers = Port.convertIndexes(indexes);
        Assertions.assertArrayEquals(expectedNumbers, actualNumbers);
    }

    @Test
    void getAllCombinationsWithNullInputTest() {
        Assertions.assertThrows(NullPointerException.class, () -> Port.getAllCombinations(null));
    }

    @Test
    void getAllCombinationsWithEmptyInputTest() {
        int[][] numbers = {};
        Set<List<Integer>> expectedCombinations = new HashSet<>();
        Set<List<Integer>> actualCombinations = Port.getAllCombinations(numbers);
        Assertions.assertEquals(expectedCombinations, actualCombinations);
    }
}
