package com.example.oop_library.library;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Book;
import com.example.oop_library.user.User;

interface LibraryInterface {

    void updateBookStatus(@NonNull Book book);

    boolean isMember(@NonNull final User user);

    void registerUser(@NonNull final User user);

    void removeUser(@NonNull final User user);

    void notifyIncorrectMembership(@NonNull final User user);

    void notifyBookUnavailable(@NonNull final Book book);

    void notifyTooManyBooks(@NonNull final User user);
}
