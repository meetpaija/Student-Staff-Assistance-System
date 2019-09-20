package com.assistance.studentstaff.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.DiscussionChatModel;

@Repository
public interface IDiscussionChatRepo extends JpaRepository<DiscussionChatModel, String>{

	@Query("select chat from DiscussionChatModel chat where chat.discThreadId = :discThreadId order by chat.timestamp desc")
	List<DiscussionChatModel> fetchDiscChatsInDescOrder(String discThreadId);

}
