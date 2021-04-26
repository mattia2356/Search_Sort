import java.io.FileWriter;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int [] elenco = new int [10];
        int num;
        int num2;
/*         for (int i = 0; i < elenco.length; i++) {
            elenco[i]=(int)(Math.random()*10);
        } */
        elenco[0]=0;
        elenco[1]=1;
        elenco[2]=2;
        elenco[3]=4;
        elenco[4]=3;
        elenco[5]=5;
        elenco[6]=6;
        elenco[7]=7;
        elenco[8]=8;
        elenco[9]=9;
        Dati d = new Dati(elenco); 

   
        System.out.println("\n"+"|Scrivi 1 per ricerca binaria || 2 per ricerca lineare|");
        num2=sc.nextInt();
        if(num2==1){
            System.out.println("Ricerca binaria: "+d.binarySearch(7));
            System.out.println("Num cicli binario: "+d.getBnumCicli()+"\n");
            System.out.println(d.toString());
        }
        if(num2==2){
            System.out.println("Ricerca Lineare: "+d.linearySearch(6));
            System.out.println("Numero cicli lineare: "+d.getLnumCicli()); 
            System.out.println(d.toString());
        }
 

        System.out.print("\n"+"Array prima di essere ordinato: "+d.toString());
        System.out.println("\n"+"|Scrivi 1 per Selection || 2 per Bubblesort|");
        num=sc.nextInt();
        //Selezione sort
        if(num==1){
            System.out.println("\n"+"SelectionSort");
            d.selctionSort();
            System.out.println(d.toString());
        }
        if (num == 2) {
            System.out.println("\n" + "BubbleSort");
            d.bubbleSort();
            System.out.println(d.toString());
        }

        d.save("dati.txt");

        // confronto ric lineare e binaria e salvo
        Dati v;
        int n = 10;
        FileWriter fw = new FileWriter("dati.csv");
        for (int i = 0; i < 3; i++) {
            n = n * 10;
            v = new Dati(n);

            // salvo cicli necessari per ric Lineare
            fw.write(n + "; " + v.ricLineareV2(3) + "; ");

            // salvo cicli necessari per ric Binaria
            fw.write(v.ricBinariaV2(3) + "; " + "\n");
        }
        fw.close();

        // confronto bubble sort e selection sort
        Dati vSorting;
        int n2 = 10;

        FileWriter fw2 = new FileWriter("datiSorting.txt");

        for (int i = 0; i < 3; i++) {

            n2 = n2 + 100;
            vSorting = new Dati(n2);

            // salvo cicli necessari per bubble
            fw2.write(n2 + "; " + vSorting.bubbleSort() + "; ");

            // salvo cicli necessari per selection
            fw2.write(vSorting.selctionSort() + "; " + "\n");
        }
        fw2.close();

        

    }
}
