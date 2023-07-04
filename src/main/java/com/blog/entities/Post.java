package com.blog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int postId;
@Column(length=100,nullable=false)
private String title;
@Column(length=1000)
private String content;
private String imageName;
private Date addedDate;
@ManyToOne
@JoinColumn(name="category_id")
private Category category;
@ManyToOne
private User user;


}
