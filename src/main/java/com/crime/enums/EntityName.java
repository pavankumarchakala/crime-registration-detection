package com.crime.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum EntityName {

	DEPARTMENT_USER("DepartmentUser"), COMPLAINT_USER("ComplaintUser"), CRIME("Crime"),;

	private String displayValue;

	private EntityName(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDislayValue() {
		return displayValue;
	}

	public static EntityName getValueOf(String value) {
		Optional<EntityName> filteredItem = Arrays.asList(EntityName.values()).stream()
				.filter(item -> item.name().toLowerCase().equals(value.toLowerCase())).findFirst();
		if (filteredItem.isPresent())
			return filteredItem.get();
		return null;
	}

	public static List<String> getAllDisplayValues() {
		return Arrays.asList(EntityName.values()).stream().map(entityName -> entityName.displayValue)
				.collect(Collectors.toList());
	}

}
