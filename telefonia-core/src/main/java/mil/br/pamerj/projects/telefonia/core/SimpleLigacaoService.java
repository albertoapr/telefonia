package mil.br.pamerj.projects.telefonia.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mil.br.pamerj.projects.telefonia.api.LigacaoService;
import mil.br.pamerj.projects.telefonia.api.exceptions.CoreException;
import mil.br.pamerj.projects.telefonia.dao.DAOFactory;
import mil.br.pamerj.projects.telefonia.dao.LigacaoDAO;
import mil.br.pamerj.projects.telefonia.dao.RamalDAO;
import mil.br.pamerj.projects.telefonia.dto.LigacaoDTO;
import mil.br.pamerj.projects.telefonia.dto.RamalDTO;
import mil.br.pamerj.projects.telefonia.util.DAOUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernandofot
 */
public class SimpleLigacaoService implements LigacaoService {

    private static DAOFactory factory = DAOUtil.getDAOFactory();

    @Override
    public void createLigacao(LigacaoDTO ligacao) {
        LigacaoDAO dao = factory.getLigacaoDAO();
        dao.create(ligacao);
    }

    @Override
    public void createRamal(RamalDTO ramal) {
        RamalDAO dao = factory.getRamalDAO();
        dao.create(ramal);
    }

    @Override
    public void updateRamal(RamalDTO ramal) {
        RamalDAO dao = factory.getRamalDAO();
        dao.update(ramal);
    }

    @Override
    public void removeRamal(Long ramalId) {
        RamalDAO dao = factory.getRamalDAO();
        dao.remove(ramalId);
    }

    //temporario
    public List<LigacaoDTO> readAll() {
        LigacaoDAO dao = factory.getLigacaoDAO();
        return dao.findAll();
    }

    private List<RamalDTO> readRamaisFromFile(File file) throws CoreException {
        RamalDAO dao = factory.getRamalDAO();
        List<RamalDTO> listaDeRamaisAtual= dao.findAll();
        Map<String, RamalDTO> ramais = new HashMap<String, RamalDTO>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linha;
            linha = reader.readLine();

            Pattern p = Pattern.compile("^ Ramal");
            //int i = 0;

            while (linha != null) {
                Matcher m = p.matcher(linha);
                if (m.find()) {
                    String numeroRamal = linha.substring(7, 11);
                    //String nome = linha.substring(24,70);
                    String login = linha.substring(70, 90);


                    //RamalDTO ramal = dao.findByNumero(numeroRamal);
                    //verifica se o Ramal já existe
                    RamalDTO ramal = null;
                    for (RamalDTO ramalAtual: listaDeRamaisAtual){
                    if (ramalAtual.getNumero().equals(numeroRamal))
                    {
                       ramal=ramalAtual;
                       listaDeRamaisAtual.remove(ramalAtual);
                        break;
                    }
                   
                    }
                      
                    if (ramal == null) {
                        RamalDTO r = new RamalDTO();
                        r.setNumero(numeroRamal.trim());
                        r.setLogin(login.trim());
                        ramais.put(numeroRamal, r);
                    }


                }
                linha = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //throw new CoreException("Erro na leitura do arquivo");
        }

        Collection<RamalDTO> collectionRamais = ramais.values();
        List<RamalDTO> returnCollection = new ArrayList<RamalDTO>();
        for (RamalDTO ramal : collectionRamais) {
            returnCollection.add(ramal);
        }
        return returnCollection;
    }

    private List<LigacaoDTO> readLigacoesFromFile(File file) throws CoreException {
        RamalDAO dao = factory.getRamalDAO();
        List<RamalDTO> listaDeRamaisAtual= dao.findAll();
        RamalDTO ramal = null;
        String ramalAtual = null;
        List<LigacaoDTO> ligacoes = new ArrayList<LigacaoDTO>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linha;
            linha = reader.readLine();


            System.out.println(linha);

            Pattern p = Pattern.compile("^[0-9]");
            //int i = 0;

            while (linha != null) {
                Matcher m = p.matcher(linha);
                if (m.find()) {

                    
                    System.out.println(readRamal(linha)
                            + " " + readDataHora(linha)
                            + " " + readTipo(linha)
                            + " " + readNumero(linha)
                            + " " + readLocal(linha)
                            + " " + readDuracao(linha)
                            + " " + readCusto(linha)
                            + " ");
                   
                  if (!readRamal(linha).equals(ramalAtual))
                   {   
                    ramalAtual = readRamal(linha);
                    // ramal = dao.findByNumero(ramalAtual);
                    for (RamalDTO _ramal: listaDeRamaisAtual){
                    if (_ramal.getNumero().equals(ramalAtual)){
                       ramal=_ramal;
                       break;
                    }
                   
                    }
                     
                   }

                    LigacaoDTO ligacao = new LigacaoDTO(); 
                    
                    ligacao.setRamal(ramal);
                    ligacao.setDataHora(readDataHora(linha));
                    ligacao.setTipo(readTipo(linha));
                    ligacao.setNumero(readNumero(linha));
                    ligacao.setLocal(readLocal(linha));
                    ligacao.setDuracao(readDuracao(linha));
                    ligacao.setCusto(readCusto(linha));
                    //createLigacao(ligacao);
                    ligacoes.add(ligacao);
                    
                }
                linha = reader.readLine();

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CoreException("Erro na leitura do arquivo");
        }
        return ligacoes;
    }

    private static String readRamal(String linha) {
        String ramal = linha.substring(0, 6);
        return ramal.trim();
    }

    private static Date readDataHora(String linha) throws CoreException {
        String data = linha.substring(17, 27);
        String hora = linha.substring(28, 33);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date dataFormatada = null;
        try {
            dataFormatada = format.parse(data.trim() + " " + hora.trim());
        } catch (ParseException e) {

            throw new CoreException("Erro na leitura do arquivo");
        }
        return dataFormatada;
    }

    private static String readTipo(String linha) {
        String tipo = linha.substring(34, 37);
        return tipo.trim();
    }

    private static String readNumero(String linha) {
        String numero = linha.substring(38, 50);
        return numero.trim();
    }

    private static String readLocal(String linha) {
        String local = linha.substring(52, 75);
        return local.trim();
    }

    private static Date readDuracao(String linha) throws CoreException {
        String duracao = linha.substring(76, 84);
        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date duracaoFormatada = null;
        try {
            duracaoFormatada = format.parse(duracao.trim());
        } catch (ParseException e) {

            throw new CoreException("Erro na leitura do arquivo");
        }

        return duracaoFormatada;
    }

    private static Double readCusto(String linha) {
        String custo = linha.substring(85, 90);
        return Double.parseDouble(custo.trim().replace(',', '.'));
    }

    @Override
    public void chargeDbLigacoes(File file, Date periodo) throws CoreException {
        List<RamalDTO> ramais = readRamaisFromFile(file);
        
        
      
        //modificado por Alberto em 06/12/2011
        //para fazer atualização dos ramais em uma sessão do hibernate
         //createAllRamal(ramais); 
        
        for (RamalDTO ramal : ramais) {

            createRamal(ramal);
        
        }
        



        List<LigacaoDTO> ligacoes = readLigacoesFromFile(file);
         //modificado por Alberto em 06/12/2011
        //para fazer atualização das ligações em uma sessão do hibernate
        createAllLigacao(ligacoes); 
        
       // for (LigacaoDTO ligacao : ligacoes) {
         //    createLigacao(ligacao);
        //}
    }

    @Override
    public RamalDTO findRamalByNumero(String numero) {
        RamalDAO dao = factory.getRamalDAO();
        return dao.findByNumero(numero);
    }

    @Override
    public RamalDTO findRamal(Long id) {
        RamalDAO dao = factory.getRamalDAO();
        return dao.find(id);
    }

    @Override
    public void updateLigacoes(List<LigacaoDTO> ligacoes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<RamalDTO> findRamalByLogin(String login) {
        RamalDAO dao = factory.getRamalDAO();
        return dao.findByLogin(login);
    }

    @Override
    public List<RamalDTO> findAllRamais() {
        RamalDAO dao = factory.getRamalDAO();
        return dao.findAll();
    }

    @Override
    public List<LigacaoDTO> findAllLigacoes() {
        LigacaoDAO dao = factory.getLigacaoDAO();
        return dao.findAll();
    }

    @Override
    public List<LigacaoDTO> findAllLigacoes(Date mes) {
        LigacaoDAO dao = factory.getLigacaoDAO();
        return dao.findAll(mes);
    }

    @Override
    public List<LigacaoDTO> findAllLigacoes(Long ramalId, Date mes) {
        LigacaoDAO dao = factory.getLigacaoDAO();
        return dao.findAll(ramalId, mes);
    }

    @Override
    public List<LigacaoDTO> findAllLigacoes(String login, Date mes) {
        LigacaoDAO dao = factory.getLigacaoDAO();
        return dao.findAll(login, mes);
    }

    @Override
    public List<RamalDTO> searchRamalByLogin(String login) {
         RamalDAO dao = factory.getRamalDAO();
        return dao.searchByLogin(login);
    }

    @Override
    public List<RamalDTO> searchRamalByNumero(String numero) {
         RamalDAO dao = factory.getRamalDAO();
        return dao.searchByNumero(numero);
    }

    @Override
    public void createAllLigacao(List<LigacaoDTO> ligacoes) {
        LigacaoDAO dao = factory.getLigacaoDAO();
        dao.createAll(ligacoes);
    }

    @Override
    public void createAllRamal(List<RamalDTO> ramais) {
        RamalDAO dao = factory.getRamalDAO();
        dao.createAll(ramais);
    }
}
