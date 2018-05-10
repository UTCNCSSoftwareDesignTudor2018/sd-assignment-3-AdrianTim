package com.Assig3.Assig3.BusinessLogic.Implementations;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.WriterDTO;
import com.Assig3.Assig3.BusinessLogic.IWriterLogic;
import com.Assig3.Assig3.DataAccess.Repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WriterLogic implements IWriterLogic {

    private WriterRepository writerRepository;
    private DTOFactory dtoFactory;

    @Autowired
    public WriterLogic(WriterRepository writerRepository, DTOFactory dtoFactory) {
        this.writerRepository = writerRepository;
        this.dtoFactory = dtoFactory;
    }


    @Override
    public List<WriterDTO> getWriters() {

        List<WriterDTO> writerDTOS = new LinkedList<>();

        writerRepository.findAll().forEach(w -> writerDTOS.add(dtoFactory.createDTO(w)));

        return writerDTOS;
    }

}
