package spring_boot_tutorial.service;

import java.util.List;

import spring_boot_tutorial.domain.book.Book;

public interface BookService {

    /**
     * すべての本を取得する。
     *
     * @return 本のリスト
     */
    public List<Book> findAllBook();

}
