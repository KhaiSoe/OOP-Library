package com.example.oop_library.library;

import android.support.annotation.NonNull;

import com.example.oop_library.book.Book;
import com.example.oop_library.user.User;

public interface LibrarianInterface {

    void lendBook(@NonNull final User user,
                  @NonNull final Book book);
}
