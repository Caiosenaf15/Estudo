import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.cefet.model.Motorista;
import br.cefet.model.Trajeto;
import br.cefet.model.Viagem;

public class TestViagemModel {
    @Test
    public void testeCalculoCustoViagem() {
        Trajeto trajeto = new Trajeto("São Paulo", "Rio de Janeiro", 100.0, 0.50);
        Motorista motorista = new Motorista("João Silva", 30, "M001");
        Viagem viagem = new Viagem(motorista, trajeto, 5, LocalDate.now());
        double custoEsperado = 100.0 * 0.50;
        double custoCalculado = viagem.getCusto();
        System.out.println("Custo calculado: " + custoCalculado);
        assertEquals(custoEsperado, custoCalculado, 0.001);
        System.out.println("testeCalculoCustoViagem: OK");
    }

    @Test
    public void testeCalculoCustoViagemSemTrajeto() {
        Motorista motorista = new Motorista("João Silva", 30, "M001");
        Viagem viagem = new Viagem(motorista, null, 5, LocalDate.now());
        double custoCalculado = viagem.getCusto();
        System.out.println("Custo calculado (sem trajeto): " + custoCalculado);
        assertEquals(0.0, custoCalculado, 0.001);
        System.out.println("testeCalculoCustoViagemSemTrajeto: OK");
    }

    @Test
    public void testeCalculoCustoViagemComDiferentesValores() {
        Trajeto trajeto1 = new Trajeto("A", "B", 50.0, 0.75);
        Motorista motorista = new Motorista("João Silva", 30, "M001");
        Viagem viagem1 = new Viagem(motorista, trajeto1, 3, LocalDate.now());
        double custo1 = viagem1.getCusto();
        System.out.println("Custo calculado (trajeto1): " + custo1);
        assertEquals(37.50, custo1, 0.001);

        Trajeto trajeto2 = new Trajeto("C", "D", 200.0, 0.25);
        Viagem viagem2 = new Viagem(motorista, trajeto2, 8, LocalDate.now());
        double custo2 = viagem2.getCusto();
        System.out.println("Custo calculado (trajeto2): " + custo2);
        assertEquals(50.00, custo2, 0.001);
        System.out.println("testeCalculoCustoViagemComDiferentesValores: OK");
    }
} 