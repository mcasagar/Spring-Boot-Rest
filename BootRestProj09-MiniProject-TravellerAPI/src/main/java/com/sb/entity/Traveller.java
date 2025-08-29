package com.sb.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="REST_TRAVELLER")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Traveller {
	
	//Data properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;
	@Column(length = 30)
	@NonNull
	private String name;
	@Column(length = 30)
	@NonNull
	private String country;
	@NonNull
	private Long mobileno;
	@NonNull
	private LocalDate dob;
	@Column(length = 30)
	@NonNull
	private String currentLocation;
	private String headingTo;
	 // Mapping a collection of Strings
    @ElementCollection
    @CollectionTable(
        name = "TRAVELLER_VISITED_COUNTRIES",  //Table name for the collections
        joinColumns = @JoinColumn(name = "TRAVELLER_ID", referencedColumnName = "TID")// foreign key column
    )
    @NonNull
	private List<String> visistedCountries;
	
	
    
  //@SequenceGenerator(name="gen1", sequenceName = "TID_SEQ", initialValue = 1000, allocationSize = 1)
  	//@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    
	//metadata properties
    @Version
	private Integer updateCount;
    @CreationTimestamp
    private LocalDateTime registeredOn;
    @UpdateTimestamp
    private LocalDateTime lastUpdateOn;
    @Column(length = 30)
    private String createdBy;
    @Column(length = 30)
    private String updatedBy;
}
