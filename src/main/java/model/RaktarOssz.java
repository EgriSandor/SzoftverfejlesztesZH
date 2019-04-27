package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Raktar")
public class RaktarOssz {

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


    public RaktarOssz(Integer id, String projekt, String sap, double mennyiseg) {
        this.id = id;
        this.projekt = projekt;
        this.sap = sap;
        this.mennyiseg = mennyiseg;
    }

    public RaktarOssz() {


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Raktar{" +

                ", projekt='" + projekt + '\'' +
                ", sap='" + sap + '\'' +
                ", mennyiseg=" + mennyiseg +

                '}';
    }
}
