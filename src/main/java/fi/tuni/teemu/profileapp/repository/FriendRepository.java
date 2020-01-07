package fi.tuni.teemu.profileapp.repository;

import org.springframework.data.repository.CrudRepository;

import fi.tuni.teemu.profileapp.entity.Friend;

public interface FriendRepository extends CrudRepository<Friend, Long> {

}
