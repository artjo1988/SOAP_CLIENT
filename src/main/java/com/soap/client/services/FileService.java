package com.soap.client.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service
public class FileService {

//	public final static String FILE_NAME = "source/source.xml";
	public final static String FILE_NAME = "sour/source.xml";

	public void downloadFile() throws IOException {
		URL url = new URL("http://www.cbr.ru/scripts/XML_bic.asp");
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(new File("src/main/resources/" + FILE_NAME));
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
}
