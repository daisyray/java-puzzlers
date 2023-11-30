package ray.daisy.puzzlers;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ray.daisy.puzzlers.links.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;
import static ray.daisy.puzzlers.links.Node.createNodeList;

public class CodingPracticeOneTest {
    CodingPracticeOne codingPracticeOne = new CodingPracticeOne();
    @Test
    public void removeOccurrenceTest() {
        assertEquals(codingPracticeOne.removeOccurrence("doaisy", 'o'),"daisy");
    }

    @Test
    public void fibboSeries() {
        List<Integer> fibbo = codingPracticeOne.fibbonachiSeries(6);
        assertEquals(fibbo, List.of(0,1,1,2,3,5));
    }
    @Test
    public void fizzBuzzTest() {
        assertEquals(codingPracticeOne.fizzbuzz(15), "fizzbuzz");
    }
    @Test
    public void removeDuplicatesFromArray() {
        String[] st = {"adb", "rat","cat"};
        assertEquals(codingPracticeOne.removeDuplicate(new String[]{"adb", "adb", "rat", "cat"}), st);
    }

    @Test
    public void frequencyCountTest() {
        assertEquals(codingPracticeOne.frequencyCount("daisydais"), Map.of('d',2, 'a', 2, 'i', 2, 's', 2, 'y', 1));
        assertEquals(codingPracticeOne.frequencyCount(""), Map.of());
        assertEquals(codingPracticeOne.frequencyCount(null), Map.of());
    }
    @Test
    public void isPalindromeTest() {
        assertTrue(codingPracticeOne.isPalindrome("maam"));
    }

    @Test
    public void mergeTwoListsTest() {
        List<Integer>num1 = List.of(22,33, 44);
        List<Integer>num2 = List.of(23,34, 44);
        assertEquals(codingPracticeOne.mergeTwoList(num1, num2), List.of(22,23,33,34, 44, 44));
    }

    @Test
    public void evenOddNumberTest() {
        assertEquals(codingPracticeOne.evenOdd(List.of(2,4,66,12,33,31)), Map.of("even", List.of(2,4,66,12), "odd", List.of(33,31)));
    }
    @Test
    public void shiftedOneIndexTest() {
        assertEquals(codingPracticeOne.shiftNumbersToNextPosition(List.of(2, 3, 4,5,1)), List.of(1,2,3,4,5));
        assertEquals(codingPracticeOne.shiftNumbersToNextPosition(List.of()), List.of());
        assertEquals(codingPracticeOne.shiftNumbersToNextPosition(List.of(1)), List.of(1));
    }
    @Test
    public void removeDuplicateTest() {
        assertEquals(codingPracticeOne.removeDup(List.of("da", "sa", "da", "tada")), List.of("da", "sa", "tada"));
    }
    @Test
    public void rotateRight() {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(2,3,4,5,1));
        codingPracticeOne.rotateRight(arr);
        assertEquals(arr, List.of(1,2,3,4,5));
        arr.clear();
        arr.add(2);
        codingPracticeOne.rotateRight(arr);
        assertEquals(arr, List.of(2));
        arr.clear();
        codingPracticeOne.rotateRight(arr);
        assertEquals(arr, List.of());
    }
    @Test(
        expectedExceptions = IllegalArgumentException.class,
        expectedExceptionsMessageRegExp = "null is not allowed"
    )
    public void rotateRightTestNull() {
        codingPracticeOne.rotateRight(null);
    }

    @Test
    public void rotateArrayRight() {
        assertEquals(codingPracticeOne.rotateArray(new int[]{2,3,4,5,1}), new int[]{1,2,3,4,5} );
    }
    @Test
    public void removeDuplicates() {
        assertEquals(codingPracticeOne.removeDuplicates(List.of("hello", "hello", "world")), List.of("hello", "world"));
    }
    @Ignore
    public void rotateTogivenNumber() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1,2,3,4,5));
        assertEquals(codingPracticeOne.rotateRightToNumber(numbers, 2), List.of(4,5,1,2,3));
    }
    @Test
    public void compressStringTest() {
        String compressStr = codingPracticeOne.compressString(null);
        assertNull(compressStr);
        assertEquals(codingPracticeOne.compressString("bc"), "b1c1");
    }
    @Test
    public void uniqueCharsTest() {
        assertFalse(codingPracticeOne.uniqueChars("ddaaiisy"));
        assertTrue(codingPracticeOne.uniqueChars("daisy"));
    }
    @Test
    public void isPermutation() {
        assertTrue(codingPracticeOne.isPermutation("dog", "god"));
        assertFalse(codingPracticeOne.isPermutation("ddgo", "good"));
        assertFalse(codingPracticeOne.isPermutation("dog", "dogs"));
        assertTrue(codingPracticeOne.isPermutation("dog", "dog"));
    }
    @Test
    public void sumExists() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(10,20,30,40, 11));
        assertTrue(codingPracticeOne.sumExists(numbers, 70));
        assertFalse(codingPracticeOne.sumExists(numbers, 700));
        assertFalse(codingPracticeOne.sumExists(numbers, 700));
    }
}
