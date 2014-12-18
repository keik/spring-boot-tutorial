package spring_boot_tutorial.service;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import spring_boot_tutorial.Application;
import spring_boot_tutorial.domain.book.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class BookServiceTest {

    @Autowired
    BookService SUT;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        jdbcTemplate.execute("TRUNCATE SCHEMA public AND COMMIT");
        jdbcTemplate
                .execute("INSERT INTO book (id, title, author, publisher) VALUES (1, 'Spring3入門', '長谷川 裕一', '技術評論社');"
                        + "INSERT INTO book (id, title, author, publisher) VALUES (2, '計算機プログラムの構造と解釈', 'ジェラルド・ジェイ・サスマン', 'ピアソン');"
                        + "INSERT INTO book (id, title, author, publisher) VALUES (3, '軽快なJava', 'ブルース・A. テイト', 'オライリージャパン');");
    }

    @Test
    public void すべての本を取得できる() throws Exception {
        // exercise
        List<Book> books = SUT.findAllBook();

        // verify
        assertThat(books, hasSize(3));
    }

}
