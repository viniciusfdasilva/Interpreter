import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Runtime;
import java.io.InputStream;
import java.util.Collections;
import java.util.Stack;

public class Main{
    static List<String> history;
    static List<String> history_shell;
    public static void main(String[] args){
        if(args.length > 1){
            readFile();
        }else{
            readPrompt();
        }
    }

    public static void readFile(){}

    public static void readPrompt(){
        history = new ArrayList<>();
        history_shell = new ArrayList<>();

        clearScreen();

        while(true){
            System.out.print("> ");

            String line = (new Scanner(System.in)).nextLine();
            
            List<String> listline = Arrays.asList(line.split(" "));
            Collections.reverse(listline);
            Stack<String> stack = iterator(listline);

            if(line.length() > 0 && checkCommands(line)){
                history.add(line);
                //for(int i = 0; i < stack.size(); i++){
                //    Interpreter.G(stack.pop());
                //}
                
            }         
        }
    }

    public static boolean checkCommands(String line){
        return !checkExit(line) & !checkClear(line) & !checkHistory(line) & !checkShell(line);
    }
    
    public static Stack<String> iterator(List<String> lexemes){
        Stack<String> stack = new Stack<>();
        lexemes.forEach((lexeme) -> stack.push(lexeme));
        return stack;
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean checkExit(String line){
        line = line.trim();

        if(line.equals("exit") || line.equals("exit()")){
            System.exit(1);
            return true;
        }
        return false;
    }

    public static boolean checkClear(String line){
        line = line.trim();

        if(line.equals("clear") || line.equals("cls")){
            clearScreen();
            return true;
        }
        return false;
    }

    public static boolean checkHistory(String line){
        line = line.trim();

        if(line.equals("history")){

            System.out.println("========== LANGUANGE HISTORY ==========");
            history.forEach((cmd) -> System.out.println(cmd));
            System.out.println("=======================================");
            return true;
            
        }else if(line.equals("history --shell") || line.equals("history -s")){

            System.out.println("============ SHELL HISTORY =============");
            history_shell.forEach((cmd) -> System.out.println(cmd));
            System.out.println("========================================");
            return true;
        }

        return false;
    }

    public static boolean checkShell(String line){
       line = line.trim(); 

        if(line.charAt(0) == '!'){ 
            line = line.replaceAll("!", "");
                       
            history_shell.add(line);
            String result = execCmd(line);
            System.out.println(result == null ? "Sintaxe incorreta!" : result.trim());
            return true;     
        }
        return false;
    }

    public static String execCmd(String cmd) {
        String result = null;
       if(cmd.length() > 0){
            try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream(); Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
                result = s.hasNext() ? s.next() : null;
            } catch (IOException e) {
                System.out.println("Não foi possível realizar a execução!");
                return "";
            }
        }
        return result;
    }
}