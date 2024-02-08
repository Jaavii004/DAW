public class Circulo extends Figura{
    private int radio;

    // Constructores
    public Circulo(int radio) {
        this.radio = radio;
    }
    public Circulo() {
        this.radio = 0;
    }

    public double area() {
        return (Math.PI * this.radio * this.radio);
    }
    public double perimetro() {
        return (2 * Math.PI * radio);
    }
}
