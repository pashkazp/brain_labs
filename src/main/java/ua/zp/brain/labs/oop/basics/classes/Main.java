package ua.zp.brain.labs.oop.basics.classes;

/**
 * Simple program for research public and private field declarations
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // Create, init and print class Bookshelf
        Bookshelf bookshelf = new Bookshelf();

        bookshelf.setColor(Bookshelf.COLOR_BLUE);
        bookshelf.setMaterial(Bookshelf.MATERIAL_METALL);
        bookshelf.setWidth(900);
        bookshelf.setHeight(300);
        bookshelf.setDepth(200);

        System.out.println(bookshelf);

        // Create, init an print class Pet
        Pet pet = new Pet();

        pet.setCategory(Pet.CATEGORY_ELEFANT);
        pet.setName("Vasja");
        pet.setWidth(3500);
        pet.setHeigh(75000);
        pet.setWeight(5400000);

        System.out.println();
        System.out.println(pet);

        // Create, init and print class Book
        Book book = new Book();

        book.setAuthor("Lüppken, Sven & Stäuble, Markus");
        book.setIdISBN("isbn:9781847195425, amazon:1847195423, google:WTp3mAEACAAJ");
        book.setTitle("Spring Web Flow 2 Web Development");
        book.setLabels("Computers, Web, Design, spring, Java");
        book.setPublisher("Packt Publishing");
        book.setYear(2009);
        book.setPages(272);
        book.setBinding(Book.BINDING_HARD);

        System.out.println();
        System.out.println(book);

        // Create, init and print class PostOffice
        PostOffice postOffice = new PostOffice();
        postOffice.setCity("Запоріжжя");
        postOffice.setCodeZIP("43");
        postOffice.setAdrressLine("Бородинська вулиця, 11");
        postOffice.setPostOfficeType(PostOffice.TYPE_POST);
        postOffice.setLatitude("47.887448");
        postOffice.setLongtitude("35.075352");

        System.out.println();
        System.out.println(postOffice);

    }

}
