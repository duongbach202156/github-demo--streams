import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
//        people.forEach(System.out::println);
        List<Person> female = new ArrayList<>();
        List<Person> sorted = new ArrayList<>();

        //Filter
        female = people.stream()
                        .filter(person-> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());

        //Sort
        sorted = people.stream()
                        .sorted((person1, person2) -> person1.getAge() - person2.getAge()).collect(Collectors.toList());
        sorted = people.stream()
                        .sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        //All match

        boolean allMatch = people.stream()
                        .allMatch(person -> person.getAge() > 2);
        System.out.println(allMatch);

        //Any match

        boolean anyMatch = people.stream()
                        .anyMatch(person -> person.getAge() > 100);
        System.out.println(anyMatch);

        //None match

        boolean noneMatch = people.stream()
                        .noneMatch(person -> person.getAge() == 180);
        System.out.println(noneMatch);

        //Max, min

        Optional<Person> max = people.stream()
                .max(Comparator.comparing(Person::getAge));

        people.stream()
                        .min(Comparator.comparing(Person::getAge))
                                .ifPresent(System.out::println);
        //Group

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((Gender, people1) -> {
            System.out.println(Gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

//        sorted.forEach(System.out::println);
    }
    public static List<Person> getPeople() {
        return List.of(
                    new Person("Antonio", 20, Gender.MALE),
                    new Person("Alina Smith", 33, Gender.FEMALE),
                    new Person("Helen White", 57, Gender.FEMALE),
                    new Person("Alex Boz", 14, Gender.MALE),
                    new Person("Jamie Goa", 99, Gender.MALE),
                    new Person("Anna Cook", 7, Gender.FEMALE),
                    new Person("Zelda Brown", 120, Gender.FEMALE)
        );

}
}