package JavaQuiz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExChallenge1 {

    public static void main(final String... doYourBest) {
        testRegex("lisa@gmail.com");
        testRegex("misterburns$gmail9net.com");
        testRegex("homer007_simpson@hotmail*com");
        testRegex("barney@???????(com");
        testRegex("@&lenny%com");
        testRegex("flanders@duff.");
    }

    static void testRegex(final String msg) {
        final String pattern = "^[A-Z0-9]*[@|$][&]?[a-z0-9]+.[a-z]{2,6}$";

        final Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = compiledPattern.matcher(msg);

        if (matcher.find()) {
            System.out.println("Found value:" + matcher.group(0));
        } else {
            System.out.println("No match");
        }
    }

}
/*

Summary
You will learn how to validate an email and to use specific regex operators in order to match a certain pattern.

Background
The testRegex method is basically validating an email.

Let's analyze the regex pattern expression:
    "^[A-Z0-9.-?]*[@|$][&]?[a-z0-9]+.[a-z]{2,6}$";

^ means that we will be verifying the beginning of a text.
A-Z means letters from A to Z
0-9 means number 0 to 9
* is the same as {0,} - that means 0 or many of the defined expression
[@|$] means that we can use either @ or |
[&]? means that we can use & or not since '?' means {0, 1}
+ means {1, } or 1 of the defined expression or more
. means any character
[a-z] means letters from a to z
{2,6} means that we need at least 2 characters or at the maximum 6.
$ means that we will be verifying the regex expression at the end of a text.

Therefore the result will be:

Found value:lisa@gmail.com
Found value:misterburns$gmail9net.com
No match
No match
Found value:@&lenny%com
No match
 */
