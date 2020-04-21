package com.topic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topic.entity.Topic;
import com.topic.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping(value="/linkedWith3Topics",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> topicLinkedWithThreeTopics() {
		List<Topic> topics = topicService.getTopicLinkedWithThreeTopics();
		return new ResponseEntity<>(topics,HttpStatus.OK);
	}

	@GetMapping(value="/oneChildOneParent",produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Topic>> topicWithOneChildOneParent() {
		List<Topic> topics = topicService.getTopicWithOneChildOneParent();
		return new ResponseEntity<>(topics,HttpStatus.OK);
	}

	@GetMapping(value="/3rdLevel",produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Topic>> topicPlacedAtThirdLevel() {
		List<Topic> topics = topicService.getTopicPlacedAtThirdLevel();
		return new ResponseEntity<>(topics,HttpStatus.OK);
	}
	
	@GetMapping(value="/dummy",produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> dummyMethod() {
		return new ResponseEntity<>("dummy123",HttpStatus.OK);
	}
	
}
