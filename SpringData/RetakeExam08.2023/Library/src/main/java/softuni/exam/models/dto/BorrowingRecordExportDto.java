package softuni.exam.models.dto;

import java.time.LocalDate;

public class BorrowingRecordExportDto {

    private BookExportInfoDto book;

    private LocalDate borrowDate;

    private LibraryMemberExportInfoDto libraryMember;

    public BorrowingRecordExportDto() {
    }

    public BookExportInfoDto getBook() {
        return book;
    }

    public void setBook(BookExportInfoDto book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LibraryMemberExportInfoDto getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMemberExportInfoDto libraryMember) {
        this.libraryMember = libraryMember;
    }

    @Override
    public String toString() {
        String FORMAT = "Book title: %s\n*Book author: %s\n**Date borrowed: %s\n***Borrowed by: %s %s\n";

        return String.format(FORMAT,
                this.book.getTitle(),
                this.book.getAuthor(),
                this.borrowDate,
                this.libraryMember.getFirsName(),
                this.libraryMember.getLastName());
    }
}
