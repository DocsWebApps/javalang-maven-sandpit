package JavaQuiz;

public class StringChallenge {

    public static void main(String... doYourBest) {
        var jedi = "masterYoda"; // Strings are immutable !!!

        changeString(jedi);

        System.out.println(jedi);
    }

    static String changeString(String jedi) {
        jedi.replace(jedi, "darthVader");

        return jedi;
    }

}
/*

Summary
You will learn how to change a String value and will learn how object references work.

Background
The main thing to notice in this challenge is that Strings are immutable,
which means that when we pass the String as a parameter the object will never be changed.

Inside the String class, actually the value of it is a final array of byte, this is the value type from a String:

    private final byte[] value;

By knowing that, every time you change a String value, it will not change the value you assigned to your String.

So, when we invoke this method:

jedi.replace(jedi, "darthVader");

Nothing will be changed.

It's different with StringBuffer for example, if you change the value with a StringBuffer, it will be really changed.

Then, the final result will be:
masterYoda
 */
