package gym_tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
        TreeSet<Person> candidates = new TreeSet<>(new SpacePersonComparator());
        candidates.add(new Person("Sonya Popova", 35, 15));
        candidates.add(new Person("Dazdraperma Sponzhova", 33, 15));
        candidates.add(new Person("Salavat Netologshvili", 23, 13));
        candidates.add(new Person("Sasha Sun", 31, 15));
        candidates.add(new Person("Svetlana Morkov", 38, 15));
        candidates.add(new Person("Sasha Sosnova", 38, 11));

        candidates.forEach(person -> {
            int count = SpacePersonComparator.countSubstring(person.getName(), "S");
            count += SpacePersonComparator.countSubstring(person.getName(), "s");
            System.out.println(person.getExperience() + " " + person.getName() + " " + count);
        });

        Iterator<Person> it = candidates.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
    }
}


class Person {
    private String name;
    private int age;
    private int experience;

    public Person(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SpacePersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getExperience() != person2.getExperience()) {
            return -Integer.compare(person1.getExperience(), person2.getExperience());
        }
        int count1 = countSubstring(person1.getName(), "S") + countSubstring(person1.getName(), "s");
        int count2 = countSubstring(person2.getName(), "S") + countSubstring(person2.getName(), "s");

        if (count1 != count2) {
            return -Integer.compare(count1, count2);
        }

        return Integer.compare(person1.getName().length(), person2.getName().length());
    }

    public static int countSubstring(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}