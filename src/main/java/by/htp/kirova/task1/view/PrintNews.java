package by.htp.kirova.task1.view;

import by.htp.kirova.task1.entity.News;

import java.util.List;

public class PrintNews {
	
	public static void print(List<News> news) {
		if (news == null || news.size() == 0) {
			System.out.println("No news was found for the selected criteria");
		} else {
			System.out.println(news.toString());
		}
		
	}
}
