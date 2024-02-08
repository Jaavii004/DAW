public class Cuadrado extends Figura{
    private int lado;

    // Constructores
    public Cuadrado(int lado) {
        this.lado = lado;
    }
    public Cuadrado() {
        this.lado = 0;
    }

    public double area() {
        return (this.lado * this.lado);
    }
    public double perimetro() {
        return (4 * this.lado);
    }
}