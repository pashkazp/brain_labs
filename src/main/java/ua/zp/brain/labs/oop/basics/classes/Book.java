package ua.zp.brain.labs.oop.basics.classes;

/**
 * Simple Java class that represents object Book
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Book {

    public static final String BINDING_HARD = "hard binding";
    public static final String BINDING_SOFT = "soft binding";

    private String title;
    private String author;
    private int year;
    private String publisher;
    private String labels;
    private String idISBN;
    private int pages;
    private String binding; // "hard binding", "hard binding"

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getIdISBN() {
        return idISBN;
    }

    public void setIdISBN(String idISBN) {
        this.idISBN = idISBN;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Имя класса: " + getClass().getName() +
                "\ntitle = \"" + title + '"' +
                "\nauthor = \"" + author + '"' +
                "\nyear = " + year +
                "\npublisher = \"" + publisher + '"' +
                "\nlabels = \"" + labels + '"' +
                "\nidISBN = \"" + idISBN + '"' +
                "\npages = " + pages;
    }
}
