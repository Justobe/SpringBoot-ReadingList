package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by YanMing on 2017/3/14.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(
            ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader,Model model)
    {
        List<Book> readinglist = readingListRepository.findByReader(reader);
        if(readinglist != null){
            model.addAttribute("books",readinglist);
        }
        return "readinglist";
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader,Book book)
    {
        book.setReader(reader);
        readingListRepository

                .save(book);
        return "redirect:/{reader}";
    }
}
