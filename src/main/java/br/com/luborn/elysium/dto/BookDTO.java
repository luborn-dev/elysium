package br.com.luborn.elysium.dto;

public class BookDTO {

    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int bookYear;

    public BookDTO() {
    }

    public BookDTO(Long id, String bookTitle, String bookAuthor, int bookYear) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }
}
