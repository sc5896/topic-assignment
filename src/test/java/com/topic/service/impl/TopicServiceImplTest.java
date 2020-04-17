package com.topic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.topic.entity.Topic;
import com.topic.repository.TopicRepository;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceImplTest {
	
	@InjectMocks
	private TopicServiceImpl topicService;
	
	@Mock
	private TopicRepository topicRepository;
	
	private static List<Topic> topics;
	
	@BeforeClass
	public static void setUp(){
		topics = new ArrayList<>();
		for(long i=0;i<3;i++){
			Topic topic = new Topic();
			topic.setId(i);
			topic.setName("Topic"+i);
			topics.add(topic);
		}
	}

	@Test
	public void getTopicLinkedWithThreeTopics(){
		Mockito.when(topicRepository.getTopicLinkedWithThreeTopics()).thenReturn(topics);
		List<Topic> resTopics = topicService.getTopicLinkedWithThreeTopics();
		Assert.notEmpty(resTopics,"empty list returned");
	}
	
	@Test
	public void getTopicWithOneChildOneParent(){
		Mockito.when(topicRepository.getTopicWithOneChildOneParent()).thenReturn(topics);
		List<Topic> resTopics = topicService.getTopicWithOneChildOneParent();
		Assert.notEmpty(resTopics,"empty list returned");
	}
	
	@Test
	public void getTopicPlacedAtThirdLevel(){
		Mockito.when(topicRepository.getTopicPlacedAtThirdLevel()).thenReturn(topics);
		List<Topic> resTopics = topicService.getTopicPlacedAtThirdLevel();
		Assert.notEmpty(resTopics,"empty list returned");
		resTopics.size();
	}

}
