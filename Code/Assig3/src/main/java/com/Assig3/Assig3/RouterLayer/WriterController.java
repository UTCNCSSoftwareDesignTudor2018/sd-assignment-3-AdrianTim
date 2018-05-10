package com.Assig3.Assig3.RouterLayer;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.WriterDTO;
import com.Assig3.Assig3.BusinessLogic.IWriterLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/writer")
public class WriterController {

    private IWriterLogic writerLogic;

    @Autowired
    public WriterController(IWriterLogic writerLogic) {
        this.writerLogic = writerLogic;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody List<WriterDTO> getAll(){

        return writerLogic.getWriters();

    }

}
