import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class IO {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        testPrintWriter("cammelli.txt",true);
    }

    public static void testDefaultInput(){
        String input="";
        Scanner defInput=new Scanner(System.in);
        while(defInput.hasNext()){
            input=input+defInput.next();
        }
        System.out.println(input);
        defInput.close();
    }
    public static void testDelimiters(){
        String stringaTest="Ciao-a-tutti";
        Scanner s=new Scanner(stringaTest);
        s.useDelimiter("-"); //Questo si usa per aggiungere un delimitatore

        while(s.hasNext()){
            System.out.println(s.next());
        }

        s.close();
    }
    public static void testFileReader(String path){
        FileReader reader;
        try{
            reader=new FileReader(path);
        }
        catch(FileNotFoundException exc){
            System.out.println("The file was not found");
            return;
        }
        String output="";
        while(true){
            int x;
            try{
                x=reader.read();
            }
            catch(IOException exc){
                System.out.println("An exception occoured while reading the file");
                return;
            }
            if(x==-1){
                break;
            }
            char elaboratedChar=(char)x;
            output=output+elaboratedChar;
        }
        try{
            reader.close();
        }
        catch(IOException exc){}
        System.out.println(output);
    }

    public static void testBufferedReader(String path) throws FileNotFoundException, IOException{
        FileReader reader=new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(reader);
        String s;
        while((s=bufferedReader.readLine())!=null){
            System.out.print(s+" ");
        }

        reader.close();
    }

    public static void testFileWriter(String path,boolean append) throws IOException{
        FileWriter writer=new FileWriter(path,append);
        writer.write("\nCammelli dei cammelli\nQuesto dovrebbe stare a capo");
        writer.close();
    }
    public static void testPrintWriter(String path, boolean append) throws IOException{
        PrintWriter printWriter;
        if(!append){
            printWriter=new PrintWriter(path);
        }
        else{
            printWriter=new PrintWriter(new FileWriter(path,true));
        }

        printWriter.println("Cammelli dei cammelli");
        printWriter.println("Questo dovrebbe stare a capo");

        printWriter.close();
    }
    //Si può eseguire la lettura anche usando Scanner
}
