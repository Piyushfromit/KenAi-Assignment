package com.masai.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.model.Student;
import com.masai.repository.StudentRepo;

@Controller
public class StudentUIController {

	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/welcome")   
	public String welcome() {
		return "welcome";     
    } 
	
    @GetMapping("/saveStudent")    
	public String saveStudent() {
		return "saveStudent";    

	}

	@PostMapping("/saveStudent")     // save Student
	public String saveStudent(@RequestParam Integer studentRoll, @RequestParam String studentName,
			@RequestParam Integer mathematicsMark, @RequestParam Integer scienceMark, @RequestParam Integer englishMark,
			@RequestParam Integer semester) {
		Student student = new Student(studentRoll, studentName, mathematicsMark, scienceMark, englishMark, semester);
		studentRepo.save(student);
		return "welcome";
    }

	@GetMapping("/getPercentage")
	public String getPercentageView() {
		return "getPercentage";
	}

	@PostMapping("/getPercentage")  // average percentage of class in semester
	public String getPercentageView(Model model, @RequestParam Integer semester) {
		if(semester !=1 || semester!=2) {
			return null;
		}
		int sum = 0;
		int count = 0;
		List<Student> std = studentRepo.findBySemester(semester);
		for (Student stude : std) {
			count++;
			sum = sum + stude.getMathematicsMark() + stude.getEnglishMark() + stude.getScienceMark();
		}
		sum = sum / count;
		sum = sum * 100 / 300;
		model.addAttribute("avg", sum);  // keeping this data in model object
		return "getPercentageResult";  // returning the JSP page name of same name
	}

	@GetMapping("/avgMarks")
	public String avgMarks() {
        
		return "avgMarks";
	}

	@PostMapping("/avgMarks")    // average Marks of student in subject
	public String avgMarks(Model model, @RequestParam String subject) {
		Iterable<Student> itr = studentRepo.findAll();  //findAll will not return List,
		List<Student> students = new ArrayList<>();
		//itr.forEach(students::add);
		for(Student s : itr){
		    students.add(s);
		}
		int count = 0;   // count of student
		int sum = 0;    // sum of all subject marks
		for (Student st : students) {
			System.out.println(st);
			count++;
			if (subject.equalsIgnoreCase("mathematics")) {
				sum += st.getMathematicsMark();
			} else if (subject.equalsIgnoreCase("english")) {
				sum += st.getEnglishMark();
			} else if (subject.equalsIgnoreCase("science")) {
				sum += st.getScienceMark();
			}
		}
		model.addAttribute("avgMarks", sum / count);
		return "avgResult";      // returning JSP    
	}

	@GetMapping("/topTwo")
	public String topView() {
		return "topTwo";
	}

	@PostMapping("/topTwo")   // Top two student of maximum average marks
	public String topView(Model model) {
		Iterable<Student> itr = studentRepo.findAll();
        List<Student> students = new ArrayList<>();
		
		for(Student s : itr){
		    students.add(s);
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (Student st : students) {
			map.put(st.getStudentName(), ( st.getMathematicsMark() + st.getEnglishMark() + st.getScienceMark()) / 3);
		}

		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}

		});
		
		
	    

		List<String> st = new ArrayList<>();
		int count = 1;
		for (Map.Entry<String, Integer> name : list) {
			if (count <= 2) {
				st.add(name.getKey());
				count++;
			}
        }

		model.addAttribute("top2", st);
		return "topTwoResult";       // returning JSP
	}
}
