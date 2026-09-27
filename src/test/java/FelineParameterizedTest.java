import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class FelineParameterizedTest {

    @ParameterizedTest
    @DisplayName("getFood выбрасывает исключение при невалидных значениях")
    @ValueSource(strings={"Всеядное", "", " ", "Хищник ", " Хищник", "Травоядное ", " Травоядное", "1234"})
    @NullSource
    void getFoodUnknownTypeOfAnimalThrowsExceptions(String animalKind){
        Feline feline = new Feline();
        assertThrows(Exception.class, () ->{
            feline.getFood(animalKind);
        });
    }
}
