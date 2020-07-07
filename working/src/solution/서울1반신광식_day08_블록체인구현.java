package solution;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class 서울1반신광식_day08_블록체인구현 {
	public static Block block;

	public static class Block {
		private String hash;
		private String prevhash;
		private int nonce;
		private String data;

		public Block() {
		}

		public Block(String hash, String prevhash, int nonce, String data) {
			this.hash = hash;
			this.prevhash = prevhash;
			this.nonce = nonce;
			this.data = data;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		public String getPrevhash() {
			return prevhash;
		}

		public void setPrevhash(String prevhash) {
			this.prevhash = prevhash;
		}

		public int getNonce() {
			return nonce;
		}

		public void setNonce(int nonce) {
			this.nonce = nonce;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	}

	public static void print(Block b) {
		System.out.println("nonce: " + b.getNonce());
		System.out.println("data: " + b.getData());
		System.out.println("prevhash: " + b.getPrevhash());
		System.out.println("hash: " + b.getHash());
		System.out.println();
	}

	public static String getSha256(String str) {
		String SHA;
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (byte aByteData : byteData) {
				sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

	public static void main(String[] args) {
		String s = getSha256("Genesis Block");

		block = new Block(s, "", 0, "Genesis Block");
		print(block);
		for (int i = 1; i <= 2; i++) {
			int nonce = 0;
			String temp = block.getHash();
			while (true) {
				nonce++;
				String hash = getSha256(temp);
				if (hash.substring(0, 5).equals("00000")) {
					block = new Block(hash, block.getHash(), nonce, (i + 1) + "nd");
					break;
				}
				temp = hash;
			}
			print(block);
		}
	}

}