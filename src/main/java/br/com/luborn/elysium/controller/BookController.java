package br.com.luborn.elysium.controller;

import br.com.luborn.elysium.dto.BookDTO;
import br.com.luborn.elysium.usecase.BookUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class BookController {

    private final BookUseCase bookUseCase;

    @Autowired
    public BookController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable String id) {
        try {
            BookDTO book = bookUseCase.getBook(id);
            return ResponseEntity.ok(book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/books")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookUseCase.createBook(bookDTO);
    }
}
