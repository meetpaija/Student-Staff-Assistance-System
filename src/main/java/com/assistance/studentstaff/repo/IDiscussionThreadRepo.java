package com.assistance.studentstaff.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.DiscussionThreadModel;

@Repository
public interface IDiscussionThreadRepo extends JpaRepository<DiscussionThreadModel, String>{

}
