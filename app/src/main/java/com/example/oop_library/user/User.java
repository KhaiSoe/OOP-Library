package com.example.oop_library.user;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Book;

import java.util.HashSet;
import java.util.Set;

/**
 * Data class for each user.
 * <p>
 * Has typical values such as id and name.
 * Borrowedbooks is also final because we don't want to overwrite the set of borrowed books--we only want to remove from it and add to it.
 * Membershiptype is also non final since it's possible to upgrade memeberships as users get older.
 * <p>
 * NOTE:
 * - If you look at my imports, my user class & package knows nothing about Libraries and ONLY about Books!
 *   Users should not know anything about the inner workings of a Library!
 */
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private Membership membershipType;
    private final Set<Book> borrowedBooks = new HashSet<>();

    public User(final int id,
                @NonNull final String firstName,
                @NonNull final String lastName,
                @NonNull final Membership membershipType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipType = membershipType;
    }

    /**
     * Our borrow method. This lives in the User object as the user is the one borrowing the book
     * and taking it with them.
     *
     * @param book The book the user wants to borrow.
     * @return This let's the library know if the borrow was successful. This return type is mostly
     * for database queries since they're not guarenteed.
     */
    public boolean borrow(@NonNull final Book book) {
        return this.borrowedBooks.add(book);
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    @NonNull
    public Membership getMembershipType() {
        return membershipType;
    }

    @NonNull
    public Set<Book> getAllBorrowedBooks() {
        return borrowedBooks;
    }
}
