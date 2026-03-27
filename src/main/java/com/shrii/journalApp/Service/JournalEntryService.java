package com.shrii.journalApp.Service;

import com.shrii.journalApp.Entity.JournalEntry;
import com.shrii.journalApp.Repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryService {
    @Autowired
    JournalEntryRepo repo;
    public void saveEntry(JournalEntry entry) {
        repo.save(entry);
    }

    public List<JournalEntry> getAllEntries(){
       return repo.findAll();
    }

    public JournalEntry getEntryById(String id){
        return repo.findById(id).orElse(null);
    }

    public boolean deleteEntryById(String id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public JournalEntry updateEntry(String id, JournalEntry newEntry){
        JournalEntry old = repo.findById(id).orElse(null);

        if(old!= null){
           old.setContent(newEntry.getContent());
           old.setTitle(newEntry.getTitle());
           return repo.save(old);
        }
      return null;
    }
}
