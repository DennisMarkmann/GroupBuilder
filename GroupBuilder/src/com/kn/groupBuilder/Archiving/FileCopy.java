package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

public class FileCopy {

    private final long chunckSizeInBytes = 1024 * 1024;

    public final void copy(final String source, final String destination) {
        try {

            final File sourceFile = new File(source);
            final File copiedFile = new File(destination);

            final FileInputStream fileInputStream = new FileInputStream(sourceFile);
            final FileOutputStream fileOutputStream = new FileOutputStream(copiedFile);
            final FileChannel inputChannel = fileInputStream.getChannel();
            final FileChannel outputChannel = fileOutputStream.getChannel();
            this.transfer(inputChannel, outputChannel, sourceFile.length(), false);
            fileInputStream.close();
            fileOutputStream.close();
            copiedFile.setLastModified(sourceFile.lastModified());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public final void transfer(
            final FileChannel fileChannel,
            final ByteChannel byteChannel,
            final long lengthInBytes,
            final boolean verbose) throws IOException {
        long overallBytesTransfered = 0L;
        while (overallBytesTransfered < lengthInBytes) {
            long bytesTransfered = 0L;
            bytesTransfered = fileChannel.transferTo(
                    overallBytesTransfered,
                    Math.min(this.chunckSizeInBytes, lengthInBytes - overallBytesTransfered),
                    byteChannel);
            overallBytesTransfered += bytesTransfered;
            if (verbose) {
                System.out.println("overall bytes transfered: " + overallBytesTransfered + " progress "
                        + (Math.round(overallBytesTransfered / ((double) lengthInBytes) * 100.0)) + "%");
            }
        }
    }
}
