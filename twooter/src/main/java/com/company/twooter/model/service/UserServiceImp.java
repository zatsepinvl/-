package com.company.twooter.model.service;

import com.company.twooter.model.entity.Follower;
import com.company.twooter.model.entity.FollowerPK;
import com.company.twooter.model.entity.User;
import com.company.twooter.model.repository.FileRepository;
import com.company.twooter.model.repository.FollowerRepository;
import com.company.twooter.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Vladimir on 20.03.2016.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getFollowersByUserId(long userId) {
        return (List<User>) userRepository.getFollowersByUserId(userId);
    }

    @Override
    public List<User> getFollowingByUserId(long userId) {
        return (List<User>) userRepository.getFollowingByUserId(userId);
    }

    @Override
    public void addFollower(long userId, long followerId) {
        User user = userRepository.findOne(userId);
        User follower = userRepository.findOne(followerId);
        Assert.notNull(user);
        Assert.notNull(follower);
        FollowerPK followerPK = new FollowerPK();
        followerPK.setUser(user);
        followerPK.setFollower(follower);
        Follower f = new Follower();
        f.setFollowerPK(followerPK);
        followerRepository.save(f);
    }

    @Override
    public void deleteFollowerById(long userId, long followerId) {

    }

    @Override
    public void following(long userId, long followingId) {

    }

    @Override
    public void unFollowing(long userId, long followingId) {

    }

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User entity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        if (entity.getImage() != null) {
            fileRepository.save(entity.getImage());
        }
        userRepository.save(entity);
    }

    @Secured("ROLE_GOD")
    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Secured("ROLE_ADMIN")
    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}
