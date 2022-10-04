package tryzkouskatridnikniha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Lukáš
 */
public class TridniKniha {

    ArrayList<Student> studenti = new ArrayList<>();
    File znamky;
//    private ArrayList<Znamka> znamky;

    public TridniKniha(File znamky) {
        this.studenti = studenti;
        this.znamky=znamky;
        //znamky = new ArrayList<>();
    }

    public void nactiZnamky(File znamky) throws IOException {
        

        try (BufferedReader br = new BufferedReader(new FileReader(znamky))) {
            String radek = null;
            String[] parts;
            int ID;
            double znamka, vaha;
            Znamka z;
            while ((radek = br.readLine()) != null) { //vraci string
                parts = radek.split(" ");
                ID = Integer.parseInt(parts[0]);
                //String[] firstLast = parts[1].split(" ");
                znamka = Double.parseDouble(parts[1].replace(',', '.'));
                vaha = Double.parseDouble(parts[2].replace(',', '.'));
                //denTestu = LocalDate.parse(parts[5], dtf);

                z = new Znamka(znamka, vaha); //asi neni potreba ID
                for (Student s : studenti) {
                    if(s.getID()==ID){
                        s.setZnamky(z);
                    }
                }
                //znamky.add(z);

            }
            br.close();
        }

    }

    public void nactiStudenty(File souborStudenti) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(souborStudenti))) {
            String radek = null;
            String[] parts;
            int ID;
            String prijmeni, jmeno;

            Student s;

            br.readLine();  //precti zahlavi, ale nikam ho neukladej
            while ((radek = br.readLine()) != null) { //vraci string
                parts = radek.split(";");
                ID = Integer.parseInt(parts[0]);
                prijmeni = parts[1];
                jmeno = parts[2];

                s = new Student(ID, prijmeni, jmeno);

                studenti.add(s);

            }
            br.close();
        }
        
    }


    public void seradStudentyPodleID() {

        Collections.sort(studenti);
    }

    public void seradStudentyPodlePrijmeni() {
        Collections.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs", "CZ"));
                //kvuli prijmenim jako napr: Šimon
                if (o1.getPrijmeni().equals(o2.getPrijmeni())) {
                    return col.compare(o1.getJmeno(), o2.getJmeno());
                } else {
                    return col.compare(o1.getPrijmeni(), o2.getPrijmeni());
                }
            }
        });
    }
    
    
    
    
    
    public void zapisZnamku(int ID, double znamka, double vaha) throws IOException{
        Znamka z = new Znamka(ID, znamka);
        for (Student student : studenti) {
                    if(student.getID()==ID){
                        student.setZnamky(z);
                    }
                }
        try(BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(znamky,true)))) { //zapis na konec dat                
            String znamkaStr = Double.toString(znamka);
            znamkaStr = znamkaStr.replace(".", ",");
            String vahaStr = Double.toString(vaha);
            vahaStr = vahaStr.replace(".", ",");
            String line = "\n" + ID + " " + znamkaStr + " " + vahaStr;
            w.write(line);
            w.close();
            
            /*for (Zbozi z : sortimentZbozi) {
                w.write(z.toString()+"\n");
            }*/
    }
        
    }
        
    
    
    
    
    
    

//    public String zobrazeniZnamek() {
//        StringBuilder sb = new StringBuilder();
//        for (Znamka z : znamky) {
//            sb.append(z + "\n");
//        }
//        return sb.toString();
//    }

    public String zobrazeniStudentu() {
        StringBuilder sb = new StringBuilder();
        for (Student s : studenti) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }



    
    
    
    
}
