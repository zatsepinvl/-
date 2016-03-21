package com.company.twooter.model.repository;

import com.company.twooter.model.entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vladimir on 21.03.2016.
 */
public interface MessageRepository extends CrudRepository<Message,Long> {
}
