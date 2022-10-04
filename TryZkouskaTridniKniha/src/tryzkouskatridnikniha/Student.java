package tryzkouskatridnikniha;

import java.util.ArrayList;

/**
 *
 * @author Lukáš
 */
public class Student implements Comparable <Student>{
    private int ID;
    private String prijmeni;
    private String jmeno;
    private ArrayList<Znamka>znamkyStudenta = new ArrayList<>();

    public Student(int ID, String prijmeni, String jmeno) {
        this.ID = ID;
        this.prijmeni = prijmeni;
        this.jmeno = jmeno;
    }

    public int getID() {
        return ID;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setZnamky(Znamka z) {
        znamkyStudenta.add(z);
    }
    
    

    @Override
    public String toString() {
        return ID + ":" + prijmeni + ", " + jmeno;
    }
    
    @Override
     public int compareTo(Student o) {
        return this.ID- o.ID;

    }
    
}
