package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {

//    @Query("Select b FROM BorrowingRecord b WHERE b.book.genre=:genre AND b.borrowDate=:borrowDate order by b.borrowDate desc")
//    List<BorrowingRecord> findAllByBook_GenreOrderByBorrowDateDesc(Genre genre, LocalDate borrowDate);
    List<BorrowingRecord> findAllByBook_GenreAndBorrowDateBeforeOrderByBorrowDateDesc(Genre genre, LocalDate borrowDate);

}
