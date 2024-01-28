package com.example.elinicproject;

public class patient {
    public class Patient {
        private Long id;
        private String name;
        private String surname;
        private String phoneNumber;
        private String email;
        private String address;
        private String dateOfBirth; // Można użyć klasy LocalDate z Java 8

        // Konstruktor
        public Patient(Long id, String name, String surname, String phoneNumber, String email, String address, String dateOfBirth) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
        }

        // Gettery i settery
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        // Metoda toString
        @Override
        public String toString() {
            return "Patient{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    '}';
        }
    }
}
