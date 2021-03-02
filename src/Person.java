public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }
}

class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < a.length; j++) {
            if (a[j].getLastName().equals(searchName))
                break;
        }
        if (j == a.length) {
            return null;
        } else return a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(first, last, age);
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < a.length; j++) {
            if (a[j].getLastName().equals(searchName)) {
                break;
            }
        }
        if (j == a.length) {
            return false;
        } else {
            for (int k = j; k < a.length; k++) {
                a[k] = a[k + 1];
            }
            return true;
        }
    }

    public void display() {
        for (Person person : a) {
            person.displayPerson();
        }
    }
}

class ClassDataApp {
    public static void main(String[] args) {

        ClassDataArray arr = new ClassDataArray(100);

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        arr.display();

        String searchKey = "Stimson";
        Person found;

        found = arr.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.displayPerson();
        } else System.out.println("Can’t find " + searchKey);

        System.out.println("Deleting Smith, Yee, and Creswell");

        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");

        arr.display();
    }
}
