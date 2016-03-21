package com.company.twooter.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Vladimir on 21.03.2016.
 */
@Entity
@Table(name = "followers", schema = "public", catalog = "twooter_db")
public class Follower {
    private FollowerPK followerPK;

    @EmbeddedId
    public FollowerPK getFollowerPK() {
        return followerPK;
    }

    public void setFollowerPK(FollowerPK followerPK) {
        this.followerPK = followerPK;
    }

    @Transient
    public User getUser() {
        return followerPK.getUser();
    }

    public void setUser(User user) {
        followerPK.setUser(user);
    }

    @Transient
    public User getFollower() {
        return followerPK.getFollower();
    }

    public void setFollower(User user) {
        followerPK.setFollower(user);
    }
}
