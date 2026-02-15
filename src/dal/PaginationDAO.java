package dal;

import java.util.ArrayList;
import java.util.List;

import dto.Pages;

public class PaginationDAO {

	
	static List<Pages> paginate(String fileContent){
		int pageSize = 100;
		
		int pageNumber = 1;
		String pageContent = "";
		List<Pages> pages = new ArrayList<Pages>();
		if(fileContent==null || fileContent.isEmpty())
		{
			pages.add(new Pages(0, 0, pageNumber, pageContent.toString()));
			return pages;
		}
        String[] words = fileContent.split("\\s+");
		StringBuilder pageContent = new StringBuilder();
		int wordCount = 0;

		for(int i = 0; i < words.length; i++)
		{
			pageContent.append(words[i]).append(" ");
    		wordCount++;

    	if (wordCount == pageSize || i == words.length - 1) {
        pages.add(new Pages(0, 0, pageNumber, pageContent.toString().trim()));
        pageNumber++;
        pageContent = new StringBuilder();
        wordCount = 0;
   		 }
		}
		return pages;
	} 
}
