package davids.unit2;

/**
 * Name: David Shcherbatykh 
 * Monday, Oct 30 
 * ICS3U 
 * Description: Takes an unknown number of values from 0-10 as input until user enters sentinel value 
 * and stores the values and frequencies in an ArrayList and array, respectively. Prints the frequency 
 * data of the values inputted, the mode(s) of the frequencies, and the median of the values.
 */
import java.util.*;

public class Marks {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] freqs = new int[11]; // Declares an array of size 11 for the frequencies of the marks
        ArrayList<Integer> marks = new ArrayList();

        int mark;

        System.out.println("Enter marks. Input -1 to stop input: ");

        do { // Loops taking input until sentinel is inputted
            try {
                mark = input.nextInt();
                if (mark == -1) {
                    break;
                } else if (mark >= 0 && mark <= 10) { // Updates the frequency of mark inputted if it is valid
                    freqs[mark]++;
                    marks.add(mark); // Adds mark value to ArrayList
                } else { // Prints message if input is invalid
                    System.out.println("Please enter a mark from 0 and 10");
                }
            } catch (InputMismatchException e) { // Catches String inputs and prints message
                System.out.println("Invalid input. Please enter again.");
                input.nextLine();
            }
        } while (true);

        System.out.println("\na) Frequency data");
        for (int i = 0; i < freqs.length; i++) { // Prints out the values at each index (the frequency of each mark)
            System.out.println(i + ": " + freqs[i]);
        }

        System.out.println("\nb) Mode");
        if (marks.isEmpty()) { // Checks if no marks were inputted so it doesn't calculate mode
            System.out.println("No marks inputted");
        } else {
            int maxFreq = 0;
            for (int i = 0; i <= 10; i++) { // Finds the largest value in freqs by updating maxFreq when it finds a greater value
                if (freqs[i] > maxFreq) {
                    maxFreq = freqs[i];
                }
            }

            int uniqueValues = 0;
            for (int i = 0; i <= 10; i++) { // Updates uniqueValues when finding a unique mark by comparing their frequency to 0 
                if (0 != freqs[i]) {
                    uniqueValues++;
                }
            }

            ArrayList<Integer> modes = new ArrayList();
            for (int i = 0; i <= 10; i++) { // Compares the frequencies to the maxFreq value to find the modes and stores them in ArrayList modes
                if (freqs[i] == maxFreq) {
                    modes.add(i);
                }
            }
            if (modes.size() == uniqueValues) { // Checks if there is as many modes as there are unique values which means there is no mode since all marks occur the same number of times
                System.out.print("There is no mode");
            } else {
                System.out.print("Mode: ");
                for (int i = 0; i < modes.size(); i++) { // Prints all modes/values in ArrayList
                    System.out.print(modes.get(i) + " ");
                }
            }

            System.out.println("");
        }
        System.out.println("\nc) Median");
        double median;
        String medianString;
        if (marks.isEmpty()) { // Once again checks if no marks were inputted so it doesn't have to calculate the median
            System.out.println("No marks inputted");
        } else {
            Collections.sort(marks); // Sorts the inputted marks in order of value
            if (marks.size() % 2 == 1) { // If the size of the marks Arraylist is odd then the median is just the middle value
                median = marks.get(marks.size() / 2);
            } else { // If the size of the ArrayList is even, then median becomes the average of the two middle values and is cast to a double 
                median = (double) (marks.get(marks.size() / 2) + marks.get(marks.size() / 2 - 1)) / 2;
            }
            medianString = Double.toString(median); // Converts the median into a String to be able to see if it ends with .0
            if (medianString.endsWith(".0")) { // If the median ends with .0 then it casts the median to an int to remove decimal
                System.out.println("Median: " + (int) median);
            } else {
                System.out.println("Median: " + median);
            }
        }
    }

}
