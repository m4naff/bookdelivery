package com.example.exception.book;

import com.example.exception.ProcessException;

import java.io.Serial;

/**
 * Custom exception class for cases where there is no available stock.
 */
public class NoAvailableStockException extends ProcessException {

    @Serial
    private static final long serialVersionUID = -5669253377318124296L;

    private static final String DEFAULT_MESSAGE =
            "No available stock!";

    private static final String MESSAGE_TEMPLATE =
            "No available stock for the given amount : ";

    public NoAvailableStockException(int amount) {
        super(MESSAGE_TEMPLATE.concat(String.valueOf(amount)));
    }

    public NoAvailableStockException() {
        super(DEFAULT_MESSAGE);
    }

}
