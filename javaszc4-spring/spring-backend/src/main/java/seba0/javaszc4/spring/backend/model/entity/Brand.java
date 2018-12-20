package seba0.javaszc4.spring.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("Brands")
public class Brand {

    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String name;
}
