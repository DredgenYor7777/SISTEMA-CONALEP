
package modelo;

import java.util.Date;


public class Prestamo {
    private int id_prestamo;
    private Date fecPrestamo;
    private Date fecDev;
    private int fkIdAlumno;
    private int fkIdLibro;

    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrestamo) {
        this.fecPrestamo = fecPrestamo;
    }

    public Date getFecDev() {
        return fecDev;
    }

    public void setFecDev(Date fecDev) {
        this.fecDev = fecDev;
    }

    public int getFkIdAlumno() {
        return fkIdAlumno;
    }

    public void setFkIdAlumno(int fkIdAlumno) {
        this.fkIdAlumno = fkIdAlumno;
    }

    public int getFkIdLibro() {
        return fkIdLibro;
    }

    public void setFkIdLibro(int fkIdLibro) {
        this.fkIdLibro = fkIdLibro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

   
}
