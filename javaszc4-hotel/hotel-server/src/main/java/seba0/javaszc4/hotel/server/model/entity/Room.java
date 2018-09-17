package seba0.javaszc4.hotel.server.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
public class Room {

    @Id
    private short nr;

    @Column
    private byte area;

    @Column
    private byte standard;

    @Column
    private byte beds;

    @Column(precision=7, scale=2)
    private BigDecimal price;

    @ManyToMany
    private List<Information> information;

    public short getNr() {
        return nr;
    }

    public void setNr(short nr) {
        this.nr = nr;
    }

    public byte getArea() {
        return area;
    }

    public void setArea(byte area) {
        this.area = area;
    }

    public byte getStandard() {
        return standard;
    }

    public void setStandard(byte standard) {
        this.standard = standard;
    }

    public byte getBeds() {
        return beds;
    }

    public void setBeds(byte beds) {
        this.beds = beds;
    }

    public boolean isOutOfOrder() {
        return price == null;
    }

    public Optional<BigDecimal> getPrice() {
        return Optional.ofNullable(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Information> getInformation() {
        return information;
    }

    public void setInformation(List<Information> information) {
        this.information = information;
    }
}
