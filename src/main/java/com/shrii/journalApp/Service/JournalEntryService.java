package com.shrii.journalApp.Service;

import com.shrii.journalApp.DTO.JournalEntryRequestDTO;
import com.shrii.journalApp.DTO.JournalEntryResponseDTO;
import com.shrii.journalApp.Entity.JournalEntry;
import com.shrii.journalApp.Exception.JournalNotFoundException;
import com.shrii.journalApp.Repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class JournalEntryService {
    @Autowired
    JournalEntryRepo repo;

    public JournalEntry saveEntry(JournalEntryRequestDTO entry) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        System.out.println(username);

        JournalEntry newentry = new JournalEntry();
        newentry.setTitle(entry.getTitle());
        newentry.setContent(entry.getContent());
        newentry.setUsername(username);
        newentry.setCreatedAt(LocalDateTime.now());
        return repo.save(newentry);
    }

    public List<JournalEntry> getAllEntries(){
       return repo.findAll();
    }

    public JournalEntryResponseDTO getEntryById(String id){
        JournalEntry entry = repo.findById(id).orElseThrow(()->new JournalNotFoundException("Journal Entry Not Found"));
        JournalEntryResponseDTO dto = new JournalEntryResponseDTO();
        dto.setId(entry.getId());
        dto.setContent(entry.getContent());
        dto.setTitle(entry.getTitle());
        dto.setCreatedAt(entry.getCreatedAt());
        return dto;
    }

    public boolean deleteEntryById(String id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public JournalEntry updateEntry(String id, JournalEntry newEntry){
        JournalEntry old = repo.findById(id).orElseThrow(()-> new JournalNotFoundException("Journal Entry Not Found With This Id"));


           old.setContent(newEntry.getContent());
           old.setTitle(newEntry.getTitle());
           return repo.save(old);
    }
}
