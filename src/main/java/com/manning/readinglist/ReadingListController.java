package com.manning.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


//pay attention that the english version of "spring boot in action", page 44, the URL should be localhost:8080/"authorname"
@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method= RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader,
                              Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);

        if(readingList !=null){
            model.addAttribute("books", readingList);
        }

        //resolving the corresponding template
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}

