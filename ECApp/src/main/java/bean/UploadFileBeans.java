package bean;

public class UploadFileBeans {

	private String imagePath;
	
	public UploadFileBeans() {
	}
	
	public UploadFileBeans(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
