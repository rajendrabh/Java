import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MilitaryPhoneticAlphabet {

    static Map<Character, String> hashMap = new HashMap<Character, String>();
    static Map<Character, String> treeMap = new TreeMap<Character, String>();
    public static void main(String[] args) {

        initializeHashMap();
        treeMap.putAll(hashMap);
        String line = JOptionPane.showInputDialog("Enter the words to convert: ");
        line = line.trim();
        String[] words = line.split(" ");
        String result = "";
        for(int i = 0; i < words.length; i++) {
            result = result + words[i];
            for (int j = 0; j < words[i].length(); j++) {
                if (treeMap.containsKey(Character.toUpperCase(words[i].charAt(j)))) 
                    result = result + " - " + treeMap.get(Character.toUpperCase(words[i].charAt(j)));
                else
                    result = result + " - " + words[i].charAt(j);
            }
            result = result + "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    static void initializeHashMap() {
        hashMap.put('A', "Alfa");
        hashMap.put('B', "Bravo");
        hashMap.put('C', "Charlie");
        hashMap.put('D', "Delta");
        hashMap.put('E', "Echo");
        hashMap.put('F', "Foxtrot");
        hashMap.put('G', "Golf");
        hashMap.put('H', "Hotel");
        hashMap.put('I', "India");
        hashMap.put('J', "Juliett");
        hashMap.put('K', "Kilo");
        hashMap.put('L', "Lima");
        hashMap.put('M', "Mike");
        hashMap.put('N', "November");
        hashMap.put('O', "Oscar");
        hashMap.put('P', "Papa");
        hashMap.put('Q', "Quebec");
        hashMap.put('R', "Romeo");
        hashMap.put('S', "Sierra");
        hashMap.put('T', "Tango");
        hashMap.put('U', "Uniform");
        hashMap.put('V', "Victor");
        hashMap.put('W', "Whiskey");
        hashMap.put('X', "X-ray");
        hashMap.put('Y', "Yankee");
        hashMap.put('Z', "Zulu");
    }
}
