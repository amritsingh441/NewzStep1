package com.stackroute.newz.controller;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;

/* 
 * Annotate the class with @Controller annotation. @Controller annotation is used to mark 
 * any java class as a controller so that Spring can recognize this class as a Controller 
 */
@Controller
public class NewsController {

	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 * 
	 * 1. display the list of existing news from the collection. Each news object 
	 *    should contain News Id, title, author, description, content and created date.
	 * 2. Add a new news which should contain the News Id, title, author, description, content.
	 * 3. Delete an existing news.
	 */

	/* 
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the News object from the context.
	 * Retrieve the NewsRepository object from the context.
	 */
	ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
	News newsObj = appCtx.getBean("news",News.class);
	NewsRepository newsRepo = appCtx.getBean("newsRepository",NewsRepository.class);
	
	/*Define a handler method to read the existing news by calling the getNewsList() method 
	 * of the NewsRepository class and add it to the ModelMap which is an implementation of Map 
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */
	@GetMapping("/")
	public String getAllNews(ModelMap model) {
		model.addAttribute("newsList", newsRepo.getAllNews());
		return "index";
	}

	/*Define a handler method which will read the News data from request parameters and
	 * save the news by calling the addNews() method of NewsRepository class. Please note 
	 * that the createdAt field should always be auto populated with system time and should not be accepted 
	 * from the user. Also, after saving the news, it should show the same along with existing 
	 * news elements. Hence, reading news has to be done here again.
	 * This handler method should map to the URL "/saveNews". 
	 */
	@PostMapping("/saveNews")
	public String addNews(@ModelAttribute("news") News news, ModelMap mp) {
			newsRepo.addNews(news);
		List<News> newsList= newsRepo.getAllNews();
		mp.addAttribute("newsList", newsList);
		return "redirect:"+"/";	
	}

	/* Define a handler method to delete an existing news by calling the deleteNews() method 
	 * of the NewsRepository class
	 * This handler method should map to the URL "/deleteNews" 
	 */
	@GetMapping("/deleteNews")
	public String deleteNews(int newsId, ModelMap mp) {
		newsRepo.deleteNews(newsId);
		mp.addAttribute("newsList", newsRepo.getAllNews());
		return "redirect:"+"/";
	}

}
