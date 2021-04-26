import java.io.*;
public class Dati {
    private int [] array;
    private int numEle;
    private static final int MAXNUMELE=10;
    private int lnumCicli;
    private int bnumCicli;

//costruttore default
    public Dati(){
        array=new int[MAXNUMELE];
        numEle=0;
        lnumCicli=0;
        bnumCicli=0;
    }
    public Dati(int n){
        array = new int[n];
        numEle=n;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

    }

    //costruttore master
    public Dati(int []dati){
        this();
        for (int i = 0; i < dati.length; i++) {
            array[i]=dati[i];
            numEle++;
        }
    }

    //Costruttore di copia
    public Dati(Dati vet){
        this();
        for (int i = 0; i < array.length; i++) {
            array[i]=vet.getValore(i);
            numEle++;
        }
    }

    public static int getMaxnumele() {
        return MAXNUMELE;
    }

    //GETNumele
    public int getNumEle() {
        return numEle;
    }
    //Getnumero cicli binario
    public int getBnumCicli() {
        return bnumCicli;
    }
//Get numero cicli binario
    public int getLnumCicli() {
        return lnumCicli;
    }

    //GETVALORE
    public int getValore(int n){
        return array[n];
    } 

    //Tostring
    public String toString(){
        String s="";
        for (int i = 0; i < array.length; i++) {
            s+="| "+array[i]+" |";
        }
        return s;
    }

    //EQUALS
    public boolean equals(Dati d){
        boolean cond=true;
        int i=0;
         while (i<MAXNUMELE && cond == true) {
             if(array[i]!=d.getValore(i)){
                 cond = false;
             }
             i++;
         }
         return cond;
    }

    //SAVE
    public void save (String nome)throws Exception{
        FileWriter fv = new FileWriter(nome);
        fv.write(toString());
        fv.close();
    }

    //LinearySearch return int per uso generale
    public int linearySearch(int chiave){
        int i=0;
        while (i<MAXNUMELE && array[i]!=chiave) {
            i++;
            lnumCicli++;
        }
        if(i != MAXNUMELE){
            return i;
        }
        else{
            return -1;
        }
    }

    public int binarySearch(int chiave){
        int low =0;
        int high = array.length-1;
        int mid=(low+high)/2;

        while (low <=high && array[mid]!=chiave) {
            if(array[mid] < chiave){
                low = mid+1;
                
            }
            else{
                high = mid-1;
            }
            mid = (low + high)/2;
            bnumCicli++;
        }
        if(low > high){
            mid = -1;
        }
        return mid;
    }



//NUOVI METODI PER RICERCA

    // ricerca lineare per statistica
    public int ricLineareV2(int n) {
        //deve restituire numero di cicli impiegati per fornire un risultato
        int cicli = 0;

        int pos = -1;
        int i = 0;
        while (i < array.length && pos == -1) {
            if (array[i] == n) {
                pos = i;
            }
            i++;

            //contatore cicli statistico
            cicli++;
        }

        return cicli;
    }

    // ricerca binaria per statistica
    public int ricBinariaV2(int n) {
        //deve restituire numero di cicli impiegati per fornire un risultato
        int cicli = 0;

        int high = array.length - 1;
        int low = 0;
        int mid = (low + high) / 2;

        while (low <= high && array[mid] != n) {
            if (array[mid] < n) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else { // array[mid] > n
                high = mid - 1;
                mid = (low + high) / 2;
            }

            //contatore cicli statistico
            cicli++;
        }
        if (low > high) {
            mid = -1;
        }
        return cicli;
    }

  /*   //bubble sort
    public int bubbleSort() 
    {
        int bnumSort=0;
        int n = MAXNUMELE;
        boolean cond;
        for(int i=0; i<n; i++) 
        {
            cond = false;
            for(int j=1; j<(n-i); j++)
            {
              if(array[j-1] > array[j])
                {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    cond = true;
                }
                bnumSort++;
            }
            if (!cond)
            break;
        }
        return bnumCicli;
    }

    public int selectionSort(){  
        int snumSort=0;
        for (int i = 0; i < array.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < array.length; j++){  
                if (array[j] < array[index]){  
                    index = j;//searching for lowest index  
                } 
                snumSort++; 
            }  
            int smallerNumber = array[index];   
            array[index] = array[i];  
            array[i] = smallerNumber;  
        }  
        return snumSort;
    }  */

    //bubble sort (+ contatore cicli)
    public int bubbleSort(){

        int n = numEle;
        boolean swapped;
        int cicli = 0;

        for(int i=0; i<n; i++) 
        {
            swapped = false;
            for(int j=1; j<(n-i); j++)
            {
              if(array[j-1] > array[j])
                {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            //aumento contatore
            cicli++;

            if (!swapped){
                break;
            }
        }

        return cicli;
    }

    //selection sort (+ contatore cicli)
    public int selctionSort(){

        int minIndex, lunghezza, temp;
        lunghezza = array.length;

        int cicli = 0;

        for (int startIndex = 0; startIndex <= lunghezza-2; startIndex++){
            minIndex = startIndex;

            for (int i = startIndex+1; i <= lunghezza-1; i++) {
                if (array[i] < array[minIndex]){
                    minIndex = i;
                }
                //aumento contatore cicli
                //cicli++;
            }

            temp = array[startIndex];
            array[startIndex] = array[minIndex];
            array[minIndex] = temp;

            //aumento contatore cicli
            cicli++;

        }
        return cicli;
    }
    
}
