package br.cefet.model;

import java.time.LocalDate;
import java.sql.Date; 

public class Viagem {
    private int id;
    private Motorista motorista;
    private Trajeto trajeto;
    private int passageiros;
    private LocalDate data; 
    private double custo;

    public Viagem() {
    }

    public Viagem(int id, Motorista motorista, Trajeto trajeto, int passageiros, LocalDate data) {
        this.id = id;
        this.motorista = motorista;
        this.trajeto = trajeto;
        this.passageiros = passageiros;
        this.data = data;
        this.custo = calcularCusto();
    }

    public Viagem(Motorista motorista, Trajeto trajeto, int passageiros, LocalDate data) {
        this.motorista = motorista;
        this.trajeto = trajeto;
        this.passageiros = passageiros;
        this.data = data;
        this.custo = calcularCusto();
    }

  
    public Viagem(int id, Motorista motorista, Trajeto trajeto, int passageiros, Date sqlDate) {
        this.id = id;
        this.motorista = motorista;
        this.trajeto = trajeto;
        this.passageiros = passageiros;
        if (sqlDate != null) {
            this.data = sqlDate.toLocalDate(); 
        }
        this.custo = calcularCusto();
    }


    private double calcularCusto() {
        if (this.trajeto != null) {
            return this.trajeto.getDistancia() * this.trajeto.getGastoPorKm();
        }
        return 0.0;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }

    public Trajeto getTrajeto() { return trajeto; }
    public void setTrajeto(Trajeto trajeto) {
        this.trajeto = trajeto;
        this.custo = calcularCusto();
    }

    public int getPassageiros() { return passageiros; }
    public void setPassageiros(int passageiros) { this.passageiros = passageiros; }

    public LocalDate getData() { return data; } // Retorna LocalDate
    public void setData(LocalDate data) { this.data = data; }

    public double getCusto() { return calcularCusto(); }

    @Override
    public String toString() {
        return "Viagem [id=" + id + ", motorista=" + (motorista != null ? motorista.getNome() : "N/A") +
               ", trajeto=" + (trajeto != null ? trajeto.getPartida() + "->" + trajeto.getDestino() : "N/A") +
               ", passageiros=" + passageiros + ", data=" + data + ", custo=" + String.format("%.2f", custo) + "]";
    }
    public String getDataFormatada() {
    return data.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
}


} 