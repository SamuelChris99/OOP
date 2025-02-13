import java.util.ArrayList;

class Author {
    private String name;
    private String desc;

    public Author(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

class Book {
    private String title;
    private String isbn;
    private Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }
}

class Borrower {
    private ArrayList<Book> borrowedBooks;
    private String name;

    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("===================================");
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Biography: " + book.getAuthor().getDesc());
            System.out.println("===================================");
        }
    }
}

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

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("James Gosling", "Creator of the Java programming language.");
        Author author2 = new Author("Robert C. Martin", "Known for his works on software craftsmanship.");

        Book book1 = new Book("Java Programming", "123456789", author1);
        Book book2 = new Book("Clean Code", "987654321", author2);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);

        Borrower borrower = new Borrower("Alice");

        library.borrowBook(borrower, book1);
        library.borrowBook(borrower, book2);

        borrower.displayBorrowedBooks();

        library.returnBook(borrower, book1);

        borrower.displayBorrowedBooks();

        library.displayLibraryBooks();
    }
}
