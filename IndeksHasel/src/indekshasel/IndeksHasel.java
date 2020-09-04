package indekshasel;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Żaneta
 */
public class IndeksHasel {

    public static void main(String[] args) {

       // List list = new List();
        BSTree tree = new BSTree();
        StringTokenizer st;
        System.out.println("Podaj liczbe linii tekstu do przetworzenia: ");
        Scanner sc = new Scanner(System.in);
        int linie = sc.nextInt();
        String[] hasla = new String[linie];
        System.out.println("Wprowadz dane w poszczegolnych liniach");
        sc.nextLine();
        for(int i=0; i<hasla.length; i++){
            System.out.println("Podaj dane: ");
            hasla[i] = sc.nextLine();
        }
        for(int j=0; j<hasla.length; j++){
            st=new StringTokenizer(hasla[j]);
            int ile = st.countTokens();
            for(int i=0; i<ile; i++){
                String indeks = st.nextToken();
                tree.add(indeks);
            }
        }
        System.out.println("Indeks hasel");
        tree.indexAppearance(hasla);
    }

}
