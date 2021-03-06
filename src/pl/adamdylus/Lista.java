package pl.adamdylus;

import java.io.*;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Lista implements Serializable {
    private int[] liczby;
    private int pojemnosc;
    private int rozmiar;

    public Lista(int pojemnosc){
        this.pojemnosc = pojemnosc;
        this.rozmiar = 0;
        this.liczby = new int[this.pojemnosc];
    }

    public void dodajElement(int liczbaDoDodania){
        if(rozmiar > (pojemnosc-1)){ //czy tablica jest pełna
            System.out.println("Blad! Tablica jest przeprzelniona!");
        }else {
            liczby[rozmiar] = liczbaDoDodania;
            rozmiar++;
        }
    }

    public int znajdz(int szukanaLiczna){
        for(int i=0; i<liczby.length; i++){
            if(liczby[i] == szukanaLiczna)
                return i;
        }
        return -1;
    }

    public void pisz(){
        StringBuilder elementy = new StringBuilder();
        for(int i=0; i<rozmiar; i++){
            elementy.append(liczby[i]).append(" ");
        }
        System.out.println("Lista: ");
        System.out.println("    Pojemonosc: " + pojemnosc);
        System.out.println("    Rozmiar: " + rozmiar);
        System.out.println("    Elementy: " + elementy);
    }

    public void usunPierwszy(int liczba){
        boolean czyZnaleziono = false;
        int indexLiczbyDoUsuniecia = 0;
        int[] arr = new int[pojemnosc];

        for(int i=0; i<rozmiar; i++){
            if(liczby[i] == liczba){
                indexLiczbyDoUsuniecia = i;
                czyZnaleziono = true;
                break;
            };
        }

        if(!czyZnaleziono){
            System.out.println("Nie znaleziono elementu do usuniecia");
        }else{
            int j = 0;
            for(int i = 0; i < rozmiar; i++){
                if(indexLiczbyDoUsuniecia != i){
                    arr[j] = liczby[i];
                    j++;
                }
            }
            liczby = arr;
            rozmiar--;
        }
    }

    public void usunPowtorzenia(){
        int[] arr = new int[pojemnosc];
        int arrIncrement = 0;
            for(int i = 0; i < rozmiar; i++){
                for(int j = i; j < rozmiar; j++){
                        if(i != j && liczby[i] == liczby[j]){
                            //zapelnij nowa tablice duplikatami
                            arr[arrIncrement] = liczby[i];
                            arrIncrement++;
                            break;
                        }
                    }
                }
            for(int i : arr){
                //wykonaj usuwanie duplikatow
                usunPierwszy(i);
            }
        }

    public void zapiszDoPliku(String nazwaPliku) throws IOException {
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(nazwaPliku)
        );
        o.writeObject(liczby);
        o.close();
    }
}
