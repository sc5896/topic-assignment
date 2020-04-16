package com.topic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.topic.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	@Query(value = "select t from Topic t inner join t.linkedToTopics lt group by t having count(lt)>2")
	List<Topic> getTopicLinkedWithThreeTopics();

	@Query("SELECT t FROM Topic t where t.parentTopic is not null "
			+ "and t.id in (select st.parentTopic.id from Topic st group by st.parentTopic.id having count(st.parentTopic.id)=1)")
	List<Topic> getTopicWithOneChildOneParent();
	
	@Query("SELECT t FROM Topic t where"
			+ " t.parentTopic.parentTopic is not null")
	List<Topic> getTopicPlacedAtThirdLevel();
}
