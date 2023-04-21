public class Tienda {
     static int NumStock = 3;
    
     Objeto[] Stock = new Objeto[NumStock];
     
     

    
    



     
    
    public Tienda() {
        Stock = crearStock();
    }
    public static Objeto[] crearStock(){
        String[] objetos = {"CASCO", "PECHERA", "BOTAS", "PANTALONES", "ESPADA", "ARCO", "HACHA", "MAZA", "PuntoOVA", "LANZA",  "ESCUDO", "TALISMANDEVIDA", "TALISMANDEDEFENSA", "TALISMANDEAGILIDAD"};

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
    public static void main(String[] args) {
       Tienda tienda = new Tienda();
       tienda.mostrarTienda();
       
    }
   





    
    

}