package pl.adamdylus;

public class Main {

    public static void main(String[] args) {
	    final int N = 10;
        Lista l = new Lista(10);

        for (int i = 0; i < N/2; ++i) {
            l.dodajElement( (1 << i) );
        }

        l.dodajElement(2);
        l.dodajElement(8);
        l.pisz();
        l.usunPierwszy(2);
        l.pisz();

        for (int i = 0; i < N/2; ++i) {
            l.dodajElement( (1 << i) );
        }
        l.pisz();
    }
}
