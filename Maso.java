import java.util.DoubleSummaryStatistics;
import java.util.HashMap;

public class Maso {
    static Carta carta_alta;

    public static void main(String[] args) {
        Carta maso[]=new Carta[5];
        for(int i=0;i<5;i++){
            maso[i]=Carta.generarCarta();
        }
        System.out.print("Mano: ");
        printMaso(maso);
        maso=ordenar(maso);
        String caso=tiposCasos(maso);
        System.out.println("\nEl caso es: "+caso);
        if(caso.equals("CARTA ALTA")){
            System.out.print("Valor de carta alta: ");
            printMaso(carta_alta);
        }
    }
    public static void printMaso(Carta maso[]){
        HashMap<Integer,String> palo=new HashMap<>();
        HashMap<Integer,String> valor=new HashMap<>();
        palo.put(1,"S");
        palo.put(2,"C");
        palo.put(3,"H");
        palo.put(4,"D");
        valor.put(1,"A");
        valor.put(2,"2");
        valor.put(3,"3");
        valor.put(4,"4");
        valor.put(5,"5");
        valor.put(6,"6");
        valor.put(7,"7");
        valor.put(8,"8");
        valor.put(9,"9");
        valor.put(10,"T");
        valor.put(11,"J");
        valor.put(12,"Q");
        valor.put(13,"K");
        for(int i=0;i<5;i++){
            System.out.print(valor.get(maso[i].getValor())+palo.get(maso[i].getPalo())+" ");
        }
    }
    public static void printMaso(Carta maso){
        HashMap<Integer,String> palo=new HashMap<>();
        HashMap<Integer,String> valor=new HashMap<>();
        palo.put(1,"S");
        palo.put(2,"C");
        palo.put(3,"H");
        palo.put(4,"D");
        valor.put(1,"A");
        valor.put(2,"2");
        valor.put(3,"3");
        valor.put(4,"4");
        valor.put(5,"5");
        valor.put(6,"6");
        valor.put(7,"7");
        valor.put(8,"8");
        valor.put(9,"9");
        valor.put(10,"T");
        valor.put(11,"J");
        valor.put(12,"Q");
        valor.put(13,"K");
        System.out.print(valor.get(maso.getValor())+palo.get(maso.getPalo())+" ");
    }
    public static Carta[] ordenar(Carta maso[]){
        int valor_auxiliar,palo_auxiliar;
        for(int i=0;i<4;i++){
            for(int j=i+1;j<5;j++){
                if(maso[i].getValor()>maso[j].getValor()){
                    valor_auxiliar=maso[i].getValor();
                    palo_auxiliar=maso[i].getPalo();
                    maso[i].setValor(maso[j].getValor());
                    maso[i].setPalo(maso[j].getPalo());
                    maso[j].setPalo(palo_auxiliar);
                    maso[j].setValor(valor_auxiliar);
                }
            }
        }
        return maso;
    }
    public static String tiposCasos(Carta maso[]){
        String caso="";
        if(((maso[0].getValor()==maso[1].getValor()) && (maso[1].getValor()==maso[2].getValor()) && (maso[2].getValor()==maso[3].getValor()))|| ((maso[1].getValor()==maso[2].getValor()) && (maso[2].getValor()==maso[3].getValor()) && (maso[3].getValor()==maso[4].getValor()))){
            caso="POKER";
        }else if( ((maso[0].getValor()==maso[1].getValor()) && (maso[1].getValor()==maso[2].getValor()) && (maso[3].getValor()==maso[4].getValor())) || ((maso[2].getValor()==maso[3].getValor()) && (maso[3].getValor()==maso[4].getValor()) && (maso[0].getValor()==maso[1].getValor())) ){
            caso="FULL";
        }else if(isColor(maso)&&isEscalera(maso)){
            caso="ESCALERA DE COLOR";
        }else if(isEscalera(maso)){
            caso="ESCALERA";
        }else if(isColor(maso)){
            caso="COLOR";
        }else if( ((maso[0].getValor()==maso[1].getValor()) && (maso[1].getValor()==maso[2].getValor())) || ((maso[2].getValor()==maso[3].getValor()) && (maso[3].getValor()==maso[4].getValor())) || ((maso[1].getValor()==maso[2].getValor()) && (maso[2].getValor()==maso[3].getValor()))){
            caso="TRIO";
        }else if( ((maso[0].getValor()==maso[1].getValor()) && (maso[2].getValor()==maso[3].getValor())) || ((maso[1].getValor()==maso[2].getValor()) && (maso[3].getValor()==maso[4].getValor())) || ((maso[0].getValor()==maso[1].getValor()) && (maso[3].getValor()==maso[4].getValor()))){
            caso="PAR DOBLE";
        }else if(isPar(maso)){
            caso="PAR";
        }else{
            if(maso[0].getValor()==1){
                carta_alta=maso[0];
            }else{
                carta_alta=maso[4];
            }
            caso="CARTA ALTA";
        }
        return caso;
    }
    public static boolean isColor(Carta maso[]){
        boolean value=true;
        int palo_auxiliar=maso[0].getPalo();
        for(int i=1;i<5;i++){
            if(palo_auxiliar!=maso[i].getPalo()){
                value=false;
                break;
            }
        }
        return value;
    }
    public static boolean isEscalera(Carta maso[]){
        boolean value=false;
        int sum;
        sum=maso[1].getValor()+maso[2].getValor()+maso[3].getValor()+maso[4].getValor();
        if(sum==46 && maso[0].getValor()==1){
            value=true;
        }else{
            value=true;
            for(int i=1;i<4;i++){
                if(maso[i].getValor()+1!=maso[i+1].getValor()){
                    value=false;
                }
            }
        }
        return value;
    }
    public static boolean isPar(Carta maso[]){
        boolean value=false;
        for(int i=0;i<4;i++){
             for(int j=i+1;j<5;j++){
                 if(maso[i].getValor()==maso[j].getValor()){
                     value=true;
                     break;
                 }
             }
             if(value==true){
                 break;
             }
        }
        return value;
    }
}