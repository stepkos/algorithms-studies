package aisd.W03;

public class Student{
	int nrIndeksu; 
	double stypendium; 
	public Student(int nr, double kwota){
		nrIndeksu=nr; 
		stypendium=kwota; 
	} 
	public void zwiekszStypendium(double kwota){
		stypendium+=kwota; 
	} 
	@Override
	public String toString(){ 
		return String.format("%6d %8.2f\n",nrIndeksu,stypendium); 
	}
	
	public boolean equals(Student stud) {
		return nrIndeksu==stud.nrIndeksu;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return equals((Student) obj);
	}
	
}

