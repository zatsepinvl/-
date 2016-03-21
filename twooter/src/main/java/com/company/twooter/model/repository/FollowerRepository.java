package com.company.twooter.model.repository;

import com.company.twooter.model.entity.Follower;
import com.company.twooter.model.entity.FollowerPK;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vladimir on 21.03.2016.
 */
public interface FollowerRepository extends CrudRepository<Follower,FollowerPK> {

}
