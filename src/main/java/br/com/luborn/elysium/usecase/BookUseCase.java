package br.com.luborn.elysium.usecase;

import br.com.luborn.elysium.dto.BookDTO;

import java.util.List;

public interface BookUseCase {
    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook();

    BookDTO deleteBook();

    BookDTO getBook(String id);

    List<BookDTO> getAllBooks();
}
