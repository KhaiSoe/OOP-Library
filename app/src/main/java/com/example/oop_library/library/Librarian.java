package com.example.oop_library.library;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Book;
import com.example.oop_library.user.User;

import java.util.Date;

/**
 * My "interactor" or "manager" for my library. This is who is exposed to the public as an interface
 * to the library (in real life) and so it's what I wrote to expose to the rest of the app through the
 * LibrarianInterface.
 * <p>
 * Note that my interface only has 1 method: lendBook(). No one else needs to know
 * about my librarian checking if the user has the correct membership, if the book is available,
 * or if they have too many books.
 */
public class Librarian implements LibrarianInterface {
    private final LibraryInterface library;

    /**
     * @param library The library that the librarian works at.
     */
    public Librarian(@NonNull final LibraryInterface library) {
        this.library = library;
    }

    /**
     * The only method I expose. The public only needs to know about the librarian lending books.
     * They don't care about how or if they make checks in the background.
     */
    @Override
    public void lendBook(@NonNull final User user,
                         @NonNull final Book book) {
        if (!library.isMember(user)) {
            library.registerUser(user);
        }

        if (canBorrow(user, book)) {
            final Date checkoutDate = new Date();
            book.setBorrowed(checkoutDate);
            user.borrow(book);
            library.updateBookStatus(book);
        }
    }

    /**
     * Notice I break down each of my boolean checks.
     * This allows me to produce side effects in the form on notifications/toasts/snackbars
     * if the check returns false.
     */
    private boolean canBorrow(@NonNull final User user,
                              @NonNull final Book book) {
        return hasCorrectMembership(user, book)
                && isBookAvailable(book)
                && hasTooManyBooks(user);
    }

    /**
     * Notice that although my librarian makes the check if the user has the correct membership,
     * it's not its job to SHOW the notification. That's up to the library.
     * My librarian should have nothing to do with views.
     */
    private boolean hasCorrectMembership(@NonNull User user,
                                         @NonNull Book book) {
        final boolean hasCorrectmembership = user.getMembershipType()
                .getGenreAccess()
                .contains(book.getGenre());

        if (!hasCorrectmembership) {
            library.notifyIncorrectMembership(user);
        }

        return hasCorrectmembership;
    }

    /**
     * Same comment as above.
     */
    private boolean isBookAvailable(@NonNull Book book) {
        final boolean isAvailable = !book.isBorrowed();

        if (!isAvailable) {
            library.notifyBookUnavailable(book);
        }

        return isAvailable;
    }

    /**
     * Same comment as above.
     */
    private boolean hasTooManyBooks(@NonNull User user) {
        final boolean atBookLimit = user.getAllBorrowedBooks().size() != user.getMembershipType().getBorrowLimit();

        if (atBookLimit) {
            library.notifyIncorrectMembership(user);
        }

        return atBookLimit;
    }
}
