package hospital;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class HospitalTest extends JFrame implements ActionListener {

    // Service
    HospitalService service = new HospitalService();

    // ---------------- PATIENT COMPONENTS ----------------
    JTextField patientIdField;
    JTextField patientNameField;
    JTextField patientAgeField;
    JTextField patientGenderField;

    JButton addPatientButton;
    JButton showPatientsButton;
    JButton clearPatientButton;

    JTable patientTable;
    DefaultTableModel patientTableModel;

    // ---------------- DOCTOR COMPONENTS ----------------
    JTextField doctorIdField;
    JTextField doctorNameField;
    JTextField specializationField;

    JButton addDoctorButton;
    JButton showDoctorsButton;
    JButton clearDoctorButton;

    JTable doctorTable;
    DefaultTableModel doctorTableModel;

    // ---------------- APPOINTMENT COMPONENTS ----------------
    JTextField appointmentIdField;
    JTextField appointmentPatientIdField;
    JTextField appointmentDoctorIdField;
    JTextField appointmentDateField;

    JButton bookAppointmentButton;
    JButton showAppointmentsButton;
    JButton clearAppointmentButton;

    JTable appointmentTable;
    DefaultTableModel appointmentTableModel;

    // ---------------- CONSTRUCTOR ----------------
    public HospitalTest() {

        setTitle("Hospital Management System");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
    }

    // ---------------- CREATE GUI ----------------
    private void createGUI() {

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create tabs
        JPanel patientPanel = createPatientPanel();
        JPanel doctorPanel = createDoctorPanel();
        JPanel appointmentPanel = createAppointmentPanel();

        tabbedPane.addTab("Patients", patientPanel);
        tabbedPane.addTab("Doctors", doctorPanel);
        tabbedPane.addTab("Appointments", appointmentPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(exitButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // =========================================================
    //                     PATIENT PANEL
    // =========================================================

    private JPanel createPatientPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(
                BorderFactory.createTitledBorder("Patient Details"));

        JLabel idLabel = new JLabel("Patient ID:");
        JLabel nameLabel = new JLabel("Patient Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");

        patientIdField = new JTextField();
        patientNameField = new JTextField();
        patientAgeField = new JTextField();
        patientGenderField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(patientIdField);

        inputPanel.add(nameLabel);
        inputPanel.add(patientNameField);

        inputPanel.add(ageLabel);
        inputPanel.add(patientAgeField);

        inputPanel.add(genderLabel);
        inputPanel.add(patientGenderField);

        // Buttons
        JPanel buttonPanel = new JPanel();

        addPatientButton = new JButton("Add Patient");
        showPatientsButton = new JButton("Show Patients");
        clearPatientButton = new JButton("Clear");

        addPatientButton.addActionListener(this);
        showPatientsButton.addActionListener(this);
        clearPatientButton.addActionListener(this);

        buttonPanel.add(addPatientButton);
        buttonPanel.add(showPatientsButton);
        buttonPanel.add(clearPatientButton);

        inputPanel.add(buttonPanel);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {
                "Patient ID",
                "Name",
                "Age",
                "Gender"
        };

        patientTableModel = new DefaultTableModel(columns, 0);

        patientTable = new JTable(patientTableModel);

        JScrollPane scrollPane = new JScrollPane(patientTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Patient Records"));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    // =========================================================
    //                      DOCTOR PANEL
    // =========================================================

    private JPanel createDoctorPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.setBorder(
                BorderFactory.createTitledBorder("Doctor Details"));

        JLabel idLabel = new JLabel("Doctor ID:");
        JLabel nameLabel = new JLabel("Doctor Name:");
        JLabel specializationLabel =
                new JLabel("Specialization:");

        doctorIdField = new JTextField();
        doctorNameField = new JTextField();
        specializationField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(doctorIdField);

        inputPanel.add(nameLabel);
        inputPanel.add(doctorNameField);

        inputPanel.add(specializationLabel);
        inputPanel.add(specializationField);

        // Buttons
        JPanel buttonPanel = new JPanel();

        addDoctorButton = new JButton("Add Doctor");
        showDoctorsButton = new JButton("Show Doctors");
        clearDoctorButton = new JButton("Clear");

        addDoctorButton.addActionListener(this);
        showDoctorsButton.addActionListener(this);
        clearDoctorButton.addActionListener(this);

        buttonPanel.add(addDoctorButton);
        buttonPanel.add(showDoctorsButton);
        buttonPanel.add(clearDoctorButton);

        inputPanel.add(buttonPanel);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {
                "Doctor ID",
                "Name",
                "Specialization"
        };

        doctorTableModel =
                new DefaultTableModel(columns, 0);

        doctorTable = new JTable(doctorTableModel);

        JScrollPane scrollPane =
                new JScrollPane(doctorTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Doctor Records"));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    // =========================================================
    //                   APPOINTMENT PANEL
    // =========================================================

    private JPanel createAppointmentPanel() {

        JPanel mainPanel =
                new JPanel(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel =
                new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Appointment Details"));

        JLabel appointmentIdLabel =
                new JLabel("Appointment ID:");

        JLabel patientIdLabel =
                new JLabel("Patient ID:");

        JLabel doctorIdLabel =
                new JLabel("Doctor ID:");

        JLabel dateLabel =
                new JLabel("Date (YYYY-MM-DD):");

        appointmentIdField = new JTextField();
        appointmentPatientIdField = new JTextField();
        appointmentDoctorIdField = new JTextField();
        appointmentDateField = new JTextField();

        inputPanel.add(appointmentIdLabel);
        inputPanel.add(appointmentIdField);

        inputPanel.add(patientIdLabel);
        inputPanel.add(appointmentPatientIdField);

        inputPanel.add(doctorIdLabel);
        inputPanel.add(appointmentDoctorIdField);

        inputPanel.add(dateLabel);
        inputPanel.add(appointmentDateField);

        // Buttons
        JPanel buttonPanel = new JPanel();

        bookAppointmentButton =
                new JButton("Book Appointment");

        showAppointmentsButton =
                new JButton("Show Appointments");

        clearAppointmentButton =
                new JButton("Clear");

        bookAppointmentButton.addActionListener(this);
        showAppointmentsButton.addActionListener(this);
        clearAppointmentButton.addActionListener(this);

        buttonPanel.add(bookAppointmentButton);
        buttonPanel.add(showAppointmentsButton);
        buttonPanel.add(clearAppointmentButton);

        inputPanel.add(buttonPanel);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {
                "Appointment ID",
                "Patient ID",
                "Doctor ID",
                "Date"
        };

        appointmentTableModel =
                new DefaultTableModel(columns, 0);

        appointmentTable =
                new JTable(appointmentTableModel);

        JScrollPane scrollPane =
                new JScrollPane(appointmentTable);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Appointment Records"));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    // =========================================================
    //                   EVENT HANDLING
    // =========================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        // Add Patient
        if (e.getSource() == addPatientButton) {
            addPatient();
        }

        // Show Patients
        else if (e.getSource() == showPatientsButton) {
            showPatients();
        }

        // Clear Patient
        else if (e.getSource() == clearPatientButton) {
            clearPatientFields();
        }

        // Add Doctor
        else if (e.getSource() == addDoctorButton) {
            addDoctor();
        }

        // Show Doctors
        else if (e.getSource() == showDoctorsButton) {
            showDoctors();
        }

        // Clear Doctor
        else if (e.getSource() == clearDoctorButton) {
            clearDoctorFields();
        }

        // Book Appointment
        else if (e.getSource() == bookAppointmentButton) {
            bookAppointment();
        }

        // Show Appointments
        else if (e.getSource() == showAppointmentsButton) {
            showAppointments();
        }

        // Clear Appointment
        else if (e.getSource() == clearAppointmentButton) {
            clearAppointmentFields();
        }

        // Exit
        else if (e.getActionCommand().equals("Exit")) {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    // =========================================================
    //                      ADD PATIENT
    // =========================================================

    private void addPatient() {

        try {

            if (patientIdField.getText().isEmpty()
                    || patientNameField.getText().isEmpty()
                    || patientAgeField.getText().isEmpty()
                    || patientGenderField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all patient details."
                );

                return;
            }

            int id =
                    Integer.parseInt(
                            patientIdField.getText());

            String name =
                    patientNameField.getText();

            int age =
                    Integer.parseInt(
                            patientAgeField.getText());

            String gender =
                    patientGenderField.getText();

            PatientBean patient =
                    new PatientBean(
                            id,
                            name,
                            age,
                            gender
                    );

            boolean result =
                    service.registerPatient(patient);

            if (result) {

                JOptionPane.showMessageDialog(
                        this,
                        "Patient added successfully!"
                );

                clearPatientFields();
                showPatients();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to add patient."
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Patient ID and Age must be numbers."
            );
        }
    }

    // =========================================================
    //                     SHOW PATIENTS
    // =========================================================

    private void showPatients() {

        patientTableModel.setRowCount(0);

        List<PatientBean> patients =
                service.getAllPatients();

        for (PatientBean patient : patients) {

            Object[] row = {
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getAge(),
                    patient.getGender()
            };

            patientTableModel.addRow(row);
        }
    }

    // =========================================================
    //                      ADD DOCTOR
    // =========================================================

    private void addDoctor() {

        try {

            if (doctorIdField.getText().isEmpty()
                    || doctorNameField.getText().isEmpty()
                    || specializationField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all doctor details."
                );

                return;
            }

            int id =
                    Integer.parseInt(
                            doctorIdField.getText());

            String name =
                    doctorNameField.getText();

            String specialization =
                    specializationField.getText();

            DoctorBean doctor =
                    new DoctorBean(
                            id,
                            name,
                            specialization
                    );

            boolean result =
                    service.registerDoctor(doctor);

            if (result) {

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor added successfully!"
                );

                clearDoctorFields();
                showDoctors();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to add doctor."
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Doctor ID must be a number."
            );
        }
    }

    // =========================================================
    //                      SHOW DOCTORS
    // =========================================================

    private void showDoctors() {

        doctorTableModel.setRowCount(0);

        List<DoctorBean> doctors =
                service.getAllDoctors();

        for (DoctorBean doctor : doctors) {

            Object[] row = {
                    doctor.getDoctorId(),
                    doctor.getName(),
                    doctor.getSpecialization()
            };

            doctorTableModel.addRow(row);
        }
    }

    // =========================================================
    //                  BOOK APPOINTMENT
    // =========================================================

    private void bookAppointment() {

        try {

            if (appointmentIdField.getText().isEmpty()
                    || appointmentPatientIdField.getText().isEmpty()
                    || appointmentDoctorIdField.getText().isEmpty()
                    || appointmentDateField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all appointment details."
                );

                return;
            }

            int appointmentId =
                    Integer.parseInt(
                            appointmentIdField.getText());

            int patientId =
                    Integer.parseInt(
                            appointmentPatientIdField.getText());

            int doctorId =
                    Integer.parseInt(
                            appointmentDoctorIdField.getText());

            LocalDate date =
                    LocalDate.parse(
                            appointmentDateField.getText());

            boolean result =
                    service.bookAppointment(
                            appointmentId,
                            patientId,
                            doctorId,
                            date
                    );

            if (result) {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment booked successfully!"
                );

                clearAppointmentFields();
                showAppointments();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to book appointment."
                );
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment ID, Patient ID and Doctor ID must be numbers."
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid date. Use YYYY-MM-DD format."
            );
        }
    }

    // =========================================================
    //                  SHOW APPOINTMENTS
    // =========================================================

    private void showAppointments() {

        appointmentTableModel.setRowCount(0);

        List<AppointmentBean> appointments =
                service.getAllAppointments();

        for (AppointmentBean appointment : appointments) {

            Object[] row = {
                    appointment.getAppointmentId(),
                    appointment.getPatientId(),
                    appointment.getDoctorId(),
                    appointment.getDate()
            };

            appointmentTableModel.addRow(row);
        }
    }

    // =========================================================
    //                    CLEAR METHODS
    // =========================================================

    private void clearPatientFields() {

        patientIdField.setText("");
        patientNameField.setText("");
        patientAgeField.setText("");
        patientGenderField.setText("");
    }

    private void clearDoctorFields() {

        doctorIdField.setText("");
        doctorNameField.setText("");
        specializationField.setText("");
    }

    private void clearAppointmentFields() {

        appointmentIdField.setText("");
        appointmentPatientIdField.setText("");
        appointmentDoctorIdField.setText("");
        appointmentDateField.setText("");
    }

    // =========================================================
    //                         MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            HospitalTest gui =
                    new HospitalTest();

            gui.setVisible(true);
        });
    }
}