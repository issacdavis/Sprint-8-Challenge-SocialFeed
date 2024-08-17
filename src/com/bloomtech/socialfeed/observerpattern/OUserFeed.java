package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.App;
import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;

import java.util.ArrayList;
import java.util.List;

//TODO: Implement Observer Pattern
public class OUserFeed implements Observer {
    private User user;
    private List<Post> feed;

    public OUserFeed(User user) {
        this.user = user;
        App.sourceFeed.attach(this);
        //TODO: update OUserFeed in constructor after implementing observer pattern
    }

    @Override
    public void update() {
        feed = new ArrayList<>();
        for (Post post :App.sourceFeed.getPosts()) {
            for (String username : user.getFollowing()) {
                if (post.getUsername().equals(username)) {
                    feed.add(post);
                }
            }
        }
    }

    public User getUser() {
        return user;
    }

    public List<Post> getFeed() {
        return feed;
    }
}


