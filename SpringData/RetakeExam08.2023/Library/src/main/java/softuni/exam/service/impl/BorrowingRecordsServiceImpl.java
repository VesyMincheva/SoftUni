package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordExportDto;
import softuni.exam.models.dto.BorrowingRecordWrapperDto;
import softuni.exam.models.dto.BorrowingRecordsImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository,
                                       BookRepository bookRepository,
                                       LibraryMemberRepository libraryMemberRepository,
                                       ValidationUtils validationUtils,
                                       ModelMapper modelMapper,
                                       XmlParser xmlParser) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/borrowing-records.xml"));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        final StringBuilder stringBuilder = new StringBuilder();

        final List<BorrowingRecordsImportDto> records =
                this.xmlParser
                        .fromFile(Path.of("src/main/resources/files/xml/borrowing-records.xml").toFile(), BorrowingRecordWrapperDto.class).getBorrowingRecord();

        for (BorrowingRecordsImportDto record : records) {
            stringBuilder.append(System.lineSeparator());

            if (this.validationUtils.isValid(record)) {
                final Optional<Book> book =
                        this.bookRepository.findFirstByTitle(record.getBook().getTitle());
                final Optional<LibraryMember> member =
                        this.libraryMemberRepository.findFirstById(record.getLibraryMember().getId());

                if (book.isEmpty() || member.isEmpty()) {
                    stringBuilder.append(String.format("Invalid borrowing record"));
                    continue;
                }

                final BorrowingRecord recordToSave = this.modelMapper.map(record, BorrowingRecord.class);
                recordToSave.setBorrowDate(LocalDate.parse(record.getBorrowDate()));
                recordToSave.setReturnDate(LocalDate.parse(record.getReturnDate()));
                recordToSave.setBook(book.get());
                recordToSave.setLibraryMember(member.get());


                this.borrowingRecordRepository.save(recordToSave);
                stringBuilder.append(String.format("Successfully imported borrowing record %s - %s",
                        record.getBook().getTitle(),
                        record.getBorrowDate()));
                continue;
            }
            stringBuilder.append(String.format("Invalid borrowing record"));
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {

        StringBuilder sb = new StringBuilder();

        List<BorrowingRecord> records =
                borrowingRecordRepository
                        .findAllByBook_GenreAndBorrowDateBeforeOrderByBorrowDateDesc(Genre.SCIENCE_FICTION,
                                LocalDate.parse("2021-09-10"));

        records.forEach(r -> {
            sb.append(String.format("Book title: %s\n*Book author: %s\n**Date borrowed: %s\n***Borrowed by: %s %s",
                    r.getBook().getTitle(),
                    r.getBook().getAuthor(),
                    r.getBorrowDate(),
                    r.getLibraryMember().getFirsName(),
                    r.getLibraryMember().getLastName()))
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
