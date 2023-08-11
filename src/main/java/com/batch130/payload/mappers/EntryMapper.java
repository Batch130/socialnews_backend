package com.batch130.payload.mappers;


import com.batch130.entity.concretes.Entry;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.request.EntryRequestForSoftDelete;
import com.batch130.payload.response.EntryResponse;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryMapper {

    @Autowired
    private  ModelMapper modelMapper;

    public EntryResponse convertEntryToResponse(Entry entry){

        return modelMapper.map(entry, EntryResponse.class);
    }


    public Entry convertRequestToEntry(EntryRequest entryRequest){
        Entry entry = modelMapper.map(entryRequest, Entry.class);
        entry.setActive(true);
        entry.setDeleted(false);
        return entry;
    }

    public Entry convertRequestToEntryUpdate(EntryRequest entryRequest, Long entryId){
        Entry entry = modelMapper.map(entryRequest, Entry.class);
        entry.setId(entryId);
        return entry;
    }

    public Entry convertRequestToEntryForSoftDelete(EntryRequestForSoftDelete entryRequest, Long entryId){
        Entry entry = modelMapper.map(entryRequest, Entry.class);
        entry.setId(entryId);
        entry.setActive(false);
        entry.setDeleted(true);
        return entry;
    }

}
