import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import br.cefet.dao.MotoristaDao;
import br.cefet.model.Motorista;

public class TestMotoristaDao {

    private MotoristaDao dao = new MotoristaDao();

    @Test
    public void testCRUD() throws Exception {
        Motorista motorista = new Motorista("Teste Motorista", 40, "T123");
        dao.salvar(motorista);
        System.out.println("Motorista salvo: " + motorista.getNome());
        List<Motorista> todos = dao.listarTodos();
        Motorista motoristaSalvo = todos.stream()
            .filter(m -> m.getMatricula().equals("T123"))
            .findFirst().orElse(null);
        assertNotNull(motoristaSalvo);
        int id = motoristaSalvo.getId();
        System.out.println("Motorista encontrado (ID): " + id);

        Motorista motoristaBuscado = dao.buscarPorId(id);
        assertNotNull(motoristaBuscado);
        System.out.println("Motorista buscado: " + motoristaBuscado.getNome());
        assertEquals("Teste Motorista", motoristaBuscado.getNome());

        motoristaBuscado.setNome("Motorista Alterado");
        dao.atualizar(motoristaBuscado);
        Motorista motoristaAlterado = dao.buscarPorId(id);
        System.out.println("Motorista alterado: " + motoristaAlterado.getNome());
        assertEquals("Motorista Alterado", motoristaAlterado.getNome());

        dao.excluir(id);
        Motorista motoristaExcluido = dao.buscarPorId(id);
        System.out.println("Motorista excluído: " + (motoristaExcluido == null ? "null" : motoristaExcluido.getNome()));
        assertNull(motoristaExcluido);
        System.out.println("testCRUD: OK");
    }
} 