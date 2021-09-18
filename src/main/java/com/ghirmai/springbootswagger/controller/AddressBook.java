package com.ghirmai.springbootswagger.controller;

import com.ghirmai.springbootswagger.model.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@RestController
@RequestMapping("/contacts")
public class AddressBook {
    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value ="Finds contacts by id",
    notes = "provide an id to look up specific contact from the address book",
    response = Contact.class)
    public Contact getContact(@ApiParam(value = "string ID needed for the contact you need to retrieve",required = true) @PathVariable("id") String id) {
        return contacts.get(id);
    }

    @GetMapping
    public List<Contact> getAllContact() {
        return new ArrayList<>(contacts.values());
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
