package JavaQuiz;

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
