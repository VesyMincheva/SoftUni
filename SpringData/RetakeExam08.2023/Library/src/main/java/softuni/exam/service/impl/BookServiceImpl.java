package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public BookServiceImpl(BookRepository bookRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.bookRepository = bookRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/books.json"));
    }

    @Override
    public String importBooks() throws IOException {
        final StringBuilder booksResult = new StringBuilder();

        final List<BookImportDto> books =
                Arrays.stream(gson.fromJson(readBooksFromFile(), BookImportDto[].class))
                        .collect(Collectors.toList());

        for (BookImportDto book : books) {
            booksResult.append(System.lineSeparator());

            if (this.bookRepository.findFirstByTitle(book.getTitle()).isPresent() ||
                    !this.validationUtils.isValid(book)) {
                booksResult.append(String.format("Invalid book"));
                continue;
            }

            this.bookRepository.save(this.modelMapper.map(book, Book.class));

            booksResult.append(String.format("Successfully imported book %s - %s",
                    book.getAuthor(),
                    book.getTitle()));
        }

        return booksResult.toString().trim();
    }
}
