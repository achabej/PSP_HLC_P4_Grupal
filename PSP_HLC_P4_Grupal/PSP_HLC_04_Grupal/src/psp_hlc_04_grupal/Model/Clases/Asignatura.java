package psp_hlc_04_grupal.Model.Clases;

public class Asignatura {
    private int codAsig;
    private String nomAsig;
    private double nota;
    private int codAlum; //FK

    public Asignatura(int codAsig, String nomAsig, double nota, int codAlum) {
        this.codAsig = codAsig;
        this.nomAsig = nomAsig;
        this.nota = nota;
        this.codAlum = codAlum;
    }

    public int getCodAsig() {
        return codAsig;
    }

    public String getNomAsig() {
        return nomAsig;
    }

    public double getNota() {
        return nota;
    }

    public int getCodAlum() {
        return codAlum;
    }

    public void setCodAsig(int codAsig) {
        this.codAsig = codAsig;
    }

    public void setNomAsig(String nomAsig) {
        this.nomAsig = nomAsig;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setCodAlum(int codAlum) {
        this.codAlum = codAlum;
    }
    
    
}
