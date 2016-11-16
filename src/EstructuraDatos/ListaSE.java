/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatos;
/**
 * @author leider
 */
public class ListaSE<T> {
    private T ini;
    private ListaSE<T> sig;
    public ListaSE(){
        ini = null;
        sig = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public boolean vacio()
    {
        boolean res = false;
        if(ini == null)
        {
            res = true;
        }
        return res;
    }
    public void insertar(T d){
        if(vacia()){
            ini = d;
            sig = new ListaSE<T>();
        }else{
            sig.insertar(d);
        }
    }
    public T getInicio(){
        return ini;
    }
    public ListaSE<T> getSig(){
        return sig;
    }
    public T eliminar(int i){
        T res = null;
        if(!vacia()){
            if(i==0){
                res = ini;
                ini = sig.ini;
                sig = sig.sig;
            }else{
                res=sig.eliminar(i-1);
            }
        }
        return res;
    }
    public T acceder(int i){
        T res = null;
        if(!vacia()){
            if(i ==0){
                res = ini;
            }else{
                res=sig.acceder(i-1);
            }
        }
        return res;
    }
    public void invertir(){
        if(!vacia()){
            sig.invertir();
            sig.insertar(ini);
            ini=sig.ini;
            sig=sig.sig;
        }
    }

    public int longitud(){
        int res=0;
        if(!vacia()){
            res=1+sig.longitud();
        }
        return res;
    }
    public boolean insertar(int i,T d){
        boolean res=false;
        if(vacia()){
            ini=d;
            sig=new ListaSE<T>();
            res=true;    
        }else{
            if(i==0){
               res=true;
               sig.insertar(0, ini);
               ini=d;
            }else{
               res=sig.insertar(i-1, d);
            }       
        }
        return res;
    }
}
