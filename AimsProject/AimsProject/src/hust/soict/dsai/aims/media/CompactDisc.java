//Chu Đình Hiển - 20215046
package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	//Thêm thuộc tính artist và danh sách tracks
	private String artist;
	private ArrayList<Track> tracks;
	private static int nbCompactDisc = 0;
	//Contructor kế thừa từ Disc
	public CompactDisc(String title, String category, float cost,String director, String artist) {
		super(title, category, cost, 0, director);//Tạo mới một CompactDisc mặc định length = 0
		super.setId(++nbCompactDisc);
		this.artist = artist;
	}
	
	public CompactDisc(String title,String category, float cost) {
		super(title,category,cost);
	}

	//Phương thức thêm track
	public void addTrack(Track track) {
		//Kiểm tra xem trong tracks có track chưa
		if(!tracks.contains(track)) {//Nếu chưa
			tracks.add(track);//Thêm vào tracks
			//Tăng độ dài Disc bằng độ dài tracks cộng độ dài track mới
			setLength(getLength()+track.getLength());
		}else {//Nếu có in ra thông báo đã tồn tại
			System.out.println("Chu Dinh Hien - 20215046: Track "+track.getTitle()+"da ton tai!");
		}
	}
	
	//Phương thức xóa Track
	public void removeTrack(Track track) {
		//Kiểm tra track có trong tracks không
		if(tracks.contains(track)) {//Nếu có
			//Xóa track
			tracks.remove(track);
			//Trừ đi độ dài track vừa mới xóa
			setLength(getLength()-track.getLength());
		}else {//Nếu chưa thì in ra thông báo
			System.out.println("Chu Dinh Hien - 20215046: Track "+track.getTitle()+"khong ton tai!");
		}
	}
	
	//Phương thức lấy độ dài
	@Override
	public int getLength() {
		int lengthTracks = 0;
		//Duyệt các CD có trong CompactDisc
		for(Track x : tracks) {
			//Cộng độ dài từng track với nhau
			lengthTracks+=x.getLength();
		}
		return lengthTracks;
	}

	//Chu Đình Hiển - 20215046
	@Override
	public void play() {
		// TODO Auto-generated method stub
		//In thông tin CD
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		//Thực hiện play cho từng track trong CD
		for(Track x : tracks) {
			x.play();
		}
	}
}