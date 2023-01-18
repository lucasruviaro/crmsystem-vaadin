package com.example.application.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;

@Service
public class Crmservice {

    private CompanyRepository companyRepository;
    private StatusRepository statusRepository;
    private ContactRepository contactRepository;
    

    public Crmservice(ContactRepository contactRepository, CompanyRepository companyRepository, StatusRepository statusRepository) {

        this.contactRepository = contactRepository;
        this.statusRepository = statusRepository;
        this.companyRepository = companyRepository;

    }

    public List<Contact> findAllContacts(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(filterText);        
        }
    }

    public long countContacts(){
        return contactRepository.count();
    }

    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact){
        if(contact == null){
            System.err.println("Contact is null.");
            return;
        } 

        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies(){
        return companyRepository.findAll();

    }

    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
