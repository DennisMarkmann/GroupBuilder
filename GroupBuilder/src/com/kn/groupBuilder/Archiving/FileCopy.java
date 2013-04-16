package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

public class FileCopy {
	private long chunckSizeInBytes = 1024 * 1024;

	public void copy(String source, String destination) {
		try {

			File sourceFile = new File(source);
			File copiedFile = new File(destination);

			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			FileOutputStream fileOutputStream = new FileOutputStream(copiedFile);
			FileChannel inputChannel = fileInputStream.getChannel();
			FileChannel outputChannel = fileOutputStream.getChannel();
			transfer(inputChannel, outputChannel, sourceFile.length(), false);
			fileInputStream.close();
			fileOutputStream.close();
			copiedFile.setLastModified(sourceFile.lastModified());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transfer(FileChannel fileChannel, ByteChannel byteChannel,
			long lengthInBytes, boolean verbose) throws IOException {
		long overallBytesTransfered = 0L;
		while (overallBytesTransfered < lengthInBytes) {
			long bytesTransfered = 0L;
			bytesTransfered = fileChannel.transferTo(
					overallBytesTransfered,
					Math.min(chunckSizeInBytes, lengthInBytes
							- overallBytesTransfered), byteChannel);
			overallBytesTransfered += bytesTransfered;
			if (verbose) {
				System.out.println("overall bytes transfered: "
						+ overallBytesTransfered
						+ " progress "
						+ (Math.round(overallBytesTransfered
								/ ((double) lengthInBytes) * 100.0)) + "%");
			}
		}
	}
}