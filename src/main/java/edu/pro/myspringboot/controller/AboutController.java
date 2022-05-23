package edu.pro.myspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AboutController {

    @GetMapping("/about")
    String sayAbout(){
        String out = "<header><center><h1>About java</h2></center></header>";
        out += "<div style='font-size:20px'>Now year is " + "<b>" +LocalDateTime.now().getYear() + "</b>" +
                " Mount is " + "<b>" + LocalDateTime.now().getMonth()+ "</b>" + " Day is " + "<b>" +
                LocalDateTime.now().getDayOfMonth() + "</b>";
        out += "<br><a href = 'https://en.wikipedia.org/wiki/Java_(programming_language)'target=\"_blank\">" +
                "What means java?</a>";
        out += "<br><a href = 'https://en.wikipedia.org/wiki/Spring_Framework'target=\"_blank\">" +
                "What means Spring Boot?</a></div>";
        String main = "<main><center><h1>About me</h2></center>";
        main += "<div style='font-size:20px'>My name <em>Roma</em>, i from Chernivtsi. i`m 20. " +
                "I finished college in <b>2021</b> " + "and have diploma " + "junior specialist." +
                " So at now i studying at " + "university CHNU <b>3 course</b> " + "(abbreviated form of education)"
                + " on specialty <b>126</b>. " + "I like university, because give me " + "new life " +
                "for programming. " + "My hobby is listening to music, programming, discovery new things.</div></main>";
        main += "<center><h1>Motivation video</h1><iframe width=\"700\" height=\"400\" " +
                "src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" " +"title=\"YouTube video player\" " +
                "frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; " +
                "encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></center>";
        out += main;
        String footer = "<footer><center><h1>Never give up :)</h1></center></footer>";
        out += footer;
        return out;
    }



}
