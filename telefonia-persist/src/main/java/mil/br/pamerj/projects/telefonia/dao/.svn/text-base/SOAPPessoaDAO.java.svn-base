/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.dao;

import com.tomasio.projects.organization.webservices.EfetivoWS;
import com.tomasio.projects.organization.webservices.EfetivoWSService;
import com.tomasio.projects.organization.webservices.MatriculaDTO;
import java.util.List;
import mil.br.pamerj.projects.telefonia.dto.PessoaDTO;

/**
 *
 * @author Fernando Tomasio
 */
public class SOAPPessoaDAO implements PessoaDAO {

    @Override
    public void create(PessoaDTO pessoa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PessoaDTO find(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PessoaDTO find(String login) {
        EfetivoWSService service = new EfetivoWSService();
        EfetivoWS port = service.getEfetivoWSPort();
        MatriculaDTO matricula = port.findMatriculaByLogin(login);
        PessoaDTO pessoa = new PessoaDTO();
        pessoa.setNome(matricula.getPessoa().getNome());
        pessoa.setNomeGuerra(matricula.getPessoa().getNomeGuerra());
        pessoa.setPosto(matricula.getCargo());
        return pessoa;
    }

    @Override
    public List<PessoaDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(PessoaDTO pessoa) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
