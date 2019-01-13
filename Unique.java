 
import AlgoTools.IO;
public class Unique {
  public static void main(String[] args){
   
    int[] eingabe;
    int i, j;
    boolean doppelt = false;


    //einlesen, es müssen mindestens zwei ints im Array sein
    do {
        eingabe = IO.readInts("Bitte ein Integer-Array: ");
    } while (eingabe.length < 2);
    
    
    //Äußere Schleife betrachtet jeweils eine Zahl im Array 
    //Während innere Schleife sie mit den folgenden Zahlen vergleicht
    //Sind zwei gleiche Elemente gefunden, bricht die innere und die äußere Schleife ab
    for(i = 0; i < eingabe.length && !doppelt; i++){
        for(j = i+1; j < eingabe.length; j++){
            if(eingabe[i]==eingabe[j]){
                doppelt=true;
                break;
            }
        }
    }

    if(doppelt){
        IO.println("Es kommen einige Elemente doppelt vor!");
    }else{
        IO.println("Alle Elemente kommen nur einmal vor!");
    }
  }
}