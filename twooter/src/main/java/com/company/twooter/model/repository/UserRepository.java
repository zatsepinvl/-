package com.company.twooter.model.repository;

import com.company.twooter.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Vladimir on 28.02.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select followerPK.follower from Follower follower where follower.followerPK.user.userId=(:userId)")
    Iterable<User> getFollowersByUserId(@Param("userId") long userId);

    @Query("select followerPK.user from Follower follower where follower.followerPK.follower.userId=(:userId)")
    Iterable<User> getFollowingByUserId(@Param("userId") long userId);

    @Query(value = "select user from User user where user.email=(:email)")
    User getUserByEmail(@Param("email") String email);

    @Query(value = "select user from User user where user.email=(:username)")
    User getUserByUsername(@Param("username") String username);


}
