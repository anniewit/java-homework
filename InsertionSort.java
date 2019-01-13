import AlgoTools.IO;

public class InsertionSort {

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

  //Operation sortiert das Int Array
  public static int[] sort (int[] array){
    int dummy;
    int i, j;

    //jede Stelle durchgehen, von vorne nach hinten
    for(i = 1; i < array.length; i++){ 
        j = i; 

        //wenn aktueller Wert kleiner ist als voriger, beide vertauschen
        //zurückgehen und kleineren Wert so lange tauschen, bis der vorherige Wert wieder kleiner ist
        while(j > 0 && array[j-1] > array[j]){
          dummy = array[j-1];
          array[j-1] = array[j];
          array[j] = dummy;
          j--;
        }
    }
      
	  return array;
  }
 

  /**
  * Die Hauptoperation von InsertionSort.
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
    // Insertion-Sort-Algorithmus implementieren.
    sort(array);


    // Ausgabe des sortierten Arrays
    IO.print("Sortiertes Array: ");
    printArray(array);

    IO.println();
  }

}
