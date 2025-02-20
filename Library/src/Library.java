import java.util.*;

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to library: " + book.getTitle());
    }

    public void borrowBook(Borrower borrower, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            borrower.borrowBook(book);
            System.out.println(borrower.getName() + " borrowed: " + book.getTitle());
        }
    }

    public void returnBook(Borrower borrower, Book book) {
        borrower.returnBook(book);
        books.add(book);
        System.out.println(borrower.getName() + " returned: " + book.getTitle());
    }

    public void displayLibraryBooks() {
        System.out.println("Books in library:");
        for (Book book : books) {
            System.out.println("===================================");
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Biography: " + book.getAuthor().getDesc());
            System.out.println("===================================");
        }
    }
}