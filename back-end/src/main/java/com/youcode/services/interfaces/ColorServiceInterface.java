package com.youcode.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.youcode.models.Color;

public interface ColorServiceInterface {

	public void add(Color color);
	public Optional<Color> get(int id);
	public List<Color> getAll();
	public void delete(int id);
	
}
