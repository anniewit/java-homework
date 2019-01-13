import AlgoTools.IO;

public class Chomp { 
 public static void main(String[] args){

    char [][] spielfeld;
    int zeilen, spalten;
    int zeile, spalte;
    int eingabeZeile, eingabeSpalte;
    boolean ende = false;
    boolean spielerA = true;              // true = Spieler A, false = Spieler B


    do {
        zeilen = IO.readInt("Zeilen: ");
    } while (zeilen <1);
    do {
        spalten = IO.readInt("Spalten: ");
    } while (spalten <1);


    spielfeld = new char [zeilen][spalten];
    do{
        //spielfeld ausgeben
        for (zeile = 0; zeile<zeilen; zeile++){
            for (spalte =0; spalte < spalten; spalte ++){
                if (spielfeld [zeile][spalte] != 'A' && spielfeld [zeile][spalte] != 'B' ){
                    spielfeld [zeile][spalte] = '.';
                }
                IO.print (spielfeld[zeile][spalte],5);
            }
            IO.println();
        }

        if (!ende) {

            if(spielerA){
                IO.println("Spieler A ist am Zug!");
            }else{
                IO.println("Spieler B ist am Zug!");
            }

            //Spielzüge einlesen
            do{
                do {
                    eingabeZeile = IO.readInt("Zeile waehlen: ");
                } while (eingabeZeile<0 || eingabeZeile >= spielfeld.length);
                do {
                    eingabeSpalte = IO.readInt("Spalte waehlen: ");
                } while (eingabeSpalte <0 || eingabeSpalte >= spielfeld[0].length);
            //prüfen, ob Stelle bereits belegt ist
            }while(spielfeld[eingabeZeile][eingabeSpalte] != '.');

            //Spiel beenden, wenn 0/0 gewählt wird
            if(eingabeZeile==0 && eingabeSpalte==0){
                ende =true;
            }else{
                //Spielfeld beschriften
                for (zeile = 0; zeile<zeilen; zeile++){
                    for (spalte =0; spalte < spalten; spalte ++){
                        if(zeile>=eingabeZeile && spalte>= eingabeSpalte){
                            if(spielerA){
                                if(spielfeld[zeile][spalte] != 'B'){
                                spielfeld[zeile][spalte] = 'A'; 
                                }
                                
                            }else if (spielfeld[zeile][spalte] != 'A'){
                                spielfeld[zeile][spalte] = 'B';
                            }
                            
                        }
                    }
                }
            }
            
                    
            //zum anderen Spieler wechseln
            spielerA= !spielerA;

        }
    }while (!ende); 

    if(spielerA){
        IO.println("SPIELER A HAT GEWONNEN!");
    }else{
        IO.println("SPIELER B HAT GEWONNEN!");
    }
    IO.println();    
    }
}
