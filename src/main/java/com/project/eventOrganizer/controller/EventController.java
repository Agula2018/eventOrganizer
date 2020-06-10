package com.project.eventOrganizer.controller;

import com.project.eventOrganizer.service.EventService;
import com.project.eventOrganizer.view.EventView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/events/")
public class EventController {

    private final EventService service;

    @GetMapping("/add")
    public String getForm(Model model, EventView eventView) {
        model.addAttribute("event", eventView);
        return "event-add";
    }

    @PostMapping("/add")
    public String add(@Valid EventView eventView) {
        service.add(eventView);
        return "redirect:/events/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("events", service.findAll());
        return "event-list";
    }
}
