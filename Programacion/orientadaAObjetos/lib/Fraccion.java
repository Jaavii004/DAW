package lib;

public class Fraccion {
    private int numerador;
    private int denominador;

    // Constructores
    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
    }
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    // geters and setters
    public int getNumerador() {
        return numerador;
    }
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    // Funciones
    public void Invertir() {
        int tmp = this.denominador;
        this.denominador = this.numerador;
        this.numerador = tmp;
    }

    public void Simplificar() {
        int MaximoComunDivisor = 0;
        MaximoComunDivisor = maximoComunDivisorRecursivo(this.denominador, this.numerador);
        this.numerador /= MaximoComunDivisor;
        this.denominador /= MaximoComunDivisor;
    }

    public static int maximoComunDivisorRecursivo(int a, int b) {
        if (b == 0) {
            return a;
        }
        return maximoComunDivisorRecursivo(b, a % b);
    }

    public void Multiplicar(Fraccion nuevFraccion) {
        this.numerador *= nuevFraccion.numerador;
        this.denominador *= nuevFraccion.denominador;
    }

    // Multiplicar una fraccion
    public void Multiplicar(int fra_numerador, int fra_denominador) {
        this.numerador *= fra_numerador;
        this.denominador *= fra_denominador;
    }

    // Multiplicar un entero
    public void Multiplicar(int fra_numerador) {
        this.numerador *= fra_numerador;
    }

    // Dividir por otro fracion
    public void Dividir(int fra_numerador, int fra_denominador) {
        int tmpnum = this.numerador * fra_denominador;
        this.denominador = this.denominador * fra_numerador;
        this.numerador = tmpnum;
    }

    // Dividir por numero entero
    public void Dividir(int fra_numerador) {
        int tmpnum = this.numerador;
        this.denominador = this.denominador * fra_numerador;
        this.numerador = tmpnum;
    }

    // Dividir por uan fracion
    public void Dividir(Fraccion fraccion) {
        int tmpnum = this.numerador * fraccion.denominador;
        this.denominador = this.denominador * fraccion.numerador;
        this.numerador = tmpnum;
    }
}