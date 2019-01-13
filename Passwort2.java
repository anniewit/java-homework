import AlgoTools.IO;
public class Passwort2 { 

    static int laenge;
    static char [] pw = new char [laenge];
    static boolean gefunden = false;

    public static void main(String[] args){

        int [] ordnungszahl = new int [pw.length];
        int i, j;
        int ord;
        int zaehler;
        char zeichen;

        zaehler=1;
        j=0;
        
        int[]pw = new int[laenge];
        
        do{

            //Berechnet die Ordnungzahlen an der jeweiligen Stelle
            for(i=0; i < ordnungszahl.length-1; i++){
                if(zaehler% Math.pow(26,i) == 0){
                    ordnungszahl[i]=(ordnungszahl[i]+1)%26;
                }
            }

            //Trägt Buchstaben ein
            do{
                
                ord = ordnungszahl[j] + (int) 'a';
                zeichen= (char) ord;
                
            }while()

            IO.print (pw); 
            pruefen(); 

            zaehler = zaehler +1;
                    
        } while(!gefunden);
    }
    public static char Arrayvergroeßern() {
        
        laenge= laenge+1;
        char[]pw = new char[laenge];
        int[]ordnungszahl = new int[laenge];
        return char[] pw;
        return int[] ordnungszahl;
        return laenge;
        
    
        
    } 

    public static void pruefen() {
        
    
        String password = new String (pw);
        String result = Secret.getSuperSecretText(password);

        if (result.length() == 0) {
            IO.println(" Passwort ist falsch!");
        } else {
            IO.println(" Korrektes Passwort. Geheimer Text:");
            IO.println(result);
            gefunden =true;
        }
    } 
    
    
}