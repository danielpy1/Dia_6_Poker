import java.util.Random;

public class Carta {
    private int valor;
    private int palo;

    public Carta() {

    }

    public Carta(int valor, int palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    static public Carta generarCarta(){
        Carta carta_auxiliar;
        carta_auxiliar=new Carta(generarValor(),generarPalo());
        return carta_auxiliar;
    }
    static public int generarValor(){
        Random r=new Random();
        return r.nextInt(13)+1;
    }
    static public int generarPalo(){
        Random r=new Random();
        return r.nextInt(4)+1;
    }
}
