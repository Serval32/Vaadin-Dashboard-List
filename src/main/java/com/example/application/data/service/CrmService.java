/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CrmService {
    
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;
    
    public CrmService(
            ContactRepository contactRepository,
            CompanyRepository companyRepository,
            StatusRepository statusRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }
    
    public List<Contact> findAllContacts(String filterText){
        if(filterText==null || filterText.isEmpty()){
            return  contactRepository.findAll();
        }
        else{
            return contactRepository.search(filterText);
        }
    }
    
    public long countContact(){
        return contactRepository.count();
    }
    
    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }
    
    public void saveContact(Contact contact){
        if(contact==null){
            System.out.println("Contact is empty");
            return;
        }
        contactRepository.save(contact);
    }
    
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }
    
    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }
}
