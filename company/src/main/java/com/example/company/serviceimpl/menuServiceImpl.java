package com.example.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.entity.menu;
import com.example.company.repository.menuRepository;
import com.example.company.service.menuService;

@Service
public class menuServiceImpl implements menuService{

	@Autowired
    private menuRepository repository;

    @Override
    public List<menu> getAllMenus() {
        return repository.findAll();
    }

    @Override
    public menu getMenuById(Long menuId) {
        Optional<menu> menu = repository.findById(menuId);
        return menu.orElse(null);
    }

    @Override
    public menu saveMenu(menu menu) {
        return repository.save(menu);
    }

    @Override
    public void deleteMenu(Long menuId) {
    	repository.deleteById(menuId);
    }
	
}
