package com.cobanoglu.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "merged_texts")
@Data
public class MergedText {

    @Transient
    public static final String SEQUENCE_NAME = "merged_texts_sequence";

    @Id
    private int id;
    private String text;
    private long time;

}
