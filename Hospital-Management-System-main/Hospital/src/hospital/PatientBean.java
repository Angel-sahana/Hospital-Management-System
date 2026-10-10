package hospital;

public class PatientBean {
    private int patientId;
    private String name;
    private int age;
    private String gender;

    public PatientBean() {}

    public PatientBean(int patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getPatientId() 
    { 
    	return patientId; 
    }
    public void setPatientId(int patientId) 
    { 
    	this.patientId = patientId; 
    }

    public String getName() 
    { 
    	return name; 
    }
    public void setName(String name) 
    { 
    	this.name = name; 
    }

    public int getAge() 
    { 
    	return age; 
    }
    public void setAge(int age) 
    { 
    	this.age = age; 
    }

    public String getGender() 
    { 
    	return gender; 
    }
    public void setGender(String gender) 
    { 
    	this.gender = gender; 
    }

    @Override
    public String toString() 
    {
        return "Patient [ID=" + patientId + ", Name=" + name + ", Age=" + age + ", Gender=" + gender + "]";
    }
}

