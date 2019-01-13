import AlgoTools.IO;

public class MaximumSuche {

  public static void main(String[] args) {

    int[] eingabe;

    int groeste=0;
    int zweitgroeste=0;

    int groeste_stelle=0;
    int zweitgroeste_stelle=0;

    do {
      eingabe = IO.readInts("Geben Sie eine Zahlenfolge ein: ");
    }while (eingabe.length<2);

    int laenge = eingabe.length;

    for (int i=0;i<laenge ;i++ ) {
      if (eingabe[i]>groeste) {
        zweitgroeste=groeste;
        zweitgroeste_stelle=groeste_stelle;
        groeste=eingabe[i];
        groeste_stelle=i+1;
      }else if (eingabe[i]>zweitgroeste) {
          zweitgroeste=eingabe[i];
          zweitgroeste_stelle=i+1;
        }
    }
    IO.println("Die groesste Zahl ist "+groeste+" an Stelle "+groeste_stelle);
    IO.println("Die zweitgroesste Zahl ist "+zweitgroeste+" an Stelle "+zweitgroeste_stelle);
  }
}
