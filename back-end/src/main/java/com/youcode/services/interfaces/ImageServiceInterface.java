package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Image;

public interface ImageServiceInterface {

	public void add(Image image);
	public Optional<Image> getImage(int id);
	public List<Image> getAll();
	public void delete(int id);
	
}
