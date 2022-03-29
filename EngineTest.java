import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        engine = new EngineImpl();
    }

    private void todo() {
        fail("Unimplemented test");
    }

    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        //System.out.println("Bonjour");
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }

    @Test
    @DisplayName("Insert element, check if is in there !")
    void getBufferContents() {
        engine.insert("ABC");
        assertEquals("ABC",engine.getBufferContents());
    }

    @Test
    @DisplayName("Sélectionne un text donné, le copy et on regarde si il est dans le clipBoard")
    void getClipboardContents() {
        //set debut et fin index
        //note ce que le buufer à dans cette partie

        Selection selection = engine.getSelection();
        int iDeb = selection.getBufferBeginIndex();
        int iFin = selection.getBufferEndIndex();
        String ret = engine.getBufferContents().substring(iDeb,iFin);
        engine.copySelectedText();
        String res = engine.getClipboardContents();
        assertEquals(ret,res);
    }

    @Test
    @DisplayName("Séléctionne un text le coupe et voit si y'a le bon texte dans le clipboard et que le buffer ne contient plus la sélection")
    void cutSelectedText() {

        String ret = "ABC"; // mettre ca dans la selection IDK?
        engine.insert(ret);
        Selection sel = engine.getSelection();
        sel.setBeginIndex(0);
        sel.setEndIndex(3);
        engine.cutSelectedText();
        String res = engine.getClipboardContents();
        String res1 = engine.getBufferContents();
        //System.out.println(res);
        // le text à disparu du buffer
        assertEquals(ret,res);
        assertEquals("",res1);
        //todo();
    }


    @Test
    @DisplayName("Copy du texte et vérifie qu'il est bien copié")
    void copySelectedText() {
        String ret = "ABC"; // mettre ca dans la selection IDK?
        engine.insert(ret);
        Selection sel = engine.getSelection();
        sel.setBeginIndex(0);
        sel.setEndIndex(3);
        engine.copySelectedText();
        String res = engine.getClipboardContents();
        //System.out.println(res);
        // le text à disparu du buffer
        assertEquals(ret,res);
        //todo();
    }

    @Test
    @DisplayName("Le buffer prend le presse papier et le presse papier reste identique")
    void pasteClipboard() {
        String ret = "ABC"; // mettre ca dans la selection IDK?
        engine.insert(ret);
        Selection sel = engine.getSelection();
        sel.setBeginIndex(0);
        sel.setEndIndex(3);
        engine.cutSelectedText();
        String res = engine.getClipboardContents();
        String res1 = engine.getBufferContents();
        //System.out.println(res);
        // le text à disparu du buffer
        assertEquals(ret,res);
        assertEquals("",res1);
        // voir si le buffer contient ce text

        todo();
    }
}
