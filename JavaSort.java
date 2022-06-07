package question3;
import java.util.*;

class Student{
    private int Id;
    private String sname;
    private double Cgpa;
    
    public Student( String sname, double Cgpa, int Id) {
        this.Id = Id;
        this.sname = sname;
        this.Cgpa = Cgpa;
    }
    
	public int getId() {
		return Id;
	}

	public String getSname() {
		return sname;
	}

	public double getCgpa() {
		return Cgpa;
	}
}

public class JavaSort
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int testCases = Integer.parseInt(in.nextLine());
        List<Student> studentList = new ArrayList<Student>();
        System.out.println("Enter the detail of students in the given format [ENTER-STUDENT NAME-STUDENT CGPA-TOKEN ID]");
        while(testCases>0){
        	try {
		        String str = in.nextLine();
		        String[] tokens = str.split("-");    
		        String sname=tokens[1];
		        String cgpa=tokens[2];
		        double Cgpa = Double.parseDouble(cgpa);
		        String id=tokens[3];
		        int Id = Integer.parseInt(id);
		        Student st = new Student(sname, Cgpa, Id);
	            studentList.add(st);
        } catch (Exception e) {
			System.out.println("Given Input is not valid");
		}
        	testCases--;
        }

            studentList.sort(new Comparator<Student>(){
                @Override
                public int compare(Student s1,Student s2){
                    if(s1.getCgpa()==s2.getCgpa()){
                        return s1.getSname().compareTo(s2.getSname());
                    } else if(s1.getCgpa()<s2.getCgpa()){
                        return 1;               
                    } else if((s1.getCgpa()==s2.getCgpa()) && (s1.getSname().equals(s2.getSname()))) {
                    	int comp=  Integer.compare(s1.getId(), s2.getId());
                    	
                    	return comp;
                    } else{
                        return -1;
                        }
                }
            });

      
          for(Student st1: studentList){
            System.out.println(st1.getSname());
        }
    }
}
