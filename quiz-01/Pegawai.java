public class Pegawai {
	public static int jmlInstance;
	private int NIP;
	private String nama, departemen, email;

	public Pegawai(int NIP, String nama, String departemen){
		jmlInstance++;
		this.NIP = NIP;
		this.nama = nama;
		this.departemen = departemen;
	}

	public String getNama(){
		return this.nama;
	}

	public int getNIP(){
		return this.NIP;
	}

	public String getDepartemen(){
		return this.departemen;
	}

	public void setNama(String namaBaruBro){
		this.nama = namaBaruBro;
	}

	public void setDepartemen(String departemenBaruBro){
		this.departemen = departemenBaruBro;
	}

	public boolean cekFormatEmail(String email){
		if ((! email.contains("@")) || (! email.contains(".")))
			return false;

		// Menghitung jumlah "@"
		int numAt = 0;
		for (char c: email.toCharArray()){
			if (c == '@') numAt++;
		}

		// Kalo jumlah "@" lebih dari 1 berarti gak valid
		if (numAt > 1) return false;

		// Kalo email diakhiri dengan "." atau "@" berarti gak valid
		if (email.charAt(email.length() - 1) == '.' || email.charAt(email.length() - 1) == '@')
			return false;

		// Kalo bisa melewati tes-tes di atas berarti formatnya udah bener
		return true;
	}

	public void catatEmail(String email) {
		if(cekFormatEmail(email)) {
			this.email = email;
			System.out.println("Email tercatat");
		}
		else
			System.out.println("Format email salah!!");
	}

	public static void main(String[] args){
		Pegawai khalid = new Pegawai(123, "khalid", "diskrit");
		System.out.println(khalid.getNama());
		System.out.println(khalid.getNIP());
		System.out.println(khalid.getDepartemen());
		Pegawai andre = new Pegawai(124, "andre", "variansi");
		Pegawai alif = new Pegawai(125, "alif", "PI");
		System.out.println(Pegawai.jmlInstance);
		khalid.catatEmail("hehe@hoho,com");
		khalid.catatEmail("haha@hihi.co.id");
		khalid.catatEmail("a@b.c");
		khalid.catatEmail("huhu.haha.com");
		khalid.catatEmail("hoho@hehe");
		System.out.println(khalid.email);
	}


}