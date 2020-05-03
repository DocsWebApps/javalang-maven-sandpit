package JavaQuiz;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TokenizerChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner("ThisIsIt,theFinalString,NoBugsProject");

        Pattern pattern = Pattern.compile("[^\\w*]");
        sc.useDelimiter(pattern);

        while (sc.hasNext()) {
            System.out.println(sc.next());
        }

        sc.close();
    }
}

/*

Summary
Use the Scanner class to parse primitive types and strings using regular expressions.

Background
Use the Scanner class to parse primitive types and strings using regular expressions.

We created the object Scanner passing the String to be tokenized, separated by a pattern.
At first, you’ve got to know what the symbols on the tokens mean.

This symbol is called Regex. Many languages use the same concept.

In simple words, this symbol “^\\w” means “not a word” and the “*” means that – Occurs zero or more times,
is short for {0,}, so it will tokenize by the comma “,“.

The result is:

ThisIsIt
theFinalString
NoBugsProject


 */
