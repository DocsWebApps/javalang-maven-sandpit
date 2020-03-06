package JavaQuiz;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ReflectionChallenge1 {

    public static void main(String... doYourBest) {
        System.out.println(Jedi.class.getAnnotation(Table.class).name());
        System.out.println(Jedi.class.getAnnotation(Column.class).name());
    }

    @Table(name = "jedi")
    static class Jedi {
        @Column(name="attack_type")
        String attackType;

        public String getAttackType() { return attackType; }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Table { String name(); }
    @interface Column { String name(); }
}

/*
Summary
How to manipulate classes with reflection.

Background
Let's analyze the code, in the first line:

    System.out.println(Jedi.class.getAnnotation(Table.class).name());

The Table.class annotation will be picked without any problem since we have the @Retention(RetentionPolicy.RUNTIME)
annotation declared on it:

    @Retention(RetentionPolicy.RUNTIME)
    @interface Table { String name(); }

In the next code line:
    System.out.println(Jedi.class.getAnnotation(Column.class).name());

There are two reasons this code will throw a NullPointerException,
the first one is that this annotation is not marked as RUNTIME:

    @interface Column { String name(); }

The other one is that we should access the Column annotation through the fields and not in the class.
The code would work if it was like this:

    Arrays.stream(Jedi.class.getDeclaredFields()).forEach(f -> {
          if (f.getName().equals("attackType")) {
               System.out.println(f.getAnnotation(Column.class).name());
          }
    });

So the final output will be:
    jedi
    NullPointerException will be thrown
 */
