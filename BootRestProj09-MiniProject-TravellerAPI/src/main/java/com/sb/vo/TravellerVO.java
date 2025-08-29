package com.sb.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TravellerVO {
	private Integer tid;
	@NonNull
	private String name;
	@NonNull
	private String country;
	@NonNull
	private Long mobileno;
	@NonNull
	private LocalDate dob;
	@NonNull
	private String currentLocation;
	@NonNull
	private String headingTo;
	@NonNull
	private List<String> visistedCountries;
}
