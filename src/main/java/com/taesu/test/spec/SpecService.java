package com.taesu.test.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taesu.test.spec.dto.SpecForSelect;

@Service
public class SpecService {
	
	private void fillSpecChildrenList(List<SpecForSelect> children, int size){
		for( int i=0 ; i<size ; i++ ){
			SpecForSelect temp = new SpecForSelect();
			temp.setName("temp"+i);
			temp.setOpen(false);
			children.add(temp);
		}
	}
	
	public List<SpecForSelect> readAllSpecList(){
		List<SpecForSelect> result 	  = new ArrayList<SpecForSelect>();		
		List<SpecForSelect> children1 = new ArrayList<SpecForSelect>();
		List<SpecForSelect> children2 = new ArrayList<SpecForSelect>();
		List<SpecForSelect> children3 = new ArrayList<SpecForSelect>();
		
		fillSpecChildrenList(children1, 5);
		fillSpecChildrenList(children2, 3);
		fillSpecChildrenList(children3, 2);
		
		SpecForSelect parent1 = new SpecForSelect();
		parent1.setName("parent1");
		parent1.setOpen(true);
		parent1.setChildren(children1);
		
		SpecForSelect parent2 = new SpecForSelect();
		parent2.setName("parent2");
		parent2.setOpen(false);
		parent2.setChildren(children2);
		
		SpecForSelect parent3 = new SpecForSelect();
		parent3.setName("parent3");
		parent3.setOpen(false);
		parent3.setChildren(children3);
		
		result.add(parent1);
		result.add(parent2);
		result.add(parent3);
		
		return result;
	}
}
