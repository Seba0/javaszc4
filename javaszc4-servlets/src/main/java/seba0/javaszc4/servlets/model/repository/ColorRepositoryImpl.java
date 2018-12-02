package seba0.javaszc4.servlets.model.repository;


public class ColorRepositoryImpl implements ColorRepository {

    private String background = "#000";

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
