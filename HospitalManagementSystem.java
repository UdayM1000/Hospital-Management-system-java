import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    String assignedDoctor;

    public Patient(int id, String name, int age, String disease, String assignedDoctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.assignedDoctor = assignedDoctor;
    }

    public void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Assigned Doctor: " + assignedDoctor);
        System.out.println("-----------------------------");
    }
}

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patientList = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Delete Patient Record");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    System.out.println("Exiting system... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    public static void addPatient() {
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter disease: ");
        String disease = sc.nextLine();

        System.out.print("Assign a doctor: ");
        String doctor = sc.nextLine();

        Patient p = new Patient(nextId++, name, age, disease, doctor);
        patientList.add(p);

        System.out.println("✅ Patient record added successfully.");
    }

    public static void viewPatients() {
        if (patientList.isEmpty()) {
            System.out.println("⚠️ No patient records found.");
        } else {
            System.out.println("\n📋 List of Patients:");
            for (Patient p : patientList) {
                p.display();
            }
        }
    }

    public static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        Iterator<Patient> it = patientList.iterator();
        while (it.hasNext()) {
            Patient p = it.next();
            if (p.id == id) {
                it.remove();
                found = true;
                System.out.println("🗑️ Patient record deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Patient ID not found.");
        }
    }
}
