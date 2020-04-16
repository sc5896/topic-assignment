package com.topic.service;

import java.util.List;

import com.topic.entity.Topic;

public interface TopicService {
	/**
	 * This method returns all Topic which are linked with at least three Topics
	 * @return List<Topic>
	 */
	List<Topic> getTopicLinkedWithThreeTopics();
	
	/**
	 * This method returns all Topic which are having one child and one parent
	 * @return List<Topic>
	 */
	List<Topic> getTopicWithOneChildOneParent();
	
	/**
	 * This method returns all Topic which are placed at 3rd level in the hierarchy
	 * @return List<Topic>
	 */
	List<Topic> getTopicPlacedAtThirdLevel();
}
