package ageria.entities;

import ageria.enums.Periodicity;

import java.time.LocalDate;

public class Magazine extends CatalogElement {

    private Periodicity periodicity;

    public Magazine(long isbn, String title, LocalDate publishedDate, int pages, Periodicity periodicity) {
        super(isbn, title, publishedDate, pages);
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine: " +
                "periodicity: " + periodicity;
    }


}
