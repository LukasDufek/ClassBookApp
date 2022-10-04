package tryzkouskatridnikniha;

/**
 *
 * @author Lukáš
 */
public class Znamka {
    private int IDproStudenta;
    private double znamka;
    private double vaha;

    public Znamka(int IDproStudenta, double znamka, double vaha) {
        this.IDproStudenta = IDproStudenta;
        this.znamka = znamka;
        this.vaha = vaha;
    }

    public Znamka(double znamka, double vaha) {
        this.znamka = znamka;
        this.vaha = vaha;
    }
    
    

    public int getIDproStudenta() {
        return IDproStudenta;
    }

    public double getZnamka() {
        return znamka;
    }

    public double getVaha() {
        return vaha;
    }

    public void setZnamka(double znamka) {
        this.znamka = znamka;
    }

    public void setVaha(double vaha) {
        this.vaha = vaha;
    }

    @Override
    public String toString() {
        return "ID studenta" + IDproStudenta + ", znamka= " + znamka + ", vaha= " + vaha;
    }
    
    
    
    
}
