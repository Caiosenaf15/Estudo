// src/main/java/br/cefet/model/Trajeto.java
package br.cefet.model;

public class Trajeto {
    private int id;
    private String partida;
    private String destino;
    private double distancia;
    private double gastoPorKm; // Campo adicionado

    // Construtor padrão
    public Trajeto() {
    }

    // Construtor para criar um novo Trajeto (sem ID)
    public Trajeto(String partida, String destino, double distancia, double gastoPorKm) {
        this.partida = partida;
        this.destino = destino;
        this.distancia = distancia;
        this.gastoPorKm = gastoPorKm;
    }

    // Construtor completo (para carregar Trajeto do banco de dados)
    public Trajeto(int id, String partida, String destino, double distancia, double gastoPorKm) {
        this.id = id;
        this.partida = partida;
        this.destino = destino;
        this.distancia = distancia;
        this.gastoPorKm = gastoPorKm;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getGastoPorKm() {
        return gastoPorKm;
    }

    public void setGastoPorKm(double gastoPorKm) {
        this.gastoPorKm = gastoPorKm;
    }

    @Override
    public String toString() {
        return "Trajeto [id=" + id + ", partida=" + partida + ", destino=" + destino + ", distancia=" + distancia + ", gastoPorKm=" + gastoPorKm + "]";
    }
}