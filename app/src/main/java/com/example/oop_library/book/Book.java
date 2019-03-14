package com.example.oop_library.book;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Data class for a book.
 * Includes the usual id, title, author, and Genre. These are set in stone when each book is created
 * and should not be changed. Therefore, they're final without any setters.
 * <p>
 * Each book should also know if it's been borrowed and when its due date is.
 * Since these are changed regularly, I have setters for each.
 * <p>
 * NOTE:
 * - If you look at my imports, my book class & package knows nothing about Users or Libraries!
 *   Books shouldn't care about any of that stuff!
 */
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final Genre genre;

    private boolean isBorrowed = false;
    private Date dueDate = null;

    public Book(final int id,
                @NonNull final String title,
                @NonNull final String author,
                @NonNull final Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    /**
     * Adds 21 days/3 weeks to the take out date to get the due date.
     *
     * @param checkoutDate The date which the book was taken out. Should be passed in by the library.
     *                  Each book is not responsible for finding out the current time--its passed in.
     */
    public void setBorrowed(@NonNull Date checkoutDate) {
        isBorrowed = true;
//        dueDate = checkoutDate + 21 days;
    }

    /**
     * Separate method for setting borrowed and returned. This is preferred over creating a single
     * method that takes in a boolean. This is clearer.
     * <p>
     * Nulls the due date since it's been returned.
     * Be careful for NPEs.
     */
    public void setReturned() {
        isBorrowed = false;
        dueDate = null;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    @NonNull
    public Genre getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
