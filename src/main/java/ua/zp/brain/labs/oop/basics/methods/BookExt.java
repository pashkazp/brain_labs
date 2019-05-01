package ua.zp.brain.labs.oop.basics.methods;

import ua.zp.brain.labs.oop.basics.classes.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Extended Book object that represents extended Class book
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class BookExt extends Book {
    private int chaptersCount;
    private int currentPage;
    private String chapters;


    public String getChapters() {
        return chapters;
    }

    /**
     * Set chaters and calculate chapters count
     *
     * @param chapters string of whole chapters
     */
    public void setChapters(String chapters) {
        this.chapters = chapters;
        this.setChaptersCount(chapters.split(";").length);
    }

    /**
     * Scroll pages of book to pege number if it is possible
     *
     * @param pageNum the number of the page you are looking for
     */
    public void scrollToPage(int pageNum) {
        if (pageNum > getPages() || pageNum < 0) {
            System.out.println("Page number is unreachable. Scroll cancelled.");
            return;
        }
        System.out.println("Total pages : " + getPages() +
                ". Current page is : " + getCurrentPage() +
                ". Try search the " + pageNum + " page.");
        int leftP = 0;
        int rightP = getPages();
        while (pageNum != getCurrentPage()) {
            if (pageNum > getCurrentPage()) {
                leftP = getCurrentPage();
                System.out.print("Divide the right side between " + leftP + " and " + rightP +
                        " page numbers in about half.");
                setCurrentPage((leftP + rightP) / 2);
                System.out.println(" Current page is set to: " + getCurrentPage());
            } else {
                rightP = getCurrentPage();
                System.out.print("Divide the left side between " + leftP + " and  " + rightP +
                        " page numbers in about half.");
                setCurrentPage((leftP + rightP) / 2);
                System.out.println(" Current page is set to: " + getCurrentPage());
            }
        }
        System.out.println("Page " + pageNum + " is found.");
    }

    public int getChaptersCount() {
        return chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<String> getChapterList() {
        return Arrays.asList(chapters.split(";"));
    }

    /**
     * Search appropriate Chapter by page num and return it or empty
     *
     * @param pageNum page number of Chapter
     * @return name of chapter
     */
    public String getChapterByPage(int pageNum) {
        String[] chaps = chapters.split(";");
        if (pageNum < 0 || pageNum > getPages()) {
            return "Chapter not found";

        }
        int chapIndex = 0;
        for (String cha : chaps) {
            int nextChapIndex = Integer.valueOf(cha.substring(cha.lastIndexOf(".") + 1));
            if (nextChapIndex > pageNum) {
                if (chapIndex == 0) {
                    break;
                }
                return chaps[--chapIndex];
            } else {
                chapIndex++;
            }
        }
        return "Chapter not found";
    }
}
