package com.kn.groupBuilder.Archiving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

import com.kn.groupBuilder.Exceptions.CopyOperationException;

class FileCopy {

    private final long chunckSizeInBytes = 1024 * 1024;

    final void copy(final String source, final String destination) {
        try {

            final File sourceFile = new File(source);
            final File copiedFile = new File(destination);

            final FileInputStream fileInputStream = new FileInputStream(sourceFile);
            final FileOutputStream fileOutputStream = new FileOutputStream(copiedFile);

            final FileChannel inputChannel = fileInputStream.getChannel();
            final FileChannel outputChannel = fileOutputStream.getChannel();

            this.transfer(inputChannel, outputChannel, sourceFile.length());

            fileInputStream.close();
            fileOutputStream.close();

        } catch (final Exception e) {
            new CopyOperationException(source);
        }
    }

    private void transfer(final FileChannel inputChannel, final ByteChannel outputChannel, final long lengthInBytes)
            throws IOException {

        long overallBytesTransfered = 0L;

        while (overallBytesTransfered < lengthInBytes) {
            long bytesTransfered = 0L;

            bytesTransfered = inputChannel.transferTo(
                    overallBytesTransfered,
                    Math.min(this.chunckSizeInBytes, lengthInBytes - overallBytesTransfered),
                    outputChannel);

            overallBytesTransfered += bytesTransfered;
        }
    }
}
