package com.shrii.journalApp.Repository;

import com.shrii.journalApp.Entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String>{
}
