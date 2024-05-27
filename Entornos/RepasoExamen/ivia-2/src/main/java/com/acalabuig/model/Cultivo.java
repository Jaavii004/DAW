package com.acalabuig.model;

public class Cultivo {

    private String nombre;
    /* En hectareas */
    private double area;
    /* En toneladas por area */
    private double rendimiento;

    /**
     * Constructor del objeto cultivo
     * 
     * @param nombre Representa el nombre del cultivo
     * @param area Es el area de cultivo en hectareas
     * @param rendimiento El rendimiento del cultivo 
     * @throws IllegalArgumentException Lanza la excepcion si nombre es vacio o null o si area o rendimiento es 0 o negativo
     */
    public Cultivo(String nombre, double area, double rendimiento) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cultivo no puede ser nullo o vacío.");
        }
        if (area <= 0 || rendimiento <= 0) {
            throw new IllegalArgumentException("Area y rendimiento deben ser números positivos");
        }
        this.nombre = nombre;
        this.area = area;
        this.rendimiento = rendimiento;
    }

    /**
     * Cambiar el nombre del cultivo
     * 
     * @param nombre nombre del cultivo 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Cambiar el area del cultivo
     * 
     * @param area el area del cultivo 
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Cambiar el rendimiento del cultivo
     * 
     * @param rendimiento el rendimiento del cultivo
     */
    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    /**
     * Obtener el nombre del cultivo
     * 
     * @return el nombre del cultivo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener el area del cultivo
     * 
     * @return el area del cultivo
     */
    public double getArea() {
        return area;
    }

    /**
     * Obtener rendimiento del cultivo
     * 
     * @return el rendimiento del cultivo
     */
    public double getRendimiento() {
        return rendimiento;
    }

    /**
     * Calcular el rendimiento total del cultivo
     * 
     * @return el rendimiento total
     */
    public double calcularRendimientoTotal() {
        return area * rendimiento;
    }

    /**
     * Calcualos los ingresos totales por precio por tonelada
     * 
     * @param precioPorTonelada el precio de la tonelada
     * @return el total de ingresos
     */
    public double calcularIngresos(double precioPorTonelada) {
        return calcularRendimientoTotal() * precioPorTonelada;
    }
}
