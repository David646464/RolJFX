public class Objeto {
    
    String[] objetos = {"CASCO", "PECHERA", "BOTAS", "PANTALONES", "ESPADA", "ARCO", "HACHA", "MAZA", "PuntoOVA", "LANZA",  "ESCUDO", "TALISMANDEVIDA", "TALISMANDEDEFENSA", "TALISMANDEAGILIDAD"};

    String[] Calidad = {"COMUN", "POCOCOMUN","RARO","EPICO","LEGENDARIO"};
    String objeto;
    String calidad;
    String nombreObjeto;
    int Nivel;
    int XP;
    int limiteXP;
    int daño;
    int agilidad;
    int defensa;
    int vida;
    int precision;
    int precio;

    public Objeto( String objeto) {
        this.objeto = objeto;
        calidad = generarCalidad();
        Nivel = 1;
        XP = 0;
        limiteXP = generarLimite(calidad);
        daño = generarDaño(objeto,calidad);
        agilidad = generarAgilidad(objeto,calidad);
        defensa = generarDefensa(objeto,calidad);
        vida = generarVida(objeto,calidad);
        precision = generarPrecision(objeto);
        this.nombreObjeto = generarNombre(objeto,calidad);
        precio = generarPrecio(objeto,calidad);
    }

    

    private int generarPrecio(String objeto2, String calidad2) {
        int Auxprecio =0;
        switch (objeto2)
        {
            case "ESPADA":
            Auxprecio =45;
            break;
            case "ARCO":
            Auxprecio =75;
            break;
            case "HACHA":
            Auxprecio =55;
            break;
            case "MAZA":
            Auxprecio =60;
            break;
            case "PuntoOVA":
            Auxprecio =9999;
            break;
            case "LANZA":
            Auxprecio =50;
            break;
            case "TALISMANDEAGILIDAD":
            Auxprecio =1000;
            break;
            case "TALISMANDEDEFENSA":
            Auxprecio =1000;
            break;
            case "TALISMANDEVIDA":
            Auxprecio =1000;
            break;
            case "ESCUDO":
            Auxprecio =100;
            break;
            case "BOTAS":
            Auxprecio =65;
            break;
            case "CASCO":
            Auxprecio =50;
            break;
            case "PECHERA":
            Auxprecio =80;
            break;
            case "PANTALONES":
            Auxprecio =75;
            break;

        }
        switch (calidad)
        {
            case "COMUN":
            Auxprecio =Auxprecio;
            break;
            case "POCOCOMUN":
            Auxprecio =(int) Math.round(Auxprecio * 1.05);            break;
            case "RARO":
            Auxprecio =(int) Math.round(Auxprecio * 1.20);            break;
            case "EPICO":
            Auxprecio =(int) Math.round(Auxprecio * 1.35);            break;
            case "LEGENDARIO":
            Auxprecio =(int) Math.round(Auxprecio * 1.50);            break;
            

        }

        return Auxprecio;
    }

    private String generarCalidad() {
        String calidad = null;
        int probabilidad = (int) (Math.random() * 99) + 1;
        if (probabilidad >= 1 && probabilidad <= 35){
            calidad ="COMUN";
        }else if (probabilidad > 35 && probabilidad <= 65){
            calidad = "POCOCOMUN";
        }else if (probabilidad > 65 && probabilidad <= 85){
            calidad = "RARO";
        }else if (probabilidad > 85 && probabilidad <= 95){
            calidad ="EPICO";
        }else if (probabilidad > 95 && probabilidad <= 100){
            calidad ="LEGENDARIO";
        }

        return calidad;
    }

    private String generarNombre(String objeto2,String calidad) {
        return objeto2 + " (" + calidad + ")";
    }

    private int generarPrecision(String objeto2) {
        int AuxPrecision = 0;
        switch (objeto2)
        {
            case "ESPADA":
            AuxPrecision = 95;
            break;
            case "ARCO":
            AuxPrecision = 80;
            break;
            case "HACHA":
            AuxPrecision = 75;
            break;
            case "MAZA":
            AuxPrecision = 90;
            break;
            case "PuntoOVA":
            AuxPrecision = 5;
            break;
            case "LANZA":
            AuxPrecision = 100;
            break;

        }
        
        return AuxPrecision;
    }

    private int generarVida(String objeto2,String calidad) {
        int AuxVida = 0;
        switch (objeto2)
        {
            case "CASCO":
            AuxVida = 20;
            break;
            case "TALISMANDEVIDA":
            AuxVida = 50;
            break;
            case "PECHERA":
            AuxVida = 30;
            break;
            case "BOTAS":
            AuxVida = 20;
            break;
            case "PANTALONES":
            AuxVida = 25;
            break;
            

        }
        AuxVida = ajustarCalidad(AuxVida, calidad);

        return AuxVida;
    }

    private int generarDefensa(String objeto2,String calidad) {
        int AuxDefensa = 0;
        switch (objeto2)
        {
            case "CASCO":
            AuxDefensa = 20;
            break;
            case "ESCUDO":
            AuxDefensa = 40;
            break;
            case "TALISMANDEDEFENSA":
            AuxDefensa = 50;
            break;
            case "PECHERA":
            AuxDefensa = 30;
            break;
            case "BOTAS":
            AuxDefensa = 10;
            break;
            case "PANTALONES":
            AuxDefensa = 25;
            break;
            

        }
        AuxDefensa = ajustarCalidad(AuxDefensa, calidad);

        return AuxDefensa;
    }

    private int generarAgilidad(String objeto2,String calidad) {
        int AuxAgilidad =0;
        switch (objeto2){
            case "TALISMANDEAGILIDAD":
            AuxAgilidad = 50;
            break;
            case "LANZA":
            AuxAgilidad = 20;
            break;
            case "HACHA":
            AuxAgilidad = -20;
            break;
            case "ESPADA":
            AuxAgilidad = 10;
            break;
            case "BOTAS":
            AuxAgilidad = 10;
            break;
            case "MAZA":
            AuxAgilidad = -10;
            break;
            
        }
        AuxAgilidad = ajustarCalidad(AuxAgilidad, calidad);
        return AuxAgilidad;
    }

    private int generarDaño(String objeto2,String calidad) {
        int AuxDaño =0;
        switch (objeto2){
            case "ESPADA":
            AuxDaño = 40;
            break;
            case "LANZA":
            AuxDaño = 30;
            break;
            case "HACHA":
            AuxDaño = 75;
            break;
            case "ARCO":
            AuxDaño = 65;
            break;
            case "PuntoOVA":
            AuxDaño = 999999999;
            break;
            case "MAZA":
            AuxDaño = 55;
            break;
            
        }
        AuxDaño = ajustarCalidad(AuxDaño, calidad);
        return AuxDaño;
    }
   
    public int ajustarCalidad(int puntos, String calidad){
        
        if (calidad == "LEGENDARIO"){
            puntos = (int) Math.round(puntos * 1.40);
        } else if (calidad == "EPICO"){
            puntos = (int) Math.round(puntos * 1.30);
        }else if (calidad == "RARO"){
            puntos = (int) Math.round(puntos * 1.20);
        }else if (calidad == "POCOCOMUN"){
            puntos = (int) Math.round(puntos * 1.10);
        }else{
            puntos = puntos;
        }
        
        
    
    
        return puntos;

    }
    public int generarLimite(String calidad){
        limiteXP = 1000;
        if (calidad == "LEGENDARIO"){
            limiteXP = (int) Math.round(limiteXP * 1.40);
        } else if (calidad == "EPICO"){
            limiteXP = (int) Math.round(limiteXP * 1.30);
        }else if (calidad == "RARO"){
            limiteXP = (int) Math.round(limiteXP * 1.20);
        }else if (calidad == "POCOCOMUN"){
            limiteXP = (int) Math.round(limiteXP * 1.10);
        }else{
            limiteXP = limiteXP;
        }
        return limiteXP;
        
    }
    public void sumarExperiencia(int puntosXP) {
        XP += puntosXP;
        if (XP >= limiteXP){
            subirNivel();
            XP-= limiteXP;
            limiteXP = (int) Math.round(limiteXP * 1.40);
        }

        
    }

    public void subirNivel() {
        Nivel++;
        daño = (int) Math.round(daño * 1.05);
        agilidad = (int) Math.round(agilidad * 1.05);
        defensa = (int) Math.round(defensa * 1.05);
        vida = (int) Math.round(vida * 1.05);
        precio = (int) Math.round(precio * 1.05);
    }

    public void mostrar(){
        System.out.println("Objeto");
        System.out.println("Nombre del objeto: " + nombreObjeto );
        System.out.println("Nivel: " + Nivel );
        System.out.println("XP: " + XP + "/" + limiteXP );
        System.out.println("Aumento de daño: " + daño);
        System.out.println("Aumento de agilidad: " + agilidad);
        System.out.println("Aumento de defensa: " + defensa);
        System.out.println("Aumento de vida: " + vida);
        System.out.println("Precision: " + precision);
        System.out.println("Precio: " + precio);





        
    }
    public static void main(String[] args) {
        Objeto objeto1 = new Objeto("CASCO");
        Objeto objeto2 = new Objeto("ESPADA");
        Objeto objeto3 = new Objeto("ESCUDO");
        objeto1.mostrar();
        System.out.println("==============================");
        objeto2.mostrar();
        System.out.println("==============================");
        objeto3.mostrar();
        System.out.println("==============================");
        objeto1.sumarExperiencia(1400);
        objeto1.mostrar();
    }
    
}
