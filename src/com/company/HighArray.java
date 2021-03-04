package com.company;
import java.util.Arrays;

import java.lang.reflect.Array;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (nElems == j) {
            return false;
        } else
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
        nElems--;
        return true;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println(" ");
    }

    public long getMax() {
        long max = 0;
        int k;
        if (nElems == 0)
            return -1;

        for (k = 0; k < nElems; k++) {
            if (a[k] > max) {
                max = a[k];
            }

        }
        System.out.println("The Max number in the array is " + max);

        delete(max);

        return max;

    }
}


class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        int serchKey = 35;
        if (arr.find(serchKey)) {
            System.out.println("Found " + serchKey);
        } else System.out.println("Can't find " + serchKey);

        arr.delete(12);
        arr.delete(55);
        arr.delete(99);

        arr.display();
        arr.getMax();

        arr.display();


    }
}
