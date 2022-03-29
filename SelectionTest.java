import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionTest {

    private Selection selection;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        selection = new SelectionImpl() {
        };
    }

    private void todo() {
        fail("Unimplemented test");
    }

    @Test
    @DisplayName("Index de début")
    void getBeginIndex(){
        assertEquals(0,selection.getBeginIndex());
        //todo();
    }

    @Test
    @DisplayName("Index de fin")
    void getEndIndex(){
        assertEquals(0,selection.getEndIndex());
        //todo();
    }

    @Test
    @DisplayName("Index de début du buffer")
    void getBufferBeginIndex(){
        assertEquals(0,selection.getBufferBeginIndex());
        //todo();
    }

    @Test
    @DisplayName("Index de fin du buffer")
    void getBufferEndIndex(){
        assertEquals(0,selection.getBufferEndIndex());
        //todo();
    }

    @Test
    @DisplayName("Change indice de début et voit si ca change")
    void setBeginIndex(){
        selection.setBeginIndex(12);
        assertEquals(12,selection.getBeginIndex());
        //todo();
    }

    @Test
    @DisplayName("Change indice de fin et voit si ca change")
    void setEndIndex(){
        selection.setEndIndex(12);
        assertEquals(12,selection.getEndIndex());
        //todo();
    }
}
