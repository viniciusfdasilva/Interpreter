import java.util.Map;
import java.util.HashMap;

public class Token{
    
    private static Map<String, Integer> keywords;
    
    public static final int AND    =  0x00000;
    public static final int ELSE   =  0x00002;
    public static final int FOR    =  0x00003;
    public static final int IF     =  0x00004;
    public static final int NIL    =  0x00005;
    public static final int OR     =  0x00006;
    public static final int PRINT  =  0x00007;
    public static final int RETURN =  0x00008;
    public static final int TRUE   =  0x00009;
    public static final int FALSE  =  0x0000a;
    public static final int WHILE  =  0x0000b;

    private static void init(){
        keywords = new HashMap<>();

        keywords.put("and",    AND);
        keywords.put("or",     OR);

        keywords.put("if",     IF);
        keywords.put("else",   ELSE);

        keywords.put("for",    FOR);
        keywords.put("while",  WHILE);

        keywords.put("nil",    NIL);
        
        keywords.put("print",  PRINT);
        keywords.put("return", RETURN);
        
        keywords.put("true",   TRUE);
        keywords.put("false",  FALSE);

    }

    public static int getToken(String lexeme){
        init();
        return keywords.get(lexeme);
    }
}