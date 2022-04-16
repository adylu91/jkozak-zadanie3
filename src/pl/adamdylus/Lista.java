package pl.adamdylus;

public class Lista {
    private int[] liczby;
    private int pojemnosc;
    private int rozmiar;

    public Lista(int pojemnosc){
        this.pojemnosc = pojemnosc;
        this.rozmiar = 0;
        this.liczby = new int[this.pojemnosc];
    }

    public int[] getLiczby() {
        return liczby;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getRozmiar() {
        return rozmiar;
    }
}
