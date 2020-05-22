package JavaQuiz;

// Intermediate
public class MisterBurnsGetsMedicine {
    public static void main(String... doYourBest) {
        MedicineSupplier medicine = Smithers::new;
        medicine.provideMedicine(Integer.valueOf(3));
        medicine.provideMedicine(10);
        medicine.provideMedicine(1);
    }

    // Nested static class
    static class Smithers {
        Smithers(int any) {
            System.out.printf("Smithers gives:%s to Mister Burns with int ", any);
        }
        Smithers(short any) {
            System.out.printf("Smithers gives:%s to Mister Burns with short ", any);
        }
        Smithers(Integer any) {
            System.out.printf("Smithers gives:%s to Mister Burns with Integer ", any);
        }
    }

    // Functional Interface
    @FunctionalInterface
    private interface MedicineSupplier {
        Smithers provideMedicine(int quantity);
    }
}

/*

Summary
You will learn how to manipulate Method References when instantiating a new class and will understand better the concept of higher functions and functional programming with Java.

Background
The concept of Method Reference in Java is very powerful,
it enables us to create a function of a function, it's also called as higher-order functions.
An interesting way to use Method References is with a constructor.

Let's analyze the code:

    MedicineSupplier medicine = Smithers::new;

The first line only works because the interface MedicineSupplier matches exactly with one of the
constructors from the Smithers class. Let's see it:

    static class Smithers {
            Smithers(int any) { System.out.printf("Smithers gives:%s to Mister Burns with int \n", any); }
             // Other constructors...
    }

    private interface MedicineSupplier {
         Smithers provideMedicine(int quantity);
    }

Notice that the constructor from Smithers receives an int and returns Smithers and the MedicineSupplier
method matches exactly the same. As long as the other constructors don't match the MedicineSupplier
interface method, only the Smithers(int any) {  ... } constructor will be invoked.

Therefore the result of this challenger will be:
Smithers gives:3 to Mister Burns with int
Smithers gives:10 to Mister Burns with int
Smithers gives:1 to Mister Burns with int
 */
