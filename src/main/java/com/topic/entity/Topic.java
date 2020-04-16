package com.topic.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="parentTopic")
    private List<Topic> subtopics;
	
	@JsonIgnore
	@ManyToOne
    private Topic parentTopic;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="topic_linked",
	 joinColumns=@JoinColumn(name="id"),
	 inverseJoinColumns=@JoinColumn(name="linkedId")
	)
	private List<Topic> linkedFromTopics;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="topic_linked",
	 joinColumns=@JoinColumn(name="linkedId"),
	 inverseJoinColumns=@JoinColumn(name="id")
	)
	private List<Topic> linkedToTopics;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getLinkedToTopics() {
		return linkedToTopics;
	}

	public void setLinkedToTopics(List<Topic> linkedToTopics) {
		this.linkedToTopics = linkedToTopics;
	}

	public List<Topic> getSubtopics() {
		return subtopics;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSubtopics(List<Topic> subtopics) {
		this.subtopics = subtopics;
	}

	public Topic getParentTopic() {
		return parentTopic;
	}

	public void setParentTopic(Topic parentTopic) {
		this.parentTopic = parentTopic;
	}

	public List<Topic> getLinkedFromTopics() {
		return linkedFromTopics;
	}

	public void setLinkedFromTopics(List<Topic> linkedFromTopics) {
		this.linkedFromTopics = linkedFromTopics;
	}

}
