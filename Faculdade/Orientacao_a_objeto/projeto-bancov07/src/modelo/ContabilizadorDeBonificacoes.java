package modelo;

public class ContabilizadorDeBonificacoes {
    private double totalEmBonificacoes;

    public void contabiliza(Funcionario f){
        this.totalEmBonificacoes += f.getBonificacaoNatalina();
    }

    /*public void contabiliza(Caixa c){
        this.totalEmBonificacoes += c.getBonificacaoNatalina();
    }*/

    public double getTotalEmBonificacoes() {
        return this.totalEmBonificacoes;
    }
}
