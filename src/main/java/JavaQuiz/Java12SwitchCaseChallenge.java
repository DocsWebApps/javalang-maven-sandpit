package JavaQuiz;

public class Java12SwitchCaseChallenge {
//    public static void main(String... doYourBest) {
//        Java12SwitchCaseChallenge switchCaseChallenge = new Java12SwitchCaseChallenge();
//
//        Object homerBeersTuesday = switchCaseChallenge.getBeers(WeekDay.TUESDAY);
//        Object homerBeersSaturday = switchCaseChallenge.getBeers(WeekDay.SATURDAY);
//        Object homerBeersForNoBeerDay = switchCaseChallenge.getBeers(WeekDay.NO_BEER_DAY);
//
//        System.out.println("" + homerBeersTuesday + homerBeersSaturday + homerBeersForNoBeerDay);
//    }
//
//    <R extends WeekDay, T> T getBeers(R weekDay) {
//        var t = switch ((WeekDay) weekDay) {
//            case MONDAY -> (T) Integer.valueOf(4);
//            case TUESDAY, WEDNESDAY, THURSDAY -> {
//                System.out.println("Every day is beer day for Homer");
//                break (T) (Object) (Integer.valueOf(129) == 129 ? 5 : 7); // Line 17
//            }
//            case FRIDAY -> (T) Double.valueOf(4);
//            case SATURDAY, SUNDAY -> (T) (Object) "6" == new String("6") ? 2 : 4; // Line 20
//            default -> new IllegalStateException("Non existent day.");
//        };
//
//        return (T) t;
//    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, NO_BEER_DAY
    }

}
/*
Summary
You will learn details about working with switch case in Java 12.

Background
Understand loop concept

When we run this method invocation:
    switchCaseChallenge.getBeers(WeekDay.TUESDAY);

As we are passing TUESDAY, this case statement will be executed:

    case TUESDAY, WEDNESDAY, THURSDAY -> {
        System.out.println("Every day is beer day for Homer");
        break (T) (Object) (Integer.valueOf(129) == 129 ? 5 : 7);
    }

The result will be 5 since 129 is an int number, the Integer.valueOf(129) will be unboxed to int when being compared with the int 129 then it will return true.

Then on this one:
    switchCaseChallenge.getBeers(WeekDay.SATURDAY);

This case statement will be invoked:
    case SATURDAY, SUNDAY -> (T) (Object) "6" == new String("6") ? 2 : 4;

Since we create a new String explicitly, the new String instance of 6 will allocate a new space in the memory heap. Making this comparison to be false.

When we invoke the:
    switchCaseChallenge.getBeers(WeekDay.NO_BEER_DAY);

Since there is no such an option, the default statement will be run and the IllegalStateException will be returned.

Then the final result will be:
Every day is beer day for Homer
54java.lang.IllegalStateException: Non existent day.
 */
