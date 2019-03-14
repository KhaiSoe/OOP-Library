package com.example.oop_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.oop_library.book.Book;
import com.example.oop_library.library.Library;

public class MainActivity extends AppCompatActivity {
    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLibrary();
    }

    private void setupLibrary() {
        library = new Library("Example");
        library.donateBooks(getBooks());
    }

    private Book getBooks() {
        return null;
    }
}
