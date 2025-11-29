package hw04;

public class Book {

    public static int MIN_PRICE = 250;
    public static int BIG_BOOK_PAGES = 500;

    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        return pages > BIG_BOOK_PAGES;
    }

    public boolean matches(String word) {
        word = word.toLowerCase();
        return title.toLowerCase().contains(word) ||
                author.name.toLowerCase().contains(word) ||
                author.surname.toLowerCase().contains(word);
    }

    public int estimatePrice() {
        int price = (int) Math.floor(pages * 3 * Math.sqrt(author.rating));
        return Math.max(price, MIN_PRICE);
    }

    public String getInfo() {
        return "Книга: '" + title + "'. Автор книги: '" + author.getInfo() + "'. Год выпуска: '"
                + releaseYear + "' Количество страниц: " + pages;
    }
}
