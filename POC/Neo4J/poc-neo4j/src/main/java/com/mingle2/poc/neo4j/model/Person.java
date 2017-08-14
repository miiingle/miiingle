package com.mingle2.poc.neo4j.model;

import lombok.*;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"addresses", "friends"})
@ToString(exclude = {"addresses", "friends"})
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Person {

    @GraphId
    Long id;

    @Relationship(type = "LIVES_IN", direction = Relationship.INCOMING)
    Set<Address> addresses;

    @Relationship(type = "FRIEND_OF", direction = Relationship.INCOMING)
    Set<Person> friends;

    String name;
    Integer age;

    public void addFriend(Person friend) {
        if (friends == null) friends = new HashSet<>();
        friends.add(friend);
    }
}
