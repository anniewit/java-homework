import AlgoTools.IO;
// ein und ausgabe funktion kopieren

public class Cesar {

  public static void main(String[] args) {

    String kryptotext;      
    int i;                  //index der for-schleifen
    int max;                //speichert den höchsten Wert, zum Vergleichen
    int pos = 0;            
    int ord;
    int schluessel;
    int[] zaehler = new int[26];
    char haeufigster;
    char [] klartext;
    char zeichen;

    do {
        kryptotext = IO.readString("Verschlüsselter Text: ");
    } while (kryptotext.length() == 0);

    //kleinbuchstaben Umwandeln
    kryptotext = kryptotext.toLowerCase();
    
    //Zählen der Buchstaben
    for(i= 0; i<kryptotext.length(); i++){
        if(kryptotext.charAt(i) <= 'z' && kryptotext.charAt(i) >= 'a'){
            ord = (int) kryptotext.charAt(i) - (int) 'a';
            zaehler[ord] = zaehler[ord] + 1;
        }
    }
  /*  //zaehler ausgeben
    for (i=0; i< zaehler.length-1; i++){
        IO.print(zaehler[i]);
    }
    IO.println(); 
    */

    //häufigsten Buchstaben finden
    max = zaehler[0];
    for (ord = 1; ord < zaehler.length-1; ord++){
       
        if (max < zaehler[ord]){
            max = zaehler[ord];
            pos = ord;
        }
    }    
    //häufigsten ausgeben
    haeufigster = (char) (pos + (int)'a');
    IO.print("Häufigster Buchstabe: " + haeufigster + ",");

    //schlüssel berechnen
    schluessel = (int) haeufigster -(int) 'e';
    schluessel = (schluessel+26) % 26;

    IO.println( " Schlüssel: " + schluessel);


    //Kryptotext umwandeln in klartext 
    klartext  = new char[kryptotext.length()];
    for(i =0; i < kryptotext.length(); i++){

        zeichen = kryptotext.charAt(i);

        if(zeichen <= 'z' && zeichen >= 'a'){
            ord = (int)zeichen - (int) 'a';
            ord = ((ord - schluessel)+26) %26;
            klartext[i]=(char) (ord + (int) 'a');
        } else {
            klartext[i]=zeichen;
        }
    }
    //klartext ausgeben
    for (i=0; i< klartext.length; i++){
        IO.print(klartext[i]);
    }
    IO.println();
   }
}