import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;



public class LionParameterizedTest {

    @ParameterizedTest
    @DisplayName("Исключение в случае некорректных данных пола")
    @ValueSource(strings={"Оно", "", " ", "Самец ", " Самец", "Самка ", " Самка", "1234"})
    @NullSource
    void doesHaveManeUnknownSexThrowsException(String sex){
        assertThrows(Exception.class, () ->{
            new Lion(sex,null);
    });
}
}
