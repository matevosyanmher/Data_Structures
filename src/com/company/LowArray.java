package com.company;

public class LowArray {
    private long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElement(int index) {

        return a[index];
    }
}

class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;

        arr.setElem(0, 77); // insert 10 items
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10; // now 10 items in array

        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElement(j) + " ");
        }
        System.out.println("");

        int searchKey = 26;
        for (j = 0; j < nElems; j++) {
            if (arr.getElement(j) == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can't find " + searchKey);
        } else System.out.println("Found " + searchKey);

        for (j = 0; j < nElems; j++) {
            if (arr.getElement(j) == 55) {
                break;
            }
        }
        for (int k = j; k < nElems; k++) {
            arr.setElem(k, arr.getElement(k + 1));
        }

        nElems--;
        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElement(j) + " ");
        }
        System.out.println("");
    }
}


