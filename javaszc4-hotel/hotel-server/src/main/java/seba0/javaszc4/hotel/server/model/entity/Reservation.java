package seba0.javaszc4.hotel.server.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @ManyToOne(optional = false)
    private Room room;

    @ManyToOne(optional = false)
    private Guest guest;

    @ManyToMany
    private List<Information> information;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<Information> getInformation() {
        return information;
    }

    public void setInformation(List<Information> information) {
        this.information = information;
    }
}
