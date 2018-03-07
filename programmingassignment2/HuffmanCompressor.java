package programmingassignment2;

import java.util.ArrayList;
import java.io.*;

public class HuffmanCompressor {
	//public static String huffmanEncoder(String inputFileName, String encodingFileName, String outputFileName) {
		
	//}
	
	public static ArrayList<HuffmanNode> scanFile(String inputFileName) throws IOException {
		ArrayList<HuffmanNode> list = new ArrayList<HuffmanNode>();
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		int ch;
		while((ch = br.read()) != -1) {
			if(list.size() == 0) {
				list.add(new HuffmanNode((char)ch, 1));
			} else {
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getInChar() != ch && i == list.size() - 1) {
						list.add(new HuffmanNode((char)ch, 1));
						break;
					} else if(list.get(i).getInChar() == ch) {
						list.get(i).setFrequency(list.get(i).getFrequency() + 1);
						break;
					}
				}
			}
		}

		return list;
	}
	
	public static HuffmanNode combineHuffmanNode(HuffmanNode one, HuffmanNode two) {
		HuffmanNode combined = new HuffmanNode('*', one.getFrequency() + two.getFrequency());
		combined.setLeft(one);
		combined.setRight(two);
		return combined;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<HuffmanNode> ex = scanFile("/Users/andrewliao/code/projtestjv/programmingassignment2/ex");
		
		for(int i = 0; i < ex.size(); i++) {
			System.out.print((char)ex.get(i).getInChar() + " " + ex.get(i).getFrequency());
			System.out.println();
		}
		System.out.println("finished with list");
		
		HuffmanNode x = combineHuffmanNode(ex.get(0), ex.get(1));
		System.out.println((char)x.getInChar());
		System.out.println((char)x.getLeft().getInChar() + " " + x.getLeft().getFrequency());
		System.out.println((char)x.getRight().getInChar() + " " + x.getRight().getFrequency());
		
		HuffmanNode y = combineHuffmanNode(x, ex.get(2));
		System.out.println((char)y.getInChar());
		System.out.println((char)y.getLeft().getInChar() + " " + y.getLeft().getFrequency());
		System.out.println((char)y.getRight().getInChar() + " " + y.getRight().getFrequency());
		
	}
}
