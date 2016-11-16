/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;
/**
 * @author 
 */
public class Cola<T> {
    private ListaSE<T> cola;
    
    public Cola(){
        cola = new ListaSE<T>();
    }
    public boolean vacio(){
        return cola.vacio();
    }
    public void encolar(T dato){
        cola.insertar(dato);
    }
    public T ver(){
        return cola.getInicio();        
    }
    public T decolar(){
        T res = null;
        res = cola.getInicio();
        cola = cola.getSig();
        return res;
    }
    
}
