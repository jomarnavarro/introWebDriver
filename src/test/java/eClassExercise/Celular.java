package eClassExercise;

public class Celular {



    String marcaModelo;
    String nombre;
    double precio;
    int capacidadGb;

    public Celular(String marcaModelo, String nombre, double precio, int capacidadGb) {
        this.marcaModelo = marcaModelo;
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadGb = capacidadGb;
    }



    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidadGb() {
        return capacidadGb;
    }

    public void setCapacidadGb(int capacidadGb) {
        this.capacidadGb = capacidadGb;
    }


}
