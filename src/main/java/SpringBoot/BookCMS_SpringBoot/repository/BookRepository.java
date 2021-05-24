package SpringBoot.BookCMS_SpringBoot.repository;

import SpringBoot.BookCMS_SpringBoot.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findAllByCategoryId(Integer cateId);

}
