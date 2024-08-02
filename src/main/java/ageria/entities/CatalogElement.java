package ageria.entities;

import java.time.LocalDate;

public abstract class CatalogElement {

    private long isbn;
    private String title;
    private LocalDate publishedDate;
    private int pages;


    public CatalogElement(long isbn, String title, LocalDate publishedDate, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.publishedDate = publishedDate;
        this.pages = pages;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "CatalogElement: " +
                "isbn: " + isbn +
                ", title: '" + title + '\'' +
                ", publishedDate: " + publishedDate +
                ", pages: " + pages;
    }
}
