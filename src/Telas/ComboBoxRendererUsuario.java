/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import ordemservico.model.Usuario;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ricardo
 */
public class ComboBoxRendererUsuario extends JLabel implements ListCellRenderer {
    
    public ComboBoxRendererUsuario(){
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof Usuario){
            Usuario usuario = (Usuario)value;
            if(usuario != null){
                setText(String.valueOf(usuario.getCodigoUsuario()));
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
