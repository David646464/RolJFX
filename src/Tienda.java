public class Tienda {
     static int NumStock = 3;
    
     Objeto[] Stock = new Objeto[NumStock];
     static String[] objetos = Objeto.objetos;

     

    
    



     
    
    public Tienda() {
        Stock = crearStock();
    }
    public static Objeto[] crearStock(){

        Objeto[] ObjetosAux = new Objeto[NumStock];
        for (int i=0 ; i < NumStock; i++){

            int numeroAux = (int) (Math.random() * 13) + 1;


            Objeto auxObjeto = new Objeto((objetos[numeroAux]));
            ObjetosAux[i] = auxObjeto;
        } 
        return ObjetosAux;
    }

    public void mostrarTienda(){

        for (int i =0; i < NumStock ; i++){
            System.out.println("==============================");
            Stock[i].mostrar();
        }
        System.out.println("==============================");
       
    }
    public static  boolean comprarObjeto(Objeto objeto, Personaje personaje){
        boolean confirmacion = false;
        if (objeto.precio < personaje.dinero){
            personaje.dinero -= objeto.precio;
            confirmacion = true;
            System.out.println("Gracias por su compra");
            System.out.println(objeto.nombreObjeto + " ha sido añadido al inventario");
        }else{
            System.out.println("No hay suficiente dinero");
        }
        return confirmacion;
    }
    public static  boolean venderObjeto(Objeto objeto, Personaje personaje){
        boolean confirmacion = true;

        personaje.dinero = objeto.precio;
        System.out.println("Gracias por su venta");
        System.out.println(objeto.nombreObjeto + " ha sido eliminado del inventario");
        return confirmacion;
    }
    public static void main(String[] args) {
       Tienda tienda = new Tienda();
       tienda.mostrarTienda();
       Personaje personaje = new Personaje("David", "HUMANO");
       personaje.dinero = 2000;
       personaje.mostrar();
       System.out.println(comprarObjeto(tienda.Stock[1], personaje));
       personaje.mostrar();
       
    }
   





    
    

}