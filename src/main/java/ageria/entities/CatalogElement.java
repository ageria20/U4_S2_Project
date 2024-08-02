package ageria.entities;

public abstract class CatalogElement {

    private int isbn;
    private String title;
    private String publishedDate;
    private int pages;


    public CatalogElement(int isbn, String title, String publishedDate, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.publishedDate = publishedDate;
        this.pages = pages;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
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
