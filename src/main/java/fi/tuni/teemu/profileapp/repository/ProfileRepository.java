package fi.tuni.teemu.profileapp.repository;

import org.springframework.data.repository.CrudRepository;

import fi.tuni.teemu.profileapp.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
