package org.recursion;

/* Implement a function that capitalizes each word in String. */
//TODO
public class CapitalizeWord {
    public static String capitalizeFirstLetter(String sentence){
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }

        // Find the first word
        int spaceIndex = sentence.indexOf(' ');
        if (spaceIndex == -1) {
            return capitalizeFirstLetter(sentence); // Last word in the sentence
        }

        // Capitalize the first word and concatenate it with the capitalized remaining sentence
        String firstWord = sentence.substring(0, spaceIndex);
        String remainingSentence = sentence.substring(spaceIndex + 1);

        return capitalizeFirstLetter(firstWord) + " " + capitalizeFirstLetter(remainingSentence);
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(capitalizeFirstLetter(str)); // Output: Hello World
    }
}
