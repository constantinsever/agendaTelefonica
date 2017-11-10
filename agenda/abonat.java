
package agenda;

import java.io.Serializable;


public class abonat implements Serializable, Comparable {
    String nume, prenume;
    long CNP;
    long nrTel;

    public abonat(String n, String p, long c, long nr){
       nume = n;
       prenume = p;
       CNP = c;
       nrTel = nr;
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public long getCNP(){
        return CNP;
    }

    public long getNrtel(){
        return nrTel;
    }

    //////////////////////////////////////////////
    
    public void setNume(String s){
        nume = s;
    }

    public void setPrenume(String s){
        prenume = s;
    }

    public void setCNP(long n){
        CNP = n;
    }

    public void setNrtel(long n){
        nrTel = n;
    }

    public int compareTo(Object o) {
       //????
        return 0;
    }
}
