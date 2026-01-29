package PracticeQuestionsMentor;

import java.util.*;

public class EchoWeaveEncryption {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the input");
        String input = sc.nextLine();

        if (!input.matches("[a-zA-Z]+")) {
            System.out.println(input + " is an invalid input");
            return;
        }

        String word = input.toUpperCase();

        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char ch : word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder evenGroup = new StringBuilder();
        StringBuilder oddGroup = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 == 0)
                evenGroup.append(entry.getKey());
            else
                oddGroup.append(entry.getKey());
        }

        StringBuilder encrypted = new StringBuilder();
        encrypted.append(evenGroup).append(oddGroup);

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int remaining = entry.getValue() - 1;
            for (int i = 0; i < remaining; i++) {
                encrypted.append(entry.getKey());
            }
        }

        int singleCount = 0;
        for (int count : freqMap.values()) {
            if (count == 1)
                singleCount++;
        }

        if (singleCount > 0) {
            int len = encrypted.length();
            int index = (len % 2 == 0) ? (len / 2) : (len / 2 + 1);
            encrypted.insert(index, singleCount);
        }

        System.out.println("Encrypted output: " + encrypted);

        sc.close();
    }
}

