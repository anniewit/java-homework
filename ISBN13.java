import AlgoTools.IO;

public class ISBN13 { 
 public static void main(String[] args){
     
    int[] ziffern;
    int pruefziffer;
    int i,  ungerade, gerade;

    //einlesen
    do {
        ziffern = IO.readInts("ISBN-13 eingeben: ");
    } while (ziffern.length !=13);

    //prüfziffer berechnen

    ungerade = ziffern[0]+ziffern[2]+ziffern[4]+ziffern[6]+ziffern[8]+ziffern[10];
    gerade = 3*(ziffern[1]+ziffern[3]+ziffern[5]+ziffern[7]+ziffern[9]+ziffern[11]);
    pruefziffer = ungerade + gerade;

    do{
        pruefziffer= pruefziffer % 10;
    }while (pruefziffer >= 10);
    
    pruefziffer = 10 - pruefziffer;

    //Ausagbe und Korrektur, falls falsche Ziffer
    if(pruefziffer != ziffern[12]){
        ziffern[12] = pruefziffer;
        IO.print("Die eingegebene Pruefziffer ist nicht korrekt. Die richtige Pruefziffer lautet: ");
        for(i = 0; i<ziffern.length;i++){
            IO.print(ziffern[i]);
        }
    }else {
        IO.println("Die Pruefziffer der eingegebenen ISBN-13 ist korrekt!");
    }
    IO.println();
 }
}