package com.topic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topic.entity.Topic;
import com.topic.repository.TopicRepository;
import com.topic.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getTopicLinkedWithThreeTopics() {
		return topicRepository.getTopicLinkedWithThreeTopics();
	}

	@Override
	public List<Topic> getTopicWithOneChildOneParent() {
		return topicRepository.getTopicWithOneChildOneParent();
	}

	@Override
	public List<Topic> getTopicPlacedAtThirdLevel() {
		return topicRepository.getTopicPlacedAtThirdLevel();
	}

}
