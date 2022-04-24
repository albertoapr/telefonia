/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.br.pamerj.projects.telefonia.core;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mil.br.pamerj.projects.telefonia.api.AdminUserService;
import mil.br.pamerj.projects.telefonia.api.RelatorioService;
import mil.br.pamerj.projects.telefonia.dto.FaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;
import mil.br.pamerj.projects.telefonia.dto.PessoaDTO;

/**
 *
 * @author Fernando Tomasio
 */
public class ITextRelatorioService implements RelatorioService {

    @Override
    public byte[] gerarFaturaPDF(FaturaDTO fatura) {

        AdminUserService service = new SimpleAdminUserService();

        PessoaDTO responsavel = service.findPessoa(fatura.getRamal().getLogin());


        SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        SimpleDateFormat duracaoFormatter = new SimpleDateFormat("mm:ss");
        SimpleDateFormat periodoFormatter = new SimpleDateFormat("MM/ yyyy");
        DecimalFormat nf = new DecimalFormat("R$ ###,##0.00"); 
        String classPath=System.getProperty("file.path");
        String fileSeparator=System.getProperty("file.separator");

        System.out.println(classPath);
        
        Document document = new Document(PageSize.A4);
        Font font = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);

        //FileOutputStream file = null;
        ByteArrayOutputStream byteArray = null;





        try {
            //file = new FileOutputStream("Teste.pdf");
            byteArray = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, byteArray);

            document.open();
            
            Image image = Image.getInstance("http://10.52.152.2:8080/telefonia-flexapp/bin/logo.png");
            

            image.setAlignment(Element.ALIGN_LEFT);
            document.add(image);


            Paragraph pRespons = null;
            pRespons = new Paragraph("Responsavel : "
                    + new String(responsavel.getPosto().getBytes(), "ISO-8859-1")
                    + " "
                    + new String(responsavel.getNome().getBytes(), "ISO-8859-1"),
                    font);
            pRespons.setAlignment(Element.ALIGN_LEFT);

            document.add(pRespons);

            Paragraph pCod = null;
            pCod = new Paragraph(new String("COD. CENTEL : ".getBytes(), "ISO-8859-1")
                    + fatura.getRamal().getNumero(), font);

            pCod.setAlignment(Element.ALIGN_LEFT);

            document.add(pCod);
            Paragraph p1 =
                    new Paragraph(new String("Periodo     : ".getBytes(), "ISO-8859-1")
                    + periodoFormatter.format(fatura.getFaturamento().getPeriodo()), font);
            p1.setAlignment(Element.ALIGN_LEFT);

            document.add(p1);

            PdfPTable table = new PdfPTable(5);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.setWidthPercentage(100);
            table.addCell(new String("Numero".getBytes(), "ISO-8859-1"));
            table.addCell("Data");
            table.addCell(new String("Duracao".getBytes(), "ISO-8859-1"));
            table.addCell("Custo");
            table.addCell("Natureza");

            for (ItemFaturaDTO item : fatura.getItems()) {

                String data = null;
                String duracao = null;



                if (item.getLigacao().getDataHora() != null) {
                    data = dataFormatter.format(item.getLigacao().getDataHora());
                }

                if (item.getLigacao().getDuracao() != null) {
                    duracao = duracaoFormatter.format(item.getLigacao().getDuracao());
                }

                table.addCell(new Phrase(item.getLigacao().getNumero(), font));
                table.addCell(new Phrase(data, font));
                table.addCell(new Phrase(duracao, font));
                table.addCell(new Phrase(nf.format(item.getLigacao().getCusto()), font));
                table.addCell(new Phrase(item.getNatureza(), font));

            }


            document.add(table);
            Paragraph p2 = null;
            p2 = new Paragraph(new String("Total em ligacoes particulares: ".getBytes(), "ISO-8859-1")
                    + nf.format(fatura.getTotalParticular()), font);
            p2.setAlignment(Element.ALIGN_RIGHT);
            Paragraph p3 =
                    new Paragraph(new String("Total em ligacoes a serviço: ".getBytes(), "ISO-8859-1")
                    + nf.format(fatura.getTotalServico()), font);
            p3.setAlignment(Element.ALIGN_RIGHT);
            Paragraph p4 =
                    new Paragraph(new String("Total :".getBytes(), "ISO-8859-1")
                    + nf.format(fatura.getTotal()), font);
            p4.setAlignment(Element.ALIGN_RIGHT);


            document.add(p2);
            document.add(p3);
            document.add(p4);


        } catch (BadElementException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        }


        document.close();

        return byteArray.toByteArray();



    }

    @Override
    public byte[] gerarRelatorioFaturasPDF(List<FaturaDTO> faturas) {

        SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        SimpleDateFormat duracaoFormatter = new SimpleDateFormat("mm:ss");
        SimpleDateFormat periodoFormatter = new SimpleDateFormat("MM/ yyyy");
        DecimalFormat nf = new DecimalFormat("R$ ###,##0.00"); 

        Document document = new Document(PageSize.A4);
        Font font = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);

        //FileOutputStream file = null;
        ByteArrayOutputStream byteArray = null;

        try {
            //file = new FileOutputStream("Teste.pdf");
            byteArray = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, byteArray);

            document.open();
            
            Image image = Image.getInstance("http://10.52.152.2:8080/telefonia-flexapp/bin/logo.png");
            

            image.setAlignment(Element.ALIGN_LEFT);
            document.add(image);


            PdfPTable table = new PdfPTable(5);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.setWidthPercentage(100);
            table.addCell(new String("Nome".getBytes(), "ISO-8859-1"));
            table.addCell("Ramal");
            table.addCell(new String("Comunicado".getBytes(), "ISO-8859-1"));
            table.addCell("Data");
            table.addCell("Valor");

            for (FaturaDTO fatura : faturas) {

                String data = null;
                String duracao = null;



//                if (item.getLigacao().getDataHora() != null) {
//                    data = dataFormatter.format(item.getLigacao().getDataHora());
//                }
//
//                if (item.getLigacao().getDuracao() != null) {
//                    duracao = duracaoFormatter.format(item.getLigacao().getDuracao());
//                }

                table.addCell(new Phrase("", font));
                table.addCell(new Phrase(fatura.getRamal().getNumero(), font));
                table.addCell(new Phrase("__sim  __ nao", font));
                table.addCell(new Phrase("      /  /    ", font));
                table.addCell(new Phrase(nf.format(fatura.getTotal()), font));

            }


            document.add(table);



        } catch (BadElementException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ITextRelatorioService.class.getName()).log(Level.SEVERE, null, ex);
        }


        document.close();

        return byteArray.toByteArray();

    }
}
