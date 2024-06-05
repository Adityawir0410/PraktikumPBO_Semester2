package Laprak12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================");
        System.out.println("Masukkan teks: ");
        System.out.println("=================");
        String text = scanner.nextLine().toLowerCase();
        String[] wordsWithPunctuation = text.split(" ");
        List<String> words = new ArrayList<>();
        for (String word : wordsWithPunctuation) {
            if (word.endsWith(".")) {
                words.add(word.substring(0, word.length() - 1));
            } else {
                words.add(word);
            }
        }
        List<String> uniqueWords = new ArrayList<>();
        int[] wordCount = getWordCount(words, uniqueWords);
        int totalWords = uniqueWords.size();
        int totalCount = getTotalCount(wordCount);
        int maxWordLength = getMaxWordLength(uniqueWords);
        printWordCount(wordCount, uniqueWords, totalWords, totalCount, maxWordLength);
    }

    private static int[] getWordCount(List<String> words, List<String> uniqueWords) {
        int[] wordCount = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int index = uniqueWords.indexOf(word);
            if (index == -1) {
                uniqueWords.add(word);
                index = uniqueWords.size() - 1;
                wordCount[index] = 1;
            } else {
                wordCount[index]++;
            }
        }
        return wordCount;
    }

    private static int getTotalCount(int[] wordCount) {
        int totalCount = 0;
        for (int count : wordCount) {
            totalCount += count;
        }
        return totalCount;
    }

    private static int getMaxWordLength(List<String> uniqueWords) {
        int maxLength = 0;
        for (String word : uniqueWords) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }

    private static void printWordCount(int[] wordCount, List<String> uniqueWords, int totalWords, int totalCount, int maxWordLength) {
        System.out.println("Total kata yang berbeda: " + totalWords);
        System.out.println("Total seluruh kata: " + totalCount);
        System.out.println();

        for (int i = 0; i < uniqueWords.size(); i++) {
            String word = uniqueWords.get(i);
            System.out.printf("%-" + (maxWordLength + 2) + "s: %d%n", word, wordCount[i]);
        }
    }
}