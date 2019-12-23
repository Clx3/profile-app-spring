package fi.tuni.teemu.profileapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "relation_id", columnDefinition = "serial")
	public Long relationId;
	
	@Column(name = "profile_id")
	public Long profileId;
	
	@Column(name = "friend_id")
	public Long friendId;
	
	public Friend() {}

	public Long getRelationId() {
		return relationId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
}
