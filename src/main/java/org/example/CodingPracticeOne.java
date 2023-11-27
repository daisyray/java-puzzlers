package org.example;

import java.util.*;

public class CodingPracticeOne {
    // remove character from String
    public String removeOccurrence(String str, Character toRemove) {
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            Character strChar = str.charAt(i);
            if (strChar != toRemove) {
                newStr.append(strChar);
            }
        }
        return newStr.toString();
    }

    // outputs the fibonacchi Series of the give number
    public List<Integer> fibbonachiSeries(Integer number) {
        if (number == 0) {
            return null;
        }
        List<Integer> fibboSeries = new ArrayList<>();
        fibboSeries.add(0);
        fibboSeries.add(1);
        for (int i = 0; i < number - 2; i++) {
            int num1 = fibboSeries.get(i);
            int num2 = fibboSeries.get(i + 1);
            fibboSeries.add(num1 + num2);
        }
//        Stack<Integer> fibboSeries = new Stack<>();
//        fibboSeries.push(0);
//        fibboSeries.push(1);
//        for(int i = 0; i < number - 2; i++) {
//            int num1 = fibboSeries.get(i);
//            int num2 = fibboSeries.get(i + 1);
//            fibboSeries.push(num1 + num2);
//        }
        return fibboSeries;
    }

    // count occurrance
    public int countOccurence(String str, char toCount) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == toCount) {
                count++;
            }
        }
        return count;
    }

    // reverse a string
    public String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder();
        int strLength = str.length();
        for (int i = strLength - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return reversedString.toString();
    }

    //fizzbuzz
    public String fizzbuzz(int num) {
        if (num == 0) {
            return null;
        }
        if ((num % 3 == 0) && (num % 5 == 0)) {
            return "fizzbuzz";
        } else if (num % 3 == 0) {
            return "fizz";
        } else if (num % 5 == 0) {
            return "buzz";
        } else {
            return (String.valueOf(num));
        }
    }

    // remove duplicates from array
    public String[] removeDuplicate(String[] str) {
        if (str.length == 0) {
            return null;
        }
        List<String> resultList = new ArrayList<>();

        Set<String> strSet = new HashSet<>();
        for (String s : str) {
            if (!strSet.contains(s)) {
                resultList.add(s);
            }
            strSet.add(s);
        }
        String[] resultArray = new String[strSet.size()];

        return resultList.toArray(resultArray);
    }

    // isPalindrome
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int end = str.length() - 1;
        for (int begin = 0; begin < end; begin++) {
            if (str.charAt(begin) != str.charAt(end)) {
                System.out.println(false);
                return false;
            }
            System.out.println("end " + str.charAt(end));
            System.out.println("Begin " + str.charAt(begin));
            end--;
        }
        System.out.println("true");
        return true;
    }

    // merge two sorted list
    public List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        Integer num1Size = list1.size();
        Integer num2Size = list2.size();
        List<Integer> mergedNums = new ArrayList<>();

        Integer i = 0;
        Integer j = 0;

        while (i < num1Size && j < num2Size) {
            Integer num1 = list1.get(i);
            Integer num2 = list2.get(j);
            if (num1 < num2) {
                mergedNums.add(num1);
                i++;
            } else if (num1 == num2) {
                mergedNums.add(num1);
                mergedNums.add(num2);
                i++;
                j++;
            } else {
                mergedNums.add(num2);
                j++;
            }
        }
        if (i < num1Size) {
            for (int k = i; k < num1Size; k++) {
                mergedNums.add(list1.get(k));
            }
        }
        if (j < num2Size) {
            for (int k = j; k < num2Size; k++) {
                mergedNums.add(list2.get(k));
            }
        }
        return mergedNums;
    }

    // return even or odd
    public Map<String, List<Integer>> evenOdd(List<Integer> nums) {
        Map<String, List<Integer>> evenOddMap = new HashMap<>();

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (Integer num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        evenOddMap.put("even", even);
        evenOddMap.put("odd", odd);
        return evenOddMap;
    }

    //frequency count
    public Map<Character, Integer> frequencyCount(String word) {
        Map<Character, Integer> freqCount = new HashMap<>();
        int wordLength = word == null ? 0 : word.length();

        for (int i = 0; i < wordLength; i++) {
            int value = 1;
            Character key = word.charAt(i);
            if (freqCount.containsKey(key)) {
                value = freqCount.get(key) + 1;
            }
            freqCount.put(key, value);
        }
        return freqCount;
    }

    public List<Integer> shiftNumbersToNextPosition(List<Integer> numbers) {
        int numberSize = numbers.size();
        List<Integer> shiftedNumbersList = new ArrayList<>();
        shiftedNumbersList.addAll(numbers);
        int newIndex = 1;
        for (Integer num : numbers) {
            if (newIndex == numberSize) {
                shiftedNumbersList.set(0, num);
                break;
            }
            shiftedNumbersList.set(newIndex, num);
            newIndex++;
        }
        return shiftedNumbersList;
    }

    public List<String> removeDup(List<String> words) {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    // rotate each element of the list by the give number to the right
    public List<Integer> rotateRightToNumber(List<Integer> numbers, int shift) {
        if (numbers.isEmpty()) {
            return numbers;
        }
        int size = numbers.size();
        Collections.rotate(numbers, 2);
        System.out.println("rotated with collection method " + numbers);

        for (int i = 0; i < shift; i++) {
            numbers.add(0, numbers.remove(size - 1));
        }
        System.out.println("The number is " + numbers);
        System.out.println("rotated with for loop " + numbers);

        return numbers;
    }

    public void rotateRight(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("null is not allowed");
        }
        if (numbers.isEmpty()) {
            return;
        }
        int size = numbers.size();

        Integer numToRotate = numbers.get(0);
        for (int i = 0; i < size - 1; i++) {
            Integer temp = numbers.get(i + 1);
            int index = i + 1;
            numbers.set(index, numToRotate);
            numToRotate = temp;
        }
        numbers.set(0, numToRotate);
        System.out.println("numtorotate " + numToRotate);

//      Another way of solving the same problem

//        Integer lastNumber = numbers.get(size -1);
//        System.out.println("last number " + lastNumber);
//        for(int i = size -1; i > 0; i-- ) {
//            Integer number = numbers.get(i -1);
//            System.out.println("number to rotate " + number);
//            numbers.set(i, number);
//        }
//        numbers.set(0, lastNumber);
    }

    public int[] rotateArray(int[] ar) {
        if (ar == null || ar.length == 0) {
            return ar;
        }
        System.out.println("unmodified " + Arrays.toString(ar));

        int length = ar.length;
        System.out.println("length " + length);
        int lastIndexValue = ar[length - 1];
        for (int i = length - 1; i > 0; i--) {
            ar[i] = ar[i - 1];
        }
        ar[0] = lastIndexValue;
        System.out.println("modified " + Arrays.toString(ar));
        return ar;
    }

    //find duplicates from the given list of strings
    public List<String> removeDuplicates(List<String> words) {
        List<String> newWord = new ArrayList<>();
        int length = words.size();
        for (int i = 0; i < length; i++) {
            String temp = words.get(i);
            if (!isFound(newWord, temp)) {
                newWord.add(temp);
            }
        }
        return newWord;
    }

    public boolean isFound(List<String> words, String s) {
        for (String word : words) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    //    take 2 list of numbers and return a set which consists of elements that are common to both
    public Set<Integer> commonSet(List<Integer> list1, List<Integer> list2) {
        Set<Integer> commonNumbers = new HashSet<>();

        for (Integer l1 : list1) {
            if (list2.contains(l1)) {
                commonNumbers.add(l1);
            }
        }
        return commonNumbers;
    }

    // compute aggregate of numbers
    public Aggregate computeStats(List<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        double avg = (double) sum / nums.size();
        Integer min = nums.get(0);
        Integer max = nums.get(0);
        for (int n : nums) {
            if (max < n) {
                max = n;
            } else if (min > n) {
                min = n;
            }
        }
        return new Aggregate(min, max, avg);
    }

    // swap give maps key with its value
    public Map<Integer, List<Integer>> swapKeyWithValue(Map<Integer, Integer> sourceMap) {
        Map<Integer, List<Integer>> targetMap = new HashMap<>();
        for (Integer sourceMapKey : sourceMap.keySet()) {
            Integer targetMapKey = sourceMap.get(sourceMapKey);
            List<Integer> targetMapValue = targetMap.get(targetMapKey);
            if (targetMapValue == null) {
                targetMapValue = new ArrayList<>();
            }
            targetMapValue.add(sourceMapKey);
            targetMap.put(targetMapKey, targetMapValue);
        }
        return targetMap;
    }

    // remove extra space from String
    public String removeExtraSpace(String string) {
//        return string.replaceAll("\\s+", " ");
        StringBuilder newString = new StringBuilder();
        Boolean seenAspace = false;
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (c != null) {
                newString.append(c);
                seenAspace = false;
            } else if (seenAspace == false) {
                newString.append(" ");
                seenAspace = true;
            }
        }
        return newString.toString();
    }

    // merge two Arrays
    public int[] mergeArrays(int[] ar1, int[] ar2) {
        if((ar1.length == 0) || (ar2.length == 0)) {
            return null;
        }
//        int[] mergedArray = new int[size];
//        System.arraycopy(ar1, 0, mergedArray, 0, ar1.length);
//        System.arraycopy(ar2, 0, mergedArray, ar1.length, ar2.length);

        int ar1Len = ar1.length;
        int ar2Len = ar2.length;
        if(ar1Len == 0 || ar2Len == 0) {
            return null;
        }
        int[] mergedArray = new int[ar1Len + ar2Len] ;
        for(int i = 0; i < ar1Len; i++) {
            mergedArray[i] = ar1[i];
        }

        for(int i = 0; i < ar2Len; i++) {
            mergedArray[ar1Len++] = ar2[i];
        }
        return mergedArray;
    }
    public String compressString(String str) {
        if ((str == null) || (str.isBlank())) {
            return str;
        }
        CompressionState compressionState = new CompressionState(1, str.charAt(0));
        StringBuilder newStr = new StringBuilder();
        int lastIndex = str.length() -1;

        for(int i = 1; i <= lastIndex; i++ ) {
            Character currentChar = str.charAt(i);
            if (compressionState.getRunningChar() == currentChar) {
                compressionState.incrementRunningcount();
            } else {
                newStr.append(compressionState.getRunningChar()).append(compressionState.getRunningCount());
                compressionState.setRunningChar(currentChar);
                compressionState.setRunningCount(1);
            }
        }
        newStr.append(compressionState.getRunningChar()).append(compressionState.getRunningCount());
        return newStr.toString();
    }
}

class CompressionState {
    private int runningCount;
    private Character runningChar;

    public CompressionState(int runningCount, Character runningChar) {
        this.runningCount = runningCount;
        this.runningChar = runningChar;
    }

    public int getRunningCount() {
        return runningCount;
    }

    public Character getRunningChar() {
        return runningChar;
    }

    public void setRunningCount(int runningCount) {
        this.runningCount = runningCount;
    }

    public void setRunningChar(Character runningChar) {
        this.runningChar = runningChar;
    }
    public void incrementRunningcount() {
        this.runningCount++;
    }
}


/*
determine if a string has all unique characters ( use set)
give 2 strings, write a method to decide if one is a permutation of another ( use sort)
 */