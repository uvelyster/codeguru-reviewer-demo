package com.packt.aws.books.pipeline;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.aws.books.pipeline.dao.BookEntity;
import com.packt.aws.books.pipeline.dao.BookRepositiry;

@RestController
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BookRepositiry bookRepositiry;

	@GetMapping("/book")
	public ResponseEntity<Void> createBook(@RequestParam String bookTitle,
			@RequestParam(required = false) String author) {
		Random random = new Random();
		Integer id = random.nextInt();
		BookEntity book = new BookEntity();
		if (author != null) {
			LOGGER.info("Author name is {}", author);
			book.setAuthor(author);
		} else {
			LOGGER.info("Missing author name for id {}", id);
		}
		if (author != null) {
			bookTitle = bookTitle.toLowerCase();
			LOGGER.info("Author name is {}", bookTitle);
			book.setTitle(bookTitle);
		} else {
			LOGGER.error("Missing book title for book id {}", id);
		}
		book.setId(id);
		bookRepositiry.save(book);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
