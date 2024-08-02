package ageria;

import ageria.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Inserisci il codice ISBN, il Titolo, l'anno, il numero di pagine, l'Autore e il genere del libro che vuoi aggiungere");
        System.out.println("Inserisci il codice ISBN: ");
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

        Book book1 = new Book(isbn, title, year, pages, author, genre);
        List<Book> bookList = new ArrayList<>();
        addElemet(bookList, book1);
        System.out.println(bookList);
        System.out.println("Inserisci il codice ISBN del libro che vuoi eleiminare dalla lista");
        isbn = scanner.nextInt();
        scanner.nextLine();
        removeElemet(bookList, isbn);
        System.out.println(bookList);
    }

    public static void addElemet(List<Book> bookList, Book book) {
        bookList.add(book);
    }

    public static void removeElemet(List<Book> bookList, int isbn) {
        if (bookList.size() <= 0) System.out.println("Non ci sono elementi. Non puoi rimuovere niente");
        else bookList.removeIf(book -> book.getIsbn() == isbn);
    }

    public static void searchByISBN(List<Book> bookList, int isbn) {
        bookList.stream().filter(book -> book.getIsbn() == isbn).forEach(book -> System.out.println(book));
    }

    public static void searchByYear(List<Book> bookList, String year) {
        bookList.stream().filter(book -> Objects.equals(book.getPublishedDate(), year)).forEach(System.out::println);
    }

    public static void searchByAuthor(List<Book> bookList, String author) {
        bookList.stream().filter(book -> Objects.equals(book.getPublishedDate(), author)).forEach(System.out::println);
    }


}
