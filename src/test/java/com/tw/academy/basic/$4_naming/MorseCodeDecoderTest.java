package com.tw.academy.basic.$4_naming;

import com.tw.academy.basic.$4_naming.practiceOne.MorseCodeDecoder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeDecoderTest {
    @Test
    public void testBasicMorseDecoding() {
        assertEquals(MorseCodeDecoder.decode(".-"), "A");
        assertEquals(MorseCodeDecoder.decode("."), "E");
        assertEquals(MorseCodeDecoder.decode(".."), "I");
        assertEquals(MorseCodeDecoder.decode(". ."), "EE");
        assertEquals(MorseCodeDecoder.decode(".   ."), "E E");
    }

    @Test
    public void testMoreComplexTests() {
        assertEquals(MorseCodeDecoder.decode(" . "), "E");
        assertEquals(MorseCodeDecoder.decode("   .   . "), "E E");
        assertEquals(MorseCodeDecoder.decode("        - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  "), "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.");
    }
}