public class Objeto {
    String nombreObjeto;

    enum TipoObjeto {CASCO, PECHERA, BOTAS, PANTALONES, ESPADA, ARCO, HACHA, MAZA, PuntoOVA, LANZA,
         ESCUDO, TALISMANDEVIDA, TALISMANDEDEFENSA, TALISMANDEAGILIDAD}
    TipoObjeto objeto;

    enum Calidad {COMUN, POCOCOMUN,RARO,EPICO,LEGENDARIO}
    Calidad calidad;
    int Nivel;
    int XP;
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
        daño = generarDaño(objeto,calidad);
        agilidad = generarAgilidad(objeto,calidad);
        defensa = generarDefensa(objeto,calidad);
        vida = generarVida(objeto,calidad);
        precision = generarPrecision(objeto);
        this.nombreObjeto = generarNombre(objeto,calidad);
    }

    private Objeto.Calidad generarCalidad() {
        return null;
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
        return 0;
    }

    private int generarDefensa(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        return 0;
    }

    private int generarAgilidad(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        return 0;
    }

    private int generarDaño(Objeto.TipoObjeto objeto2,Objeto.Calidad calidad) {
        return 0;
    }
   
    
}
