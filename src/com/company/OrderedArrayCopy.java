package com.company;

public class OrderedArrayCopy {
    private long[] a;
    private int nElms;

    public OrderedArrayCopy(int max) {
        a = new long[max];
        nElms = 0;
    }

    public int getSize() {
        return nElms;
    }

    public void insert(int value) {
        int j;
        for (j = 0; j < nElms; j++) {
            if (a[j] > value) {
                break;
            }
        }
        for (int k = nElms; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElms++;
    }

    public void display() {
        for (int i = 0; i < nElms; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElms - 1;
        int curIndex;

        while (true) {
            curIndex = (lowerBound + upperBound) / 2;

            if (a[curIndex] == searchKey) {
                return curIndex;
            } else if (lowerBound > upperBound)
                return nElms;
            else {
                if (searchKey > a[curIndex])
                    lowerBound = curIndex + 1;
                else upperBound = curIndex - 1;
            }
        }
    }
}

class OrderedArrayAppCopy {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArrayCopy arr = new OrderedArrayCopy(maxSize);
        arr.insert(25);
        arr.insert(77);
        arr.insert(12);
        arr.insert(10);

        arr.display();
        System.out.println(arr.find(177));
    }
}
