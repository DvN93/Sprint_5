import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() throws Exception{
        this.feline= new Feline();
    }

    @Test
    @DisplayName("Метод getFamily возвращает верное значение")
    void getFamilyReturnsCatFamily(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("Метод getKittens возвращает значение 1")
    void getKittensWithoutParamsReturnsOne(){
        assertEquals(1,feline.getKittens());
    }

    @Test
    @DisplayName("Метод getKittens возвращает значение переданное в параметре")
    void getKittensWithParamsReturnsValue(){
        assertEquals(2,feline.getKittens(2));
    }

    @Test
    @DisplayName("Метод eatMeat возвращает значение Хищник")
    void eatMeatReturnPredator() throws Exception{
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
}
