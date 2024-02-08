public class Triangulo extends Figura{
    private int base;
    private int altura;

    // Constructores
    public Triangulo(int base,int altura) {
        this.base = base;
        this.altura = altura;
    }
    public Triangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public double area() {
        return ((this.base * this.altura)/2);
    }

    public double perimetro() {
        double ladopitagoras = Math.sqrt((base * base)/4 + (altura * altura));
        return this.base + (ladopitagoras * 2);
    }
}
