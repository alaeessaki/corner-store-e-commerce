package com.youcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.dao.ImageDaoInterface;
import com.youcode.models.Image;
import com.youcode.services.interfaces.ImageServiceInterface;

@Service
public class ImageService implements ImageServiceInterface{

	@Autowired
	ImageDaoInterface image_dao;
	
	public void add(Image image) {
		image_dao.save(image);
	}
	
	public Optional<Image> getImage(int id) {
		return image_dao.findById(id);
	}
	
	public List<Image> getAll(){
		return image_dao.findAll();
	}
	
	public void delete(int id){
		image_dao.deleteById(id);
	}
}
