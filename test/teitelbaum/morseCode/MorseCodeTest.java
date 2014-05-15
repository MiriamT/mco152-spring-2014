package teitelbaum.morseCode;

import org.junit.Assert;
import org.junit.Test;

import teitelbaum.morseCode.MorseCodeOld;

public class MorseCodeTest 
{
	@Test
	public void testAlphabetToMorseCode()
	{
		MorseCodeOld morseCode = new MorseCodeOld();
		String alphabet = "?>+abcdefghijklmnopqrstuvwxyz 1234567890";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. / .---- ..--- ...-- ....- ..... -.... --... ---.. ----. -----"; //must go online and get the morsecode for alphabet (copy/paste)
		
		Assert.assertEquals(expected, code); //throws exception if not equal
	}
	
	@Test
	public void testMorseCodeToAlphabet()
	{
		MorseCodeOld mc = new MorseCodeOld();
		String code = "? ------ ......... .---- ..--- ...-- ....- ..... -.... --... ---.. ----. ----- / .- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String translation = mc.toPlainText(code);
		String expected = "1234567890 ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		Assert.assertEquals(expected, translation);
	}
	
	@Test
	public void testAlphaToMorseCodeAndBack()
	{
		MorseCodeOld beep = new MorseCodeOld();
		String alphabet = "abcdefghijklmnopqrstuvwxyz 1234567890";
		String code = beep.toMorseCode(alphabet);
		String backtoAlpha = beep.toPlainText(code);
		
		Assert.assertEquals(alphabet.toUpperCase(), backtoAlpha);
	}
	
	@Test
	public void testMorseCodeToAlphaAndBack()
	{
		MorseCodeOld boop = new MorseCodeOld();
		String code = ".---- ..--- ...-- ....- ..... -.... --... ---.. ----. ----- / .- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
		String translation = boop.toPlainText(code);
		String backToCode = boop.toMorseCode(translation);
		
		Assert.assertEquals(code, backToCode);
	}
	
	
}
