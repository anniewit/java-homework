import AlgoTools.IO;

public class Bigramme { 
 public static void main(String[] args){

    String text;
    String bigramm;
    String haeufigster = "";        
    int [][] zaehler = new int [26][26];
    int i, ord = 0;
    int  ord2 = 0;
    int max;                //Vergleichswert
    int pos =0;             //merkt sich Stelle, an dem höchstes Bigramm vorkommt
    int pos2 = 0;           //merkt sich Stelle, an dem höchstes Bigramm vorkommt
    boolean ende = false;



    do {
        text = IO.readString("Bitte einen String eingeben: ");
    } while (text.length() == 0);

    //kleinbuchstaben Umwandeln
    text = text.toLowerCase();

    //bigramme zählen
    for(i= 0; i<text.length()-1; i++){
        if(text.charAt(i) <= 'z' && text.charAt(i) >= 'a'){
            if(text.charAt(i+1) <= 'z' && text.charAt(i+1) >= 'a'){
                ord = (int) text.charAt(i) - (int) 'a';
                ord2 = (int) text.charAt(i+1) - (int) 'a';
                zaehler[ord][ord2] = zaehler[ord][ord2] + 1;
            }
        }
    }

    //häufigstes Bigramm finden
    max = zaehler[0][0];
    for (ord = 1; ord < zaehler.length-1; ord++){
       for (ord2 = 1; ord2 < zaehler.length-1; ord2++){
        if (max < zaehler[ord][ord2]){
            max = zaehler[ord][ord2];
            pos = ord;
            pos2 = ord2;
        }
       }
    }    
    //häufigsten ausgeben
    haeufigster = haeufigster + (char) (pos + (int)'a');
    haeufigster = haeufigster + (char) (pos2 + (int)'a');

    IO.print("Häufigstes Bigramm: " + haeufigster + ", kommt " + zaehler[pos][pos2] + " mal vor.");
    IO.println();

    
    do{
        bigramm = IO.readString("Bitte Bigramm eingeben (oder nichts zum abbrechen): ");
        
        if(bigramm.length() == 0){
        ende = true;
        }else if (bigramm.length() == 2){
            //kleinbuchstaben Umwandeln
            bigramm = bigramm.toLowerCase();

            //bigramm in Tabelle finden
            ord = (int) bigramm.charAt(0) - (int) 'a';
            ord2 = (int) bigramm.charAt(1) - (int) 'a';

            IO.print("Das Bigramm " + bigramm + " kommt " + zaehler[ord][ord2] + " mal vor.");
            IO.println();
            }
    }while(!ende);
    IO.println();
 }
}