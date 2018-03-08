package labs.lab4.test;

import labs.lab4.NonResolvedSymbolException;
import labs.lab4.PunctuationSymbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunctuationSymbolTest {
    @Test
    public void PunctuationSymbolThrowsNonResolvedSymbolExceptionTest(){
        assertThrows(NonResolvedSymbolException.class, ()-> new PunctuationSymbol('c'));
    }

    @Test
    public void PunctuationSymbolFromCharTest() throws Exception{
        assertEquals(new PunctuationSymbol('?').character, '?');
    }

    @Test
    public void PunctuationSymbolFromStringCorrectTest() throws Exception{
        assertEquals(new PunctuationSymbol("?").character, '?');
    }

    @Test
    public void PunctuationSymbolFromStringThrowsIllegalArgumentExceptionTest(){
        assertThrows(IllegalArgumentException.class, ()-> new PunctuationSymbol("??aadsd?"));
    }

    @Test
    public void PunctuationSymbolFromStringThrowsNonResolvedSymbolExceptionTest(){
        assertThrows(NonResolvedSymbolException.class, ()-> new PunctuationSymbol("s"));
    }

}