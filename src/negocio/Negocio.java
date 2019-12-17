/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcela Florez
 */
public class Negocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
     ArrayList<negocio.Proveedor> Proveedores = new ArrayList<negocio.Proveedor>();
  public void MostrarProveedores() {
        String temp = "";
        
        for (int i=0; i<Proveedores.size();i++) {
            temp = temp +"Proveedor"+(i+1)+"  "
                    +"\n Nombre: " + Proveedores.get(i).getNombre() + "  "
                    + "\n agente: " +Proveedores.get(i).getAgente() + "  "
                    + "\n Telefono: " + Proveedores.get(i).getTelefono() 
                    + "\n----------------------------";
        }
        JOptionPane.showMessageDialog(null, temp);

    }  
public void agregarProveedores() {
    int telefono =0;
    for(int i = 0; i<1;i++){
        telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telefono de la empresa"));
            if (Proveedores.size()!=0){
                for (int j = 0; j < Proveedores.size(); j++) {
                    if (Proveedores.get(i).getTelefono()==telefono){
                        JOptionPane.showMessageDialog(null,"El numero de telefono ya existe, ingrese otra");
                        i--;
                    }
                    
                }
            }
    }
        String nombreE = JOptionPane.showInputDialog("Ingrese el nombre de la empresa");

        String agente = JOptionPane.showInputDialog("Ingrese el nombre del agente");
        
        Proveedor Primer = new Proveedor (nombreE, agente, telefono);
        Proveedores.add(Primer);
        JOptionPane.showMessageDialog(null,"Se agregó exitosamente el Proveedor");
         
        }
public void modificarProveedor(){
    int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telefono de la empresa que desea modificar"));
    for (int i = 0; i < Proveedores.size(); i++) {
        if (Proveedores.get(i).getTelefono()==telefono){
            Proveedor Primer = new Proveedor();
             Primer = encontrarP (telefono);
             int  telefonoC = (int) Primer.getTelefono();
             String nombreE = JOptionPane.showInputDialog("Ingrese el nombre de la empresa", Primer.getNombre());
             String agente  = JOptionPane.showInputDialog("Ingrese el nombre de la empresa", Primer.getAgente());
             Proveedor modiProveedor = new Proveedor (telefonoC, nombreE, agente);
             for (int j = 0; j < Proveedores.size(); j++) {
                 if (Primer.getTelefono()==Proveedores.get(j).getTelefono()){
                     Proveedores.get(j).setNombre(modiProveedor.getNombre());
                     Proveedores.get(j).setAgente(modiProveedor.getAgente());
                     
                     
                 }
                
            }
             
        }else{ JOptionPane.showMessageDialog(null,"EL numero de telefono de la empresa no existe");
            
        }
     
        
    }
    
}

public void eliminarProveedor(){
    int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese EL numero de telefono de la empresa a eliminar"));
    for (int i = 0; i < Proveedores.size(); i++) {
        if (telefono == Proveedores.get(i).getTelefono()){
            Proveedores.remove(i);
            JOptionPane.showMessageDialog(null,"Se eiminó el Proveedor");
        }else{
            JOptionPane.showMessageDialog(null,"El Proveedor no existe"); 

            
        }
        
    }

}
public negocio.Proveedor encontrarP (int telefonoC){
    for (int i = 0; i < Proveedores.size(); i++) {
           if (telefonoC == Proveedores.get(i).getTelefono()){
               return Proveedores.get(i);
           }        
    }
    return new negocio.Proveedor();
}

    
}
 
