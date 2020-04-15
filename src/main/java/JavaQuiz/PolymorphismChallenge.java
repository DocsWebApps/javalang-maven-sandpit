package JavaQuiz;

public class PolymorphismChallenge {
    static abstract class Simpson {
        void talk() {
            System.out.println("Simpson!");
        }
    }

    static class Homer extends Simpson {
        void talk() {
            System.out.println("Spider Pig!");
        }
    }

    static class Bart extends Simpson {
        protected void talk() {
            System.out.println("Eat my shorts!");
        }
    }

    static class Maggie extends Simpson {
    }

    public static void main(String... doYourBest) {
        // 1. Output: Spider Pig!, Eat my shorts!, Simpson!
        new Homer().talk();
        new Bart().talk();
        new Maggie().talk();

        // 2. Output: Spider Pig!, Eat my shorts!, Simpson!
        Simpson homerSimpson = new Homer();
        Simpson bartSimpson = new Bart();
        Simpson maggieSimpson = new Maggie();
        homerSimpson.talk();
        bartSimpson.talk();
        maggieSimpson.talk();

        // 3. Output: Spider Pig!, Eat my shorts!, Simpson!
        new Homer().talk();
        Simpson simpson = new Bart();
        simpson.talk();
        new Maggie().talk();

        // 4. Eat my shorts!, Eat my shorts!, Simpson!
        Simpson homerSimpson1 = new Homer();
        Simpson bartSimpson1 = new Bart();
        Simpson maggieSimpson1 = new Maggie();

        homerSimpson1 = bartSimpson1;

        homerSimpson1.talk();
        bartSimpson1.talk();
        maggieSimpson1.talk();
    }
}
