package resources;

public enum APIResources {
	
	
	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	UpdatePlaceAPI("/maps/api/place/update/json"),
	GetPlaceAPI("/maps/api/place/get/json");
	
	private String resource; 

	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}
	
	public String getresource() {
		return resource;
	}

	

}
