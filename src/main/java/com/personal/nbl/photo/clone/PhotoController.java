package com.personal.nbl.photo.clone;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotoController {
    
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    // private List<Photo> db = List.of();

    //run the page
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    //list of photo
    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return db.values();
    }

    //photo by id
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    //Delete photo
    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
