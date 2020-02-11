package JavaQuiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThenComparingChallenge {

    public static void main(String... doYourBest) {
        List<Jedi> jediList = new ArrayList<>();
        jediList.add(new Jedi("Anakin", 10));
        jediList.add(new Jedi("Obi Wan", 7));
        jediList.add(new Jedi("Luke", 5));
        jediList.add(new Jedi("Luke", 6));

        Comparator<Jedi> comparator;

        // 1. Compares name and sorts in descending order
        comparator = Comparator
                .comparing(Jedi::getName);

        // 2. Only displays Luke since the .thenComparing () only gets triggered if there are 2 names the same
        comparator = Comparator
                .comparing(Jedi::getName).thenComparing((a1,a2) -> {System.out.println("Only Luke here: " + a1.name); return 1;});

        // 3. Compares by name, and if 2 names are the same (and only if there are 2 names the same), it will then
        // go on to compare their ages and sorts
        comparator = Comparator
                .comparing(Jedi::getName).thenComparing((a1,a2) -> a2.age
                        .compareTo(a1.getAge()));

//       In the first comparision, we will sort by name,
//       then the age will be sorted for duplicate names in the inverse order since we are inverting the comparison like this: a2.age .compareTo(a1.getAge())
//        a2 is Luke:6 while a1 is Luke:5
        Collections.sort(jediList, comparator);
        jediList.forEach(j -> System.out.println(j.name + ":" + j.age));

/*
Baeldung: Using Comparator.thenComparing
The thenComparing function lets you set up lexicographical ordering of values by provisioning multiple sort keys in a particular sequence.
Let's consider another array of Employee class:

    someMoreEmployees = new Employee[] { ... };

Consider the following sequence of elements in the above array:

    [Employee(name=Jake, age=25, salary=3000.0, mobile=9922001),
    Employee(name=Jake, age=22, salary=2000.0, mobile=5924001),
    Employee(name=Ace, age=22, salary=3000.0, mobile=6423001),
    Employee(name=Keith, age=35, salary=4000.0, mobile=3924401)]

Let's write a sequence of comparisons as age followed by the name and see the ordering of this array:

    @Test
    public void whenThenComparing_thenSortedByAgeName(){
        Comparator<Employee> employee_Age_Name_Comparator
          = Comparator.comparing(Employee::getAge)
            .thenComparing(Employee::getName);

        Arrays.sort(someMoreEmployees, employee_Age_Name_Comparator);

        assertTrue(Arrays.equals(someMoreEmployees, sortedEmployeesByAgeName));


Here the ordering will be done by age, and for the values with the same age, ordering will be done by name. Let's observe this in the sequence we receive after sorting:
    [Employee(name=Ace, age=22, salary=3000.0, mobile=6423001),
    Employee(name=Jake, age=22, salary=2000.0, mobile=5924001),
    Employee(name=Jake, age=25, salary=3000.0, mobile=9922001),
    Employee(name=Keith, age=35, salary=4000.0, mobile=3924401)]

Let's use the other version of thenComparing that is thenComparingInt, by changing the lexicographical sequence to name followed by age:

    @Test
    public void whenThenComparing_thenSortedByNameAge() {
        Comparator<Employee> employee_Name_Age_Comparator
          = Comparator.comparing(Employee::getName)
            .thenComparingInt(Employee::getAge);

        Arrays.sort(someMoreEmployees, employee_Name_Age_Comparator);

        assertTrue(Arrays.equals(someMoreEmployees,
          sortedEmployeesByNameAge));
    }

Let's see how the employees array values are ordered after the sort:

    [Employee(name=Ace, age=22, salary=3000.0, mobile=6423001),
    Employee(name=Jake, age=22, salary=2000.0, mobile=5924001),
    Employee(name=Jake, age=25, salary=3000.0, mobile=9922001),
    Employee(name=Keith, age=35, salary=4000.0, mobile=3924401)]

Similarly, there are functions thenComparingLong and thenComparingDouble for using long and double sorting keys.
 */







    }

    static class Jedi {
        String name;
        Integer age;
        public Jedi(String name, Integer age) {
            this.name = name;
            this.age = age; }
        public String getName() { return name; }
        public Integer getAge() { return age;  }
    }
}
