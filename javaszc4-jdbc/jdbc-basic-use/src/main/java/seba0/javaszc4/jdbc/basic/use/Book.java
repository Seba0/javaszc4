package seba0.javaszc4.jdbc.basic.use;

import seba0.javaszc4.jdbc.basic.use.helper.Column;
import seba0.javaszc4.jdbc.basic.use.helper.Table;

import java.io.Serializable;

@Table
public class Book implements Serializable {
    @Column
    private String title;
}
