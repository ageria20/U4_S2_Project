package ageria;

import ageria.entities.Book;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Inserisci il codice ISBN, il Titolo, l'anno, il numero di pagine, l'Autore e il genere del libro che vuoi aggiungere");


        List<Book> bookList = new ArrayList<>();

        while (true) {

            System.out.println("Scegli cosa fare");
            System.out.println("1 - Per aggiungere un Elemento");
            System.out.println("2 - Per eliminare un elemento");
            System.out.println("3 - Ricerca un articolo");
            System.out.println(bookList);

            String choice = scanner.nextLine();

            if (Objects.equals(choice, "0")) break;
            else {
                switch (choice) {
                    case "1":
                        addElement(bookList);
                        break;
                    case "2":
                        removeElement(bookList);
                        break;
                    case "3":
                        searchBy(bookList);
                        break;
                }
            }
        }


        addElement(bookList);
        System.out.println(bookList);
        System.out.println("Vuoi inserire i librio dentro file? [y/n]");
        String choice = scanner.nextLine();

        switch (choice) {
            case "y":
                try {
                    writeData("src/catalog.txt", bookList);
                } catch (IOException e) {
                    System.out.println();
                }
                break;
            default:
                System.out.println("See u, bye");
                break;
        }


        System.out.println(bookList);


    }

    public static void addElement(List<Book> bookList) {


        try {
            System.out.println("Inserisci il codice ISBN: ");
            int isbn = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il Titolo: ");
            String title = scanner.nextLine();
            System.out.println("Inserisci l'anno di pubblicazione: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci il numero di pagine: ");
            int pages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci l'Autore: ");
            String author = scanner.nextLine();
            System.out.println("Inserisci il genere: ");
            String genre = scanner.nextLine();
            Book book = new Book(isbn, title, year, pages, author, genre);
            bookList.add(book);

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
    }

    public static void removeElement(List<Book> bookList) {
        try {
            if (bookList.size() <= 0) {
                System.out.println("Non ci sono elementi. Non puoi rimuovere niente.");
            } else {
                System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere:");
                int isbn = scanner.nextInt();
                scanner.nextLine();
                bookList.removeIf(book -> book.getIsbn() == isbn);
                System.out.println("Lista aggiornata: " + bookList);
            }
        } catch (RuntimeException e) {
            System.out.println("Input non valido. Assicurati di inserire i dati correttamente.");
            scanner.nextLine();
        }
    }

    public static void searchBy(List<Book> bookList) {
        System.out.println("Cosa vuoi cercare?");
        System.out.println("1 - Cerca con ISBN");
        System.out.println("2 - Cerca per anno di pubblicazione");
        System.out.println("3 - Cerca per autore");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                try {
                    System.out.println("Inserisci il codice ISBN dell'elemento che vuoi cercare");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    bookList.stream().filter(book -> book.getIsbn() == isbn).forEach(book -> System.out.println(book));
                } catch (InputMismatchException e) {
                    System.out.println("Input non valido. Assicurati di inserire i dati correttamente.");
                    scanner.nextLine();
                }
            case "2":
                try {
                    System.out.println("Inserisci l'anno di pubblicazione dell'elemento che vuoi cercare");
                    String year = scanner.nextLine();
                    bookList.stream().filter(book -> Objects.equals(book.getPublishedDate(), year)).forEach(System.out::println);
                } catch (InputMismatchException e) {
                    System.out.println("Input non valido. Assicurati di inserire i dati correttamente.");
                    scanner.nextLine();
                }
            case "3":
                try {
                    System.out.println("Inserisci il nome dell'Autore dell'elemento che vuoi cercare");
                    String author = scanner.nextLine();
                    bookList.stream().filter(book -> Objects.equals(book.getAuthor(), author)).forEach(System.out::println);
                } catch (InputMismatchException e) {
                    System.out.println("Input non valido. Assicurati di inserire i dati correttamente.");
                    scanner.nextLine();
                }
        }


    }


    public static void writeData(String filePath, List<Book> bookList) throws IOException {
        StringBuilder str = new StringBuilder();
        for (Book book : bookList) {
            str.append(book.getIsbn()).append(", ")
                    .append(book.getTitle()).append(", ")
                    .append(book.getAuthor()).append(", ")
                    .append(book.getPages()).append(", ")
                    .append(book.getPublishedDate()).append(", ")
                    .append(book.getGenre()).append(System.lineSeparator());
        }
        FileUtils.writeStringToFile(new File(filePath), str.toString(), StandardCharsets.UTF_8, true);
    }


    public static void readData(String filePath, List<Book> bookList) throws IOException {
        String content = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        String[] contentAsArray = content.split(System.lineSeparator());
        for (String book : contentAsArray) {
            String[] bookString = book.split(", ");
            if (bookString.length == 6) {
                int isbn = Integer.parseInt(bookString[0]);
                String title = bookString[1];
                String author = bookString[2];
                int pages = Integer.parseInt(bookString[3]);
                int year = Integer.parseInt(bookString[4]);
                String genre = bookString[5];
                bookList.add(new Book(isbn, title, year, pages, author, genre));
                System.out.println(bookList);
            }
        }
    }

}
