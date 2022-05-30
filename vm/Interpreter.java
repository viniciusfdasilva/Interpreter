public class Interpreter {
    

    public static void procedure_S(int token){
        
    }

    public static void G(String lexeme){
        int token = Token.getToken(lexeme);
        procedure_S(token);
    }
}
