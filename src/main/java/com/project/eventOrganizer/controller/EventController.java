package com.project.eventOrganizer.controller;

import com.project.eventOrganizer.service.EventService;
import com.project.eventOrganizer.view.EventView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Event Controller, responsible for Event endpoints,
 * based on HTTP protocol.
 */
@Controller
@AllArgsConstructor
@RequestMapping(path = "/event/")
public class EventController {

    private final EventService service;

    /**
     * Endpoint with Thymeleaf form,
     * filled passed to @Post.
     *
     * @param model Model
     * @param eventView EventView
     * @return event-add template
     */
    @GetMapping("/add")
    public String getForm(Model model, EventView eventView) {
        model.addAttribute("event", eventView);
        return "event-add";
    }

    /**
     * Endpoint posts Event into repository.
     *
     * @param eventView EventView
     * @return redirects to event-list template
     */
    @PostMapping("/add")
    public String add(EventView eventView) {
        service.add(eventView);
        return "redirect:/event/list";
    }

    /**
     * Endpoint with Thymeleaf template - listing
     *
     * @param model Model
     * @return event-list template
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("events", service.findAll());
        return "event-list";
    }
}
