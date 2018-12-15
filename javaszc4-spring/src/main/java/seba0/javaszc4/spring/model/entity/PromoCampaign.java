package seba0.javaszc4.spring.model.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class PromoCampaign {

    @Id
    private ObjectId id;
    @Indexed
    @NonNull
    private String name;
    private String description;
    @NonNull
    private Brand brand;
    @NonNull
    private LocalDate begin;
    @NonNull
    private LocalDate end;
    @NonNull
    private Customer creator;

}
