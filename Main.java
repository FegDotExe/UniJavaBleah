import java.util.Scanner;
public class Main {
    public static void main(String[] args)throws EmptyCDException{
        MiaCD coda1=new MiaCD();
        MiaCD coda2=new MiaCD();
        MiaCD coda3=new MiaCD();

        Scanner console=new Scanner(System.in);
        while(console.hasNext()){
            String line=console.nextLine();
            Scanner lineScanner=new Scanner(line);
            try{
                int number=Integer.parseInt(lineScanner.next());
                coda1.addLast(number);
            }
            catch(NumberFormatException exc){}
            lineScanner.close();
        }
        console.close();
        while(!coda1.isEmpty()){
            coda2.addFirst(coda1.removeLast());
        }
        while(!coda2.isEmpty()){
            coda3.addLast(coda2.removeFirst());
        }
        while(!coda3.isEmpty()){
            System.out.println(coda3.removeLast());
        }


        //-Inserire alla fine della 1
        //Svuotare 1 con removeLast e aggiungere all'inizio della 2
        //Svuotare 2 dall'inizio e aggiungere alla fine della tre
        //Svuotare 3 dall'inizio e scrivere in uscita standard
    }
}
