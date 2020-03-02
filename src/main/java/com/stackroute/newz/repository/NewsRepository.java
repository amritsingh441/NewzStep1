package com.stackroute.newz.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.News;


/*
 * Annotate the class with @Repository annotation. 
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
@Repository
public class NewsRepository {
	
	/* Declare a variable called "newsList" to store all the news. */
    private List<News> newsList;

    public NewsRepository() {
    	/* Initialize the variable using proper data type */
    	newsList = new ArrayList<>();
    	
    }

    /* This method should return all the news in the list */
    public List<News> getNewsList() {
        return newsList;
    }

    /* This method should set the list variable with new list of news */
    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    /*
	 * This method should News object as argument and add the new news object into
	 * list
	 */
    public void addNews(News news) {
    	news.setPublishedAt(LocalDateTime.now());
    	newsList.add(news); 
    	
    }
    
    
    /* This method should return the list of news */
    public List<News> getAllNews() {
    	Collections.sort(newsList,new Comparator<News>() {
			@Override
			public int compare(News news1, News news2) {
				return news2.getPublishedAt().compareTo(news1.getPublishedAt());
			}
    		
		});
        return newsList;
    }
    
    /* This method should delete a specified news from the list */
    public boolean deleteNews(int newsId) {
       
    	Iterator<News> itr=this.newsList.listIterator();
    	boolean deleted=false;
    	
    	while(itr.hasNext())
    	{
    		if(newsId==itr.next().getNewsId())
    		{
    			itr.remove();
    			deleted=true;
    		}
    	}
        return deleted;
       

    }
  
}
