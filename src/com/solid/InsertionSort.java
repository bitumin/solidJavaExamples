package com.solid;

public class InsertionSort extends Sorter {

    public InsertionSort() {
        super.type = SortType.INSERTIONSORT;
    }

    @Override
    protected void sort() {
        System.out.println("Sorting with InsertionSort...");
    }
}
