package com.solid;

public class Book {

    private ProductPrinter productPrinter; //Composition!
    private BookPersistence bookPersistence; //Composition!
    private int nPages;
    private String authorName;

    public Book(String authorName, int nPages) {
        this.nPages = nPages;
        this.authorName = authorName;
        this.bookPersistence = new BookPersistence(); //Composition!
        this.productPrinter = new ProductPrinter(); //Composition!
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

    public void save() {
        this.bookPersistence.save(this); //Composition!
    }

    public void print() {
        this.productPrinter.print(this); //Composition!
    }

    @Override
    public String toString() {
        return authorName + " - " + nPages;
    }
}
