import com.example.FelineBehavior;
import com.example.LionAlex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionAlexTest {

    @Mock
    private FelineBehavior felineBehaviorMock;
    private LionAlex lionAlex;

    @Test
    @DisplayName("Количество котят льва Алекса")
    void getKittensReturnZero() throws Exception{
        LionAlex lionAlex = new LionAlex(felineBehaviorMock);
        assertEquals(0,lionAlex.getKittens());
    }

    @Test
    @DisplayName("Список друзей льва Алекса")
    void getFriendsReturnAlexFriends() throws Exception{
        LionAlex lionAlex = new LionAlex(felineBehaviorMock);
        List<String> resultList = lionAlex.getFriends();
        assertEquals(3,resultList.size());
        assertEquals("зебра Марти", resultList.get(0));
        assertEquals("бегемотиха Глория", resultList.get(1));
        assertEquals("жираф Мелман", resultList.get(2));
    }

    @Test
    @DisplayName("Место жительства льва Алекса")
    void getPlaceOfLivingReturnNewYorkZoo() throws Exception{
        LionAlex lionAlex = new LionAlex(felineBehaviorMock);
        String place = lionAlex.getPlaceOfLiving();
        assertEquals("Зоопарк Нью-Йорка", place);
    }
}
