package JavaQuiz;

import java.io.FileNotFoundException;

public class ExceptionsDeclarationChallenge {

    public static void main(String... doYourBest) throws FileNotFoundException {
        new Scientist() {
            public void talk() throws FileNotFoundException {
                super.talk();
            }
        }.talk();
    }

    static class Scientist {
        public void talk() throws FileNotFoundException { // Line 15
            System.out.println("Making experiences");
        }
    }

//    static class Sheldon extends Scientist {
//        public void talk() throws IOException { // Line 21
//            System.out.println("My spot");
//        }
//    }

}
