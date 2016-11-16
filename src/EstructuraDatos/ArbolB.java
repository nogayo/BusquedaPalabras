/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates sfserfersfer
 * and open the template in the editor.  vvvv
 */
package EstructuraDatos;

/**
 *
 * @author 
 */
public class ArbolB<T extends Comparable> {
    private T raiz;
    private ArbolB<T> izq, der;
   public ArbolB(){
       raiz=null;
       izq=der=null;
   }
   public boolean vacia(){
        return raiz==null;
   }
/**
 * Este metodo denominado insertarAmp es el encargado de crear y insertar 
 * datos a un arbol binario.
 */
   public void insertarAmp(T d){
        Cola<ArbolB<T>>c;
        c=new Cola<ArbolB<T>>();
        c.encolar(this);
        insertarAmp(d, c);
   }
   private void insertarAmp(T d, Cola<ArbolB<T>>c){
        ArbolB<T>arb;
        arb=c.decolar();
        if(arb.vacia()){
            arb.raiz=d;
            arb.izq=new ArbolB<T>();
            arb.der=new ArbolB<T>();
        }else{
            c.encolar(arb.izq);
            c.encolar(arb.der);
            insertarAmp(d, c);
        }
   }
   
   public T eliminar(T d){
        T res=null;
        if(!vacia()){
            if(raiz.equals(d)){
                if(raizHoja()){
                    res=raiz;
                    raiz=null;
                    izq=der=null;
                }
            }else{
                res=izq.eliminar(d);
                if(res==null){
                    res=der.eliminar(d);
                }
            }
        }
        return res;
   }
   private boolean raizHoja(){
        return izq.vacia() && der.vacia();
   }
   public int nroHojas(){
        int res = 0;
        if(!vacia()){
            if(raizHoja()){
                res=1;
            }else{
                res=izq.nroHojas()+der.nroHojas();
            }
        }
        return res;
   }
   /**
    * Este metodo llamado busqueda profundidad se encarga de 
    * decirnos con un valor booleano true o false, si un dato se encuentrar
    * en un arbol binario especifico.
    */
   public boolean busquedaProfundidad(T dato){
       return busquedaProfundidad( dato, false);
   }
   private boolean busquedaProfundidad( T dato, boolean bandera){
       boolean res=bandera;
       if(raiz!=null){
           if(raiz.equals(dato)){
                res=true;
            }else{
                res=izq.busquedaProfundidad(dato, res);
                res=der.busquedaProfundidad(dato, res);          
       }
       }
       return res;
   }
   /**
    * Este metodo llamado profundidad nos dice el nivel que tiene
    * un arbol binario.
    */
       public int profundidad(){
       return profundidad(0);
   }
   private int profundidad(int index){
       int indexx=index;
       if(raiz!=null){
           indexx+=1;
           indexx=izq.profundidad(indexx);
       }
       return indexx;
   }
   /**
    * Este metodo recursivo  denominado niverResul nos devuelve el
    * nivel de profundiad que se encuentra un dato en un arbol binario
    * especifico.
    */
   public int nivelResult(T dato){
       int res=nivelResult( dato, -1);
       return  res;
   }
   private int nivelResult( T dato, int index){
       int res=index;
       if(raiz!=null){       
           if(!raiz.equals(dato)){
               if (!izq.vacia()) {
                    res=izq.nivelResult(dato, res+1);
                    if(!izq.busquedaProfundidad(dato)){
                        res=der.nivelResult(dato, res);                        
                        if(!der.busquedaProfundidad(dato)){
                            res=res-1;
                        }
                    }                   
               }                                            
            }else{
               res=res+1;         
           }
       }
       return res;
   }
}
