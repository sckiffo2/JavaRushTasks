package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
	public static ImageReader getImageReader(ImageTypes type) {
		try {
			if (type.equals(ImageTypes.BMP)) {
				return new BmpReader();
			}
			if (type.equals(ImageTypes.PNG)) {
				return new PngReader();
			}
			if (type.equals(ImageTypes.JPG)) {
				return new JpgReader();
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}
}
