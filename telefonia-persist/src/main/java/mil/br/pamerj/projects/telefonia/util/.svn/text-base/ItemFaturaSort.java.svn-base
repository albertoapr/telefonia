/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mil.br.pamerj.projects.telefonia.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mil.br.pamerj.projects.telefonia.dto.ItemFaturaDTO;

/**
 *
 * @author fernandofot
 */
public class ItemFaturaSort implements Comparator<ItemFaturaDTO> {

    @Override
    public int compare(ItemFaturaDTO o1, ItemFaturaDTO o2) {
               
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        c1.setTime(o1.getLigacao().getDataHora());
        c2.setTime(o2.getLigacao().getDataHora());
        

        
        int i = 0;

        if(c1.before(c2)){
            i = -1;
        }else if(c1.after(c2)){
            i = 1;
        }else{
            i = 0;
        }
        return i;
    }

}
