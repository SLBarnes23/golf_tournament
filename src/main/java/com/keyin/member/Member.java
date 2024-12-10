package com.keyin.member;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import com.keyin.tournament.Tournament;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;

    @Column(name = "membership_start_date")
    private LocalDate startDate;

    private Integer duration;

    @ManyToMany(mappedBy = "members")
    private Set<Tournament> tournaments;

    private String membershipType; // New field added

    // Default Constructor
    public Member() {
    }

    // All-Args Constructor
    public Member(Long id, String name, String address, String email, String phone, LocalDate startDate, Integer duration, Set<Tournament> tournaments, String membershipType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.duration = duration;
        this.tournaments = tournaments;
        this.membershipType = membershipType;
    }

    // Getters and Setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public String getMembershipType() {
        return membershipType; // Getter for membershipType
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType; // Setter for membershipType
    }
}
