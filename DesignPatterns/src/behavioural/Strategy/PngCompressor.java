package behavioural.Strategy;

public class PngCompressor implements Compressor {

	@Override
	public void compress(String fileName) {
		System.out.println("Compressing using PNG");

	}

}
