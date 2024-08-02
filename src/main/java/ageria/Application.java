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

            String choice = scanner.nextLine();

            if (Objects.equals(choice, "0")) break;
            else {
                switch (choice) {
                    case "1":
                        addElement(bookList);
                    case "2":
                        removeElemet(bookList);
                    case "3":
                        searchBy(bookList);
                }
            }
        }


        addElement(bookList);
        System.out.println(bookList);
        System.out.println("Inserisci il codice ISBN del libro che vuoi eleiminare dalla lista");


        System.out.println(bookList);


    }

    public static void addElement(List<Book> bookList) {
        System.out.println("Inserisci il codice ISBN: ");
        try {
            int isbn = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci il Titolo: ");
            String title = scanner.nextLine();
            System.out.println("Inserisci L'anno di pubblicazione: ");
            String year = scanner.nextLine();
            System.out.println("Inserisci il numero di pagine: ");
            int pages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci L'Autore: ");
            String author = scanner.nextLine();
            System.out.println("Inserisci il genere: ");
            String genre = scanner.nextLine();
            Book book = new Book(isbn, title, year, pages, author, genre);
            bookList.add(book);
        } catch (InputMismatchException e) {
            System.out.println("Dato errato, inserisci un numero valido" + e.getMessage());
        }
    }

    public static void removeElemet(List<Book> bookList) {
        if (bookList.size() <= 0) System.out.println("Non ci sono elementi. Non puoi rimuovere niente");
        
        else
            System.out.println("Inserisci il codice ISBN del elemento che vuoi rimuovere");
        int isbn = scanner.nextInt();
        scanner.nextLine();
        bookList.removeIf(book -> book.getIsbn() == isbn);
        System.out.println("Lista aggiornata" + bookList);
    }

    public static void searchBy(List<Book> bookList) {
        System.out.println("Cosa vuoi cercare?");
        System.out.println("1 - Cerca con ISBN");
        System.out.println("2 - Cerca per anno di pubblicazione");
        System.out.println("1 - Cerca per autore");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                try {
                    System.out.println("Inserisci il codice ISBN dell'elemento che vuoi cercare");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    bookList.stream().filter(book -> book.getIsbn() == isbn).forEach(book -> System.out.println(book));
                } catch (InputMismatchException e) {
                    System.out.println("Dato errato, inserisci un numero valido" + e.getMessage());
                }
            case "2":
                try {
                    System.out.println("Inserisci il codice ISBN dell'elemento che vuoi cercare");
                    String year = scanner.nextLine();
                    bookList.stream().filter(book -> Objects.equals(book.getPublishedDate(), year)).forEach(System.out::println);
                } catch (InputMismatchException e) {
                    System.out.println("Dato errato, inserisci un numero valido" + e.getMessage());
                }
            case "3":
                try {
                    System.out.println("Inserisci il codice ISBN dell'elemento che vuoi cercare");
                    String author = scanner.nextLine();
                    bookList.stream().filter(book -> Objects.equals(book.getAuthor(), author)).forEach(System.out::println);
                } catch (InputMismatchException e) {
                    System.out.println("Dato errato, inserisci un numero valido" + e.getMessage());
                }
        }


    }


    public static void writeData(String filePath, List<Book> bookList) throws IOException {
        StringBuilder str = new StringBuilder();
        for (Book book : bookList) str.append(book.getIsbn()).append(System.lineSeparator());
        FileUtils.writeStringToFile(new File(filePath), str.toString(), StandardCharsets.UTF_8, true);
    }

    public static void readData(String filePath, List<Book> bookList) throws IOException {
        String content = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        String[] contentAsArray = content.split(System.lineSeparator());
        for (String book : contentAsArray) {
            String[] bookString = book.split(", ");
        }
    }


}
