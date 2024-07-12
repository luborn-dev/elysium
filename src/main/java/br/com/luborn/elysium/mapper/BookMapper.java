package br.com.luborn.elysium.mapper;

import br.com.luborn.elysium.dto.BookDTO;
import br.com.luborn.elysium.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO toDomain(BookEntity livro) {
        BookDTO livroDTO = new BookDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setBookTitle(livro.getBookTitle());
        livroDTO.setBookAuthor(livro.getBookAuthor());
        livroDTO.setBookYear(livro.getBookYear());
        return livroDTO;
    }
}
