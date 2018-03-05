package labs.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetSymbolTest {

    @Test
    public void AlphabetSymbolThrowsNonResolvedSymbolException(){
        assertThrows(NonResolvedSymbolException.class, ()-> new AlphabetSymbol('.'));
    }

    @Test
    public void AlphabetSymbolCorrectTest() throws Exception{
        assertEquals(new AlphabetSymbol('c').character, 'c');

    }
}