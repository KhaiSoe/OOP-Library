package com.example.oop_library.library;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Book;
import com.example.oop_library.user.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Basic data class for a simple library that has
 * a name and holds a Set of books and a Set of registered users.
 * A library by itself is just the building with a set of books and users. They don't perform
 * any transactions. I have a Librarian class for that.
 * <p>
 * NOTE:
 * - I'm exposing only the methods my Librarian needs from the Library through an interface.
 * - The library doesn't handle any of the book lending/borrowing transactions.
 * - Only Library class/package knows about both Books AND Users.
 */
public class Library implements LibraryInterface {
    // Each library has a name;
    private final String name;
    // But also holds all the books.
    private final Set<Book> bookInventory = new HashSet<>();
    // As well as all the members it has. Remember in order to take out a book, you need to have
    // a library card and be registered in their database.
    private final Set<User> userList = new HashSet<>();

    public Library(@NonNull final String name) {
        this.name = name;
    }

    @Override
    public void updateBookStatus(@NonNull final Book book) {
        bookInventory.add(book);
    }

    @Override
    public boolean isMember(@NonNull final User user) {
        return userList.contains(user);
    }

    @Override
    public void registerUser(@NonNull final User user) {
        this.userList.add(user);
    }

    @Override
    public void removeUser(@NonNull final User user) {
        this.userList.remove(user);
    }

    /**
     * I have my library doing all the notifying since my Librarian class is just an "interface"
     * for the user to interact with the library.
     */
    @Override
    public void notifyIncorrectMembership(@NonNull User user) {
        // Notify user they have incorrect membership.
    }

    @Override
    public void notifyBookUnavailable(@NonNull Book book) {
        // Notify user book has been taken out.
    }

    @Override
    public void notifyTooManyBooks(@NonNull User user) {
        // Notify user has too many books checked out.
    }
}
