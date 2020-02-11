package JavaQuiz;

public class GarbageCollectionTest {

    public static void main(String[] args) {

        HowManyObjectsWillBeCleanedByTheGarbageCollector gc = new GarbageCollectionTest()
                .new HowManyObjectsWillBeCleanedByTheGarbageCollector();

        gc.executeAction();

        System.out.println("How many objects are eligible be collected by "
                + "the Garbage Collector after "
                + "the executeAction() method invokation?" + gc);

    }

    private class HowManyObjectsWillBeCleanedByTheGarbageCollector {

        private Character homer = new Character("Dooh");

        private Character misterBurns = new Character("you are fired");

        private Character bart = new Character("eat my shorts");

        private Character elBarto;

        public void executeAction() {
            homer.talk();
            misterBurns.talk();
            makeTwoCharactersTalk(misterBurns, homer);
            System.out.println("mrburns" + misterBurns);
            System.out.println("homer" + homer);
            misterBurns = null;
            elBarto = bart;
            bart = null;
            elBarto.talk();
            homer.talk();

            System.out.println("Homer: " + homer);
            System.out.println("MrBurns: " + misterBurns);
//            System.out.println(bart);
            System.out.println("Bart: " + elBarto);
        }

        private void makeTwoCharactersTalk(Character misterBurns, Character homer) {
            System.out.println(homer);
            misterBurns.talk();
            homer.talk();
            misterBurns = null;
            homer = null;
            System.out.println("mrburns" + misterBurns);
            System.out.println("homer" + homer);
        }
    }
}

class Character {
    private String talk;
    public Character(String talk) {
        this.talk = talk;
    }
    public void talk() {
        System.out.println(this.talk);
    }
}
