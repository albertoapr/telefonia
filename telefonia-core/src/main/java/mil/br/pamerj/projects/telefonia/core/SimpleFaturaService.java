/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.core;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import mil.br.pamerj.projects.telefonia.api.FaturaService;
import mil.br.pamerj.projects.telefonia.api.LigacaoService;
import mil.br.pamerj.projects.telefonia.api.exceptions.CoreException;
import mil.br.pamerj.projects.telefonia.dao.DAOFactory;
import mil.br.pamerj.projects.telefonia.dao.FaturaDAO;
import mil.br.pamerj.projects.telefonia.dao.FaturamentoDAO;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.FaturamentoDTO;
import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;
import mil.br.pamerj.projects.telefonia.util.DAOUtil;

/**
 *
 * @author Fernando Tomasio
 */
public class SimpleFaturaService implements FaturaService {

    private static DAOFactory factory = DAOUtil.getDAOFactory();
    LigacaoService ligacaoService = new SimpleLigacaoService();

    @Override
    public void createFatura(FaturaDTO fatura) {
        FaturaDAO dao = factory.getFaturaDAO();
        dao.create(fatura);
    }

    @Override
    public void updateFatura(FaturaDTO fatura) {
        FaturaDAO dao = factory.getFaturaDAO();
        dao.update(fatura);
    }

    @Override
    public void removeFatura(Long faturaId) {
        FaturaDAO dao = factory.getFaturaDAO();
        dao.remove(faturaId);
    }

    @Override
    public FaturaDTO findFatura(Long faturaId) {
        FaturaDAO dao = factory.getFaturaDAO();
        return dao.find(faturaId);
    }

    @Override
    public void createFaturamento(FaturamentoDTO faturamento) {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        dao.create(faturamento);

    }

    @Override
    public void createFaturamento(FaturamentoDTO faturamento, byte[] file)
            throws CoreException {

        FaturamentoDAO dao = factory.getFaturamentoDAO();
        FaturamentoDTO _faturamento = dao.findFaturamentoByPeriodo(faturamento.getPeriodo());
        if (_faturamento != null) {
            throw new CoreException("Faturamento existente para esse período");
        } else {
            dao.create(faturamento);
            File f = new File("temp.txt");
            try {

                FileOutputStream fos = new FileOutputStream(f);
                fos.write(file);
                fos.flush();
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ligacaoService.chargeDbLigacoes(f, null);
            faturarPeriodo(faturamento);

        }




    }

    public void faturarPeriodo(FaturamentoDTO faturamento) {
        List<RamalDTO> ramais = ligacaoService.findAllRamais();
        for (RamalDTO ramal : ramais) {
            FaturaDTO fatura = new FaturaDTO();
            fatura.setFaturamento(faturamento);
            fatura.setRamal(ramal);

            List<LigacaoDTO> ligacoes = ligacaoService.findAllLigacoes(ramal.getId(), faturamento.getPeriodo());
            for (LigacaoDTO ligacao : ligacoes) {
                ItemFaturaDTO item = new ItemFaturaDTO();
                item.setLigacao(ligacao);
                fatura.addItem(item);


            }
            createFatura(fatura);
//            System.out.println(fatura);
//            for (ItemFaturaDTO item : fatura.getItems()) {
//                System.out.println(item.getLigacao().getId());
//            }
        }
    }

    @Override
    public void updateFaturamento(FaturamentoDTO fatura) {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        dao.update(fatura);
    }

    @Override
    public void removeFaturamento(Long faturamentoId) {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        dao.remove(faturamentoId);
    }

    @Override
    public FaturamentoDTO findFaturamento(Long faturamentoId) {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        return dao.find(faturamentoId);
    }

    @Override
    public List<FaturamentoDTO> findAllFaturamentos() {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        return dao.findAll();
    }

    @Override
    public FaturamentoDTO findFaturamentoByPeriodo(Date mes) {
        FaturamentoDAO dao = factory.getFaturamentoDAO();
        return dao.findFaturamentoByPeriodo(mes);
    }

   
    @Override
    public List<FaturaDTO> findFaturasByLogin(String login) {
         FaturaDAO dao = factory.getFaturaDAO();
        return dao.findAllByLogin(login);
    }

    @Override
    public List<FaturaDTO> findAllFaturas() {
        FaturaDAO dao = factory.getFaturaDAO();
        return dao.findAll();
    }

    @Override
    public List<FaturaDTO> findAllFaturas(Date periodo) {
        FaturaDAO dao = factory.getFaturaDAO();
        return dao.findAll(periodo);
    }

    @Override
    public List<FaturaDTO> findAllFaturas(Date periodo, boolean aberto) {
        FaturaDAO dao = factory.getFaturaDAO();
        return dao.findAll(periodo, aberto);
    }
}
