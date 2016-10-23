package com.solid;

public class SorterManager {
    public void sort(Sorter sorter) {
        if(sorter.type == SortType.INSERTIONSORT)
            doInsertionSort(sorter);
        else if (sorter.type == SortType.MERGESORT)
            doMergesort(sorter);
    }

    private void doMergesort(Sorter sorter) {
        sorter.sort();
    }

    private void doInsertionSort(Sorter sorter) {
        sorter.sort();
    }
}
