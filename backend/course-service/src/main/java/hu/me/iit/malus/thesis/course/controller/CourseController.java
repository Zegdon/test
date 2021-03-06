package hu.me.iit.malus.thesis.course.controller;


import hu.me.iit.malus.thesis.course.controller.converters.DtoConverter;
import hu.me.iit.malus.thesis.course.controller.dto.CourseModificationDto;
import hu.me.iit.malus.thesis.course.controller.dto.CourseOverviewDto;
import hu.me.iit.malus.thesis.course.model.Course;
import hu.me.iit.malus.thesis.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

/**
 * Controller endpoint of this service
 * @author Javorek Dénes
 * @author Attila Szőke
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_Teacher')")
    public Course createCourse(@RequestBody CourseModificationDto courseModificationDto, Principal principal) {
        return service.create(DtoConverter.CourseDtoToCourse(courseModificationDto), principal.getName());
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ROLE_Teacher')")
    public Course editCourse(@RequestBody CourseModificationDto courseModificationDto, Principal principal) {
        return service.edit(DtoConverter.CourseDtoToCourse(courseModificationDto), principal.getName());
    }

    @GetMapping("/get/{courseId}")
    public Course get(@PathVariable Long courseId, Principal principal) {
        return service.get(courseId, principal.getName());
    }

    @GetMapping("/getAll")
    public Set<CourseOverviewDto> getAll(Principal principal) {
        return DtoConverter.CourseToCourseOverviewSet(service.getAll(principal.getName()));
    }

}
