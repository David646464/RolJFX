public class Objeto {
    
    enum TipoObjeto {CASCO, PECHERA, BOTAS, PANTALONES, ESPADA, ARCO, HACHA, MAZA, PuntoOVA, LANZA,  ESCUDO, TALISMANDEVIDA, TALISMANDEDEFENSA, TALISMANDEAGILIDAD}
    TipoObjeto objeto;

    enum Calidad {COMUN, POCOCOMUN,RARO,EPICO,LEGENDARIO}
    Calidad calidad;

    String nombreObjeto;
    int Nivel;
    int XP;
    int limiteXP;
    int daño;
    int agilidad;
    int defensa;
    int vida;
    int precision;

    public Objeto( Objeto.TipoObjeto objeto) {
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
    }

    private Objeto.Calidad generarCalidad() {
        Objeto.Calidad calidad = null;
        int probabilidad = (int) (Math.random() * 99) + 1;
        if (probabilidad >= 1 && probabilidad <= 35){
            calidad = Calidad.COMUN;
        }else if (probabilidad > 35 && probabilidad <= 65){
            calidad = Calidad.POCOCOMUN;
        }else if (probabilidad > 65 && probabilidad <= 85){
            calidad = Calidad.RARO;
        }else if (probabilidad > 85 && probabilidad <= 95){
            calidad = Calidad.EPICO;
        }else if (probabilidad > 95 && probabilidad <= 100){
            calidad = Calidad.LEGENDARIO;
        }

        return calidad;
    }

    private String generarNombre(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        return objeto2 + " (" + calidad + ")";
    }

    private int generarPrecision(Objeto.TipoObjeto objeto2) {
        int AuxPrecision = 0;
        switch (objeto2)
        {
            case ESPADA:
            AuxPrecision = 95;
            break;
            case ARCO:
            AuxPrecision = 80;
            break;
            case HACHA:
            AuxPrecision = 75;
            break;
            case MAZA:
            AuxPrecision = 90;
            break;
            case PuntoOVA:
            AuxPrecision = 5;
            break;
            case LANZA:
            AuxPrecision = 100;
            break;

        }
        
        return AuxPrecision;
    }

    private int generarVida(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        int AuxVida = 0;
        switch (objeto2)
        {
            case CASCO:
            AuxVida = 20;
            break;
            case TALISMANDEVIDA:
            AuxVida = 50;
            break;
            case PECHERA:
            AuxVida = 30;
            break;
            case BOTAS:
            AuxVida = 20;
            break;
            case PANTALONES:
            AuxVida = 25;
            break;
            

        }
        AuxVida = ajustarCalidad(AuxVida, calidad);

        return AuxVida;
    }

    private int generarDefensa(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        int AuxDefensa = 0;
        switch (objeto2)
        {
            case CASCO:
            AuxDefensa = 20;
            break;
            case ESCUDO:
            AuxDefensa = 40;
            break;
            case TALISMANDEDEFENSA:
            AuxDefensa = 50;
            break;
            case PECHERA:
            AuxDefensa = 30;
            break;
            case BOTAS:
            AuxDefensa = 10;
            break;
            case PANTALONES:
            AuxDefensa = 25;
            break;
            

        }
        AuxDefensa = ajustarCalidad(AuxDefensa, calidad);

        return AuxDefensa;
    }

    private int generarAgilidad(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        int AuxAgilidad =0;
        switch (objeto2){
            case TALISMANDEAGILIDAD:
            AuxAgilidad = 50;
            break;
            case LANZA:
            AuxAgilidad = 20;
            break;
            case HACHA:
            AuxAgilidad = -20;
            break;
            case ESPADA:
            AuxAgilidad = 10;
            break;
            case BOTAS:
            AuxAgilidad = 10;
            break;
            case MAZA:
            AuxAgilidad = -10;
            break;
            
        }
        AuxAgilidad = ajustarCalidad(AuxAgilidad, calidad);
        return AuxAgilidad;
    }

    private int generarDaño(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        int AuxDaño =0;
        switch (objeto2){
            case ESPADA:
            AuxDaño = 40;
            break;
            case LANZA:
            AuxDaño = 30;
            break;
            case HACHA:
            AuxDaño = 75;
            break;
            case ARCO:
            AuxDaño = 65;
            break;
            case PuntoOVA:
            AuxDaño = 999999999;
            break;
            case MAZA:
            AuxDaño = 55;
            break;
            
        }
        AuxDaño = ajustarCalidad(AuxDaño, calidad);
        return AuxDaño;
    }
   
    public int ajustarCalidad(int puntos, Objeto.Calidad calidad){
        
        if (calidad == Calidad.LEGENDARIO){
            puntos = (int) Math.round(puntos * 1.40);
        } else if (calidad == Calidad.EPICO){
            puntos = (int) Math.round(puntos * 1.30);
        }else if (calidad == Calidad.RARO){
            puntos = (int) Math.round(puntos * 1.20);
        }else if (calidad == Calidad.POCOCOMUN){
            puntos = (int) Math.round(puntos * 1.10);
        }else{
            puntos = puntos;
        }
        
        
    
    
        return puntos;

    }
    public int generarLimite(Objeto.Calidad calidad){
        limiteXP = 1000;
        if (calidad == Calidad.LEGENDARIO){
            limiteXP = (int) Math.round(limiteXP * 1.40);
        } else if (calidad == Calidad.EPICO){
            limiteXP = (int) Math.round(limiteXP * 1.30);
        }else if (calidad == Calidad.RARO){
            limiteXP = (int) Math.round(limiteXP * 1.20);
        }else if (calidad == Calidad.POCOCOMUN){
            limiteXP = (int) Math.round(limiteXP * 1.10);
        }else{
            limiteXP = limiteXP;
        }
        return limiteXP;
        
    }
    public void sumarExperiencia(int puntosXP) {
        XP =+ puntosXP;
        if (XP >= limiteXP){
            subirNivel();
            XP=- limiteXP;
            limiteXP = (int) Math.round(limiteXP * 1.40);
        }

        
    }

    public void subirNivel() {
        Nivel++;
        daño = (int) Math.round(daño * 1.05);
        agilidad = (int) Math.round(agilidad * 1.05);
        defensa = (int) Math.round(defensa * 1.05);
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





        
    }
    public static void main(String[] args) {
        Objeto objeto1 = new Objeto(TipoObjeto.CASCO);
        Objeto objeto2 = new Objeto(TipoObjeto.ESPADA);
        Objeto objeto3 = new Objeto(TipoObjeto.ESCUDO);
        objeto1.mostrar();
        System.out.println("==============================");
        objeto2.mostrar();
        System.out.println("==============================");
        objeto3.mostrar();
    }
    
}
