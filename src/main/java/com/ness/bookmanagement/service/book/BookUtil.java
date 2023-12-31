package com.ness.bookmanagement.service.book;

import com.ness.bookmanagement.constant.ErrorCodes;
import com.ness.bookmanagement.exception.NotFoundException;

import java.util.function.Supplier;

public class BookUtil {
    private BookUtil() {
    }

    public static Supplier<NotFoundException> bookNotFoundException(long id) {
        return () ->
                new NotFoundException(
                        "Book not found with ID: " + id,
                        ErrorCodes.BOOK_NOT_FOUND
                );
    }

}
