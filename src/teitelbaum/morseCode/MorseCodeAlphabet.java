package teitelbaum.morseCode;

public enum MorseCodeAlphabet 
{
	A(".-"), B("-..."), C("-.-."), D("-.."), E("."), F("..-."), G("--."), H("...."), I(".."), J(".---"), K("-.-"), L(".-.."), M("--"), N("-."),
	O("---"), P(".--."), Q("--.-"), R(".-."), S("..."), T("-"), U("..-"), V("...-"), W(".--"), X("-..-"), Y("-.--"), Z("--..");
	
private final String morseCode;

private MorseCodeAlphabet(String mc)
{
	morseCode = mc;
}

public String getMorseCode()
{
	return morseCode;
}

}


