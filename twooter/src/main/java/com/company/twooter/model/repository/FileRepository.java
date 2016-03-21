package com.company.twooter.model.repository;

import com.company.twooter.model.entity.File;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Vladimir on 20.03.2016.
 */
public interface FileRepository extends CrudRepository<File, Long> {
}
