package com.aps.dancingQApp.Controller;

import com.aps.dancingQApp.Exceptions.InstructorException;
import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Service.InstructorService;
import com.aps.dancingQApp.Util.DQConstants;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @PostMapping(path = DQConstants.INSTRUCTORS_PATH)
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor input) throws InstructorException {
        Instructor savedInstructor = instructorService.newInstructor(input);
        return new ResponseEntity<>(savedInstructor, HttpStatusCode.valueOf(201));
    }
}