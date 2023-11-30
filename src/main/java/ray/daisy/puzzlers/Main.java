package ray.daisy.puzzlers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        CodingPracticeOne codingPracticeOne = new CodingPracticeOne();
        System.out.println(removeAnumber(List.of(2,3,4,45,5,66), 4));
    }

    public List<Integer> interviewTest(List<Integer> inputList, int toReplace, List<Integer> numtoSubstitute) {
        int size = inputList.size() + numtoSubstitute.size();
        List<Integer> newNumber = new ArrayList<>(size);

        for (Integer i: inputList) {
            if(i == toReplace) {
                newNumber.addAll(numtoSubstitute);
                newNumber.add(i);

            } else {
                newNumber.add(i);
            }

            if(i != toReplace){
                newNumber.add(i);
            }

        }
        return newNumber;
    }

    public static List<Integer> removeAnumber(List<Integer> numberList, int toRemove) {
        List<Integer> newNumber = new ArrayList<>();

        for (Integer i: numberList) {
            if(i != toRemove) {
                newNumber.add(i);
            }
        }
        return newNumber;
    }

}

/*
al: 1,2,3,4,5,6,7,8,9,10
oap:1,2,3,4,5,10,15,6,7,8,9,10
replace 6 with 10,15
https://www.jdoodle.com/online-java-compiler
opal: 1,2,3,4,5,10,15,7,8,9,10
2 with 20
3 with 30
8 with 80.
replace
 */
