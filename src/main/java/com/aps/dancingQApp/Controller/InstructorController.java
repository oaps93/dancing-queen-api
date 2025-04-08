package com.aps.dancingQApp.Controller;

import com.aps.dancingQApp.Exceptions.InstructorException;
import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Model.InstructorDTO;
import com.aps.dancingQApp.Service.InstructorService;
import com.aps.dancingQApp.Util.DQConstants;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @PostMapping(path = DQConstants.INSTRUCTORS_PATH)
    public ResponseEntity<InstructorDTO> createInstructor(@RequestBody InstructorDTO input) throws InstructorException {
        InstructorDTO savedInstructor = instructorService.newInstructor(input);
        return new ResponseEntity<>(savedInstructor, HttpStatusCode.valueOf(201));
    }

    @GetMapping(path = DQConstants.INSTRUCTORS_PATH)
    public ResponseEntity<List<InstructorDTO>> getAllInstructors() {
        return new ResponseEntity<>(instructorService.getAllInstructors(),HttpStatusCode.valueOf(200));
    }

    @PostMapping(path = DQConstants.INSTRUCTORS_PATH + "/{instructorName}/classes" )
    public ResponseEntity<Instructor> addClass(@PathVariable String instructorName, @RequestParam String className) throws InstantiationException {
        return  new ResponseEntity<>(
                instructorService.addClassToInstructor(instructorName,className),
                HttpStatusCode.valueOf(200));
    }

}