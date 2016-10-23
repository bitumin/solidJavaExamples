package com.solid;

public class BadBook {

    private int nPages;
    private String authorName;

    public BadBook(String authorName, int nPages) {
        this.nPages = nPages;
        this.authorName = authorName;
    }

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Method with 2 responsibilities!!!
    // This method is not quite inherent to a Book object => we must use composition or interfaces instead
    public void printAndSave() {
        System.out.println("Printing the book " + this);
        System.out.println("Saving the book " + this);
    }

    @Override
    public String toString() {
        return authorName + " - " + nPages;
    }
}
