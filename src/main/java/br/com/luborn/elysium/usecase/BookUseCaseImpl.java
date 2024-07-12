package br.com.luborn.elysium.usecase;

import br.com.luborn.elysium.dto.BookDTO;
import br.com.luborn.elysium.entity.BookEntity;
import br.com.luborn.elysium.mapper.BookMapper;
import br.com.luborn.elysium.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookUseCaseImpl implements BookUseCase {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookTitle(bookDTO.getBookTitle());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookYear(bookDTO.getBookYear());

        BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.toDomain(savedBook);
    }

    @Override
    public BookDTO updateBook() {

        return null;
    }

    @Override
    public BookDTO deleteBook() {

        return null;
    }

    @Override
    public BookDTO getBook(String id) {
        try {
            long bookId = Long.parseLong(id);
            BookEntity bookEntity = bookRepository.findById(bookId)
                    .orElseThrow(() -> new NoSuchElementException("Book not found"));
            return bookMapper.toDomain(bookEntity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid book ID format: " + id, e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Book not found with ID: " + id, e);
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {

        return List.of();
    }
}
