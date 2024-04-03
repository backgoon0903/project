package Ex.sort;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class InsertionSortMultiCriteria {

    public static void main(String[] args) {
        Person[] people = {
                new Person("John", 45),
                new Person("Anna", 24),
                new Person("John", 30),
                new Person("Mike", 35),
                new Person("Anna", 28)
                // Implement new person more here
        };

        insertionSort(people);

        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static void insertionSort(Person[] people) {
        int n = people.length;
        for (int i = 1; i < n; i++) {
            Person key = people[i];
            int j = i - 1;
            while (j >= 0 && (people[j].age > key.age ||
                    (people[j].age == key.age && people[j].name.compareTo(key.name) > 0))) {
                people[j + 1] = people[j];
                j = j - 1;
            }
            people[j + 1] = key;
        }
    }
}
