import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class  MyList<T> {

    private T[] myArray;

    public MyList(){
        this.myArray = (T[]) new Object[10];
    }
    public MyList(int capacity){
        this.myArray = (T[]) new Object[capacity];
    }

    //size metodu  dizideki eleman sayısını verir.
    public int size(){
        int totalSize = 0;

        for(Object i : myArray){
            if (i != null){
                totalSize ++;
            }
        }
        return totalSize;
    }

    //getCapacity  dizinin kapasite değerini verir.
    public int getCapacity(){

        return myArray.length;
    }

    //add<T> data sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
    public void add(T element){

        if (this.size() == this.getCapacity()){
            T[] newArray = (T[]) new Object[this.getCapacity()*2];
            for(int i = 0; i < this.size();i++){
                newArray[i] = this.myArray[i];

            }
            newArray[this.size()+1] = element;
            this.myArray = newArray;
        }
        else {
            myArray[this.size()] = element;
        }
    }
    //get(int index): verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public T get(int index){

        if (index < 0 || index > getCapacity()){
            return null;
        }

        return this.myArray[index];
    }
    //remove(int index): verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.
    public T remove(int index){

        if (index < 0 || index > getCapacity()){
            return null;
        }
        T removedElement = this.myArray[index];
        for(int i = index;i < this.size()-1;i++){
            this.myArray[i] = this.myArray[i+1];
        }

        this.myArray[size()-1] = null;

        return removedElement;
    }
    //set(int index, T data) : verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.
    public T set(int index , T data){
        if (index < 0 || index > getCapacity()){
            return null;
        }
        this.myArray[index] = data;
        return data;
    }

    //String toString() : Sınıfa ait dizideki elemanları listeleyen bir metot.
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Object i:this.myArray ){
            if (i != null){
                sb.append(i.toString() + " ");
            }

        }
        return sb.toString();
    }


    //int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
    public int indexOf(T data){

        int indexOf;

        for(int i = 0; i < this.size()-1;i++){
            if (this.myArray[i].equals(data)){
                indexOf = i;
                return indexOf;
            }
        }
        return -1;
    }
    
    //int lastIndexOf(T data) : Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.
    public int lastIndexOf(T data) {
        
        int lastIndexOf;
        for (int i = this.size() - 1; i > 0; i--) {
            if (this.myArray[i].equals(data)) {
                lastIndexOf = i;
                return lastIndexOf;
            }
        }
        return -1;
    }

    //boolean isEmpty() : Listenin boş olup olmadığını söyler.
    public Boolean isEmpty(){
        if (this.size() == 0){
            return true;
        }
        return false;
    }
    //T[] toArray() : Listedeki öğeleri, aynı sırayla bir array haline getirir.

    public T[] toArray(){
        T[] newArray = (T[]) new Object[this.size()];
        for(int i = 0; i < this.size()-1 ; i++){
            newArray[i] = this.myArray[i];
        }
        return newArray;
    }
    //clear() : Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear(){
       for (int i = 0; i < this.size() -1; i++){
           this.myArray[i] = null;
        }
    }

    //sublist(int start,int finish) : Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start,int finish){
        MyList<T> newList = new MyList<>(finish - start);

        for(int i = start; i < finish; i++){
            newList.add(this.myArray[i]);
        }

        return newList;
    }

    //boolean contains(T data) : Parametrede verilen değerin dizide olup olmadığını söyler.
    public boolean contains(T data){

        for(Object i : this.myArray){
            if (i.equals(data)){
                return true;
            }
        }
        return false;
    }

}
