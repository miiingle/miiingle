package com.mingle2.poc.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Person {

    @GraphId
    Long id;

    @Relationship(type = "LIVES_IN", direction = Relationship.INCOMING)
    Set<Address> addresses;

    @Relationship(type = "FRIEND_OF", direction = Relationship.UNDIRECTED)
    Set<Person> friends;

    String name;
    Integer age;
}
