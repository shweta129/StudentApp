package com.niit.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Forum")
public class Forum {

	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int forumId;
	    
	    private String forumName;
	    
	    private String forumContent;
	    
	    private int userId;
	    
	    private Date createDate;
	    
	    private String Status;
	    
	    //getter setter method

		public int getForumId() {
			return forumId;
		}

		public void setForumId(int forumId) {
			this.forumId = forumId;
		}

		public String getForumName() {
			return forumName;
		}

		public void setForumName(String forumName) {
			this.forumName = forumName;
		}

		public String getForumContent() {
			return forumContent;
		}

		public void setForumContent(String forumContent) {
			this.forumContent = forumContent;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}
	    
	   

		
	    
	    
}
