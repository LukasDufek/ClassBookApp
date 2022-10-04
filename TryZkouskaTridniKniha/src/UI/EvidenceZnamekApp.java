/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tryzkouskatridnikniha.Student;
import tryzkouskatridnikniha.TridniKniha;
import tryzkouskatridnikniha.Znamka;

/**
 *
 * @author Lukáš
 */
public class EvidenceZnamekApp {

    public static Scanner sc = new Scanner(System.in);
    public static TridniKniha tr;
    public static ArrayList<Znamka> znamky;

    public static void main(String[] args) {
        znamky = new ArrayList<>();
        boolean end = false;

        while (!end) {

            displayMenu();
            System.out.println("Zadej volbu");
            String choice = sc.next();
            switch (choice) {
                case "0":
                    System.out.println("Aplikace ukončena");
                    end = true;
                    break;
                case "1": {
                    try {
                        otevritTridniKnihu();
                    } catch (IOException ex) {
                        System.out.println("Chyba souboru");;
                    }
                }
                break;
                case "2":
                    zobrazitSeznamStudentu();
                    break;
                case "3":
                {
                    try {
                        ohodnotitDanehoStudenta();
                    } catch (IOException ex) {
                        System.out.println("Chyba pri zapisu do souboru");
                    }
                }
                    break;

                case "4":
//                        zadatZnamkuVsemStudentum();
                    System.out.println("Tato metoda jeste neni implementovana");
                    break;
                case "5":
//                        prumernaZnamkaZakaZpredmetu();
                    System.out.println("Tato metoda jeste neni implementovana");
                    break;
                case "6":
//                        vypsatStudentySVyslednymHodnocenim();
                    System.out.println("Tato metoda jeste neni implementovana");
                    break;
                case "7":
                    //zapsatHodnoceniVsechDoSouboru();
                    System.out.println("Tato metoda jeste neni implementovana");
                    break;

                default:
                    System.out.println("Neplatná volba");
            }

        }

    }

    public static void displayMenu() {
        System.out.println("**************************************************************************");
        System.out.println("*        Zadejte svoji volbu                                             *");
        System.out.println("* 1.Otevrit tridni knihu                                                 *");
        System.out.println("* 2.Zobrazit seznam zaku                                                 *");
        System.out.println("* 3.Zadat hodnoceni/znamku jednomu zakovi/studentovi                     *");
        System.out.println("* 4.Zadat znamku vsem                                                    *");
        System.out.println("* 5.Vypsat prumernou znamku zadaneho zaku z predmetu                     *");
        System.out.println("* 6.Vypsat seznam vsech zaku s vyslednou znamkou                         *");
        System.out.println("* 7.Zapsat hodnoceni (vyslednou znamku z predmetu) vsech zaku do souboru *");
        System.out.println("* 0.Konec                                                                *");
        System.out.println("**************************************************************************");

    }

    private static void otevritTridniKnihu() throws IOException {
        char choice;
        System.out.println("Zadej nazev predmetu");
        String predmet = sc.next();
        System.out.println("Zadej cestu k souboru se studenty - soubor zadan automaticky");
        //String cesta1 = sc.next();
        String cesta1 ="Data\\Studenti.txt";
        File file1=new File(cesta1);
        

        System.out.println("Zadej cestu k souboru se znamkami - soubor zadan automaticky");
        //String cesta2 = sc.next();
        String cesta2 ="Data\\Znamky.txt";
        File file2 = new File(cesta2);
        if (!file2.exists()) {
            System.out.println("Soubor neexistuje \n Chcete vytvorit novy? (a/n)");
            choice = sc.next().charAt(0);
            if (choice == 'a') {
                file2.createNewFile();
            }
        } else {
            tr=new TridniKniha(file2);
            tr.nactiStudenty(file1);
            tr.nactiZnamky(file2);
            

        }
    }

    private static void zobrazitSeznamStudentu() {
        boolean end = false;

        while (!end) {

            displayMenu2();
            System.out.println("Zadej volbu");
            String choice = sc.next();
            switch (choice) {
                case "0":
                    System.out.println("Navrat");
                    end = true;
                    break;
                case "1":
                    tr.seradStudentyPodleID();
                    System.out.println(tr.zobrazeniStudentu());
                    break;

                case "2":
                    tr.seradStudentyPodlePrijmeni();
                    System.out.println(tr.zobrazeniStudentu());
                    break;

            }
        }
    }
    
    

    private static void displayMenu2() {
        System.out.println("**************************************************************************");
        System.out.println("*        Jak chcete studenty zobrazit?                                   *");
        System.out.println("* 1.Podle cisel v seznamu                                                *");
        System.out.println("* 2.Abecedne podle prijmeni a jmena                                      *");
        System.out.println("* 0.Konec                                                                *");
        System.out.println("**************************************************************************");
    }

    private static void ohodnotitDanehoStudenta() throws IOException {
        System.out.println("Zadej ID studenta, kteremu chces dat znamku");
        int ID=sc.nextInt();
        System.out.println("Zadej znamku jako double");
        double znamka= sc.nextDouble();
        System.out.println("Zadej vahu znamky");
        double vaha=sc.nextDouble();
        
        tr.zapisZnamku(ID, znamka, vaha);
        
    }

}
