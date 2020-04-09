package JavaQuiz;

public class DragonWarriorReferenceChallenger {

    public static void main(String... doYourBest) {
        StringBuilder warriorProfession = new StringBuilder("Dragon ");
        String warriorWeapon = "Sword ";
        changeWarriorClass(warriorProfession, warriorWeapon);

        System.out.println("Warrior=" + warriorProfession + " Weapon=" + warriorWeapon);
    }

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight");

        weapon = "Dragon " + weapon; // this line will create a new local immutable string called weapon since the original weapon is immutable
        System.out.println(weapon);

        weapon = null; // only a 2nd reference to object, still referenced in main method
        warriorProfession = null; // only a 2nd reference to object, still referenced in main method
    }

}
/*

Summary
Learn what happens when using Object reference with immutable and mutable Objects and how their values are changed.

Background
The first parameter in the above example is the warriorProfession variable, which is a mutable object.
The second parameter, weapon, is an immutable String:

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        ...
     }

Now let’s analyze what is happening inside this method. At the first line of this method,
we append the Knight value to the warriorProfession variable.
Remember that warriorProfession is a mutable object; therefore the real object will be changed, and the value from it will be “Dragon Knight.”

    warriorProfession.append("Knight");

In the second instruction, the immutable local String variable will be changed to “Dragon Sword.” The real object will never be changed,
however, since String is immutable and its attributes are final:

    weapon = "Dragon " + weapon;

Finally, we pass null to the variables here, but not to the objects. The objects will remain the same as long as they are still accessible
externally--in this case through the main method. And, although the local variables will be null, nothing will happen to the objects:

    weapon = null;
    warriorProfession = null;

From all of this we can conclude that the final values from our mutable StringBuilder and immutable String will be:

System.out.println("Warrior=" + warriorProfession + " Weapon=" + warriorWeapon);

The only value that changed in the changeWarriorClass method was warriorProfession, because it’s a mutable StringBuilder object.
Note that warriorWeapon did not change because it’s an immutable String object.

The correct output from our Challenger code would be:
Warrior=Dragon Knight Weapon=Sword

Watch the FULL explanation video about this quiz and many more on the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */