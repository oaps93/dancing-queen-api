package com.aps.dancingQApp.Controller;

import com.aps.dancingQApp.Exceptions.DClassException;
import com.aps.dancingQApp.Model.DClassDTO;
import com.aps.dancingQApp.Service.DClassService;
import com.aps.dancingQApp.Util.DQConstants;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DClassController {
    private final DClassService dClassService;
    public DClassController(DClassService dClassService) {
        this.dClassService = dClassService;
    }

    @PostMapping(path = DQConstants.DCLASS_PATH)
    public ResponseEntity<DClassDTO> createNewDanceClass(@RequestBody DClassDTO input) throws DClassException {
        DClassDTO savedClass = dClassService.newDClass(input);
        return new ResponseEntity<>(savedClass, HttpStatusCode.valueOf(201));
    }
    @GetMapping(path = DQConstants.DCLASS_PATH)
    public ResponseEntity<List<DClassDTO>> getAllDClasses() {
        return new ResponseEntity<>(dClassService.getAllClasses(),HttpStatusCode.valueOf(200));
    }
}