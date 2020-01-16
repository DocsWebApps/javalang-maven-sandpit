package DesignPatterns.SOLID;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Single Responsibility Principle
public class SJournal {
    // These parameters are OK as they relate directly to the Journal
    private List<String> myEntries = new ArrayList<>();
    private int count = 0;

    // This method is OK as it is related to a function of the Journal
    public void addEntry(String entry) {
        this.myEntries.add("" + (++count) +": " + entry);
    }

    // This method is OK as it is related to a function of the Journal
    public void deleteEntry(int index) {
        this.myEntries.remove(index);
    }

    // This method is OK as it is related to a function of the Journal
    @Override
    public String toString() {
        return String.join(System.lineSeparator(), this.myEntries);
    }

    // This 3 methods below are not OK as they relate to persisting the Journal and not the function of the Journal
    // Create a new class to persist the Journal. You need to separate concerns !!
    public void save(String fileName) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(fileName)) {
            out.println(toString());
        }
    }
    public void load(String fileName) {}
    public void load(URL url) {}
}

class Demo {
    public static void main(String[] args) throws Exception {
        SJournal myJournal = new SJournal();
        myJournal.addEntry("I am at work today");
        myJournal.addEntry("I am hungry and its only midday");

        System.out.println(myJournal);
        myJournal.save("davesfile.txt");
    }
}
