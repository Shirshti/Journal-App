package com.shrii.journalApp.Controller;

import com.shrii.journalApp.Entity.JournalEntry;
import com.shrii.journalApp.Service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Journal")
public class JournalEntryController {


    //private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @Autowired
    JournalEntryService entryService;



    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        entryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping
    public List<JournalEntry> getAll(){
        return entryService.getAllEntries();
    }



    @GetMapping("id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable String id){
        return entryService.getEntryById(id);
    }

    @DeleteMapping("id/{id}")
    public boolean deleteJournalEntryById(@PathVariable String id){
        return entryService.deleteEntryById(id);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable String id, @RequestBody JournalEntry myEntry){
        return entryService.updateEntry(id, myEntry);
    }
}


