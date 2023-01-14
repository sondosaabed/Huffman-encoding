package huffman.application;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncode{
    private final Map<String, Byte> codes;
    private int freqSize;
    
	public HuffmanEncode(String[] codes) {
        this.codes = new HashMap<>();
        for (String code : codes) {
            if(code != null) {
            	String[] parts = code.split("=");
            	this.codes.put(parts[1], parts[0].getBytes()[0]);
            }
        }
    }

    private void writeHeader(String fileName, String[] codes, long fileSize, OutputStream output, int[] frequencies) throws IOException {
        output.write((fileSize + "\n").getBytes());
        output.write((this.codes.size() + "\n").getBytes());
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] >0) {
            	System.out.println((char)i+"");
                output.write(((char)i+"="+frequencies[i] + '\n').getBytes());
            }
        }
    }

    public File compress(String inputFile, String outputFilename, String[] codes, int[] frequencies) throws IOException {
        // Read in the input file
        byte[] inputData = Files.readAllBytes(Paths.get(inputFile));
        // Encode the input data using the huffman tree
        StringBuilder encodedData = new StringBuilder();
        for (byte b : inputData) {
        	encodedData.append(this.codes.get(Byte.toString(b)));
        }
        // Convert the encoded data to a byte array
        byte[] outputData = new byte[(int) Math.ceil(encodedData.length() / 8.0)];
        for (int i = 0; i < encodedData.length(); i++) {
            if (encodedData.charAt(i) == '1') {
                outputData[i / 8] |= 1 << (7 - (i % 8));
            }
        }
        File outputFile = new File(outputFilename);
        // Write the encoded data to the output file
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            writeHeader(inputFile, codes, new File(inputFile).length(), output,frequencies);
            output.write(outputData);
        }
		return outputFile;
    }
    
    public Map<String, Byte> getCodes() {
		return codes;
	}

	public int getFreqSize() {
		return freqSize;
	}

	public void setFreqSize(int freqSize) {
		this.freqSize = freqSize;
	}
}