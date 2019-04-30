package ua.zp.brain.labs.oop.basics.methods;

import ua.zp.brain.labs.oop.basics.classes.Book;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        //Book extended methods
        BookExt book = new BookExt();

        book.setAuthor("Lüppken, Sven & Stäuble, Markus");
        book.setIdISBN("isbn:9781847195425, amazon:1847195423, google:WTp3mAEACAAJ");
        book.setTitle("Spring Web Flow 2 Web Development");
        book.setLabels("Computers, Web, Design, spring, Java");
        book.setChapters("chapter 1..........11;chapter 2..........50;chapter 3..........110;chapter 4..........180;chapter 5..........230;chapter 6..........260");
        book.setPublisher("Packt Publishing");
        book.setYear(2009);
        book.setPages(272);
        book.setBinding(Book.BINDING_HARD);

        //scroll book to page
        int pageNum = 33;
        book.scrollToPage(pageNum);
        //Search Chapter of book
        System.out.println("Search chapter for page " + pageNum + ". Chapter is : " + book.getChapterByPage(pageNum));
        //Get list of Chapters
        System.out.println("\nList of Chapters");
        List<String> chaps = book.getChapterList();
        for (String cha : chaps) {
            System.out.println(cha);
        }

        //Post office static method
        System.out.println();
        System.out.println("VolumetricWeight for h:10 w:20 d:30 , weight 500 is: " + PostOfficeExt.CalculateVolumetricWeight(10, 20, 30, 500));
        System.out.println("VolumetricWeight for h:10 d:300 , weight 200 is: " + PostOfficeExt.CalculateVolumetricWeight(10, 300, 200));

        //Pet extended methods
        PetExt pet = new PetExt();
        System.out.println();
        pet.eat(3);
    }
}
