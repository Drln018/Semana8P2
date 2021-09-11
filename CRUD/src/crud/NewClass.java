/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import ClsControl.ClsComisiones;
import Modelo.ClsVendedores;
import Modelo.ConsultasVendedores;
import Vista.Vendedores;

/**
 *
 * @author Darlin
 */
public class NewClass {
    
    public static void main(String[] args){
        ClsVendedores mod= new ClsVendedores();
        ConsultasVendedores modC= new ConsultasVendedores();
        Vendedores frm=new Vendedores();
        
        ClsComisiones comi = new ClsComisiones(mod, modC, frm);
        comi.iniciar();
        frm.setVisible(true);
        
    }
}
