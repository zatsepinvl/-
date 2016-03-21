package com.company.twooter.model.service;

import com.company.twooter.model.entity.User;

import java.util.List;

/**
 * Created by Vladimir on 20.03.2016.
 */
public interface UserService extends BaseService<User> {
    User getUserByEmail(String email);

    User getUserByUsername(String username);

    List<User> getFollowersByUserId(long userId);

    List<User> getFollowingByUserId(long userId);

    void addFollower(long userId, long followerId);

    void deleteFollowerById(long userId, long followerId);

    void following(long userId, long followingId);

    void unFollowing(long userId, long followingId);
}
