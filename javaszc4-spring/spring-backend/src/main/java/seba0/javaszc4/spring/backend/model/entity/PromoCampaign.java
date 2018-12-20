package seba0.javaszc4.spring.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Document("PromoCampaigns")
public class PromoCampaign {

    @Id
    private ObjectId id;

    @Indexed
    @NonNull
    private String name;

    private String description;

    @NonNull
    @DBRef
    private Brand brand;

    @NonNull
    private LocalDate begin;

    @NonNull
    private LocalDate end;

    @NonNull
    @DBRef
    private Customer creator;
}
