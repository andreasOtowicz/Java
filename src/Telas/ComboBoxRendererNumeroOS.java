/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;


import java.awt.Component;
import javax.print.DocFlavor;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import ordemservico.model.AbrirOrdemS;

/**
 *
 * @author ricardo
 */
public class ComboBoxRendererNumeroOS extends JLabel implements ListCellRenderer {
    
    public ComboBoxRendererNumeroOS(){
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof AbrirOrdemS){
            AbrirOrdemS abertura = (AbrirOrdemS)value;
            if(abertura != null){
                setText(String.valueOf(abertura.getNumeroOrdem()));
                setFont(jlist.getFont());
            }
        }
        
        if(isSelected){
            setBackground(jlist.getSelectionBackground());
            setForeground(jlist.getSelectionForeground());
        } else {
            setBackground(jlist.getBackground());
            setForeground(jlist.getForeground());
        }
        
        return this;
    }
    
    
}
