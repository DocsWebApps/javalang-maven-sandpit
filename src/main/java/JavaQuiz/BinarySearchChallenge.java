package JavaQuiz;

import java.util.Arrays;

public class BinarySearchChallenge {

    static String[] marvel = {"Spiderman", "Venom", "Carnage", "Mysterio"};

    public static void main(String[] args) {
        Arrays.sort(marvel);

        System.out.println(Arrays.binarySearch(marvel, "Xavier"));
        System.out.println(marvel[Arrays.binarySearch(marvel, "Carnage")]);
        System.out.println(Arrays.binarySearch(marvel, "Lizard"));
        System.out.println(Arrays.binarySearch(marvel, "Apocalypse"));
        System.out.println(Arrays.binarySearch(marvel, "Spiderman"));
    }

}
/*
Summary
Learn how to use search for elements you want into an array.

Background
Let's analyze the code, this is the array we are going to work on:
    static String[] marvel = {"Spiderman", "Venom", "Carnage", "Mysterio"};

Then we are going to sort this array on the alphabetical order:
    Arrays.sort(marvel);

Therefore the array will be like that after being sorted:
    {"Carnage", "Mysterio", "Spiderman", "Venom"};

The very first important thing to understand is that to make the binarySearch method work,
it's necessary to sort the array. Otherwise, it won't work properly.

That said when the array is sorted and the element is not found,
a negative number will be returned where the element would be supposed to go.

As "Xavier" would come after "Venom" the line below will print, -5 and just keep in mind that when an element is not found,
the index will start from -1 not 0.
    System.out.println(Arrays.binarySearch(marvel, "Xavier"));

On the below code line, this element will be found and the binarySearch method will return 0.
Then we will be able to access this index with the marvel array.
Then we will have the result of "Carnage" at the line below:
    System.out.println(marvel[Arrays.binarySearch(marvel, "Carnage")]);

The same rule will be applied here, "Lizard" won't be found and then as "Lizard" would come after "Carnage"
the returned index will be -2
    System.out.println(Arrays.binarySearch(marvel, "Lizard"));

As "Apocalypse" would be the first, it will return -1
    System.out.println(Arrays.binarySearch(marvel, "Apocalypse"));

As "Spiderman" is on the list, the index that will be returned is 2, also remember that when the element is found,
it will start from the index 0.
    System.out.println(Arrays.binarySearch(marvel, "Spiderman"));

In conclusion, the final result will be:
-5
Carnage
-2
-1
2

Watch the FULL explanation video about this quiz and many more on the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
