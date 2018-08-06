package javaszc4.zajecia.podstawy._3.generyki._3;

public class Utils {

    public static  <T extends Zwierze> void kimJestem(T zwierze) {
        zwierze.kimJestem();
    }

    public static <T extends Zwierze> void kimJestem(Class<T> aClass) {
        try {
            T a = aClass.newInstance();
            a.kimJestem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        kimJestem(Kot.class);
        kimJestem(Pies.class);
        kimJestem(Slon.class);
    }
}
