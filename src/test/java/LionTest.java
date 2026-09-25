import com.example.FelineBehavior;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private FelineBehavior felineBehaviorMock;
    private Lion lion;

    @BeforeEach
    void setUp() throws Exception{
        this.lion = new Lion("Самец",felineBehaviorMock);
    }

    @Test
    @DisplayName("У самца должна быть грива")
    void doesHaveManeMaleLionHaveMane() throws Exception{
        Lion maleLion = new Lion("Самец", felineBehaviorMock);
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    @DisplayName("У самки не должно быть гривы")
    void doesHaveFemaleLionDoesntHaveMane() throws Exception{
        Lion femaleLion = new Lion("Самка",felineBehaviorMock);
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    @DisplayName("Возвращает количество котят")
    void getKittensReturnKittens() throws Exception{
        when(felineBehaviorMock.getKittens()).thenReturn(2);
        int result = lion.getKittens();
        assertEquals(2,result);
        verify(felineBehaviorMock).getKittens();
    }

    @Test
    @DisplayName("Проверка вызова getFood с аргументом Хищник")
    void getFoodReturnFood() throws Exception{
        when(felineBehaviorMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> resultList = lion.getFood();
        assertEquals(3, resultList.size());
        assertEquals("Животные", resultList.get(0));
        assertEquals("Птицы", resultList.get(1));
        assertEquals("Рыба", resultList.get(2));

        verify(felineBehaviorMock).getFood("Хищник");
    }

    @Test
    @DisplayName("getFood выбрасывает исключение")
    void getFoodThrowsException() throws Exception{
    when(felineBehaviorMock.getFood("Хищник")).thenThrow(new Exception("Выброшено исключение"));
    assertThrows(Exception.class, () ->{
        lion.getFood();
        });
    verify(felineBehaviorMock).getFood("Хищник");
    }

}
