package javaszc4.zadania.podstawy._6.komis.auta;

public abstract class Samochod<T extends Enum> {
    private String podstawoweDane;
    private T model;

    public String getPodstawoweDane() {
        return podstawoweDane;
    }

    public void setPodstawoweDane(String podstawoweDane) {
        this.podstawoweDane = podstawoweDane;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
