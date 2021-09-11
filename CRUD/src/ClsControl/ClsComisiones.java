/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClsControl;

import Modelo.ConsultasVendedores;
import java.awt.event.ActionListener;
import Modelo.ClsVendedores;
import Vista.Vendedores;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Darlin
 */
//imprementar 
public class ClsComisiones implements ActionListener {
    private ClsVendedores mod;
    private ConsultasVendedores modC;
    private Vendedores frm;
    
    //constructor
    public ClsComisiones(ClsVendedores mod, ConsultasVendedores modC, Vendedores frm){
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        //declarar action para los botones
        this.frm.BCargar.addActionListener(this);
        this.frm.BModificar.addActionListener(this);
        this.frm.BEliminar.addActionListener(this);
        this.frm.jButton5.addActionListener(this);
    }
    
    //metodo para iniciar la vista
    public void iniciar(){
        frm.setTitle("Vendedores");
        frm.setLocationRelativeTo(null);
        frm.Text6.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //if para ver que boton fue presionado
        if(e.getSource()==frm.BCargar){
            mod.setCodigo(Integer.parseInt(frm.Text1.getText())); 
            mod.setNombre(frm.Text2.getText());
            mod.setEnero(Integer.parseInt(frm.Text3.getText())); 
            mod.setFebrero(Integer.parseInt(frm.Text4.getText())); 
            mod.setMarzo(Integer.parseInt(frm.Text5.getText())); 
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado"); 
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardad");
                limpiar();
            }
        }
        if(e.getSource()==frm.BModificar){
            mod.setId(Integer.parseInt(frm.Text6.getText()));
            mod.setCodigo(Integer.parseInt(frm.Text1.getText())); 
            mod.setNombre(frm.Text2.getText());
            mod.setEnero(Integer.parseInt(frm.Text3.getText())); 
            mod.setFebrero(Integer.parseInt(frm.Text4.getText())); 
            mod.setMarzo(Integer.parseInt(frm.Text5.getText())); 
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado"); 
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        if(e.getSource()==frm.BEliminar){
            mod.setId(Integer.parseInt(frm.Text6.getText()));  
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado"); 
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        if(e.getSource()==frm.jButton5){
            mod.setCodigo(Integer.parseInt(frm.Text1.getText()));  
            
            if(modC.buscar(mod)){
                frm.Text6.setText(String.valueOf(mod.getId()));
                frm.Text1.setText(String.valueOf(mod.getCodigo()));
                frm.Text2.setText(mod.getNombre());
                frm.Text3.setText(String.valueOf(mod.getEnero()));
                frm.Text4.setText(String.valueOf(mod.getFebrero()));
                frm.Text5.setText(String.valueOf(mod.getMarzo()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            }
        }
        if(e.getSource()==frm.BLimpiar){
            limpiar();
        
        }
    }
    public void limpiar(){
            frm.Text1.setText(null);
            frm.Text2.setText(null);
            frm.Text3.setText(null);
            frm.Text4.setText(null);
            frm.Text5.setText(null);
        }
}
