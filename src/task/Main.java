package task;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Put number with digits 1 - 7. Each number represents day of week.");
        int number = sc.nextInt();



        String finalString = mainMethod(number);

        System.out.println(finalString);


    }

    static char[] toCharArray(int i){
        return ("" + i).toCharArray();
    }

    static char[] sort (char[] x){
        Arrays.sort(x);
        return x;
    }

    static char[] removeDuplicats(char[] x){
        String s = "";
        for (int i = 0; i < x.length; i++) {
            if (s.indexOf(x[i]) == -1){
                s += x[i];
            }
        }
        return s.toCharArray();
    }

    static String finalMethodComasAndDashes(char[] x){
        String s = "";

        for (int i = 0; i < x.length; i++) {          // for every single digit

            if(x[i] == x[x.length-1]){                // if this is the last or the only digit in number write it
                s += x[i];                            // to final String and continue loop
                continue;
            }

            if(s.endsWith("-")){                      // if the final String ends with '-'
                if(x[i]+1 == x[i+1]){                 // and this day and next day are consecutive
                    continue;                         // than don't do anything
                }
                else{                                 // else if days are not consecutive
                s += x[i];                            // write the day
                s += ",";                             // and coma
                continue;                             // continue loop
                }
            }

            s += x[i];                                // if it not the last digit and final String doesn't
                                                      // end with '-' write the digit to final String
            if(x[i]+1 == x[i+1]){                     // write '-' if numbers are consecutive
                s += "-";
            } else{
                s += ",";                             // or ',' if they are not
            }

        }                                             // end of the loop
        s = "'" + s + "'";

        return s;

    }

    static String mainMethod(int n){

        char[] numberArray = toCharArray(n);
        char[] numberArraySorted = sort(numberArray);
        char[] numberWithoutDuplicates = removeDuplicats(numberArraySorted);

        String s = finalMethodComasAndDashes(numberWithoutDuplicates);
        return s;
    }
}
