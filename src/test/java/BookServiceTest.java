import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository; // Создаем мок-объект BookRepository

    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); // Инициализируем моки
        bookService = new BookService(bookRepository); // Создаем экземпляр BookService с использованием мока
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("1", "Test Book", "Test Book");
        when(bookRepository.findById("1")).thenReturn(Book.builder()
                .title("Test Book")
                .build());
        assertEquals(book.getTitle(), bookService.findBookById("1").getTitle());
    }

    @Test
    public void testAllBook() {
        when(bookRepository.findAll()).thenReturn(List.of());
        assertEquals(bookService.findAllBooks(), List.of());
    }
}