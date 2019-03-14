package com.example.oop_library.user;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Genre;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Enums are great for defining a set of values--no nulls or undefined types.
 * In Java, you Can give enums properties/values.
 * Each membership has a limit to the number of books and which Genres each membership owner can borrow.
 */
public enum Membership {
    CHLID(3,
            new HashSet<>(Arrays.asList(Genre.YOUNG_FICTION))
    ),
    ADULT(5,
            new HashSet<>(Arrays.asList(Genre.YOUNG_FICTION, Genre.ADULT_FICTION))
    ),
    EDUCATOR(10,
            new HashSet<>(Arrays.asList(Genre.YOUNG_FICTION, Genre.ADULT_FICTION, Genre.EDUCATION))
    );

    private final int borrowLimit;

    // Using Sets since we don't want duplicates.
    private final Set<Genre> genreAccess;

    Membership(final int borrowLimit,
               @NonNull final Set<Genre> genreAccess) {
        this.borrowLimit = borrowLimit;
        this.genreAccess = genreAccess;
    }

    // No need for setters since these values don't change.

    @NonNull
    public Set<Genre> getGenreAccess() {
        return genreAccess;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }
}
