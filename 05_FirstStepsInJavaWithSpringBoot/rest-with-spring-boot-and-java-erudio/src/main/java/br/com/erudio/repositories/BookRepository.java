package br.com.erudio.repositories;

import br.com.erudio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
