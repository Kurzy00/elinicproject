package com.example.elinicproject;
import java.time.LocalDateTime;

public class vist {
    public class Visit {
        private Long id;
        private Long patientId;
        private Long doctorId;
        private LocalDateTime dateTime;
        private String purpose;
        private String notes;

        // Konstruktor
        public Visit(Long id, Long patientId, Long doctorId, LocalDateTime dateTime, String purpose, String notes) {
            this.id = id;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.dateTime = dateTime;
            this.purpose = purpose;
            this.notes = notes;
        }

        // Gettery i settery
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getPatientId() {
            return patientId;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public Long getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(Long doctorId) {
            this.doctorId = doctorId;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        // Metoda toString dla wygodnego wyświetlania informacji o wizycie
        @Override
        public String toString() {
            return "Visit{" +
                    "id=" + id +
                    ", patientId=" + patientId +
                    ", doctorId=" + doctorId +
                    ", dateTime=" + dateTime +
                    ", purpose='" + purpose + '\'' +
                    ", notes='" + notes + '\'' +
                    '}';
        }
    }

}
