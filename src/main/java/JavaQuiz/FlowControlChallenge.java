package JavaQuiz;

public class FlowControlChallenge {
    public static void main(String... doYourBest) {
        boolean isBarneyAlcoholic = true;
        boolean isHomerFat = true;
        String result = "";

        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        if (isHomerFat = false | (isBarneyAlcoholic = false)) {
            result += "1";
        }
        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        if (isHomerFat || isBarneyAlcoholic) {
            result += "2";
        }
        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        if (!isHomerFat && !isBarneyAlcoholic) {
            result += "3";
        }
        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        if ((isHomerFat = true) & (isBarneyAlcoholic = true)) {
            result += "4";
        }
        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        if (isHomerFat || (isBarneyAlcoholic = false)) {
            result += "5";
        }
        System.out.println("result: " + result + ", isHomerFat: " + isHomerFat +", isBarneyAlcoholic: " + isBarneyAlcoholic);

        /*
        If you use the || and && forms, rather than the | and & forms of these operators,
        Java will not bother to evaluate the right-hand operand alone.

        It's a matter of if you want to short-circuit the evaluation or not -- most of the time you want to.

        A good way to illustrate the benefits of short-circuiting would be to consider the following example.

        Boolean b = true;
        if(b || foo.timeConsumingCall())
        {
           //we entered without calling timeConsumingCall() since b is true
        }

        Let's see the explanation in the code:

        The second condition won't be executed,because it's not necessary, once we are using "&&", both conditions must be "true" when one of them is false, JVM just ignores the rest.
        if (false && true) {}


        The second condition will be checked, even if the first condition is false, this can be useful when you want to execute a command in every situation on your conditions.
        if (false & true) {}


        The second condition won't be executed because once we are using "||", if one of the conditions is "true" the whole condition will be true, so JVM won't check the next condition.
        if (true || false) {}


        When using the bitwise operator, both conditions will be check, even if the first condition is "true"
        if (true | false) {}

         */

        System.out.println(result + isHomerFat + isBarneyAlcoholic);
    }
}
