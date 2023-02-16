package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        long startTime = System.currentTimeMillis();

        logger.info(bookRepository.getByIsbn("isbn-1111").toString());
        logger.info(bookRepository.getByIsbn("isbn-0000").toString());
        logger.info(bookRepository.getByIsbn("isbn-1111").toString());
        logger.info(bookRepository.getByIsbn("isbn-0000").toString());
        logger.info(bookRepository.getByIsbn("isbn-0000").toString());
        logger.info(bookRepository.getByIsbn("isbn-1111").toString());
        logger.info(bookRepository.getByIsbn("isbn-2222").toString());

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Execution time: " + elapsedTime + " milliseconds");
    }
}
