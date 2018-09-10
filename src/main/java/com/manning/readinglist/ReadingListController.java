package com.manning.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//pay attention that the english version of "spring boot in action", page 44, the URL should be localhost:8080/"authorname"
@Controller
public class ReadingListController {
    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/search")
    public String searchAuthor(@RequestParam("authorName") String authorName, Model model){

        model.addAttribute("authorName", authorName);
        return "authorInfo";
    }

    @RequestMapping(method= RequestMethod.GET)
    public String readersBooks(Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);

        if(readingList !=null){
            model.addAttribute("books", readingList);
        }

        //resolving the corresponding template
        return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }
}

