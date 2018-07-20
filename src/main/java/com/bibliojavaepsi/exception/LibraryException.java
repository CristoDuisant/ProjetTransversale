package com.bibliojavaepsi.exception;

/**
 * returned exception when encountering an error during a method involving the processing of a book
 */
public class LibraryException extends Exception
    {
        /**
         * defines the constructor of the exception returned by some methods
         * @param message
         */
        public LibraryException(String message)
            {
                super(message);
            }
    }
