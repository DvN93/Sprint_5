import com.example.Cat;
import com.example.Predator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Predator predatorMock;



    @Test
    @DisplayName("Возврат верного значения звуков кошки")
    void getSoundReturnsMeow(){
        Cat cat = new Cat(null);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("Проверка вызова метода getFood")
    void getFoodReturnsCatsFood() throws Exception{
        Cat cat = new Cat(predatorMock);
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> resultList = cat.getFood();
        assertEquals(3, resultList.size());
        assertEquals("Животные", resultList.get(0));
        assertEquals("Птицы", resultList.get(1));
        assertEquals("Рыба", resultList.get(2));
        verify(predatorMock).eatMeat();
    }
}
