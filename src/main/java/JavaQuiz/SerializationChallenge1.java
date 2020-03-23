package JavaQuiz;

import java.io.*;

public class SerializationChallenge1 {

    public static void main(String... doYourBest) throws IOException, ClassNotFoundException {

        try (var fs = new FileOutputStream("SerTest.ser");
             var os = new ObjectOutputStream(fs)) {
            var xmen = new Xmen();
            xmen.name = "Wolverine";
            xmen.power = "Healing and defensive powers";
            xmen.weapon = "claws";
            xmen.costumeColor = "yellow";
            os.writeObject(xmen);
            xmen.costumeColor = "blue";
        }

        try (var fis = new FileInputStream("SerTest.ser");
             var ois = new ObjectInputStream(fis)) {
            var deserializedXmen = (Xmen) ois.readObject();
            System.out.println(deserializedXmen.name);
            System.out.println(deserializedXmen.power);
            System.out.println(deserializedXmen.weapon);
            System.out.println(deserializedXmen.costumeColor);
        }
    }
}

class Xmen implements Serializable {
    private static final long serialVersionUID = 632L;
    String name;
    transient String power; // Not saved as its transient
    volatile String weapon;
    static String costumeColor; // Not saved to file since its not part of the instance
}
/*
Summary
You will learn how to serialize and deserialize an object. Also, what variable will be saved when serializing.

Background
By using this code, we will be creating a file output stream that generates a file physically
and then creating an object output stream that makes it possible to write object information into the file:
    var fs = new FileOutputStream("SerTest.ser");
    var os = new ObjectOutputStream(fs);

Then we will put information in the object and write it into the file:
    var xmen = new Xmen();
    xmen.name = "Wolverine";
    xmen.power = "Healing and defensive powers";
    xmen.weapon = "claws";
    xmen.costumeColor = "yellow";
    os.writeObject(xmen);
    xmen.costumeColor = "blue";

We will create also a file input stream to enable us to get information from a file and
then an object input stream to put information from a file into an object:
    var fis = new FileInputStream("SerTest.ser");
    var ois = new ObjectInputStream(fis);

There are some details to pay attention to our POJO class:
    class Xmen implements Serializable {
        private static final long serialVersionUID = 632L;
        String name;
        transient String power;
        volatile String weapon;
        static String costumeColor;
    }

When we work with serialization, we can only serialize Serializable objects,
if the object is not Serializable we would get a NotSerializableException.

Now, let's focus on the variables, the String name will be fine to serialize.

The String power variable is transient, that means that this value won't be saved when the object is serialized.

The volatile String weapon will be saved normally since the reserved work volatile has nothing to do with serialization,
instead, it's about Threads.

Finally, with the static variable costumeColor, the serialization process doesn't even concern about static
fields since it only saves information of the current instance, not from the class.

To conclude, the final output will be:
Wolverine
null
claws
blue
 */
