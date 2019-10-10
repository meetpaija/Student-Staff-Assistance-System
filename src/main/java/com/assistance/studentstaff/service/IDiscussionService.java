package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DiscussionChatModel;
import com.assistance.studentstaff.model.DiscussionThreadModel;

public interface IDiscussionService {

	DiscussionThreadModel createDiscThread(String userId, DiscussionThreadModel discThreadModel)
			throws CustomGenericException;

	DiscussionChatModel insertDiscChat(String userId, String discThreadId, DiscussionChatModel discChatModel)
			throws CustomGenericException;

	List<DiscussionThreadModel> fetchDiscThreads() throws CustomGenericException;

	List<DiscussionChatModel> fetchDiscChats(String discThreadId) throws CustomGenericException;

	DiscussionThreadModel updateDiscThread(String userId, String discThreadId, DiscussionThreadModel discThreadModel)
			throws CustomGenericException;

	DiscussionChatModel updateDiscChat(String userId, String discThreadId, String discChatId,
			DiscussionChatModel discChatModel) throws CustomGenericException;

	void deleteDiscThread(String discThreadId) throws CustomGenericException;

	void deleteDiscChat(String discChatId) throws CustomGenericException;

}
