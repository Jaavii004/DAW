public class Pieza {
    private String nombre;
    private String color;
    

    public Pieza(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public boolean equals(Object o) {
        Pieza p = (Pieza) o;
        return  this.color.equals(p.color) &&
                this.nombre.equals(p.nombre) &&
                this.area() == p.area();
    }

    public double area(Object o) {
        Pieza p = (Pieza) o;
        return 5;
    }

}