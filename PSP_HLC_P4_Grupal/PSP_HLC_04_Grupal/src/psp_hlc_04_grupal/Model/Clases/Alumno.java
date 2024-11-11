package psp_hlc_04_grupal.Model.Clases;

import java.util.GregorianCalendar;

public class Alumno {
    private int numAlum;
    private String contraseña;
    private GregorianCalendar fechaNac;
    private int notaMedia;
    private String img_route;

    public Alumno(int numAlum, String contraseña, GregorianCalendar fechaNac, int notaMedia, String img_route) {
        this.numAlum = numAlum;
        this.contraseña = contraseña;
        this.fechaNac = fechaNac;
        this.notaMedia = notaMedia;
        this.img_route = img_route;
    }

    public int getNumAlum() {
        return numAlum;
    }

    public String getContraseña() {
        return contraseña;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public String getImg_route() {
        return img_route;
    }

    public void setNumAlum(int numAlum) {
        this.numAlum = numAlum;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void setImg_route(String img_route) {
        this.img_route = img_route;
    }
    
    
}
