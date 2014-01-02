import java.util.*;
import java.io.*;

// This class has a static function that converts all strings to camelcase

public class Utility {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a line of text");
        String line = input.nextLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(camelCase(words[i]));
            System.out.print(" ");
        }
        System.out.println("");
    }

    static String camelCase(String s) {
        s = s.trim();
        String result = s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
        return (result);
    }
}
