package fi.tuni.teemu.profileapp.repository;

import org.springframework.data.repository.CrudRepository;

import fi.tuni.teemu.profileapp.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
