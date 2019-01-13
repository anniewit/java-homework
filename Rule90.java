import AlgoTools.IO;

public class Rule90 {

public static void main(String[] args) {

//Anfangszustand einlesen
    int[] eingabe = IO.readInts("Geben Sie einen Zustand ein: ");
    int laenge = eingabe.length;
//Zahl der Schritte einlesen
    int schritte = IO.readInt("Geben Sie die Anzahl der Schritte ein: ");
//in Boolean-Array konvertieren
    boolean[] zustand = new boolean[laenge];
    boolean[] zustand_neu = new boolean[laenge];

    for (int i1=0;i1<laenge ;i1++ ) {
      if (eingabe[i1]==0) {
        zustand[i1]=false;
      }else{
        zustand[i1]=true;
      }
    }
//nöchsten Schritte simulieren und ausgeben
  for (int i2=0;i2<=schritte ;i2++ ) {
  //aktuellen Zustand ausgeben
    for (int i3=0;i3<laenge ;i3++ ) {
      if (zustand[i3]==true) {
        IO.print("@");
      }else{
        IO.print(".");
      }
    }

  //aus aktuellen Zustand neuen Zustand berechnen
    for (int i4=0;i4<laenge ;i4++ ) {
      //erstes Element
      if (i4==0) {
        if (zustand[laenge-1]!=zustand[1]) {
          zustand_neu[i4]=true;
        }else{
          zustand_neu[i4]=false;
        }
      }
      //letztes Element
      else if (i4==(laenge-1)) {
        if (zustand[laenge-2]!=zustand[0]) {
          zustand_neu[i4]=true;
        }else{
          zustand_neu[i4]=false;
        }
      }
      //Standardfall
      else if (zustand[i4-1]!=zustand[i4+1]) {
          zustand_neu[i4]=true;
        }else{
          zustand_neu[i4]=false;
        }
      }
      for (int i5=0;i5<laenge ;i5++ ) {
      zustand[i5]=zustand_neu[i5];
    }
    IO.println();
  }
}
}
