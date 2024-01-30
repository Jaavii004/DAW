package lib;

public class Fraccion {
    private int numerador;
    private int denominador;

    // Constructores
    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
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
        int tmpden = this.denominador;
        int tmpnum = this.numerador;
        int tmp = 1;
        while (tmpden != 0) {
            tmp = tmpden;
            tmpden = tmpnum % tmp;
            tmpnum = tmp;
        }
        MaximoComunDivisor = tmp;
        this.numerador /= MaximoComunDivisor;
        this.denominador /= MaximoComunDivisor;
    }
    public void Multiplicar(int fra_numerador, int fra_denominador) {
        this.numerador *= fra_numerador;
        this.denominador *= fra_denominador;
    }

    public void Dividir(int fra_numerador, int fra_denominador) {
        int tmpnum = this.numerador * fra_denominador;
        this.numerador = this.denominador * fra_numerador;
        this.denominador = tmpnum;
    }
   
}
