package labs.lab4.test;

import labs.lab4.AlphabetSymbol;
import labs.lab4.NonResolvedSymbolException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetSymbolTest {

    @Test
    public void AlphabetSymbolThrowsNonResolvedSymbolExceptionTest(){
        assertThrows(NonResolvedSymbolException.class, ()-> new AlphabetSymbol('.'));
    }

    @Test
    public void AlphabetSymbolFromCharTest() throws Exception{
        assertEquals(new AlphabetSymbol('c').character, 'c');
    }

    @Test
    public void AlphabetSymbolFromStringCorrectTest() throws Exception{
        assertEquals(new AlphabetSymbol("s").character, 's');
    }

    @Test
    public void AlphabetSymbolFromStringThrowsIllegalArgumentExceptionTest(){
        assertThrows(IllegalArgumentException.class, ()-> new AlphabetSymbol("string"));
    }

    @Test
    public void AlphabetSymbolFromStringThrowsNonResolvedSymbolExceptionTest(){
        assertThrows(NonResolvedSymbolException.class, ()-> new AlphabetSymbol("."));
    }
}