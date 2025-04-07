package modelo;

public class SistemaInterno {
    private int senhaSistema = 555;

    public void login(FuncionarioAutenticavel fa){
        if(fa.autentica(this.senhaSistema)==true)
            System.out.println("Acesso liberado.");
        else
            System.out.println("Acesso NEGADO.");
    }
}
