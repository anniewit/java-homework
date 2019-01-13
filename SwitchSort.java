import AlgoTools.IO;

public class SwitchSort {

  /**
  * Diese Operation gibt ein Integer-Array auf der Konsole aus.
  */
  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      IO.print(" " + array[i]);
    }
    IO.println();
  }

  //Sortiert ein int Array
  public static int[] sort(int[] array) {
    int n = array.length;
    int j;
    int m = 0;      //zaehler
    int i= n-1;     //initialisiert auf Ende des Arrays
    int dummy;

    do{
      m = 0;

      for (j = 0; j < n; j++){
        if (array[j] > array[i]){  // Vergleicht alle Zahlen in Array mit einer Zahl
          m = m + 1;               //Zählt wie viele Elemente größer sind als array[i]
        }                          // Berechnet dadurch den richtigen Platz
      }

      dummy = array[i];
      array[i] = array[n-m-1];     //vertauscht die Zahl mit ihrem richtigen Platz, die andere Zahl wird betrachtet
      array[n-m-1] = dummy;

      if(m == n - i - 1){           //ist die größte Zahl ganz hinten, wird die Zahl davor betrachtet
        i--;
      }

    }while(i > 0);    

    return array;
  }



  /**
  * Diese Operation liest ein Integer-Array und gibt dieses nur dann zur�ck,
  * wenn dieses mindestens die L�nge 1 hat.
  */
  public static int[] readArray() {
    // Variablendeklaration
    int[] array;

    // Sicheres Einlesen des Arrays
    do {
      array = IO.readInts("Unsortiertes Array: ");
    } while (array.length == 0);
    return array;
  }


  /**
  * Die Hauptoperation von SwitchSort.
  * Hier erfolgt die Variablendeklaration des (un-)sortierten Arrays und
  * ansonsten nur die Operationsaufrufe.
  */
  public static void main(String[] args) {
    IO.println();

    // Variablendeklaration
    int[] array;

    // Einlesen des zu sortierenden Integer-Arrays
    array = readArray();

    // Ausgabe des urspr�nglichen Arrays
    IO.print("Unsortiertes Array: ");
    printArray(array);


    // Hier wird die Operation sort() aufgerufen. Diese implementiert den
    // Switch-Sort-Algorithmus.
    sort(array);


    // Ausgabe des sortierten Arrays
    IO.print("Sortiertes Array: ");
    printArray(array);

    IO.println();
  }

}
