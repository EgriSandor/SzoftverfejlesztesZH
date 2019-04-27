package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Raktar")
public class Raktar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PROJEKT")
    private String projekt;

    @Column(name = "SAP")
    private String sap;

    @Column(name = "MENNYISEG")
    private double mennyiseg;

    public String getProjekt() {
        return projekt;
    }

    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "DATUM")
    private Date datum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public double getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(double mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Raktar(Integer id, String projekt, String sap, double mennyiseg, Date datum) {
        this.id = id;
        this.projekt = projekt;
        this.sap = sap;
        this.mennyiseg = mennyiseg;
        this.datum = datum;
    }

    public Raktar(String projekt, String sap, double mennyiseg, Date datum) {

        this.projekt = projekt;
        this.sap = sap;
        this.mennyiseg = mennyiseg;
        this.datum = datum;
    }

    public Raktar(String projekt, String sap, double mennyiseg) {
        this.projekt = projekt;
        this.sap = sap;
        this.mennyiseg = mennyiseg;
        this.datum = Calendar.getInstance().getTime();
    }

    public Raktar() {
    }

    @Override
    public String toString() {
        return "Raktar{" +
                "id=" + id +
                ", projekt='" + projekt + '\'' +
                ", sap='" + sap + '\'' +
                ", mennyiseg=" + mennyiseg +
                ", datum=" + datum +
                '}';
    }
}
