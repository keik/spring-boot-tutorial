package spring_boot_tutorial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_boot_tutorial.domain.book.Book;
import spring_boot_tutorial.domain.book.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

}
