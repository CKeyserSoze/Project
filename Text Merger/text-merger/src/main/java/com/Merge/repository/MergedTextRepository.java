package com.cobanoglu.repository;

import com.cobanoglu.model.MergedText;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MergedTextRepository extends MongoRepository<MergedText, Long> {
}
