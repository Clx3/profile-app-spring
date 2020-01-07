package fi.tuni.teemu.profileapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.tuni.teemu.profileapp.entity.Friend;

public interface FriendRepository extends CrudRepository<Friend, Long> {
	
	public List<Friend> findAllByProfileId(Long profileId);
	
	public Friend findByProfileIdAndFriendId(Long profileId, Long friendId);

}
