package com.company;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String first, String last, int a) {
        firstName = first;
        lastName = last;
        age = a;
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
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName))
                break;
        }
        if (j == nElems) {
            return null;
        } else return a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(first, last, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;


        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            a[i].displayPerson();
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
