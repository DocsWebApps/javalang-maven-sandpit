package JavaQuiz;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class DateChallenge {

    public static void main(String... doYourBest) {
        List<SpiderMan> spiderManList = Arrays.asList(
                new SpiderMan("The Spider Man", LocalDate.of(1962, Month.SEPTEMBER, 8)),
                new SpiderMan("The Black Suit", LocalDate.of(1984, Month.SEPTEMBER, 8)),
                new SpiderMan("Spider-Man 2099", LocalDate.of(1992, Month.SEPTEMBER, 17)));

        LocalDate now = LocalDate.of(2017, Month.SEPTEMBER, 18);

        spiderManList.forEach(
                s -> { Period period = Period.between(s.creationDate, now);
                    System.out.println(s.costume + " " +
                            period.get(ChronoUnit.YEARS) + " years " +
                            period.get(ChronoUnit.DAYS) + " days");
                }
        );
    }

    static class SpiderMan {
        String costume;
        LocalDate creationDate;

        SpiderMan(String costume, LocalDate dateOfBirth) {
            this.costume = costume;
            this.creationDate = dateOfBirth.plusDays(2).plusYears(2); // Line 32
        }
    }

}
/*

Summary
You will learn details about working with Date and Time in Java.

Background
Let's analyse each SpiderMan object:
    new SpiderMan("The Spider Man", LocalDate.of(1962, Month.SEPTEMBER, 8)
    new SpiderMan("The Black Suit", LocalDate.of(1984, Month.SEPTEMBER, 8)
    new SpiderMan("Spider-Man 2099", LocalDate.of(1992, Month.SEPTEMBER, 17)

Then we add 2 days and years:
    dateOfBirth.plusDays(2).plusYears(2);

Then we compare the range with this date:
    LocalDate now = LocalDate.of(2017, Month.SEPTEMBER, 18);

Then we just have to make the calculation:
    Period period = Period.between(s.creationDate, now);
                        System.out.println(s.costume + " " +
                        period.get(ChronoUnit.YEARS) + " years " +
                        period.get(ChronoUnit.DAYS) + " days");

The Spider Man year: 1962 + 2 - 2017 = 53, day:  8 + 2 - 18 = 8
The Black Suit year: 1984 + 2 - 2017 = 31, day: 8 + 2 - 18 = 8
Spider-Man 2099 year: 1992 + 2 - 2017 = 22, day: 17 + 2 - 18 = 30
 */
