import AlgoTools.IO;

public class CocktailShakerSort {

  /**
  * Diese Operation gibt ein Integer-Array auf der Konsole aus.
  */
  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      IO.print(" " + array[i]);
    }
    IO.println();
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

  //Operation sortiert ein Int Array
  public static int[] sort (int[] array){
    int dummy;
    int i, j;
    int anfang, ende;
    
    anfang= 0;
    ende= array.length-1;

    // größtes Element wird an Ende platziert, kleinstes Element zum Anfang,
    // nach den Durchlauf verkürzt sich das Array um Anfang/Ende, da diese bereits die richtigen Werte haben
    while(anfang < ende){
      //läuft von vorne nach hinten und führt Nachbartausch durch, wenn aktueller Wert größer als der nächste ist
      for(i = anfang; i < ende; i++){ 
        if (array[i] > array[i+1] ) {
          dummy = array[i];
          array[i] = array[i+1];
          array[i+1] = dummy;
        } 
      }
      //größter Wert steht am Ende, muss nicht mehr betrachtet werden
      ende--;

      //läuft von hinten nach vorne, tauscht Nachbarn, wenn vorderer Wert größer ist
      for(j = ende-1; j >= anfang; j--){ 
        if ( array[j] > array[j+1] ) {
          dummy = array[j];
          array[j] = array[j+1];
          array[j+1] = dummy;
        } 
     }
     //kleinster Wert befindet sich am Anfang, muss nicht mehr betrachtet werden
     anfang++;
   
    }
      
	  return array;
  }

  /**
  * Die Hauptoperation von CocktailShakerSort.
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


    // Hier wird die Operation sort() aufgerufen. Diese soll den
    // CocktailShaker-Sort-Algorithmus implementieren.
    sort(array);


    // Ausgabe des sortierten Arrays
    IO.print("Sortiertes Array: ");
    printArray(array);

    IO.println();
  }
}
