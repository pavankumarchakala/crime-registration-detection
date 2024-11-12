package com.crime.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.uuid.Generators;

public final class RandomUtils {

	public static long getTimeInMilliesId() {
		return System.currentTimeMillis();
	}

	public static long getGeneratedTimeStamp() {
		UUID uuid = Generators.timeBasedGenerator().generate();
		return uuid.timestamp();
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString();
	}

	public static String get24HrStandardFormat(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return dateTime.format(formatter);
	}

	public static String get12HrStandardFormat(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm aa");
		return dateTime.format(formatter);
	}

	public static long getNanos() {
		AtomicLong nanos = new AtomicLong(System.nanoTime());
//		synchronized (RandomUtils.class) {
		return nanos.get();
//		}
	}

	public static long getUUIDTimeStamp() {
		UUID uuid = UUID.randomUUID();
		return uuid.timestamp();
	}

}
